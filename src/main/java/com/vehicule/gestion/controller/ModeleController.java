package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.Categorie;
import com.vehicule.gestion.modele.Modele;
import com.vehicule.gestion.service.ModeleService;
import com.vehicule.gestion.tools.MappingModele;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ModeleController {
    @Autowired
    private ModeleService modeleService;
    private Gson gson = new Gson();
    private ApiResponse reponse;

    @GetMapping("/modeles")
    public ResponseEntity<String> findAll() throws Exception {
        try {
            List<Modele> categories = modeleService.findAll();
            reponse = new ApiResponse("", categories);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/modele/{id}")
    public ResponseEntity<String> findAllById(@PathVariable("id") Iterable<String> id) {
        try {
            reponse = new ApiResponse("", modeleService.findAllById(id));
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

    @GetMapping("/modeleByName/{nom}")
    public ResponseEntity<String> findAllById(@PathVariable("nom") String nom) {
        try {
            reponse = new ApiResponse("", modeleService.findAllByNomModele(nom));
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

    @Transactional
    @PostMapping("/modele")
    public ResponseEntity<String> save(@RequestBody Modele c) throws Exception {
        // List<Modele> categorie = modeleService.findAllByNomModele(c.getNomModele());
        // if (c.isNomDeplacated(categorie) == false) {
        reponse = new ApiResponse("", modeleService.save(c));
        return ResponseEntity.ok(gson.toJson(reponse));
        // }
        // return ResponseEntity.status(500).body("Cette modele existe dejà");
    }

    @Transactional
    @PostMapping("/modele/update")
    public ResponseEntity<String> update(@RequestBody MappingModele c) throws Exception {
        try {
            reponse = new ApiResponse("", null);
            modeleService.update(c.getIdModele(), c.getCategorie(), c.getMarque(), c.getNommodele());
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }
}
