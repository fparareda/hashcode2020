package com.google.hashcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HashcodeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HashcodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Parser parser = new Parser();
		parser.execute();
	}
}
