package ru.geekbrains.lesson1.store3D.inmemory;

public interface IModelChanger {

    /**
     * Произошло изменение в хранилище моделей
     */
    void notifyChange();

    void registerModelChanger(ModelChangedObserver o);
    void removeModelChanger(ModelChangedObserver o);

    void removeAllModelChangers();

}
