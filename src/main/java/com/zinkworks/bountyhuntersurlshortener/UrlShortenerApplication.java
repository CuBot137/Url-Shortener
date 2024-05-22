package com.zinkworks.bountyhuntersurlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.io.IOException;
@SpringBootApplication
@EnableJpaRepositories

public class UrlShortenerApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(UrlShortenerApplication.class, args);
		//test1234
	}
}
