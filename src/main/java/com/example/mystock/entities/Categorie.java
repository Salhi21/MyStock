package com.example.mystock.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Categorie")
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCateg;
    private String libCateg;
    @OneToMany(mappedBy = "categorie")
    private List<Produit> produit;

    public Long getIdCateg() {
        return idCateg;
    }

    public void setIdCateg(Long idCateg) {
        this.idCateg = idCateg;
    }

    public String getLibCateg() {
        return libCateg;
    }

    public void setLibCateg(String libCateg) {
        this.libCateg = libCateg;
    }
}
