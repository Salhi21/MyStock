package com.example.mystock.Repo;

import com.example.mystock.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByName(String nom);
}