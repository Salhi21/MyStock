package com.example.mystock.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Marque")
public class Marque {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMarque;
    private String libMarque;
    @OneToMany(mappedBy = "marque")
    private List<Produit> produit;


    public Long getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Long idMarque) {
        this.idMarque = idMarque;
    }

    public String getLibMarque() {
        return libMarque;
    }

    public void setLibMarque(String libMarque) {
        this.libMarque = libMarque;
    }

}
