package ru.andreev.task14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
💡  Добавить в проект класс Message с полями int id, String title, String text, LocalDateTime time.
	Создать класс контроллера для обработки CRUD запросов к списку объектов Message по аналогии с объектами Person.
*/
@SpringBootApplication
public class Task14Application {

	public static void main(String[] args) {
		SpringApplication.run(Task14Application.class, args);
	}

}
