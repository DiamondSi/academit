package ru.academits.dubchak.shapes;

import java.util.Comparator;

public class ShapeAreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape, Shape t1) {
        if (shape.getArea() > t1.getArea()) {
            return 1;
        }
        if (shape.getArea() < t1.getArea()) {
            return -1;
        } else return 0;
    }
}
