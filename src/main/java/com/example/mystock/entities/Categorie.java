package com.example.mystock.entities;

import com.fasterxml.jackson.annotation.*;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCateg")
public class Categorie implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCateg;
    private String libCateg;

   @OneToMany(mappedBy = "categorie",cascade = CascadeType.ALL)
   private List<Produit> produits;

   public Categorie(Long idCateg, String libCateg) {
        this.idCateg = idCateg;
        this.libCateg = libCateg;
    }

  }
