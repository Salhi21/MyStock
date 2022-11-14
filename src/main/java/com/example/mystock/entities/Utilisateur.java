package com.example.mystock.entities;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "utilisateur")
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idutil;
    private String nom;
    private String prenom;
    private String email;
    private Integer codePosta;
    private Date dateNaissance;

}
