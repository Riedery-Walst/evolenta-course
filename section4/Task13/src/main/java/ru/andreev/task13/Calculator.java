package ru.andreev.task13;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
    private final Operation operation;

    public Calculator(@Qualifier("divider") Operation operation) {
        this.operation = operation;
    }

    public void calc(double a, double b) {
        System.out.println(operation.getResult(a, b));
    }
}