package ru.geekbrains.lesson3.lesson.contracts;

import ru.geekbrains.lesson3.lesson.models.car.FuelType;

/**
 * Заправочная станция
 */
public interface RefuelingStation {

    /**
     * Заправка
     */
    void fuel(FuelType fuelType);

}
