package com.example.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
💡 Задание 1. В приложении person переместить переменную пути к сервису location в файл application.properties.
💡 Задание 1.1. Запустить несколько экземпляров сервисов, в качестве ответа прислать скриншот страницы балансировщика Eureka.
*/
@SpringBootApplication
@EnableDiscoveryClient
public class WeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

}
