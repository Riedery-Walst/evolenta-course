package ru.andreev;

public class Divider implements Operation {
    @Override
    public double getResult(double a, double b) {
        return a / b;
    }
}
