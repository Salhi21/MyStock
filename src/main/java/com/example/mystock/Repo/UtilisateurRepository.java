package com.example.mystock.Repo;

import com.example.mystock.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findbyemailandpwd(String email);
}