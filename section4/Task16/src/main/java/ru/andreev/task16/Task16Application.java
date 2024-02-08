package ru.andreev.task16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
💡Задание 1: При добавлении сообщения реализовать проверку на наличие пользователя в БД,
  если пользователь с нужным id отсутствует в базе вернуть статус BAD_REQUEST

💡Задание 2: Реализовать удаление сообщения у пользователя по его id

💡Задание 3: Реализовать вывод списка сообщений у конкретного пользователя.

💡Задание 4: Перенести логику из контроллера в класс сервиса.
*/
@SpringBootApplication
public class Task16Application {

	public static void main(String[] args) {
		SpringApplication.run(Task16Application.class, args);
	}

}
