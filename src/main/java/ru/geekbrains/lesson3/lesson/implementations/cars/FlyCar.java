package ru.geekbrains.lesson3.lesson.implementations.cars;

import ru.geekbrains.lesson3.lesson.contracts.*;
import ru.geekbrains.lesson3.lesson.models.car.Car;
import ru.geekbrains.lesson3.lesson.models.car.CarType;
import ru.geekbrains.lesson3.lesson.models.car.FuelType;

import java.awt.*;

public class FlyCar extends Car implements Fueling, Washing {

    //region Private fields
    private RefuelingStation refuelingStation;
    private WashingStation washingStation;
    //endregion

    //region Constructors
    public FlyCar(String make, String model, Color color, FuelType fuelType) {
        super(make, model, color, fuelType);
        setWheelsCount(4);
    }

    public FlyCar(String make, String model, CarType carType, Color color, FuelType fuelType) {
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
     * Заправить летающую машину
     */
    @Override
    public void fuel() {
        if (refuelingStation != null) {
            System.out.print("Летающая машина на заправке. ");
            refuelingStation.fuel(fuelType);
        } else {
            System.out.println("Летающая машина не на заправке.");
        }
    }

    /**
     * Помыть летающую машину
     */
    @Override
    public void wash() {
        if (washingStation != null) {
            System.out.print("Летающая машина на мойке. ");
            washingStation.wash();
        } else {
            System.out.println("Летающая машина не на мойке.");
        }
    }

    @Override
    public void movement() {
        fly();
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
    //endregion

    //region Own methods
    public void fly() {
        System.out.println("Автомобиль летит!");
    }

    @Override
    public void wipeMirrors() {
        System.out.println("Протирка зеркал летающей машины.");

    }

    @Override
    public void wipeWindshield() {
        System.out.println("Протирка лобового стекла летающей машины.");

    }

    @Override
    public void wipeHeadlights() {
        System.out.println("Протирка фар летающей машины.");

    }
    //endregion


}
