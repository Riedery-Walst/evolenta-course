package ru.andreev;

import java.time.LocalTime;

public class StudentWithCurrentTime implements Learner {
    private final Learner learner;

    public StudentWithCurrentTime(Learner learner) {
        this.learner = learner;
    }

    public void learn() {
        LocalTime time = LocalTime.now();
        System.out.println("Я начал учиться в " + String.valueOf(time));
        this.learner.learn();
    }
}
