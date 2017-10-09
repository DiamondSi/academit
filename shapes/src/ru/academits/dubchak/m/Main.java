package ru.academits.dubchak.m;

import ru.academits.dubchak.shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(0.5),
                new Triangle(1, 1, 2, 5, 3, 4),
                new Rectangle(2, 10),
                new Circle(3),
                new Square(32),
                new Triangle(0, 0, 1, 5, 3, 4),
                new Rectangle(4, 8),
                new Circle(1)
        };
        for (Shape shape : shapes) {
            System.out.print(shape);
            System.out.print(shape.getPerimeter());
            System.out.print(" ");
            System.out.println(shape.getArea());
        }
        Arrays.sort(shapes, new ShapeAreaComparator());
        System.out.println();
        for (Shape shape : shapes) {
            System.out.print(shape);
            System.out.print(shape.getPerimeter());
            System.out.print(" ");
            System.out.println(shape.getArea());
        }
        Arrays.sort(shapes, new ShapePerimeterComparator());
        System.out.println();
        for (Shape shape : shapes) {
            System.out.print(shape);
            System.out.print(shape.getPerimeter());
            System.out.print(" ");
            System.out.println(shape.getArea());
        }
    }
}
