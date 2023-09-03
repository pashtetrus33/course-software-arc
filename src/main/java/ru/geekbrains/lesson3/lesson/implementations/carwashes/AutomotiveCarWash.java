package ru.geekbrains.lesson3.lesson.implementations.carwashes;

import ru.geekbrains.lesson3.lesson.contracts.WashingStation;

public class AutomotiveCarWash implements WashingStation {
    @Override
    public void wash() {
        System.out.println("Процесс автоматической мойки.");

    }
}
