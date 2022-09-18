package com.primus.springcrm;

import com.primus.springcrm.entity.Student;
import com.primus.springcrm.repo.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrmApplication.class, args);
	}

	@Bean
	CommandLineRunner run(StudentRepo studentRepo) {
		return args -> {
			studentRepo.save(new Student("Javed", "Khan", "jav@gmail.com"));
			studentRepo.save(new Student("abc", "zyz", "abc@gmail.com"));
		};


	}
}
