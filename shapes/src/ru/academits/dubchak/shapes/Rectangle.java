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
        if (this == o) return true;
        if (!(getClass()==o.getClass())) return false;
        Rectangle rectangle = (Rectangle) o;
        if (Double.compare(rectangle.getWidth(), getWidth()) != 0) return false;
        return Double.compare(rectangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getWidth());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}