package ru.academits.dubchak.shapes;

import java.util.Comparator;

public class ShapePerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape, Shape t1) {
        if (shape.getPerimeter() > t1.getPerimeter()) {
            return 1;
        }
        if (shape.getPerimeter() < t1.getPerimeter()) {
            return -1;
        } else return 0;
    }
}
