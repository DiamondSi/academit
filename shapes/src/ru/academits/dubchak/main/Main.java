package ru.academits.dubchak.main;

import ru.academits.dubchak.shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(0.5),
                new Triangle(1, 1, 2, 5, 3, 4),
                new Rectangle(2, 10),
                new Circle(30),
                new Square(32),
                new Triangle(0, 0, 1, 5, 3, 4),
                new Rectangle(4, 8),
                new Circle(1)
        };
        System.out.println(getMaxAreaShape(shapes));
        System.out.println(getSecondMaxPerimeterShape(shapes));
    }

    private static Shape getMaxAreaShape(Shape shapes[]) {
        Arrays.sort(shapes, new ShapeAreaComparator());
        return shapes[shapes.length - 1];
    }

    private static Shape getSecondMaxPerimeterShape(Shape shapes[]) {
        Arrays.sort(shapes, new ShapePerimeterComparator());
        return shapes[shapes.length - 2];
    }
}