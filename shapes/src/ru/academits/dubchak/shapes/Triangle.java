package ru.academits.dubchak.shapes;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    private double getSideLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    @Override
    public double getArea() {
        double a = getSideLength(x1, y1, x2, y2);
        double b = getSideLength(x2, y2, x3, y3);
        double c = getSideLength(x3, y3, x1, y1);
        return (Math.sqrt((a + b - c) * (a - b + c) * (-a + b + c) * (a + b + c))) / 4;
    }

    @Override
    public double getPerimeter() {
        return getSideLength(x1, y1, x2, y2) + getSideLength(x2, y2, x3, y3) + getSideLength(x3, y3, x1, y1);
    }

    @Override
    public String toString() {
        return String.format("Triangle[(x1=%f; y1=%f); (x2=%f; y2=%f); (x3=%f; y3=%f)]", x1, y1, x2, y2, x3, y3);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x1);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y1);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(x2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(x3);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y3);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(getClass() == o.getClass())) return false;
        Triangle triangle = (Triangle) o;
        if (Double.compare(triangle.x1, x1) != 0) return false;
        if (Double.compare(triangle.y1, y1) != 0) return false;
        if (Double.compare(triangle.x2, x2) != 0) return false;
        if (Double.compare(triangle.y2, y2) != 0) return false;
        if (Double.compare(triangle.x3, x3) != 0) return false;
        return Double.compare(triangle.y3, y3) == 0;
    }
}
