package ru.andreev.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
💡 Задание 1. В приложении person переместить переменную пути к сервису location в файл application.properties.
💡 Задание 1.1. Запустить несколько экземпляров сервисов, в качестве ответа прислать скриншот страницы балансировщика Eureka.
*/
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplication.class, args);
	}

}
