package com.example.mystock.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "utilisateur")
    private List<Fournisseur> fournisseurs;

}
