package com.example.mystock.service;

import com.example.mystock.entities.Categorie;
import com.example.mystock.entities.Fournisseur;

import java.util.Collection;

public interface CategorieService {
    Categorie create(Categorie categorie);
    Collection<Categorie> list(int limit);
    Categorie get(Long idCateg);
    Categorie update(Categorie categorie);
    Boolean delete(Long idCateg);
}
