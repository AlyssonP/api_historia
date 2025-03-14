package com.example.api_historia;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class ApiHistoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiHistoriaApplication.class, args);
	}

}
