package ru.academits.dubchak.vector;

import java.util.Arrays;

public class Vector {
    private double[] vector;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException(Integer.toString(n));
        }
        vector = new double[n];
    }

    public Vector(Vector vector) {
        this.vector = Arrays.copyOf(vector.vector, vector.vector.length);
    }

    public Vector(double[] vector) {
        this.vector = Arrays.copyOf(vector, vector.length);
    }

    public Vector(int n, double[] vector) {
        if (n <= 0) {
            throw new IllegalArgumentException(Integer.toString(n));
        }
        this.vector = Arrays.copyOf(vector, n);
    }

    public double getElement(int index) {
        return this.vector[index];
    }

    public void setElement(int index, double value) {
        this.vector[index] = value;
    }

    private int getSize() {
        return vector.length;
    }

    public Vector addVector(Vector vector) {
        if (getSize() < vector.getSize()) {
            this.vector = Arrays.copyOf(this.vector, vector.getSize());
        }
        int minLength = Math.min(getSize(), vector.getSize());
        for (int i = 0; i < minLength; i++) {
            this.vector[i] += vector.vector[i];
        }
        return this;
    }

    public Vector subVector(Vector vector) {
        if (getSize() < vector.getSize()) {
            this.vector = Arrays.copyOf(this.vector, vector.getSize());
        }
        int minLength = Math.min(getSize(), vector.getSize());
        for (int i = 0; i < minLength; i++) {
            this.vector[i] -= vector.vector[i];
        }
        return this;
    }

    public Vector scalarMultiplicationVector(double scalar) {
        for (int i = 0; i < this.getSize(); i++) {
            vector[i] *= scalar;
        }
        return this;
    }

    public Vector reverseVector() {
        double reverse = -1;
        return this.scalarMultiplicationVector(reverse);
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

    public static double multiplicationVector(Vector vector1, Vector vector2) {
        int arrayLength = Math.min(vector1.getSize(), vector2.getSize());
        double result = 0;
        for (int i = 0; i < arrayLength; i++) {
            result += vector1.getElement(i) * vector2.getElement(i);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{" + vector[0]);
        for (int i = 1; i < vector.length; i++) {
            string.append(",").append(vector[i]);
        }
        string.append("}");
        return string.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Vector v = (Vector) o;
        return Arrays.equals(this.vector, v.vector);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vector);
    }
}