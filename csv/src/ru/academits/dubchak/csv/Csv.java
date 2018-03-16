package ru.academits.dubchak.csv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Csv {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length < 2) {
            throw new IllegalArgumentException("The number of arguments is not valid. " +
                    "There must be two arguments at least:" + args.length);
        }
        System.out.println(args[0]);
        try (Scanner scanner = new Scanner(new FileInputStream(args[0]),"windows-1251")) {
            while (scanner.hasNext()) {
                String inputString = scanner.next();
                System.out.println(inputString);
            }
        }
    }
}
