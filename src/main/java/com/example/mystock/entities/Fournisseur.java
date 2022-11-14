package com.example.mystock.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@ToString
@Getter
@Setter
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
    @OneToMany(mappedBy = "fournisseur")
    private List<Facture> factures;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "fournisseurs_produits",
            joinColumns = { @JoinColumn(name = "idFournisseur") },
            inverseJoinColumns = { @JoinColumn(name = "idProduit") })
    private Set<Produit> produits ;


}
