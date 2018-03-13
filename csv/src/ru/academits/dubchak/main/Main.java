package ru.academits.dubchak.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/etc/config.properties");
            property.load(fis);
            System.out.println(property.getProperty("destination.file"));
            System.out.println(property.getProperty("source.csv"));
            System.out.println(property.getProperty("destination.field001"));
            System.out.println(property.getProperty("destination.field002"));
            System.out.println(property.getProperty("destination.field003"));
            System.out.println(property.getProperty("destination.field004"));
            System.out.println(property.getProperty("destination.field005"));
            System.out.println(property.getProperty("destination.field006"));
            System.out.println(property.getProperty("destination.field007"));
            System.out.println(property.getProperty("destination.field008"));
            System.out.println(property.getProperty("destination.field009"));
            System.out.println(property.getProperty("destination.field010"));
            System.out.println(property.getProperty("destination.field011"));
            System.out.println(property.getProperty("destination.field012"));
            System.out.println(property.getProperty("destination.field013"));
            System.out.println(property.getProperty("destination.field014"));
            System.out.println(property.getProperty("destination.field015"));
            System.out.println(property.getProperty("destination.field016"));
            System.out.println(property.getProperty("destination.field017"));
            System.out.println(property.getProperty("destination.field018"));
            System.out.println(property.getProperty("destination.field019"));
            System.out.println(property.getProperty("destination.field020"));
            System.out.println(property.getProperty("destination.field021"));
            System.out.println(property.getProperty("destination.field022"));
            System.out.println(property.getProperty("destination.field024"));
            System.out.println(property.getProperty("destination.field025"));
            System.out.println(property.getProperty("destination.field026"));

            FileInputStream settings = new FileInputStream(new File(property.getProperty("source.csv")));
//            XSSFWorkbook wb = new XSSFWorkbook(settings);
//            XSSFSheet settingssheet = wb.getSheetAt(0);
//            Row row = settingssheet.getRow(0);
//            Cell cell = row.getCell(0);
//            System.out.println(cell.getStringCellValue());
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
