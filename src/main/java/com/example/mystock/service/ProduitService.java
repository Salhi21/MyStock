package com.example.mystock.service;

import com.example.mystock.entities.Produit;

import java.util.Collection;

public interface ProduitService {
    Produit create(Produit produit);
    Collection<Produit> list(int limit);
    Long get(Long idProduit);
    Produit update(Produit produit);
    Boolean delete(Long idProduit);
}
