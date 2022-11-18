package com.example.mystock.service;

import com.example.mystock.entities.Categorie;
import com.example.mystock.entities.Produit;
import com.example.mystock.entities.Utilisateur;

import java.util.Collection;
import java.util.Optional;

public interface UtilisateurService {
    Utilisateur create(Utilisateur utilisateur);
    Collection<Utilisateur> list(int limit);
    Utilisateur get(Long idutil);
    Optional<Utilisateur> update(Utilisateur utilisateur, Long idutil);
    Boolean delete(Long idutil);
}
