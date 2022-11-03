package com.example.mystock;

import com.example.mystock.Repo.UtilisateurRepository;
import com.example.mystock.entities.Utilisateur;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyStockApplication.class, args);
    }

//    @Bean
//    CommandLineRunner run(Utilisateur utilisateur) {
//        return args -> {
//            UtilisateurRepository.save
//        }
//    }

}
