package com.zinkworks.bountyhuntersurlshortener;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
@EnableJpaRepositories

public class UrlShortenerApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(UrlShortenerApplication.class, args);

//		String projectId = "url-shortener-417915";
//
//		String keyFilePath = "C:\\Users\\ConorLynam\\OneDrive - Zinkworks\\Desktop\\Google Cloud Platform";
//
//		GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(keyFilePath));
//
//		Storage storage = StorageOptions.newBuilder()
//				.setCredentials(credentials)
//				.build()
//				.getService();
	}



}
