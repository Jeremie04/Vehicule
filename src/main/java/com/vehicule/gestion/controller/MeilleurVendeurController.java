
package com.vehicule.gestion.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.vehicule.gestion.modele.Annonce;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.MeilleurMarqueVendu;
import com.vehicule.gestion.modele.MeilleurVendeur;
import com.vehicule.gestion.service.MeilleurMarqueVenduService;
import com.vehicule.gestion.service.MeilleurVendeurService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/statistique")
public class MeilleurVendeurController {
    @Autowired
    MeilleurVendeurService meilleurVendeurService;
    private Gson gson = new Gson();
    private ApiResponse reponse;

    
     @PostMapping("/vendeur/{mois}/{annee}/{limitation}")
    public ResponseEntity<String> getList(@PathVariable("mois") int mois,@PathVariable("annee") int annee,@PathVariable("limitation") int limitation) {
        try {
            List<MeilleurVendeur> annonce = meilleurVendeurService.findAllByMoisAndAnnee(mois,annee,limitation);
            reponse = new ApiResponse("", annonce);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}


