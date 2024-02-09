package com.vehicule.gestion.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.HistoriqueInteret;
import com.vehicule.gestion.modele.MeilleurMarqueVendu;
import com.vehicule.gestion.service.HistoriqueInteretService;
import com.vehicule.gestion.service.InteretService;
import com.vehicule.gestion.service.MeilleurMarqueVenduService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/interet")
public class InteretController {
    @Autowired
    InteretService interetService;
    private Gson gson = new Gson();
    private ApiResponse reponse;
    @Autowired
    HistoriqueInteretService historiqueInteretService;

    @Transactional
    @PostMapping("update/{date}/{taux}")
    public ResponseEntity getList(@PathVariable("date") Date date,@PathVariable("taux") float taux) {
        try {
            HistoriqueInteret histo=new HistoriqueInteret(date,taux);
            interetService.updateInteret(date,taux);
            historiqueInteretService.save(histo);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
