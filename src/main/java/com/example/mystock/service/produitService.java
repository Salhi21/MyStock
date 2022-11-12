package com.example.mystock.service;

import com.example.mystock.entities.Produit;

import java.io.IOException;
import java.util.Collection;

public interface produitService {
    Produit create(Produit produit);
    Collection<Produit> list(int limit);
    Produit get(Long idProduit);
    Produit update(Produit produit);
    Boolean delete(Long idProduit);
}
