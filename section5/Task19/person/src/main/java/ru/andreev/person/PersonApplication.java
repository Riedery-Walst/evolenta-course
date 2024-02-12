package ru.andreev.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 💡 Задание. Создать веб-службы location и weather. Подумайте, какие зависимости нужно использовать для этих служб.
@SpringBootApplication
public class PersonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonApplication.class, args);
    }

}
