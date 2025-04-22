package com.example.demo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = "com.example.demo.Model")
public class DemoApplication {

	public static void main(String[] args) {
		loadEnv();
		SpringApplication.run(DemoApplication.class, args);
	}

	private static void loadEnv() {
		Dotenv dot = Dotenv.load();

		System.setProperty("URL_DB", dot.get("URL_DB"));
		System.setProperty("USER_DB", dot.get("USER_DB"));
		System.setProperty("PASSWORD_DB", dot.get("PASSWORD_DB"));
	}
}
