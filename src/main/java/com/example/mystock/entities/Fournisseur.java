package com.example.mystock.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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
public class Fournisseur implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFournisseur;
    private String nomFournisseur;
    private String adresseFournisseur;
    private String emailFournisseur;
    private Integer telFournisseur;
    @OneToMany(mappedBy = "fournisseur",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Facture> facture;

    @OneToMany( fetch=FetchType.LAZY,mappedBy = "fournisseur")
    @JsonIgnore
    private List<Commande> commandes;
    @ManyToOne
    @JoinColumn(name = "idutil")
    @JsonBackReference
    private Utilisateur utilisateur;

}
