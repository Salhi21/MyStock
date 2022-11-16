package com.example.mystock.service;

import com.example.mystock.entities.Categorie;
import com.example.mystock.entities.Fournisseur;

import java.util.Collection;
import java.util.Optional;

public interface CategorieService {
    Categorie create(Categorie categorie);
    Collection<Categorie> list(int limit);
    Categorie get(Long idCateg);
    Optional<Categorie> update(Categorie categorie, Long id);
    Boolean delete(Long idCateg);
}
