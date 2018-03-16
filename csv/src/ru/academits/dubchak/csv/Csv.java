package ru.academits.dubchak.csv;

import java.io.*;
import java.util.Scanner;

public class Csv {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length < 2) {
            throw new IllegalArgumentException("The number of arguments is not valid. " +
                    "There must be two arguments at least:" + args.length);
        }
        System.out.println(args[0]);
        try (Scanner scanner = new Scanner(new FileInputStream(args[0]), "windows-1251");
             PrintWriter writer = new PrintWriter("./csv/src/" + args[1])) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta charset=\"utf-8\" />");
            writer.println("<title>HTML Document</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<table border=\"1\">");
            while (scanner.hasNext()) {
                writer.print("<tr>");
                writer.print("<td>");
                writer.print(scanner.nextLine());
                writer.print("</td>");
                writer.println("</tr>");
            }
            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }
}
