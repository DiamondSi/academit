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
        return width*hight;
    }

    @Override
    public double getPerimeter() {
        return width+width+hight+hight;
    }
}
