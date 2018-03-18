package ru.academits.dubchak.csv;

import java.util.ArrayList;
import java.util.List;

public class CsvFile {
    private String path;
    private String name;
    private List<CsvRecord> records;

    public CsvFile(String path, String name) {
        this.path = path;
        this.name = name;
        this.records = new ArrayList<CsvRecord>();

    }

    public void addRecord(CsvRecord record) {
        records.add(record);
    }

    public void removeRecord(CsvRecord record) {
        records.remove(record);
    }

    public void removeRecord(int index) {
        records.remove(index);
    }

    public CsvRecord getRecord(int index) {
        return records.get(index);
    }

    @Override
    public String toString() {
        String string = "CsvFile (path:" + path + ", name=" + name + ")\n{";
        for (CsvRecord record : records) {
            string += record + "\n";
        }
        return string + "}";
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public List<CsvRecord> getRecords() {
        return records;
    }
}
