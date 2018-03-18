package ru.academits.dubchak.csv;

import java.io.*;
import java.util.Scanner;

public class CsvP {
    public static CsvFile parseFile(String csvFile, char delimiter) throws IOException {
//        CsvFile file = new CsvFile(csvFile.getPath(), csvFile.getName());
        CsvFile file = new CsvFile(csvFile, csvFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "windows-1251"));
//        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        String line;
        while ((line = br.readLine()) != null) {
            CsvRecord record = processRecord(line, delimiter);
            file.addRecord(record);
        }
        br.close();
        return file;
    }

    private static CsvRecord processRecord(String line, char delimiter) {
        if (line == null || line.equals("")) {
            return null;
        }
        CsvRecord record = new CsvRecord();
        boolean inQuotes = false;
        char chars[] = line.toCharArray();
        StringBuffer value = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\"') {
                if ((i + 1) < chars.length && chars[i + 1] == '\"') {
                    value.append("\"");
                    i++;
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (chars[i] == delimiter) {
                if (inQuotes) {
                    value.append(delimiter);
                } else {
                    record.addValue(value.toString());
                    value = new StringBuffer();
                }
            } else {
                value.append(chars[i]);
            }
        }
        record.addValue(value.toString());
        return record;
    }
}
