package com.woow.tours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableJpaRepositories
@SpringBootApplication
public class SearchToursApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchToursApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

}
