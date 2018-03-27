package ru.academits.dubchak.csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import org.apache.commons.csv.CSVRecord

public class CsvParser {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length < 3) {
            throw new IllegalArgumentException("The number of arguments is not valid. " +
                    "There must be three arguments at least:" + args.length);
        }
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
            boolean inQuotes;
            while (scanner.hasNextLine()) {
                writer.print("\t\t<tr>");
                writer.print("<td>");
                String string = scanner.nextLine();
                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) == '"') {
                        inQuotes = true;
                        i++;
                        while (inQuotes) {
                            if (i == string.length() - 1) {
                                writer.println("</td></tr>");
                                inQuotes = false;
                            } else if (string.charAt(i) == '"' && string.charAt(i + 1) == '"') {
                                writer.print(string.charAt(i + 1));
                                i = i + 2;
                            } else if (string.charAt(i) != '"') {
                                while (string.charAt(i) != '"') {
                                    writer.print(string.charAt(i));
                                    i++;
                                    if (i == string.length()) {
                                        writer.print("<br/>");
                                        string = scanner.nextLine();
                                        i = 0;
                                    }
                                }
                            } else {
                                inQuotes = false;
                            }
                        }
                    } else if (string.charAt(i) == delimiter) {
                        writer.print("</td><td>");
                        if (i == string.length() - 1) {
                            writer.println("</td></tr>");
                        }
                    } else {
                        while (string.charAt(i) != delimiter) {
                            writer.print(string.charAt(i));
                            if (i == string.length() - 1) {
                                writer.println("</td></tr>");
                                break;
                            } else if (string.charAt(i + 1) == delimiter && i != string.length() - 1) {
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
            writer.println("\t</table>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }
}