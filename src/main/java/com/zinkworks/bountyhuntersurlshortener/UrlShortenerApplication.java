package com.zinkworks.bountyhuntersurlshortener;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;


@SpringBootApplication
@EnableJpaRepositories

public class UrlShortenerApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(UrlShortenerApplication.class, args);

		System.out.println("Test");

	}
	
}
