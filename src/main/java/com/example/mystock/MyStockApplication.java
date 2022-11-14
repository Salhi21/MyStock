package com.example.mystock;

import com.example.mystock.Repo.UtilisateurRepository;
import com.example.mystock.entities.Utilisateur;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MyStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyStockApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/produit-javaconfig").allowedOrigins("http://localhost:8080");
            }
        };
    }

}
