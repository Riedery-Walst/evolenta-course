package ru.andreev;

public class StudentWithTimer implements Learner {
    private final Learner learner;

    public StudentWithTimer(Learner learner) {
        this.learner = learner;
    }

    public void learn() {
        long start = System.currentTimeMillis();
        this.learner.learn();
        System.out.printf("Время учёбы: %s ms", System.currentTimeMillis() - start);
    }
}
