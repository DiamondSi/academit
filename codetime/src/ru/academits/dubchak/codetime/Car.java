package ru.academits.dubchak.codetime;

public class Car {
    int size;
    String color = "black";

    public Car(int size) {
        this.size = size;
    }
}

class MiniCar extends Car {
    public MiniCar() {
        super(5);
        this.color = "red";
    }
}
