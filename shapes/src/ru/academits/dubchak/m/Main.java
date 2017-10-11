package ru.academits.dubchak.m;

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
        getMaxAreaShape(shapes);
        getMaxPerimeterShape(shapes);
    }

    private static void getMaxAreaShape(Shape shapes[]) {
        Arrays.sort(shapes, new ShapeAreaComparator());
        System.out.printf("Max area shape is %s Area is %f%n", shapes[shapes.length - 1].toString(), shapes[shapes.length - 1].getArea());
    }

    private static void getMaxPerimeterShape(Shape shapes[]) {
        Arrays.sort(shapes, new ShapePerimeterComparator());
        System.out.printf("Second perimeter shape is %s Perimeter is %f%n", shapes[shapes.length - 2].toString(), shapes[shapes.length - 2].getPerimeter());
    }
}
