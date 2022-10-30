package com.example.mystock.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private List<Fournisseur> fournisseurs;

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public String getLibProd() {
        return libProd;
    }

    public void setLibProd(String libProd) {
        this.libProd = libProd;
    }

    public String getDescProd() {
        return descProd;
    }

    public void setDescProd(String descProd) {
        this.descProd = descProd;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Float getPrixLivr() {
        return prixLivr;
    }

    public void setPrixLivr(Float prixLivr) {
        this.prixLivr = prixLivr;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
