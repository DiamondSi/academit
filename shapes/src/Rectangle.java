public class Rectangle implements Shape {
    double width;
    double hight;

    public Rectangle(double width, double hight) {
        this.width = width;
        this.hight = hight;
    }

    @Override
    public double getWidth() {

        return width;
    }

    @Override
    public double getHeight() {
        return hight;
    }

    @Override
    public double getArea() {
        return width * hight;
    }

    @Override
    public double getPerimeter() {
        return width + width + hight + hight;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", hight=" + hight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        if (Double.compare(rectangle.getWidth(), getWidth()) != 0) return false;
        return Double.compare(rectangle.hight, hight) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getWidth());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(hight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
