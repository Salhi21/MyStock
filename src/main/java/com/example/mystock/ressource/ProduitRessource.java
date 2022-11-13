package com.example.mystock.ressource;

import com.example.mystock.entities.Produit;
import com.example.mystock.entities.Response;
import com.example.mystock.service.implementation.ProduitServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/produit")
@RequiredArgsConstructor
public class ProduitRessource {
    private final ProduitServiceImplementation produitServiceImplementation;
    @GetMapping("/list")
    public ResponseEntity<Response> getProduits() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("produits",produitServiceImplementation.list(30)))
                        .message("Proucts retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
    @PostMapping("/save")
    public ResponseEntity<Response> createProduit(@RequestBody  Produit produit) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("produit",produitServiceImplementation.create(produit)))
                        .message("Produit ajoutée")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()

        );
    }

}
