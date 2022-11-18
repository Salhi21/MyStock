package com.example.mystock.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "Marque")
public class Marque {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMarque;
    private String libMarque;
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "marque")
    private List<Produit> produit;

}
