package com.example.mystock.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Commande")
public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCommande;
    private Date Datefourni;

}
