package ru.academits.dubchak.csv;

import java.util.ArrayList;
import java.util.List;

public class CsvRecord {
    private List<String> data;

    public CsvRecord() {
        data = new ArrayList<String>();
    }

    public void addValue(String value) {
        data.add(value);
    }

    public void removeValue(String value) {
        data.remove(value);
    }

    public void removeValue(int index) {
        data.remove(index);
    }

    public String getValue(int index) {
        return data.get(index);
    }

    public List<String> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "CsvRecord{" +
                "data=" + data +
                '}';
    }
}