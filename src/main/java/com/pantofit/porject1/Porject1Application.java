package com.pantofit.porject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication



@CrossOrigin(origins = "*")
public class Porject1Application {

	public static void main(String[] args) {
		SpringApplication.run(Porject1Application.class, args);
	}

}
