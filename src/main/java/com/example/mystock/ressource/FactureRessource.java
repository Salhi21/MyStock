package com.example.mystock.ressource;

import com.example.mystock.entities.Categorie;
import com.example.mystock.entities.Facture;
import com.example.mystock.entities.Response;
import com.example.mystock.service.implementation.FactureServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",maxAge = 3600)
@RequestMapping("/facture")
@RequiredArgsConstructor
public class FactureRessource {
    private final FactureServiceImplementation factureServiceImplementation;

    @GetMapping("/list")
    public ResponseEntity<Response> getFacture() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("facture",factureServiceImplementation.list(30)))
                        .message("factures retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
    @PostMapping("/save")
    public ResponseEntity<Response> createFacture(@RequestBody Facture facture) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("facture",factureServiceImplementation.create(facture)))
                        .message("facture crée")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()

        );
    }
    @DeleteMapping("/delete/{fact_Achat}")
    public ResponseEntity<Response> deleteFacture(@PathVariable("fact_Achat") Long fact_Achat) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted",factureServiceImplementation.delete(fact_Achat)))
                        .message("Facture deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
    @PutMapping("/update/{fact_Achat}")
    public ResponseEntity<Response> updateFacture(@PathVariable("fact_Achat") Long fact_Achat , @RequestBody Facture facture) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("updated",factureServiceImplementation.update(facture , fact_Achat )))
                        .message("Facture updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping("/get/{fact_Achat}")
    public ResponseEntity<Response> getFactureid(@PathVariable("fact_Achat") Long fact_Achat) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("Facture",factureServiceImplementation.get(fact_Achat)))
                        .message("Facture retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
}
