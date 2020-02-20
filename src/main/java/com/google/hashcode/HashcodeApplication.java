package com.google.hashcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class HashcodeApplication implements CommandLineRunner {
	List<String> inputFiles = Arrays.asList(
			"a_example", "b_read_on", "c_incunabula", "d_tough_choices", "e_so_many_books", "f_libraries_of_the_world");
	
	public static void main(String[] args) {
		SpringApplication.run(HashcodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Parser parser = new Parser();

		for (String input : inputFiles) {
			parser.execute(input + ".txt", input + "_output.txt");
		}
	}
}
