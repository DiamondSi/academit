package ru.academits.dubchak.matrix;

import ru.academits.dubchak.vector.Vector;

public class Main {
    public static void main(String[] args) {
//        Matrix matrix = new Matrix(2, 3);
//        System.out.println(matrix);
//        Matrix matrix1 = new Matrix(matrix);
//        System.out.println(matrix1);
//        System.out.println(matrix1.transpose());
//        System.out.println(matrix1);
//        System.out.println();
//        double[][] array={{1,2},{3,4},{5,6},{7,8},{9,10}};
//        Matrix matrix2=new Matrix(array);
//        System.out.println(matrix2);
//        System.out.println(matrix2.scalarMultiplicationMatrix(2));
//        System.out.println(matrix2);
//        double[][] array2={{1,2,3},{4,5,6},{7,8,9}};
        double[][] array2={{1,2},{4,5},{7,8}};
        Matrix matrix3=new Matrix(array2);
        System.out.println(matrix3);
//        System.out.println(matrix3.getDeterminant());
        double[] array3 = {2, 3};
        Vector vector1 = new Vector(array3);
        Vector vector2= matrix3.multiplyMatixVector(vector1);
        System.out.println(vector2);
    }
}
