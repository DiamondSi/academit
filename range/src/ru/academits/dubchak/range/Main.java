package ru.academits.dubchak.range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(10, 20);
        System.out.println(range.getLength());
        System.out.println(range.isInside(15));
        range.setFrom(15);
        range.setTo(30);
        System.out.println(range.getLength());
        System.out.println(range.isInside(30));
        Range range1 = new Range(5, 30);
        System.out.println("range1: " + range1.getFrom() + ", " + range1.getTo());
        Range range2 = new Range(45, 50);
        System.out.println("range2: " + range2.getFrom() + ", " + range2.getTo());
        if (range1.getIntersection(range2) != null) {
            Range intersection = range1.getIntersection(range2);
            System.out.printf("Intersection is: %f %f%n", intersection.getFrom(), intersection.getTo());
        } else{
            System.out.println("Intersection is: null");
        }
        Range[] union = range1.getUnion(range2);
        System.out.println("Union is:");
        for (Range r : union) {
            System.out.printf("%f %f%n", r.getFrom(), r.getTo());
        }
    }
}
