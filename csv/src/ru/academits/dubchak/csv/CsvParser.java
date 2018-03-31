package ru.academits.dubchak.csv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CsvParser {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("The number of arguments is not valid.\n" +
                    "There must be three arguments at least:\n" +
                    "input file name\noutput file name\ndelimiter");
        } else {
            try (Scanner scanner = new Scanner(new FileInputStream(args[0]));
                 PrintWriter writer = new PrintWriter("./csv/src/" + args[1])) {
                char delimiter = args[2].charAt(0);
                writer.println("<!DOCTYPE html>");
                writer.println("<html>");
                writer.println("<head>");
                writer.println("\t<meta charset=\"utf-8\" />");
                writer.println("\t<title>HTML document converted from CSV</title>");
                writer.println("</head>");
                writer.println("<body>");
                writer.println("\t<table border=\"1\" cellspacing=\"0\" align=\"center\">");
                boolean inQuotes = false;
                while (scanner.hasNextLine()) {
                    writer.print("\t\t<tr><td>");
                    String string = scanner.nextLine();
                    for (int i = 0; i < string.length(); i++) {
                        if (inQuotes) {
                            if (string.charAt(i) == '"') {
                                if (i == string.length() - 1) {
                                    writer.println("</td></tr>");
                                    inQuotes = false;
                                } else if ((i + 1) < string.length() && string.charAt(i + 1) == '"') {
                                    writer.print(printChar(string.charAt(i)));
                                    i++;
                                } else {
                                    inQuotes = false;
                                }
                            } else if (i == string.length() - 1) {
                                writer.print(printChar(string.charAt(i)));
                                writer.print("<br/>");
                                string = scanner.nextLine();
                                i = -1;
                            } else {
                                writer.print(printChar(string.charAt(i)));
                            }
                        } else if (string.charAt(i) == '"') {
                            inQuotes = true;
                        } else if (string.charAt(i) == delimiter) {
                            writer.print("</td><td>");
                            if (i == string.length() - 1) {
                                writer.println("</td></tr>");
                            }
                        } else {
                            writer.print(printChar(string.charAt(i)));
                            if (i == string.length() - 1) {
                                writer.println("</td></tr>");
                            }
                        }
                    }
                }
                writer.println("\t</table>");
                writer.println("</body>");
                writer.println("</html>");
            } catch (FileNotFoundException e) {
                System.out.printf("%s. Try again.", e);
            }
        }
    }
    private static String printChar(char ch){
        switch (ch){
            case '<':
                return ("&lt;");
            case '>':
                return ("&gt;");
            case '&':
                return ("&amp;");
            default:
                return String.valueOf(ch);
        }
    }
}