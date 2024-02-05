package ru.andreev;

public class Main {
    public static void main(String[] args) {
        Learner student = new StudentWithCurrentTime(new StudentWithTimer(new Student()));
        student.learn();
    }
}
