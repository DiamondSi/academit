package ru.academits.dubchak.matrix;

import ru.academits.dubchak.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] rows;

    // 1.Конструкторы:
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

    //1.c.Matrix(double[][]) – из двумерного массива
    public Matrix(double[][] array) {
        int rowsCount = array.length;
        if (rowsCount <= 0) {
            throw new IllegalArgumentException(Integer.toString(rowsCount));
        }
        int columnsCount = 0;
        for (double[] vector : array) {
            columnsCount = Math.max(columnsCount, vector.length);
        }
        if (columnsCount <= 0) {
            throw new IllegalArgumentException(Integer.toString(columnsCount));
        }
        this.rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            this.rows[i] = new Vector(columnsCount, array[i]);
        }
    }

    //1.d.Matrix(Vector[]) – из массива векторов-строк
    public Matrix(Vector[] vectors) {
        int rowsCount = vectors.length;
        if (rowsCount <= 0) {
            throw new IllegalArgumentException(Integer.toString(rowsCount));
        }
        int columnsCount = 0;
        for (Vector vector : vectors) {
            columnsCount = Math.max(columnsCount, vector.getSize());
        }
        if (columnsCount <= 0) {
            throw new IllegalArgumentException(Integer.toString(columnsCount));
        }
        this.rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            this.rows[i] = new Vector(columnsCount);
            for (int j = 0; j < vectors[i].getSize(); j++) {
                this.rows[i].setElement(j, vectors[i].getElement(j));
            }
        }
    }

    //3.	Статические методы:
    //3.a.	Сложение матриц
    public static Matrix getSumMatrix(Matrix matrix1, Matrix matrix2) {
        return new Matrix(matrix1).sumMatrix(matrix2);
    }

    //3.b.	Вычитание матриц
    public static Matrix getSubMatrix(Matrix matrix1, Matrix matrix2) {
        return new Matrix(matrix1).subMatrix(matrix2);
    }

    //3.c.	Умножение матриц
    public static Matrix multiply(Matrix matrix1, Matrix matrix2) {
        int matrix1ColumnsCount = matrix1.getColumnsCount();
        int matrix2RowsCount = matrix2.getRowsCount();
        if (matrix1ColumnsCount != matrix2RowsCount) {
            throw new IllegalArgumentException("Matrices are not consistent");
        }

        int matrix1RowsCount = matrix1.getRowsCount();
        int matrix2ColumnsCount = matrix2.getColumnsCount();
        Matrix resultMatrix = new Matrix(matrix1RowsCount, matrix2ColumnsCount);
        for (int i = 0; i < matrix1RowsCount; i++) {
            Vector resultVector = new Vector(matrix2ColumnsCount);
            for (int j = 0; j < matrix2ColumnsCount; j++) {
                resultVector.setElement(j, Vector.multiplicationVector(matrix1.getRow(i), matrix2.getColumn(j)));
            }
            resultMatrix.setRow(i, resultVector);
        }
        return resultMatrix;
    }

    //2.	Методы:
    //2.a.	Получение размеров матрицы
    public int getRowsCount() {
        return rows.length;
    }

    public int getColumnsCount() {
        return rows[0].getSize();
    }

    //2.b.	Получение и задание вектора-строки по индексу
    public Vector getRow(int index) {
        int rowCount = getRowsCount();
        if (index < 0 || index >= rowCount) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        return new Vector(rows[index]);
    }

    public void setRow(int index, Vector vector) {
        int rowCount = getRowsCount();
        if (index < 0 || index >= rowCount) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        rows[index] = new Vector(vector);
    }

    //2.c.	Получение вектора-столбца по индексу
    public Vector getColumn(int index) {
        int columnCount = getColumnsCount();
        if (index < 0 || index >= columnCount) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        int rowsCount = getRowsCount();
        Vector vector = new Vector(rowsCount);
        for (int i = 0; i < rowsCount; i++) {
            vector.setElement(i, rows[i].getElement(index));
        }
        return vector;
    }

    //2.d.	Транспонирование матрицы
    public Matrix transpose() {
        int rowsCount = getColumnsCount();
        Vector[] vectors = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            vectors[i] = getColumn(i);
        }
        rows = vectors;
        return this;
    }

    //2.e.	Умножение на скаляр
    public Matrix scalarMultiplicationMatrix(double scalar) {
        for (Vector row : rows) {
            row.scalarMultiplicationVector(scalar);
        }
        return this;
    }

    //2.f.	Вычисление определителя матрицы
    public double getDeterminant() {
        int rowCount = getRowsCount();
        int columnsCount = getColumnsCount();

        if (rowCount != columnsCount) {
            throw new IllegalArgumentException("matrix is non-square");
        }

        Matrix matrix = new Matrix(this);
        int permutationsCount = 0;
        for (int i = 0; i < columnsCount; i++) {
            for (int j = i + 1; j < rowCount; j++) {
                if (matrix.rows[j].getElement(i) != 0) {
                    if (matrix.getIndexMaxElement(i) != i) {
                        Vector vector = matrix.rows[i];
                        matrix.rows[i] = matrix.rows[j];
                        matrix.rows[j] = vector;
                        ++permutationsCount;
                        double num = matrix.rows[j].getElement(i) / matrix.rows[i].getElement(i);
                        for (int k = i; k < columnsCount; k++) {
                            matrix.rows[j].setElement(k, matrix.rows[j].getElement(k) - matrix.rows[i].getElement(k) * num);
                        }
                    }
                }
                if (matrix.rows[i].getElement(i) == 0) {
                    return 0;
                }
            }
        }
        double det = 1;
        for (int i = 0; i < columnsCount; i++) {
            det *= matrix.rows[i].getElement(i);
        }
        if (permutationsCount % 2 != 0) {
            return -det;
        }
        return det;
    }

    private int getIndexMaxElement(int index) {
        Vector column = getColumn(index);
        double maxValue = Math.abs(column.getElement(index));
        int temp = index;
        for (int i = index; i < getRowsCount(); i++) {
            if (Math.abs(column.getElement(i)) > maxValue) {
                maxValue = Math.abs(column.getElement(i));
                temp = i;
            }
        }
        return temp;
    }

    //2.g.	toString определить так, чтобы выводить в виде { { 1, 2 }, { 2, 3 } }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append(rows[0]);
        for (int i = 1; i < rows.length; i++) {
            stringBuilder.append(",");
            stringBuilder.append(rows[i]);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    //2.h.	умножение матрицы на вектор
    public Vector multiplyMatrixVector(Vector vector) {
        int matrixColumnsCount = getColumnsCount();
        int vectorSize = vector.getSize();
        if (vectorSize != matrixColumnsCount) {
            throw new IllegalArgumentException("The matrix and the vector are not consistent");
        }
        int resultLength = getRowsCount();
        Vector resultVector = new Vector(resultLength);
        for (int i = 0; i < resultLength; i++) {
            resultVector.setElement(i, Vector.multiplicationVector(getRow(i), vector));
        }
        return resultVector;
    }

    //2.i.	Сложение матриц
    public Matrix sumMatrix(Matrix matrix) {
        int rowsCounts = getRowsCount();
        int columnsCounts = getColumnsCount();
        int matrixRowsCounts = matrix.getRowsCount();
        int matrixColumnsCounts = matrix.getColumnsCount();
        if (rowsCounts != matrixRowsCounts || columnsCounts != matrixColumnsCounts) {
            throw new IllegalArgumentException("Matrices are not consistent");
        }
        for (int i = 0; i < rowsCounts; i++) {
            rows[i].addVector(matrix.getRow(i));
        }
        return this;
    }

    //2.j.	Вычитание матриц
    public Matrix subMatrix(Matrix matrix) {
        int rowsCounts = getRowsCount();
        int columnsCounts = getColumnsCount();
        int matrixRowsCounts = matrix.getRowsCount();
        int matrixColumnsCounts = matrix.getColumnsCount();
        if (rowsCounts != matrixRowsCounts || columnsCounts != matrixColumnsCounts) {
            throw new IllegalArgumentException("Matrices are not consistent");
        }
        for (int i = 0; i < rowsCounts; i++) {
            rows[i].subVector(matrix.getRow(i));
        }
        return this;
    }

}