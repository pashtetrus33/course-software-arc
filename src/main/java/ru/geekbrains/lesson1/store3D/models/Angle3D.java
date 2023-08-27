package ru.geekbrains.lesson1.store3D.models;

public class Angle3D {

    private final Point3D point1;
    private final Point3D point2;
    private final Point3D point3;

    public Point3D getPoint1() {
        return point1;
    }

    public Point3D getPoint2() {
        return point2;
    }

    public Point3D getPoint3() {
        return point3;
    }
    public Angle3D(Point3D point1, Point3D point2, Point3D point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    // Function to find the angle between the two lines
        public void calculateAngle()
        {

            // Find direction ratio of line AB
            double ABx = point1.getX() - point2.getX();
            double ABy = point1.getY() - point2.getY();
            double ABz = point1.getZ() - point2.getZ();

            // Find direction ratio of line BC
            double BCx = point3.getX() - point2.getX();
            double BCy = point3.getY() - point2.getY();
            double BCz = point3.getZ() - point2.getZ();

            // Find the dotProduct of lines AB & BC
            double dotProduct = ABx * BCx +
                    ABy * BCy +
                    ABz * BCz;

            // Find magnitude of line AB and BC
            double magnitudeAB = ABx * ABx +
                    ABy * ABy +
                    ABz * ABz;
            double magnitudeBC = BCx * BCx +
                    BCy * BCy +
                    BCz * BCz;

            // Find the cosine of the angle formed by line AB and BC
            double angle = dotProduct;
            angle /= Math.sqrt(magnitudeAB * magnitudeBC);

            // Find angle in radian
            angle = (angle * 180) / 3.14;

            // Print the angle
            System.out.printf("%.4f", Math.abs(angle));
            System.out.println();
        }
    }
