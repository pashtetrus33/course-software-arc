package ru.geekbrains.lesson1.store3D.models;

import ru.geekbrains.lesson1.store.Buyer;
import ru.geekbrains.lesson1.store.OrderItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Scene {

    private int id;
    private static int count;

    private List<Camera> cameras = new ArrayList<>();
    private List<Flash> flashes = new ArrayList<>();
    private List<PoligonalModel> poligonalModels = new ArrayList<>();

    {
        id = ++count;
    }

    public Scene(List<PoligonalModel> poligonalModels, List<Camera> cameras) {

        if (poligonalModels == null || poligonalModels.size() == 0) {
            throw new RuntimeException("Scene must contains one or more PoligonalModels.");
        }

        if (cameras == null || cameras.size() == 0) {
            throw new RuntimeException("Scene must contains one or more Cameras");
        }

        this.poligonalModels = poligonalModels;
        this.cameras = cameras;
        System.out.println("Scene " + id + " is created");
    }

    public Scene(List<PoligonalModel> poligonalModels, List<Camera> cameras, List<Flash> flashes) {
        this(poligonalModels,cameras);
        this.flashes = flashes;
    }

    public Scene add(Camera camera) {
        cameras.add(camera);
        System.out.println("Camera is added to scene " + id);
        return this;
    }

    public boolean remove(Camera camera) {
        if ((cameras.size() >= 2) && (cameras.contains(camera))){
            cameras.remove(camera);
            System.out.println("Camera is removed from scene " + id);
            return true;
        }
        System.out.println("Camera cannot be removed from scene " + id);
        return false;
    }

    public boolean remove(PoligonalModel model) {
        if ((poligonalModels.size() >= 2) && (poligonalModels.contains(model))){
            poligonalModels.remove(model);
            System.out.println("PoligonalModel is removed from scene " + id);
            return true;
        }
        System.out.println("PoligonalModel cannot be removed from scene " + id);
        return false;
    }

    public Scene add(Camera camera, PoligonalModel model) {
        cameras.add(camera);
        poligonalModels.add(model);
        System.out.println("Camera and PoligonalModel are added to scene " + id);
        return this;
    }

}
