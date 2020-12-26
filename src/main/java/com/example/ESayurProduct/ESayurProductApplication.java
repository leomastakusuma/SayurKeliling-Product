package com.example.ESayurProduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class ESayurProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ESayurProductApplication.class, args);
	}

}
