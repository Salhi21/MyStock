package com.example.mystock.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Categorie")
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCateg;
    private String libCateg;
    @OneToMany(mappedBy = "categorie")
    private List<Produit> produit;

  }
