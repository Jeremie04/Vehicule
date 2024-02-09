package com.vehicule.gestion.controller;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.Pays;
import com.vehicule.gestion.service.ServicePays;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ControllerPays {

    @Autowired
    private ServicePays servicepays;
    private Gson gson = new Gson();
    private ApiResponse reponse;

    @GetMapping("/pays")
    public ResponseEntity<String> findAll() {
        try {
            List<Pays> lesPays = servicepays.findAll();
            reponse = new ApiResponse("", lesPays);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @Transactional(rollbackOn = Exception.class)
    @PostMapping("/pays/{nom_pays}")
    public ResponseEntity<String> save(@PathVariable("nom_pays") String nomMarque) {
        try {
            Pays pays = new Pays(nomMarque);
            servicepays.save(pays);
            return ResponseEntity.ok("Pays saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }

    }

    @GetMapping("/paysspecifique/{idpays}")
    public ResponseEntity<String> findById(@PathVariable("idpays") String idPays) {
        try {
            Optional<Pays> lesMarques = servicepays.findById(idPays);
            reponse = new ApiResponse("", lesMarques.get());
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @Transactional(rollbackOn = Exception.class)
    @GetMapping("/suppressionpays/{idpays}")
    public ResponseEntity<String> deleteById(@PathVariable("idpays") String idpays) {
        try {
            servicepays.deleteById(idpays);
            return ResponseEntity.ok("Marque id = " + idpays + " deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

}
