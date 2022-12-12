package com.example.mystock;

import com.example.mystock.Repo.UtilisateurRepository;
import com.example.mystock.entities.Produit;
import com.example.mystock.entities.Utilisateur;
import com.example.mystock.service.UtilisateurService;
import com.example.mystock.service.implementation.ProduitServiceImplementation;
import com.example.mystock.service.implementation.UtilisateurServiceImplementation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class MyStockApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyStockApplication.class, args);
    }

}
