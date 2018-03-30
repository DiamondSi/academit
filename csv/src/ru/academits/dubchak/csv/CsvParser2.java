package ru.academits.dubchak.csv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CsvParser2 {
    public static void main(String[] args) {
        CsvParser.csvParser(new String[]{"C:\\Users\\sbt-dubchak-da\\IdeaProjects\\academit\\csv\\src\\input.csv", "output.htm", ","});
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
                writer.println("\t<title>HTML Document</title>");
                writer.println("</head>");
                writer.println("<body>");
                writer.println("\t<table border=\"1\" cellspacing=\"0\">");
                boolean inQuotes = false;
                while (scanner.hasNextLine()) {
                    writer.print("\t\t<tr><td>");
                    String string = scanner.nextLine();
                    for (int i = 0; i < string.length(); i++) {
                        if (string.charAt(i) == '"') {
                            if ((i + 1) < string.length() && string.charAt(i + 1) == '"') {
                                writer.print(string.charAt(i));
                                i += 2;
                            } else {
                                inQuotes = !inQuotes;
                            }
                        } else if (string.charAt(i) == delimiter) {
                            if (inQuotes) {
                                writer.print(delimiter);
                            } else {
                                writer.print("</td><td>");
                                if (i == string.length() - 1) {
                                    writer.println("</td></tr>");
                                }
                            }
                        } else if (i == string.length() - 1 && inQuotes) {
                            writer.print(string.charAt(i));
                            writer.print("<br/>");
                            string = scanner.nextLine();
                            i = -1;
                        } else if (i == string.length() - 1 && !inQuotes) {
                            writer.print(string.charAt(i));
                            writer.println("</td></tr>");
                        } else {
                            writer.print(string.charAt(i));
                        }
                    }
                }
                writer.println("\t</table>");
                writer.println("</body>");
                writer.println("</html>");
            } catch (FileNotFoundException e) {
                System.out.printf("Input file %s not found. Try again.", args[0]);
            }
        }
    }
}