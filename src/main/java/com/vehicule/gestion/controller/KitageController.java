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
import com.vehicule.gestion.modele.Kitage;
import com.vehicule.gestion.service.AnnonceService;
import com.vehicule.gestion.service.KitageService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class KitageController {

    @Autowired
    private KitageService entiteService;
    private AnnonceService annonceService;
    private Gson gson = new Gson();
    private ApiResponse reponse;

    @Transactional
    @PostMapping("/kitage")
    public ResponseEntity<String> save(@RequestBody Kitage c, String id) throws Exception {
        List<Annonce> annonce = annonceService.findAllByIdAnnonce(id);
        if (annonce.size() > 0) {
            reponse = new ApiResponse("", entiteService.save(c));
            return ResponseEntity.ok(gson.toJson(reponse));
        }
        reponse = new ApiResponse("Cette annonce nexiste pas", null);
        return ResponseEntity.status(500).body("Cette annonce nexiste pas");
    }

    // public List<Kitage> findAllById(String id,String idAnnonce){
    // return entiteService.findAllByIdAnnonce(idAnnonce);
    // }

    @GetMapping("/kitages")
    public ResponseEntity<String> getAll() {
        try {
            reponse = new ApiResponse("", entiteService.findAll());
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

    @GetMapping("/kitage/{id}")
    public ResponseEntity<String> findAllById(@PathVariable("id") String id) {
        try {
            reponse = new ApiResponse("", entiteService.findAllById(id));
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

}
