package com.example.mystock.Repo;

import com.example.mystock.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    Produit findByid(Long idProduit);

}