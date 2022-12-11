package com.example.mystock.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "categorie")
    private List<Produit> produit;

  }
