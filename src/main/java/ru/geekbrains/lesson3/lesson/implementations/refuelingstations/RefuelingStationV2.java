package ru.geekbrains.lesson3.lesson.implementations.refuelingstations;

import ru.geekbrains.lesson3.lesson.contracts.RefuelingStation;
import ru.geekbrains.lesson3.lesson.models.car.FuelType;

public class RefuelingStationV2 implements RefuelingStation {
    @Override
    public void fuel(FuelType fuelType) {
        switch (fuelType){
            case Diesel -> System.out.println("Заправка дизельным топливом");
            case Gasoline -> System.out.println("Заправка бензином");
            case Electricity -> System.out.println("Станции зарядки нет.");
        }
    }
}