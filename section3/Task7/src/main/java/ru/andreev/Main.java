package ru.andreev;

import java.util.*;

/*
💡- Создать класс "User", содержащий две переменных:

private String name;

private Integer age;

💡- Добавить в класс геттеры и сеттеры, присваивающие и возвращающие значения этих переменных

💡- Добавить в класс метод: public String toString(), который возвращает строку вида: "Вася, возраст 25 лет", где "Вася" - значение переменной name, а 25 - значение переменной age.

💡- Создать конструктор класса, принимающий на вход два значения и инициализирующий ими эти переменные

в методе main главного класса:

💡- Создать новый список ArrayList<User>();

💡- Циклически запросить у оператора ввести данные 5-ти пользователей и записать объекты, созданные при вводе, в ArrayList<>

💡- Вывести на консоль список пользователей (используя метод toString()), отсортированных по возрастанию возраста (сортировать, используя Collections.sort(), реализовав в нем Comparator, сравнивающий значения переменных age)
*/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<User> users = new ArrayList<>();

        System.out.println("Введите данные пяти пользователей: ");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Введите данные " + i + " пользователя: ");

            System.out.println("Имя: ");
            String name = in.nextLine();

            System.out.println("Возраст: ");
            Integer age = in.nextInt();

            in.nextLine();

            users.add(new User(name, age));
        }

        for (int i = 0; i < 5; i++) {
            printSortedUsers(users, i);
        }
    }

    public static void printSortedUsers(List<User> users, int i) {
        Comparator<User> userComparator = new UserComparator();
        users.sort(userComparator);
        System.out.println(users.get(i));
    }
}