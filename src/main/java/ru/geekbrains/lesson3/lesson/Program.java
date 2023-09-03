package ru.geekbrains.lesson3.lesson;

import ru.geekbrains.lesson3.lesson.implementations.cars.FlyCar;
import ru.geekbrains.lesson3.lesson.implementations.cars.SportsCar;
import ru.geekbrains.lesson3.lesson.implementations.carwashes.AutomotiveCarWash;
import ru.geekbrains.lesson3.lesson.implementations.carwashes.ManualCarWash;
import ru.geekbrains.lesson3.lesson.implementations.carwashes.SelfServiceCarWash;
import ru.geekbrains.lesson3.lesson.implementations.refuelingstations.RefuelingStationV1;
import ru.geekbrains.lesson3.lesson.models.car.Car;
import ru.geekbrains.lesson3.lesson.models.car.CarType;
import ru.geekbrains.lesson3.lesson.models.car.FuelType;
import ru.geekbrains.lesson3.lesson.implementations.cars.Harvester;
import ru.geekbrains.lesson3.lesson.models.car.GearboxType;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Program {

    /**
     * 1. Спроектировать абстрактный класс «Car» у которого должны
     *  быть свойства: марка, модель, цвет, тип кузова, число колёс, тип
     *  топлива, тип коробки передач, объём двигателя; методы:
     *  движение, обслуживание, переключение передач, включение
     *  фар, включение дворников.
     *
     * 2. Создать конкретный автомобиль путём наследования класса
     *  «Car».
     * 3. Расширить абстрактный класс «Car», добавить метод: подметать
     * улицу. Создать конкретный автомобиль путём наследования
     * класса «Car». Провести проверку принципа SRP.
     *
     * 4. Расширить абстрактный класс «Car», добавить метод:
     * включение противотуманных фар, перевозка груза. Провести
     * проверку принципа OCP.
     *
     * 5. Создать конкретный автомобиль путём наследования класса
     * «Car», определить число колёс = 3. Провести проверку принципа LSP.
     *
     * 6. Создать конкретный автомобиль путём наследования класса
     * «Car», определить метод «движение» - «полёт». Провести
     * проверку принципа LSP.
     *
     * 7. Создать интерфейс «Заправочная станция», создать метод:
     * заправка топливом.
     *
     *
     * 8. Имплементировать метод интерфейса «Заправочная станция» в
     * конкретный класс «Car».
     *
     * 9. Добавить в интерфейс «Заправочная станция» методы: протирка
     * лобового стекла, протирка фар, протирка зеркал.
     *
     * 10. Имплементировать все методы интерфейса «Заправочная
     * станция» в конкретный класс «Car». Провести проверку
     * принципа ISP. Создать дополнительный/е интерфейсы и
     * имплементировать их в конкретный класс «Car». Провести
     * проверку принципа ISP.
     *
     * 11. Создать путём наследования класса «Car» два
     * автомобиля: с бензиновым и дизельным двигателями,
     * имплементировать метод «Заправка топливом» интерфейса
     * «Заправочная станция». Реализовать заправку каждого
     * автомобиля подходящим топливом. Провести проверку принципа DIP.
     *
     * @param args
     */
    public static void main(String[] args) {

        //region Создание коллекции ТС

        //Создаем комбайн
        Harvester harvester = new Harvester("Niva", "CK-5", CarType.Agricultural_machinery, Color.GREEN, FuelType.Diesel);
        harvester.setGearboxType(GearboxType.AT);

        //Создаем летающую машину
        FlyCar flyCar = new FlyCar("Alef Aeronautics", "A", CarType.Sedan, Color.GRAY, FuelType.Electricity);
        flyCar.setGearboxType(GearboxType.AT);
        //Создаем спортивную машину
        SportsCar sportsCar = new SportsCar("Porsche", "911", CarType.Sport, Color.RED, FuelType.Gasoline);
        sportsCar.setGearboxType(GearboxType.MT);
        //Создаем коллекцию транспортных средств
        List<Car> cars = new ArrayList<>();
        cars.add(harvester);
        cars.add(flyCar);
        cars.add(sportsCar);
        //endregion

        //region Создание инфраструктуры

        //Создаем заправку
        RefuelingStationV1 refuelingStation1 = new RefuelingStationV1();

        //Создаем классическую мойку
        ManualCarWash manualCarWash1 = new ManualCarWash();

        //Создаем автоматическую мойку
        AutomotiveCarWash autoCarWash1 = new AutomotiveCarWash();

        //Создаем мойку самообслуживания
        SelfServiceCarWash selfServiceCarWash1 = new SelfServiceCarWash();

        //endregion

        //region Установка полей

        //Комбайн на заправке
        harvester.setRefuelingStation(refuelingStation1);
        //Комбайн на классической мойке
        harvester.setWashingStation(manualCarWash1);

        //Летающая машина на заправке
        flyCar.setRefuelingStation(refuelingStation1);
        //Летающая машина на мойке самообслуживания
        flyCar.setWashingStation(selfServiceCarWash1);

        //Спорткар на заправке
        sportsCar.setRefuelingStation(refuelingStation1);
        //Спорткар на автоматической мойке
        sportsCar.setWashingStation(autoCarWash1);

        //endregion

        for (Car car: cars) {
            System.out.println(car);
            car.fuel();
            car.wash();
            car.wipeMirrors();
            car.wipeWindshield();
            System.out.println("_________________________________________________________________");
        }
    }
}
