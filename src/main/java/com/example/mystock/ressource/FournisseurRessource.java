package com.example.mystock.ressource;

import com.example.mystock.entities.Fournisseur;
import com.example.mystock.entities.Response;
import com.example.mystock.service.implementation.FournisseurServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",maxAge = 3600)
@RequestMapping("/fournisseur")
@RequiredArgsConstructor
public class FournisseurRessource {
    private final FournisseurServiceImplementation fournisseurServiceImplementation;

    @GetMapping("/list")
    public ResponseEntity<Response> getFournisseur() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("fournisseur",fournisseurServiceImplementation.list(30)))
                        .message("Fournisseurs retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
    @PostMapping("/save")
    public ResponseEntity<Response> createFournisseur(@RequestBody Fournisseur fournisseur) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("fournisseur",fournisseurServiceImplementation.create(fournisseur)))
                        .message("Fournisseur ajoutée")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()

        );
    }
    @PostMapping("/login")
    public ResponseEntity<Response> recherche(@RequestBody Long id) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("fournisseur",fournisseurServiceImplementation.get(id)))
                        .message("Fournisseur ajoutée")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()

        );
    }
    @DeleteMapping("/delete/{idFournisseur}")
    public ResponseEntity<Response> deleteProudit(@PathVariable("idFournisseur") Long idFournisseur) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted",fournisseurServiceImplementation.delete(idFournisseur)))
                        .message("Fournisseur deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
    @GetMapping("/get/{idFournisseur}")
    public ResponseEntity<Response> pingServer(@PathVariable("idFournisseur") Long idFournisseur) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("fournisseur",fournisseurServiceImplementation.get(idFournisseur)))
                        .message("Fournisseur retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
    @PutMapping("/update/{idFournisseur}")
    public ResponseEntity<Response> updateProduit(@PathVariable("idFournisseur") Long idFournisseur , @RequestBody Fournisseur fournisseur) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("updated",fournisseurServiceImplementation.update(fournisseur)))
                        .message("Produit updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }



}
