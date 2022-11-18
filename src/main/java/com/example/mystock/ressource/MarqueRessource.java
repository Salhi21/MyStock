package com.example.mystock.ressource;

import com.example.mystock.entities.Categorie;
import com.example.mystock.entities.Marque;
import com.example.mystock.entities.Response;
import com.example.mystock.service.implementation.MarqueServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",maxAge = 3600)
@RequestMapping("/marque")
@RequiredArgsConstructor
public class MarqueRessource {
    private final MarqueServiceImplementation marqueServiceImplementation;

    @GetMapping("/list")
    public ResponseEntity<Response> getMarque() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("Marque",marqueServiceImplementation.list(30)))
                        .message("Marque retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
    @PostMapping("/save")
    public ResponseEntity<Response> createMarque(@RequestBody Marque marque) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("marque",marqueServiceImplementation.create(marque)))
                        .message("marque crée")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()

        );
    }
    @DeleteMapping("/delete/{idMarque}")
    public ResponseEntity<Response> deleteMarque(@PathVariable("idMarque") Long idMarque) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted",marqueServiceImplementation.delete(idMarque)))
                        .message("Marque deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
    @PutMapping("/update/{idMarque}")
    public ResponseEntity<Response> updateMarque(@PathVariable("idMarque") Long idMarque , @RequestBody Marque marque) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("updated",marqueServiceImplementation.update(marque , idMarque )))
                        .message("Marque updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping("/get/{idMarque}")
    public ResponseEntity<Response> getMarque(@PathVariable("idMarque") Long idMarque) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("marque",marqueServiceImplementation.get(idMarque)))
                        .message("Marque retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
}
