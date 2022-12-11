package com.example.mystock.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "Produits")
public class Produit {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduit;
    private String libProd;
    private String descProd;
    private Double prix;
    @JsonFormat(pattern="dd-MM-YYYY")
    private Date dateAjout;
    private Float prixLivr;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idMarque")
    private Marque marque;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idCateg")
    private Categorie categorie;

    @JsonBackReference
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "produits")
    private List<Facture> factures;

}
