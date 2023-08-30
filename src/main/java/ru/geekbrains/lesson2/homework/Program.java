package ru.geekbrains.lesson2.homework;

//Реализуем пример с паттерном builder
public class Program {
    public static void main(String[] args) {
        Car classicCar = new Director(new ClassicCarBuilder()).constructCar();
        Car modernCar = new Director(new ModernCarBuilder()).constructCar();
        Car sportsCar = new Director(new SportsCarBuilder()).constructCar();

        System.out.println(classicCar);
        System.out.println(modernCar);
        System.out.println(sportsCar);
    }
}
