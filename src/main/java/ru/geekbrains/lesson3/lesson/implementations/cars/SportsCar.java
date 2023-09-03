package ru.geekbrains.lesson3.lesson.implementations.cars;

import ru.geekbrains.lesson3.lesson.contracts.Fueling;
import ru.geekbrains.lesson3.lesson.contracts.RefuelingStation;
import ru.geekbrains.lesson3.lesson.contracts.Washing;
import ru.geekbrains.lesson3.lesson.contracts.WashingStation;
import ru.geekbrains.lesson3.lesson.models.car.Car;
import ru.geekbrains.lesson3.lesson.models.car.CarType;
import ru.geekbrains.lesson3.lesson.models.car.FuelType;

import java.awt.*;

public class SportsCar extends Car implements Washing, Fueling {

    //region Private fields
    private RefuelingStation refuelingStation;
    private WashingStation washingStation;
    //endregion

    //region Constructors
    public SportsCar(String make, String model, Color color, FuelType fuelType) {
        super(make, model, color, fuelType);
        setWheelsCount(4);
    }

    public SportsCar(String make, String model, CarType carType, Color color, FuelType fuelType) {
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
     * Заправить спорткар
     */
    @Override
    public void fuel() {
        if (refuelingStation != null) {
            System.out.print("Спорткар на заправке. ");
            refuelingStation.fuel(fuelType);
        } else {
            System.out.println("Спорткар не на заправке.");
        }
    }
    /**
     * Помыть спорткар
     */
    @Override
    public void wash() {
        if (washingStation != null) {
            System.out.print("Спорткар на мойке. ");
            washingStation.wash();
        } else {
            System.out.println("Спорткар не на мойке.");
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
        System.out.println("Протирка зеркал спорткара.");

    }

    @Override
    public void wipeWindshield() {
        System.out.println("Протирка лобового стекла спорткара.");

    }

    @Override
    public void wipeHeadlights() {
        System.out.println("Протирка фар спорткара.");

    }

    //endregion

}
