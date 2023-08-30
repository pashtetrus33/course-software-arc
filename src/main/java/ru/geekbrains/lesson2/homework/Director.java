package ru.geekbrains.lesson2.homework;

public class Director {

    private CarBuilder builder;

    public Director(CarBuilder builder) {
        this.builder = builder;
        if (this.builder == null) {
            throw new IllegalArgumentException("Director can't work without Car Builder!");
        }
    }

    public Car constructCar() {
        return builder.fixChassis().fixBody().paint().fixInterior().build();
    }
}