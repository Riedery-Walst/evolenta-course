package ru.andreev;

import java.util.Scanner;
import java.util.stream.LongStream;

/*
Задание: Используя stream api напишите метод,
принимающий на вход два числа a, b типа int и вычисляющий сумму чисел между числами a и b,
включая a и исключая b. Ответ должен иметь тип long. Например: a = 3, b = 6. Ответ: 12 (3 + 4 + 5).
*/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        System.out.println(sumBetweenAAndB(a, b));
    }

    public static long sumBetweenAAndB(int a, int b) {
        return LongStream.rangeClosed(a, b - 1).sum();
    }
}