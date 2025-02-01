package com.googleplaces.favouriteplaces;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class FavouritePlacesApplication {
    private static final Logger logger = LoggerFactory.getLogger(FavouritePlacesApplication.class);

    public static void main(String[] args) {
        logger.info("Starting Favorite Places Application...");
        SpringApplication.run(FavouritePlacesApplication.class, args);
        logger.info("Application Started Successfully!");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}


