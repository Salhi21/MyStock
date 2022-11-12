package com.example.mystock.ressource;

import com.example.mystock.entities.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/produit")
@RequiredArgsConstructor
public class ProduitRessource {
    private final com.example.mystock.service.implementation.produitServiceImplementation produitServiceImplementation;
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

}
