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

    public int getSize() {
        return vector.length;
    }
    public double getLength(){
        double result=0;
        for (double v:vector){
            result+=v*v;
        }
        return Math.sqrt(result);
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

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }
}