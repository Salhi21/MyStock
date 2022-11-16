package com.example.mystock.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateAjout = new Date(System.currentTimeMillis());
    private Float prixLivr;
    @ManyToOne
    @JoinColumn(name = "idMarque")
    private Marque marque;
    @ManyToOne
    @JoinColumn(name = "idCateg")
    private Categorie categorie;
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "produits")
    private List<Facture> factures;
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "produits")
    private List<Fournisseur> fournisseurs;

}
