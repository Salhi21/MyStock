package com.example.mystock.ressource;

import com.example.mystock.entities.Categorie;
import com.example.mystock.entities.Response;
import com.example.mystock.entities.Utilisateur;
import com.example.mystock.service.implementation.CategorieServiceImplementation;
import com.example.mystock.service.implementation.UtilisateurServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*",maxAge = 3600)
@RequestMapping("/user")
@RequiredArgsConstructor
public class UtilisateurRessource {
    private final UtilisateurServiceImplementation utilisateurServiceImplementation;

    @GetMapping("/list")
    public ResponseEntity<Response> getUser() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("user",utilisateurServiceImplementation.list(30)))
                        .message("user retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
    @PostMapping("/save")
    public ResponseEntity<Response> createUser(@RequestBody Utilisateur utilisateur) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("user",utilisateurServiceImplementation.create(utilisateur)))
                        .message("utilisateur crée")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()

        );
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable("id") Long id) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted",utilisateurServiceImplementation.delete(id)))
                        .message("user deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateUser(@PathVariable("id") Long id , @RequestBody Utilisateur utilisateur) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("updated",utilisateurServiceImplementation.update(utilisateur , id )))
                        .message("User updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getbyiduser(@PathVariable("id") Long id) {
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("user",utilisateurServiceImplementation.get(id)))
                        .message("Utilisateur retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()

        );
    }
    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody Utilisateur utilisateur) {
        return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(of("user",utilisateurServiceImplementation.existsByEmailandPassword(utilisateur.getEmail(), utilisateur.getPassword())))
                            .message("Utilisateur retrieved")
                            .status(OK)
                            .statusCode(OK.value())
                            .build()

        );
    }

}

