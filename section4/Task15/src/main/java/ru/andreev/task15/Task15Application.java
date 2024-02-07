package ru.andreev.task15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
💡 Исправить запрос на обновление так, чтобы не сохранялась старая запись в БД,
   а у новой записи был id такой же как и у старой.
   Запрос необходимо исправить как для Person, так и для Message
 */
@SpringBootApplication
public class Task15Application {

	public static void main(String[] args) {
		SpringApplication.run(Task15Application.class, args);
	}

}
