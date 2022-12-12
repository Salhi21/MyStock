package com.example.mystock.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Commande")
public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCommande;
    private Date Datefourni;
    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "idFournisseur")
    private Fournisseur fournisseur;


}
