import java.util.ArrayList;

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
        System.out.println(getMaxShapeArea(shapes));
        System.out.println(getMaxShapeArea(shapes).getArea());
        System.out.println(getMaxShapePerimeter(shapes));
        System.out.println(getMaxShapeArea(shapes).getPerimeter());
    }

    public static Shape getMaxShapeArea(Shape[] shapes) {
        int shapeIndex = 0;
        double maxArea = shapes[0].getArea();
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > maxArea) {
                maxArea = shapes[i].getArea();
                shapeIndex = i;
            }
        }
        return shapes[shapeIndex];
    }

    public static Shape getMaxShapePerimeter(Shape[] shapes) {
        int shapeIndex = 0;
        double maxPerimeter = shapes[0].getArea();
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > maxPerimeter) {
                maxPerimeter = shapes[i].getPerimeter();
                shapeIndex = i;
            }
        }
        return shapes[shapeIndex];
    }
}
