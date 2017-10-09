package ru.academits.dubchak.shapes;

import java.util.Comparator;

public class Square implements Shape, Comparable {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getWidth() {
        return side;
    }

    @Override
    public double getHeight() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        int SIDES_COUNT = 4;
        return SIDES_COUNT * side;
    }

    @Override
    public String toString() {
        return String.format("Square[side=%f]",side);
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(side);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(getClass()==o.getClass())){
            return false;
        }
        Square square = (Square) o;
        return Double.compare(square.side, side) == 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
