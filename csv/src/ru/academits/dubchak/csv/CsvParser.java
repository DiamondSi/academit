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
//        try (Scanner scanner = new Scanner(new FileInputStream(args[0]), "windows-1251");
        try (Scanner scanner = new Scanner(new FileInputStream(args[0]));
             PrintWriter writer = new PrintWriter("./csv/src/" + args[1])) {
            char delimiter = args[2].charAt(0);
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta charset=\"utf-8\" />");
            writer.println("<title>HTML Document</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<table border=\"1\" cellspacing=\"0\">");
            boolean inQuotes = false;
            while (scanner.hasNext()) {
                writer.print("<tr>");
                writer.print("<td>");
                String string = scanner.nextLine();
                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) == '"') {
                        if ((i + 1) < string.length() && string.charAt(i + 1) == '"') {
                            writer.print("\"");
                            i++;
                        } else {
                            inQuotes = !inQuotes;
                        }
                    } else if (string.charAt(i) == delimiter) {
                        if (inQuotes) {
                            writer.print(delimiter);
                        } else writer.print("</td>");
                    } else {
                        writer.print(string.charAt(i));
                    }

                }
                writer.print("</td>");
                writer.println("</tr>");
            }
            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }
}