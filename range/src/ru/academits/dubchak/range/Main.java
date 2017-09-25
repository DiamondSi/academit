package ru.academits.dubchak.range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(10, 20);
        System.out.println(range.getLength());
        System.out.println(range.isInside(15));
        range.setFrom(15);
        range.setTo(30);
        System.out.println(range.getLength());
        System.out.println(range.isInside(30));
        Range range1 = new Range(10,20);
        Range range2 = new Range(5,30);
    }
}
