package com.SampleMongoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.SampleMongoDB")
public class SampleMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleMongoDbApplication.class, args);
	}

}
