package dev.melis.travelplanapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class TravelplanappApplication {
    public static void main(String[] args) {
		SpringApplication.run(TravelplanappApplication.class, args);

	}

}
