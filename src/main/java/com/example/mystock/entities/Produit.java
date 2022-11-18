package com.example.mystock.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @Column(nullable = false)
    private LocalDate dateAjout = LocalDate.now();
    private Float prixLivr;
    @ManyToOne
    @JoinColumn(name = "idMarque")
    @JsonBackReference
    private Marque marque;
    @ManyToOne
    @JoinColumn(name = "idCateg", nullable = false)
    @JsonBackReference
    private Categorie categorie;

    @JsonManagedReference
    @JsonIgnore
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "produits")
    private List<Facture> factures;
    @JsonBackReference
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "produits")
    private List<Fournisseur> fournisseurs;

}
