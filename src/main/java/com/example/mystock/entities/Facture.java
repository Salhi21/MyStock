package com.example.mystock.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    @ManyToOne
    @JoinColumn(name = "idFournisseur")
    @JsonBackReference
    private Fournisseur fournisseur;

    @JsonManagedReference
    @JsonIgnore
    @ManyToMany(cascade = { CascadeType.ALL }, fetch=FetchType.LAZY)
    @JoinTable(name = "factures_produits",
            joinColumns = { @JoinColumn(name = "fact_Achat") },
            inverseJoinColumns = { @JoinColumn(name = "idProduit") })
    private Set<Produit> produits ;
}
