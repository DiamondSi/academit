package ru.academits.dubchak.csv;

import java.io.*;
import java.util.Properties;
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
            while (scanner.hasNext()) {
                writer.println(scanner.nextLine());
            }
        }
    }
}
