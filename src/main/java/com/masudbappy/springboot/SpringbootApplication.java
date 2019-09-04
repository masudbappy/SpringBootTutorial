package com.masudbappy.springboot;

import com.masudbappy.springboot.repositories.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootApplication {
	@Autowired
	private BookCategoryRepository bookCategoryRepository;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);

	}
/*
	@Override
	public void run(String... args) throws Exception {
		bookCategoryRepository.save(new BookCategory("Category 1", new Book("Hello Koding 1"), new Book("Hello Koding 2")));
	}*/
}
