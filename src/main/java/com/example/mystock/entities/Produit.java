package com.example.mystock.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "Produits")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProduit")
public class Produit implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduit;
    private String libProd;
    private String descProd;
    private Double prix;
    @JsonFormat(pattern="MM-DD-YYYY")
    private Date dateAjout;
    private Float prixLivr;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idMarque")
    private Marque marque;
   @ManyToOne
   @JoinColumn(name = "idCateg")
   private Categorie categorie;

   @ManyToMany(fetch=FetchType.LAZY,mappedBy = "produits")
   @JsonIgnore
   private List<Facture> factures;

}
