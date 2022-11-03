package com.example.mystock.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "facture")
public class Facture {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fact_Achat;
    private Date date;
    private Double totalHT;
    private Double total_TVA;
    private Double total_TTC;
    @OneToMany(mappedBy = "facture")
    private List<Produit> produits;
    @ManyToOne
    @JoinColumn(name = "fournisseur")
    private Fournisseur fournisseur;
}
