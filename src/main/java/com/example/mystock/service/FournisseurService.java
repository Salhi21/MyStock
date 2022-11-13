package com.example.mystock.service;

import com.example.mystock.entities.Fournisseur;
import com.example.mystock.entities.Produit;

import java.util.Collection;

public interface FournisseurService {
    Fournisseur create(Fournisseur fournisseur);
    Collection<Fournisseur> list(int limit);
    Fournisseur get(Long idFournisseur);
    Fournisseur update(Fournisseur fournisseur);
    Boolean delete(Long idFournisseur);
}
