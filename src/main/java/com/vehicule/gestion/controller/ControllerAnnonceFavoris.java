package com.vehicule.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.Annonce;
import com.vehicule.gestion.modele.AnnonceFavoris;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.Utilisateur;
import com.vehicule.gestion.service.AnnonceService;
import com.vehicule.gestion.service.ServiceAnnonceFavoris;
import com.vehicule.gestion.service.UtilisateurService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/annoncefavoris")
public class ControllerAnnonceFavoris {

    @Autowired
    private ServiceAnnonceFavoris serviceannoncefavoris;
    private Gson gson = new Gson();
    private ApiResponse reponse;
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/listefavoris")
    public ResponseEntity<String> getList() {
        try {
            String mailutilisateur = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());
            Utilisateur utilisateur = utilisateurService.findByMail(mailutilisateur).get();
            List<AnnonceFavoris> annonces = serviceannoncefavoris.findByIdUtilisateur(utilisateur.getIdUtilisateur());
            reponse = new ApiResponse("", annonces);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/mettreFavoris/{idannonce}")
    public ResponseEntity<String> valideAnnonce(@PathVariable("idannonce") String idannonce) {
        try {
            String mailutilisateur = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());
            Utilisateur utilisateur = utilisateurService.findByMail(mailutilisateur).get();
            Annonce a = new Annonce();
            a.setIdAnnonce(idannonce);
            AnnonceFavoris annoncefavoris = new AnnonceFavoris(utilisateur, a);
            reponse = new ApiResponse("", "Annonce ajouter au hebergement");
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
