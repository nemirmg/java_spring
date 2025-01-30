package ru.gb.hw12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Hw12Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw12Application.class, args);
	}

}
