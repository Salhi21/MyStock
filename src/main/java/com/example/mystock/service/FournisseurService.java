package com.example.mystock.service;

import com.example.mystock.entities.Categorie;
import com.example.mystock.entities.Fournisseur;
import com.example.mystock.entities.Produit;

import java.util.Collection;
import java.util.Optional;

public interface FournisseurService {
    Fournisseur create(Fournisseur fournisseur);
    Collection<Fournisseur> list(int limit);
    Fournisseur get(Long idFournisseur);
    Optional<Fournisseur> update(Fournisseur fournisseur, Long idFournisseur);
    Boolean delete(Long idFournisseur);
}
