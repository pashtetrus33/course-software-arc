package ru.geekbrains.lesson1.store3D.inmemory;

public class Observer2 implements ModelChangedObserver{
    @Override
    public void applyUpdateModel() {
        System.out.println("Был добавлен новый элемент - observer#2");
    }
}
