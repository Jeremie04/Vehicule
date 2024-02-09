package com.vehicule.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.FonctionnaliteTechnologique;
import com.vehicule.gestion.service.FonctionnaliteTechnologiqueService;

import jakarta.transaction.Transactional;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FonctionnaliteTechonologiqueController {
    @Autowired
    private FonctionnaliteTechnologiqueService entiteService;
    private Gson gson = new Gson();
    private ApiResponse reponse;

    @GetMapping("/fonctionnalite")
    public ResponseEntity<String> getAll() {
        try {
            reponse = new ApiResponse("", entiteService.findAll());
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

    @GetMapping("/fonctionnalite/{id}")
    public ResponseEntity<String> findAllById(@PathVariable("id") Iterable<String> id) {
        try {
            reponse = new ApiResponse("", entiteService.findAllById(id));
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

    @Transactional
    @PostMapping("/fonctionnalite")
    public ResponseEntity<String> save(@RequestBody FonctionnaliteTechnologique c) throws Exception {
        List<FonctionnaliteTechnologique> FonctionnaliteTechonologique = entiteService
                .findAllByNomFonctionnaliteTechnologique(c.getNomFonctionnaliteTechonologique());
        if (c.isNomDuplicated(FonctionnaliteTechonologique) == false) {
            reponse = new ApiResponse("", entiteService.save(c));
            return ResponseEntity.ok(gson.toJson(reponse));
        }
        reponse = new ApiResponse("Cette Fonctionnalite existe dejà", null);
        return ResponseEntity.status(500).body(gson.toJson(reponse));
    }

    @Transactional
    @PostMapping("/fonctionnalite/delete/{id}")
    public ResponseEntity<String> postMethodName(@PathVariable("id") String id) {
        try {
            entiteService.delete(id);
            return ResponseEntity.ok("fonctionnalite " + id + " supprimé avec succes");
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }

    }

}
