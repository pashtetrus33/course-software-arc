package ru.geekbrains.lesson3.lesson.models.car;

import ru.geekbrains.lesson3.lesson.contracts.Fueling;
import ru.geekbrains.lesson3.lesson.contracts.Washing;
import ru.geekbrains.lesson3.lesson.contracts.Wiping;

import java.awt.*;

public abstract class Car implements Washing, Fueling, Wiping {

    //region Constructors

    public Car(String make, String model, Color color, FuelType fuelType) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.fuelType = fuelType;
    }

    //endregion

    //region Public Methods

    // Движение
    public abstract void movement();

    // Обслуживание
    public abstract void maintenance();

    // Переключение передач
    public abstract boolean gearShifting();

    // Включение фар
    public abstract boolean switchHeadlights();

    // Включение дворников
    public abstract boolean switchWipers();

    // Подметать
    //public abstract void sweeping();

    public boolean switchFogLights() {
        fogLights = !fogLights;
        return fogLights;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color=" + color +
                ", type=" + type +
                ", wheelsCount=" + wheelsCount +
                ", fuelType=" + fuelType +
                ", gearboxType=" + gearboxType +
                ", engineCapacity=" + engineCapacity +
                ", fogLights=" + fogLights +
                '}';
    }

    //endregion

    //region Setters, Getters
    protected void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public CarType getType() {
        return type;
    }

    public GearboxType getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(GearboxType gearboxType) {
        this.gearboxType = gearboxType;
    }

    public void setType(CarType type) {
        this.type = type;

    }

    //endregion

    //region Private Fields

    // Марка автомобиля
    private String make;

    // Модель
    private String model;

    // Цвет
    private Color color;

    // Тип
    protected CarType type;

    // Число колес
    private int wheelsCount;

    // Тип топлива
    protected FuelType fuelType;


    // Тип коробки передач
    private GearboxType gearboxType;

    // Объем двигателя
    private double engineCapacity;

    // Состояние противотуманных фар
    private boolean fogLights = false;


    //endregion

}
