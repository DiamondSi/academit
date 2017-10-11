package ru.academits.dubchak.shapes;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {

        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return width + width + height + height;
    }

    @Override
    public String toString() {
        return String.format("Rectangle[width=%f; height=%f]", width, height);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.getWidth(), getWidth()) == 0 && Double.compare(rectangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int hash = 1;
        hash = PRIME * hash + (int) height;
        hash = PRIME * hash + (int) width;
        return hash;
    }
}
