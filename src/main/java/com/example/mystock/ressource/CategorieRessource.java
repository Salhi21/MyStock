package com.example.mystock.ressource;

import com.example.mystock.entities.Categorie;
import com.example.mystock.entities.Fournisseur;
import com.example.mystock.entities.Produit;
import com.example.mystock.entities.Response;
import com.example.mystock.service.implementation.CategorieServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@RestController
@CrossOrigin(origins="*",allowedHeaders="*",maxAge = 3600)
@RequestMapping("/categorie")
@RequiredArgsConstructor
public class CategorieRessource {
    private final CategorieServiceImplementation categorieServiceImplementation;

    @GetMapping("/list")
    public ResponseEntity<Response> getCategorie() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("categorie",categorieServiceImplementation.list(30)))
                        .message("Categories retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
    @PostMapping("/save")
    public ResponseEntity<Response> createCategorie(@RequestBody  Categorie categorie) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("categorie",categorieServiceImplementation.create(categorie)))
                        .message("Categorie crée")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()

        );
    }
    @DeleteMapping("/delete/{idCateg}")
    public ResponseEntity<Response> deleteProudit(@PathVariable("idCateg") Long idCateg) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted",categorieServiceImplementation.delete(idCateg)))
                        .message("Categorie deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
    @PutMapping("/update/{idCategorie}")
    public ResponseEntity<Response> updateProduit(@PathVariable("idCategorie") Long idCategorie , @RequestBody Categorie categorie) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("updated",categorieServiceImplementation.update(categorie , idCategorie )))
                        .message("Categorie updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping("/get/{idCategorie}")
    public ResponseEntity<Response> pingServer(@PathVariable("idCategorie") Long idCategorie) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("categorie",categorieServiceImplementation.get(idCategorie)))
                        .message("Categorie retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
}
