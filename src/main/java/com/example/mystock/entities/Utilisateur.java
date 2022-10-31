package com.example.mystock.entities;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "utilisateur")
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idutil;
    private String nom;
    private String prenom;
    private String email;
    private Integer codePosta;
    private Date dateNaissance;

    public Long getIdutil() {
        return idutil;
    }

    public void setIdutil(Long idutil) {
        this.idutil = idutil;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCodePosta() {
        return codePosta;
    }

    public void setCodePosta(Integer codePosta) {
        this.codePosta = codePosta;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
