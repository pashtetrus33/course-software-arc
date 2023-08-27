package ru.geekbrains.lesson1.store3D;

import ru.geekbrains.lesson1.store3D.inmemory.ModelStore;
import ru.geekbrains.lesson1.store3D.inmemory.Observer1;
import ru.geekbrains.lesson1.store3D.models.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Задание: На основе Диаграмы классов ModelElements, разработать классы:
// Model Store, PoligonalModel (Texture, Poligon), Flash, Camera, Scene

public class Program {

    public static void main(String[] args) {
        //Создание тестового хранилища
        ModelStore testStore = new ModelStore();
        //Регистрация наблюдателя хранилища
        testStore.registerModelChanger(new Observer1());
        //Создание списка полигонов
        List<Poligon> poligons = List.of(new Poligon());
        //Создание полигональной тестовой модели
        PoligonalModel poligonalModel = new PoligonalModel(poligons);
        //Создание списка полигональных тестовых моделей
        List<PoligonalModel> poligonalModels = new ArrayList<>();
        poligonalModels.add(poligonalModel);

        testStore.add(poligonalModel);

        //Создание тестовой камеры
        Camera testCamera = new Camera(new Point3D(2,3,4),
                new Angle3D(
                        new Point3D(4,5,6),
                        new Point3D(6,5,4),
                        new Point3D(3,0,9)));

        testStore.add(testCamera);
        //Тестирование методов камеры
        testCamera.move(new Point3D(5,5,5));
        testCamera.rotate(new Angle3D(
                new Point3D(4,5,6),
                new Point3D(6,5,4),
                new Point3D(3,0,9)));

        //Создание тестовго света
        Flash testFlash = new Flash(new Point3D(2,3,4),
                new Angle3D(
                        new Point3D(-6,1,-4),
                        new Point3D(7,-5,3),
                        new Point3D(3,0,9)), Color.RED,4.5f);

        testStore.add(testFlash);

        //Создание тестовой точки 3D
        Point3D pointA = new Point3D(-5,-3,0);
        //Создание тестового угла 3D
        Angle3D angleA = new Angle3D(
                new Point3D(4,5,6),
                new Point3D(6,5,4),
                new Point3D(3,0,9));
        //Создание списка камер
        List<Camera> cameras = List.of(new Camera(pointA, angleA));
        // Создание тестовой сцены
        Scene testScene = new Scene(poligonalModels,cameras);
        testScene.remove(testCamera);

        //Добавление тествой сцены в хранилице
        testStore.add(testScene);


        Scene scene = testStore.getScene(1);

        testStore.removeAllModelChangers();
    }

}
