package ru.andreev.task13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// 💡 Добавить в проект компоненты для операций деления и умножения
@SpringBootApplication
public class Task13Application {
    private final Calculator calculator;

    public Task13Application(Calculator calculator) {
        this.calculator = calculator;
    }

    public static void main(String[] args) {
        SpringApplication.run(Task13Application.class, args);
    }

    @Bean
    public boolean outToConsole() {
        System.out.print("Result: ");
        calculator.calc(2, 3);
        return true;
    }
}
