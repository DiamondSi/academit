package ru.academits.dubchak.vector.main;

import ru.academits.dubchak.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(10);
        System.out.printf("vector1: %s%n", vector1);
        Vector vector2 = new Vector(vector1);
        System.out.printf("vector2: %s%n", vector2);
        double[] array = {1, 22, 3, 4, 21, 3};
        Vector vector3 = new Vector(array);
        System.out.printf("vector3: %s%n", vector3);
        Vector vector4 = new Vector(10, array);
        System.out.printf("vector4: %s%n", vector4);
        System.out.printf("vector4 * vector3:%s%n", vector4.addVector(vector3));
        System.out.printf("vector3 - vector4:%s%n", vector3.subVector(vector4));
        final int MULTIPLIER = 100;
        System.out.println(vector3.scalarMultiplicateVector(MULTIPLIER));
        System.out.println(vector4.scalarMultiplicateVector(MULTIPLIER));
        System.out.printf("reverse vector4:%s%n", vector3.reverseVector());
        System.out.printf("vector 4 module:%s", vector4.getLength());
    }
}
