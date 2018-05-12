package picalculator;

import static java.lang.Math.pow;

public class CircleArea {

    private double piValue = 3.14;
    private double area;

    public void setArea(double radius) {

        area = (Math.PI * pow(radius, 2));

    }

    public double getArea() {
        return area;
    }
}
