package ru.geekbrains.lesson1.store3D.models;

import java.awt.*;

public class Flash {

    private Point3D location;
    private Angle3D angle;

    private Color color;
    private float power;

    public Flash(Point3D location, Angle3D angle, Color color, float power) {
        this.location = location;
        this.angle = angle;
        this.color = color;
        this.power = power;
    }

    public Point3D getLocation() {
        return location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public void rotate(Angle3D angle){
        System.out.println("Flash is rotated. Angle: ");
        angle.calculateAngle();
    }

    public void move(Point3D point3D){
        System.out.printf("Flash moved to point: (%.4f,%.4f,%.4f)",point3D.getX(),point3D.getY(),point3D.getZ());
    }
}
