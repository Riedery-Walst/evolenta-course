package com.example.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
Оптимизирование запросов
Балансировщик нагрузки
Обнаружение служб
Создание микросервиса location
*/
@SpringBootApplication
@EnableDiscoveryClient
public class WeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

}
