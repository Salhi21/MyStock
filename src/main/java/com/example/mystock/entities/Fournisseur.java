package com.example.mystock.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fournisseurs")
public class Fournisseur {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFournisseur;
    private String nomFournisseur;
    private String adresseFournisseur;
    private String emailFournisseur;
    private Integer telFournisseur;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "fournisseurs_produits",
            joinColumns = { @JoinColumn(name = "idFournisseur") },
            inverseJoinColumns = { @JoinColumn(name = "idProduit") })
    private Set<Produit> produits ;

    public Long getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Long idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getAdresseFournisseur() {
        return adresseFournisseur;
    }

    public void setAdresseFournisseur(String adresseFournisseur) {
        this.adresseFournisseur = adresseFournisseur;
    }

    public String getEmailFournisseur() {
        return emailFournisseur;
    }

    public void setEmailFournisseur(String emailFournisseur) {
        this.emailFournisseur = emailFournisseur;
    }

    public Integer getTelFournisseur() {
        return telFournisseur;
    }

    public void setTelFournisseur(Integer telFournisseur) {
        this.telFournisseur = telFournisseur;
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }
}
