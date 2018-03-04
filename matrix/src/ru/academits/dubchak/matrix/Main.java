package ru.academits.dubchak.matrix;

import ru.academits.dubchak.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(2, 3);
        System.out.println(matrix);
        Matrix matrix1 = new Matrix(matrix);
        System.out.println(matrix1);
        System.out.println(matrix1.transpose());
    }
}
