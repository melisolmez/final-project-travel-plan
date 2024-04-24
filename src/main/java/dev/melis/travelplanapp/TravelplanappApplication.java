package dev.melis.travelplanapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TravelplanappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelplanappApplication.class, args);
	}

}
