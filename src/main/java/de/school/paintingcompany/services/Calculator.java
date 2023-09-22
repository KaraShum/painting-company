package de.school.paintingcompany.services;

public class Calculator {
    double length;
    double height;
    double doorSize;
    double windowSize;
    boolean isCeilingWindow;

    public Calculator(double length, double height, double doorSize, double windowSize) {
        this.length = length;
        this.height = height;
        this.doorSize = doorSize;
        this.windowSize = windowSize;
    }

    public double calculateArea(double length, double height, double doorSize, double windowSize, boolean isCeilingWindow) {
        if (doorSize > 2.5) {
            return length * height - doorSize;
        } else if (windowSize > 0.5 && isCeilingWindow) {
            return length * height - windowSize;
        } else if (windowSize > 2.5) {
            return length * height - windowSize;
        } else {
            return length * height;
        }
    }
}