package ru.andreev.task13;

import org.springframework.stereotype.Component;

@Component
public class Adder implements Operation {

    @Override
    public double getResult(double a, double b) {
        return a + b;
    }
}