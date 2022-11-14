package com.example.mystock.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "Produits")
public class Produit {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduit;
    private String libProd;
    private String descProd;
    private Double prix;
    private Date dateAjout;
    private Float prixLivr;
    @ManyToOne
    @JoinColumn(name = "idMarque")
    private Marque marque;
    @ManyToOne
    @JoinColumn(name = "idCateg")
    private Categorie categorie;
    @ManyToMany(mappedBy = "produits")
    private List<Facture> factures;
    @ManyToMany(mappedBy = "produits")
    private List<Fournisseur> fournisseurs;

}
