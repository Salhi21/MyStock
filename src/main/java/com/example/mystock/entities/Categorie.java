package com.example.mystock.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "Categorie")
public class Categorie implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCateg;
    private String libCateg;

   @OneToMany(mappedBy = "categorie",cascade = CascadeType.ALL)
   @JsonManagedReference
   private List<Produit> produits;

   public Categorie(Long idCateg, String libCateg) {
        this.idCateg = idCateg;
        this.libCateg = libCateg;
    }

  }
