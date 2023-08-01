package com.pblgllgs.searchapi;

import com.github.javafaker.Faker;
import com.pblgllgs.searchapi.entity.Product;
import com.pblgllgs.searchapi.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Locale;


@SpringBootApplication
public class SearchApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			Faker faker = new Faker(new Locale("es"));
			for (long i = 1; i <51 ; i++) {
				Product product = new Product(
						i,
						faker.starTrek().character(),
						faker.name().firstName(),
						faker.lorem().sentence(),
						faker.bool().bool(),
						faker.internet().image(),
						LocalDateTime.now(),
						LocalDateTime.now()
				);
				productRepository.save(product);
			}
		};
	}

}
