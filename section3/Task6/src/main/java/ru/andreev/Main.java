package ru.andreev;

import java.util.Scanner;

/*
💡💡- Создать класс "User", содержащий две переменных:

private String name;

private Integer age;

💡- Добавить в класс геттеры и сеттеры, присваивающие и возвращающие значения этих переменных

💡- Добавить в класс метод: public String toString(), который возвращает строку вида: "Вася, возраст 25 лет", где "Вася" - значение переменной name, а 25 - значение переменной age.

💡- Создать конструктор класса, принимающий на вход два значения и инициализирующий ими эти переменные

в методе main главного класса:

💡- Последовательно запросить у пользователя ввести строку с именем, затем число возраста, сохранить их в соответствующих переменных

💡- Создать объект класса User, передав в его конструктор эти две переменных в качестве значений, которые он может принять

💡- Еще раз запросить у оператора имя и возраст другого юзера

💡- Создать второй объект класс User, передав в его конструктор эти две переменных в качестве значений, которые он может принять

💡- Вывести в консоль значение, которое возвращает toString() у объекта с наименьшим age
*/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя: ");
        String firstName = in.nextLine();

        System.out.println("Введите возраст: ");
        Integer firstAge = in.nextInt();

        User firstUSer = new User(firstName, firstAge);

        in.nextLine();

        System.out.println("Введите имя: ");
        String secondName = in.nextLine();

        System.out.println("Введите возраст: ");
        Integer secondAge = in.nextInt();

        User secondUser = new User(secondName, secondAge);

        printYoungestUser(firstUSer, secondUser);
    }

    public static void printYoungestUser(User fistUser, User secondUser) {
        if (fistUser.getAge() < secondUser.getAge())
            System.out.println(fistUser);
         else System.out.println(secondUser);
    }
}