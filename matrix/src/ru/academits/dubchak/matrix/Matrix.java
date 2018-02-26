package ru.academits.dubchak.matrix;

import ru.academits.dubchak.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] vectors;

    // TODO 1.Конструкторы:
    // 1.a.	Matrix(n, m) – матрица нулей размера nxm
    public Matrix(int columns, int rows) {
        if (rows <= 0) {
            throw new IllegalArgumentException(Integer.toString(rows));
        }
        if (columns <= 0) {
            throw new IllegalArgumentException(Integer.toString(columns));
        }
        vectors = new Vector[rows];
        for (int i = 0; i < rows; i++) {
            vectors[i] = new Vector(columns);
        }
    }
    //TODO 1.b.	Matrix(Matrix) – конструктор копирования
public Matrix(Matrix matrix){

}
    //TODO 1.c.Matrix(double[][]) – из двумерного массива
    //TODO 1.d.Matrix(Vector[]) – из массива векторов-строк

    //TODO 2.	Методы:
    //TODO 2.a.	Получение размеров матрицы
    //TODO 2.b.	Получение и задание вектора-строки по индексу
    //TODO 2.c.	Получение вектора-столбца по индексу
    //TODO 2.d.	Транспонирование матрицы
    //TODO 2.e.	Умножение на скаляр
    //TODO 2.f.	Вычисление определителя матрицы
    //TODO 2.g.	toString определить так, чтобы выводить в виде { { 1, 2 }, { 2, 3 } }
    @Override
    public String toString() {
        return "{" +
                Arrays.toString(vectors) +
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