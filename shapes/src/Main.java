import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(0.5),
                new Triangle(1, 1, 2, 5, 3, 4),
                new Rectangle(2, 10),
                new Circle(3),
                new Square(1),
                new Triangle(0, 0, 1, 5, 3, 4),
                new Rectangle(4, 8),
                new Circle(5)
        };
        System.out.println(getMaxShapeArea(shapes));
        System.out.println(getMaxShapeArea(shapes).getArea());
        //        ArrayList<Shape> shapes = new ArrayList();
//        shapes.add(new Square(10));
//        shapes.add(new Triangle(1, 1, 2, 5, 3, 4));
//        shapes.add(new Rectangle(2, 10));
//        shapes.add(new Circle(3));
//        shapes.add(new Square(10));
//        shapes.add(new Triangle(0, 0, 1, 5, 3, 4));
//        shapes.add(new Rectangle(4, 8));
//        shapes.add(new Circle(5));
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
}
