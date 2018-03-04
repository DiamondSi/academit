package ru.academits.dubchak.matrix;

import ru.academits.dubchak.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] rows;

    // TODO 1.Конструкторы:
    // 1.a.	Matrix(n, m) – матрица нулей размера nxm
    public Matrix(int columns, int rows) {
        if (rows <= 0) {
            throw new IllegalArgumentException(Integer.toString(rows));
        }
        if (columns <= 0) {
            throw new IllegalArgumentException(Integer.toString(columns));
        }
        this.rows = new Vector[rows];
        for (int i = 0; i < rows; i++) {
            this.rows[i] = new Vector(columns);
        }
    }

    //1.b.	Matrix(Matrix) – конструктор копирования
    public Matrix(Matrix matrix) {
        int matrixRows = matrix.rows.length;
        this.rows = new Vector[matrixRows];
        for (int i = 0; i < matrixRows; i++) {
            this.rows[i] = new Vector(matrix.rows[i]);
        }
    }

    //TODO 1.c.Matrix(double[][]) – из двумерного массива
    public Matrix(double[][] array) {
        int matrixRows = array.length;
        this.rows = new Vector[matrixRows];
        for (int i = 0; i < matrixRows; i++) {
            this.rows[i] = new Vector(array[i]);
        }
    }

    //TODO 1.d.Matrix(Vector[]) – из массива векторов-строк
    public Matrix(Vector[] vector) {
        int matrixRows = vector.length;
        this.rows = new Vector[matrixRows];
        for (int i = 0; i < matrixRows; i++) {
            this.rows[i] = new Vector(vector[i]);
        }
    }

    //TODO 2.	Методы:
    //2.a.	Получение размеров матрицы
    public int getRowsCount() {
        return rows.length;
    }

    public int gerColumnsCount() {
        return rows[0].getSize();
    }

    //2.b.	Получение и задание вектора-строки по индексу
    public Vector getRow(int index) {
        int rowCount = getRowsCount();
        if (index < 0 || index >= rowCount) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        return rows[index];
    }

    public void setRow(int index, Vector vector) {
        int rowCount = getRowsCount();
        if (index < 0 || index >= rowCount) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        rows[index] = new Vector(vector);
    }

    //TODO 2.c.	Получение вектора-столбца по индексу
    //TODO 2.d.	Транспонирование матрицы
    //TODO 2.e.	Умножение на скаляр
    //TODO 2.f.	Вычисление определителя матрицы
    //TODO 2.g.	toString определить так, чтобы выводить в виде { { 1, 2 }, { 2, 3 } }
    @Override
    public String toString() {
        return "{" +
                Arrays.toString(rows) +
                '}';
    }

    //TODO 2.h.	умножение матрицы на вектор
    //TODO 2.i.	Сложение матриц
    //TODO 2.j.	Вычитание матриц

    //TODO 3.	Статические методы:
    //TODO 3.a.	Сложение матриц
    //TODO 3.b.	Вычитание матриц
    //TODO 3.c.	Умножение матриц
}