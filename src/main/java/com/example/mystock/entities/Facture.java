package com.example.mystock.entities;

import com.fasterxml.jackson.annotation.*;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "fact_Achat")
public class Facture {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fact_Achat;
    private Date date;
    private Double totalHT;
    private Double total_TVA;
    private Double total_TTC;
    @ManyToOne
    @JoinColumn(name = "idFournisseur")
    private Fournisseur fournisseur;

    @ManyToMany(cascade = CascadeType.MERGE , fetch=FetchType.LAZY)
    @JoinTable(name = "factures_produits",
            joinColumns = { @JoinColumn(name = "fact_Achat",referencedColumnName = "fact_Achat") },
            inverseJoinColumns = { @JoinColumn(name = "idProduit",referencedColumnName = "idProduit" )})
    private List<Produit> produits ;
}
