package ru.gb.hw11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Hw11Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw11Application.class, args);
	}

}
