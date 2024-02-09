package com.vehicule.gestion.controller;

import java.util.List;

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
import com.vehicule.gestion.modele.Annonce;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.ImageAnnonce;
import com.vehicule.gestion.service.AnnonceService;
import com.vehicule.gestion.service.ImageAnnonceService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ImageAnnonceController {
    @Autowired
    private ImageAnnonceService entiteService;
    private AnnonceService annonceService;
    private Gson gson = new Gson();
    private ApiResponse response;

    @GetMapping("/imageAnnonces")
    public ResponseEntity<String> getAll() {
        try {
            List<ImageAnnonce> images = entiteService.findAll();
            response = new ApiResponse("", images);
            return ResponseEntity.ok(gson.toJson(response));
        } catch (Exception e) {
            response = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/imageAnnonces/{id}")
    public ResponseEntity<String> findAllById(@PathVariable("id") Iterable<String> id) {
        try {
            List<ImageAnnonce> images = entiteService.findAllById(id);
            response = new ApiResponse("", images);
            return ResponseEntity.ok(gson.toJson(response));
        } catch (Exception e) {
            response = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @Transactional
    @PostMapping("/imageAnnonce")
    public ImageAnnonce save(@RequestBody ImageAnnonce c, String idAnnonce) throws Exception {
        List<Annonce> annonces = annonceService.findAllByIdAnnonce(idAnnonce);
        if (annonces.size() > 0) {
            return entiteService.save(c);
        }
        throw new Exception("Cette annonce n'existe pas ");
    }

}
