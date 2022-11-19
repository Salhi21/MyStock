package com.example.mystock.service;

import com.example.mystock.entities.Utilisateur;

import java.util.Collection;
import java.util.Optional;

public interface UtilisateurService {
    Utilisateur create(Utilisateur utilisateur);
    Collection<Utilisateur> list(int limit);
    Utilisateur existsByEmailandPassword(String email, String password);
    Utilisateur get(Long id);
    Optional<Utilisateur> update(Utilisateur utilisateur, Long idutil);
    Boolean delete(Long idutil);
}
