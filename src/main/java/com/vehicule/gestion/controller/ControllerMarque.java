package com.vehicule.gestion.controller;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.Marque;
import com.vehicule.gestion.modele.Pays;
import com.vehicule.gestion.service.ServiceMarque;
import com.vehicule.gestion.service.ServicePays;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ControllerMarque {

    @Autowired
    private ServiceMarque servicemarque;
    private final ServicePays servicepays = new ServicePays();
    private Gson gson = new Gson();
    private ApiResponse reponse;

    // @GetMapping("/marques")
    // public List<Marque> findAll() {
    // List<Marque> lesMarques = servicemarque.findAll();
    // return lesMarques;
    // }

    @GetMapping("/marques")
    public ResponseEntity<String> findAll() {
        try {
            List<Marque> lesMarques = servicemarque.findAll();
            reponse = new ApiResponse("", lesMarques);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @Transactional(rollbackOn = Exception.class)
    @PostMapping("/marque")
    public ResponseEntity<String> save(@RequestBody Marque marque) {
        try {
            servicemarque.save(marque);
            return ResponseEntity.ok("Marque saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }

    }

    @GetMapping("/marques/{id_marque}")
    public ResponseEntity<String> findById(@PathVariable("id_marque") String id_marque) {
        try {
            Optional<Marque> lesMarques = servicemarque.findById(id_marque);
            ;
            reponse = new ApiResponse("", lesMarques.get());
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @Transactional(rollbackOn = Exception.class)
    @PostMapping("/marque/{id_marque}")
    public ResponseEntity<String> deleteById(@PathVariable("id_marque") String id_marque) {
        try {
            servicemarque.deleteById(id_marque);
            return ResponseEntity.ok("Marque id = " + id_marque + " deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

    @Transactional(rollbackOn = Exception.class)
    @PostMapping("/marque/{id_marque}/{pays}")
    public ResponseEntity<String> update(@PathVariable("id_marque") String id_marque,@PathVariable("pays") String pays) {
        try {
            servicemarque.updateMarque(pays,id_marque);
            return ResponseEntity.ok("Marque id = " + id_marque + " update successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

}
