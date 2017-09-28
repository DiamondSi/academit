package ru.academits.dubchak.range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(10, 20);
        System.out.printf("range [%f .. %f] length:%f%n", range.getFrom(), range.getTo(), range.getLength());
        System.out.printf("point 15 is inside: %b%n", range.isInside(15));

        range.setFrom(15);
        range.setTo(35);
        System.out.printf("range [%f .. %f] length:%f%n", range.getFrom(), range.getTo(), range.getLength());
        System.out.printf("point 30 is inside: %b%n", range.isInside(30));

        Range range1 = new Range(5, 30);
        System.out.printf("range [%f .. %f] length:%f%n", range1.getFrom(), range1.getTo(), range1.getLength());
        Range range2 = new Range(5, 10);
        System.out.printf("range [%f .. %f] length:%f%n", range2.getFrom(), range2.getTo(), range2.getLength());

        if (range1.getIntersection(range2) != null) {
            Range intersection = range1.getIntersection(range2);
            System.out.printf("Intersection is: %f %f%n", intersection.getFrom(), intersection.getTo());
        } else {
            System.out.println("Intersection is: null");
        }

        System.out.println("Union is:");
        for (Range r : range1.getUnion(range2)) {
            System.out.printf("%f %f%n", r.getFrom(), r.getTo());
        }

        System.out.println("Difference is:");
        for (Range r : range1.getDifference(range2)) {
            System.out.printf("%f %f%n", r.getFrom(), r.getTo());
        }
    }
}
