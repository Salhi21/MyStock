package com.example.mystock.service;

import com.example.mystock.entities.Categorie;
import com.example.mystock.entities.Marque;

import java.util.Collection;
import java.util.Optional;

public interface MarqueService {
    Marque create(Marque marque);
    Collection<Marque> list(int limit);
    Marque get(Long idMarque);
    Optional<Marque> update(Marque marque, Long idMarque);
    Boolean delete(Long idMarque);
}
