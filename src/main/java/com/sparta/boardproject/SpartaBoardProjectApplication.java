package com.sparta.boardproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpartaBoardProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpartaBoardProjectApplication.class, args);
	}

}
