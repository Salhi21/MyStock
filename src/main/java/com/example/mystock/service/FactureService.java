package com.example.mystock.service;

import com.example.mystock.entities.Facture;
import com.example.mystock.entities.Utilisateur;

import java.util.Collection;
import java.util.Optional;

public interface FactureService {
    Facture create(Facture facture);
    Collection<Facture> list(int limit);
    Facture get(Long fact_Achat);
    Optional<Facture> update(Facture facture, Long fact_Achat);
    Boolean delete(Long fact_Achat);
}
