package com.example.WebProjekat;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.WebProjekat.*")
public class WebProjekatApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebProjekatApplication.class, args);
	}

}
