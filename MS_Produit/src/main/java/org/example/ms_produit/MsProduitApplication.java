package org.example.ms_produit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication

@EnableMongoRepositories(basePackages = "org.example.ms_produit.Repository")
public class MsProduitApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProduitApplication.class, args);
    }

}
