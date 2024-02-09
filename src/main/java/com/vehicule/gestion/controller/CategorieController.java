package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.Categorie;
import com.vehicule.gestion.service.CategorieService;

import jakarta.transaction.Transactional;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CategorieController {
    @Autowired
    private CategorieService entiteService;
    private Gson gson = new Gson();
    private ApiResponse response;

    @GetMapping("/categories")
    public ResponseEntity<String> getAll() {
        try {
            List<Categorie> categories = entiteService.findAll();
            response = new ApiResponse("", categories);
            return ResponseEntity.ok(gson.toJson(response));
        } catch (Exception e) {
            response = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/categories/{id_categorie}")
    public ResponseEntity<String> findAllById(@PathVariable("id_categorie") String idCategorie) {
        try {
            List<Categorie> categorie = entiteService.findAllById(idCategorie);
            response = new ApiResponse("", categorie);
            return ResponseEntity.ok(gson.toJson(response));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @Transactional
    @PostMapping("/categorie")
    public ResponseEntity<String> save(@RequestBody Categorie c) {
        try {
            List<Categorie> categorie = entiteService.findAllByNomCategorie(c.getNomCategorie());
            if (c.isNomDuplicated(categorie) == false) {
                response = new ApiResponse("", entiteService.save(c));
                return ResponseEntity.ok(gson.toJson(response));
            }
            return ResponseEntity.status(500).body("Cette catégorie existe dejà");

        } catch (Exception e) {
            e.printStackTrace();
            response = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(response));
        }
    }

    @Transactional
    @PostMapping("/suppressionCategorie/{id_categorie}")
    public ResponseEntity<String> delete(@PathVariable("id_categorie") String idCategorie) {
        try {
            entiteService.delete(idCategorie);
            return ResponseEntity.ok("Suppression reussie");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }

}
