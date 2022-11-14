package com.example.mystock.entities;

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
    @OneToMany(mappedBy = "marque")
    private List<Produit> produit;

}
