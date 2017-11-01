package ru.academits.dubchak.vector;

import java.util.Arrays;

public class Vector {
    private double[] vector;

    public Vector(int n) {
        vector = new double[n];
    }

    public Vector(Vector vector) {
        this.vector = Arrays.copyOf(vector.vector, vector.vector.length);
    }

    public Vector(double[] vector) {
        this.vector = vector;
    }

    public Vector(int n, double[] vector) {
        if (vector.length < n) {
            this.vector = Arrays.copyOf(vector, n);
        } else {
            this.vector = Arrays.copyOf(vector, vector.length);
        }
    }

    public double getVectorElementByIndex(int index) {
        return this.vector[index];
    }

    public void setVectorElementByIndex(int index, double value) {
        this.vector[index] = value;
    }

    private int getSize() {
        return vector.length;
    }

    public Vector addVector(Vector vector) {
        int resultLength = getSize() > vector.getSize() ? getSize() : vector.getSize();
        double[] resultArray = Arrays.copyOf(this.vector, resultLength);
        for (int i = 0; i < vector.getSize(); i++) {
            resultArray[i] += vector.vector[i];
        }
        this.vector = resultArray;
        return this;
    }

    public Vector subVector(Vector vector) {
        int resultLength = getSize() > vector.getSize() ? getSize() : vector.getSize();
        double[] resultArray = Arrays.copyOf(this.vector, resultLength);
        for (int i = 0; i < vector.getSize(); i++) {
            resultArray[i] -= vector.vector[i];
        }
        this.vector = resultArray;
        return this;
    }

    public Vector scalarMultiplicateVector(double scalar) {
        for (int i = 0; i < this.getSize(); i++) {
            vector[i] = scalar * vector[i];
        }
        return this;
    }

    public Vector reverseVector() {
        for (int i = 0; i < this.getSize(); i++) {
            vector[i] = -vector[i];
        }
        return this;
    }

    public double getLength() {
        double result = 0;
        for (double v : vector) {
            result += v * v;
        }
        return Math.sqrt(result);
    }

    public static Vector getSumVector(Vector vector1, Vector vector2) {
        return new Vector(vector1).addVector(vector2);
    }

    public static Vector getSubVector(Vector vector1, Vector vector2) {
        return new Vector(vector1).subVector(vector2);
    }

    public static double multiplicateVector(Vector vector1, Vector vector2) {
        int arrayLength = vector1.getSize() < vector2.getSize() ? vector1.getSize() : vector2.getSize();
        double result = 0;
        for (int i = 0; i < arrayLength; i++) {
            result += vector1.getVectorElementByIndex(i) * vector2.getVectorElementByIndex(i);
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Vector v = (Vector) o;
        if (v.getSize() != this.getSize()) {
            return false;
        }
        for (int i = 0; i < v.getSize(); i++) {
            if (this.vector[i] != v.vector[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vector);
    }
}