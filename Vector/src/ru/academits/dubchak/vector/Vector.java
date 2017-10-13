package ru.academits.dubchak.vector;

import java.util.Arrays;

public class Vector {
    private double[] vector;

    public Vector(int n) {
        for (int i = 0; i < n; i++) {
            this.vector[i] = 0;
        }
    }

    public Vector(Vector vector) {
        this.vector = Arrays.copyOf(vector.vector, vector.vector.length);
    }

    public Vector(double[] vector) {
        this.vector = vector;
    }
    public Vector(int n, double[] vector){
        for (int i = 0; i < vector.length; i++) {
            this.vector[i] = vector[i];
        }
        if (vector.length<n){
            for (int i = vector.length; i < n; i++) {
                this.vector[i] = 0;
            }
        }
    }
    public int getSize(){
        return vector.length;
    }
}