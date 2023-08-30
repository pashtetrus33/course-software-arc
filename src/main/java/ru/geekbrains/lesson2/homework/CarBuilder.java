package ru.geekbrains.lesson2.homework;

public interface CarBuilder {

    // Этап 1
    public CarBuilder fixChassis();

    // Этап 2
    public CarBuilder fixBody();

    // Этап 3
    public CarBuilder paint();

    // Этап 4
    public CarBuilder fixInterior();

    // Выпуск автомобиля
    public Car build();
}