package ru.geekbrains.lesson1.store3D.models;

public class Camera {

    private Point3D location;
    private Angle3D angle;

    public Camera(Point3D location, Angle3D angle) {
        this.location = location;
        this.angle = angle;
    }

    public Point3D getLocation() {
        return location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public void rotate(Angle3D angle){
        System.out.print("Camera is rotated. Angle: ");
        angle.calculateAngle();
    }

    public void move(Point3D point3D){
        System.out.printf("Camera moved to point: (%.4f,%.4f,%.4f)",point3D.getX(),point3D.getY(),point3D.getZ());
        System.out.println();

    }
}
