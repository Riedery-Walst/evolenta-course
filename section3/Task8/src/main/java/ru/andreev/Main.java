package ru.andreev;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Integer, List<User>> map = new HashMap<>();

        System.out.println("Введите данные пяти пользователей: ");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Введите данные " + i + " пользователя: ");

            System.out.println("Имя: ");
            String name = in.nextLine();

            System.out.println("Возраст: ");
            Integer age = in.nextInt();

            in.nextLine();

            if (!map.containsKey(age)) {
                List<User> users = new ArrayList<>();

                users.add(new User(name, age));

                map.put(age, users);
            } else {
                map.get(age).add(new User(name, age));
            }
        }

        System.out.println("Введите возраст пользователей для получения их списка: ");
        Integer age = in.nextInt();
        if (map.containsKey(age)) {
            List<User> users = map.get(age);
            printSortedUsers(users);
        } else throw new RuntimeException("Пользователи с возрастом " + age + " не найдены");
    }

    public static void printSortedUsers(List<User> users) {
        Comparator<User> userComparator = new UserComparator();
        users.sort(userComparator);
        System.out.println(users);


    }


}
