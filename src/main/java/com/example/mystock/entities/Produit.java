package com.example.mystock.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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
public class Produit implements Serializable {
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
   @JsonBackReference
   @JoinColumn(name = "idCateg", nullable = false)
   private Categorie categorie;
   @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "produits")
   private List<Facture> factures;

}
