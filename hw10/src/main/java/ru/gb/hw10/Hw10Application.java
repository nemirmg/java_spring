package ru.gb.hw10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Hw10Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw10Application.class, args);
	}

}
