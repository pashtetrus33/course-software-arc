package ru.geekbrains.lesson1.store3D.inmemory;

import ru.geekbrains.lesson1.store3D.models.Camera;
import ru.geekbrains.lesson1.store3D.models.Flash;
import ru.geekbrains.lesson1.store3D.models.PoligonalModel;
import ru.geekbrains.lesson1.store3D.models.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger {

    private List<ModelChangedObserver> observers = new ArrayList<>();

    private List<PoligonalModel> models = new ArrayList<>();
    private List<Flash> flashes = new ArrayList<>();
    private List<Scene> scenes = new ArrayList<>();
    private List<Camera> cameras = new ArrayList<>();

    public void add(PoligonalModel model){
        models.add(model);
        notifyChange();
    }

    public void add(Camera camera){
        cameras.add(camera);
        notifyChange();
    }

    public void add(Flash flash){
        flashes.add(flash);
        notifyChange();
    }

    public void add(Scene scene){
        scenes.add(scene);
        notifyChange();
    }
    @Override
    public void notifyChange() {
        for (ModelChangedObserver observer : observers){
            observer.applyUpdateModel();
        }
    }

    @Override
    public void registerModelChanger(ModelChangedObserver o) {
        observers.add(o);
        System.out.println("Store observer is added");
    }

    @Override
    public void removeModelChanger(ModelChangedObserver o) {
        observers.remove(o);
        System.out.println("Store observer is removed");
    }

    @Override
    public void removeAllModelChangers() {
        observers.clear();
        System.out.println("Store observers are cleaned");
    }

    public Scene getScene(int id) {
        return scenes.size() > id? scenes.get(id):null;
    }
}
