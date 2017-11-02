package ru.academits.dubchak.main;

import ru.academits.dubchak.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(10);
        System.out.printf("vector1 created by Vector(n): %s%n%n", vector1);

        Vector vector2 = new Vector(vector1);
        System.out.printf("vector2 created by Vector(Vector): %s%n%n", vector2);

        double[] array = {1, 22, 3, 4, 21, 3};
        Vector vector3 = new Vector(array);
        System.out.printf("vector3 created by Vector(double[]): %s%n%n", vector3);

        Vector vector4 = new Vector(10, array);
        System.out.printf("vector4 created by Vector(n, double[]): %s%n%n", vector4);


        System.out.printf("vector3 + vector4:%s%n%n", vector3.addVector(vector4));

        System.out.printf("vector3 - vector4:%s%n%n", vector3.subVector(vector4));

        final int MULTIPLIER = 100;
        System.out.printf("vector3 * %d: %s%n%n", MULTIPLIER, vector3.scalarMultiplicationVector(MULTIPLIER));

        System.out.printf("reverse vector4: %s%n%n", vector4.reverseVector());

        System.out.printf("vector4 module: %s%n%n", vector4.getLength());
        int index = 1;
        System.out.printf("vector4[%d]: %s%n%n", index, vector4.getElement(index));

        index = 7;
        double value = 555;
        System.out.printf("vector4[%d]: %s%n", index, vector4.getElement(index));
        vector4.setElement(index, value);
        System.out.printf("vector4[%d] has set to: %s%n%n", index, vector4.getElement(index));

        double[] array2 = {1, 22, 3, 4, 221, 2};
        Vector vector5 = new Vector(array2);
        double[] array3 = {11, 22, 3, 4, 22, 1};
        Vector vector6 = new Vector(array3);
        System.out.printf("vector5 %s equals to vector6 %s: %s%n%n", vector5, vector6, vector5.equals(vector6));

        System.out.printf("Sum vector5 %s vector6 %s: %s%n%n", vector5, vector6, Vector.getSumVector(vector5, vector6));

        System.out.printf("Subtraction vector5 %s vector6 %s: %s%n%n", vector5, vector6, Vector.getSubVector(vector5, vector6));


        double[] array4 = {1, 1, 1, 1, 1, 1, 1, 1, 3, 4, 1, 1, 1};
        double[] array5 = {2, 1};
        Vector vector7 = new Vector(array4);
        Vector vector8 = new Vector(array5);
        System.out.printf("Scalar multiplication vector6 %s vector7 %s: %s%n%n", vector7, vector8, Vector.multiplicationVector(vector7, vector8));
    }
}
