package ru.geekbrains.lesson3.lesson.implementations.cars;

import ru.geekbrains.lesson3.lesson.contracts.*;
import ru.geekbrains.lesson3.lesson.models.car.Car;
import ru.geekbrains.lesson3.lesson.models.car.CarType;
import ru.geekbrains.lesson3.lesson.models.car.FuelType;

import java.awt.*;

public class Harvester extends Car implements Fueling, Wiping, Washing {

    //region Private fields
    private RefuelingStation refuelingStation;
    private WashingStation washingStation;
    //endregion

    //region Constructors
    public Harvester(String make, String model, Color color, FuelType fuelType) {
        super(make, model, color, fuelType);
        setWheelsCount(6);
    }

    public Harvester(String make, String model, CarType carType, Color color, FuelType fuelType) {
        this(make, model, color, fuelType);
        setType(carType);
    }
    //endregion

    //region Setters
    public void setRefuelingStation(RefuelingStation refuelingStation) {
        this.refuelingStation = refuelingStation;
    }

    public void setWashingStation(WashingStation washingStation) {
        this.washingStation = washingStation;
    }
    //endregion

    //region Override methods

    /**
     * Заправить комбайн
     */
    @Override
    public void fuel() {
        if (refuelingStation != null) {
            System.out.print("Комбайн на заправке. ");
            refuelingStation.fuel(fuelType);
        } else {
            System.out.println("Комбайн не на заправке.");
        }
    }

    /**
     * Помыть комбайн
     */
    @Override
    public void wash() {
        if (washingStation != null) {
            System.out.print("Комбайн на мойке. ");
            washingStation.wash();
        } else {
            System.out.println("Комбайн не на мойке.");
        }
    }

    @Override
    public void movement() {

    }

    @Override
    public void maintenance() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }


    @Override
    public void wipeMirrors() {
        System.out.println("Протирка зеркал комбайна.");

    }

    @Override
    public void wipeWindshield() {
        System.out.println("Протирка лобового стекла комбайна.");

    }

    @Override
    public void wipeHeadlights() {
        System.out.println("Протирка фар комбайна.");

    }
    //endregion
}
