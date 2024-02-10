package com.vehicule.gestion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.Annonce;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.MappingRecherche;
import com.vehicule.gestion.modele.Marque;
import com.vehicule.gestion.modele.SousModele;
import com.vehicule.gestion.modele.Utilisateur;
import com.vehicule.gestion.service.AnnonceService;
import com.vehicule.gestion.service.SousModeleService;
import com.vehicule.gestion.service.UtilisateurService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/annonce")
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;
    @Autowired
    private SousModeleService sousModeleService;
    private Gson gson = new Gson();
    private ApiResponse reponse;
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/listesValidees")
    public ResponseEntity<String> getList() {
        try {
            List<Annonce> annonce = annonceService.findAllByEtat(3);
            reponse = new ApiResponse("", annonce);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/Avalide")
    public ResponseEntity<String> valideAnnonce() {
        try {
            List<Annonce> annonce = annonceService.findAllByEtat(0);
            reponse = new ApiResponse("", annonce);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/mesAnnonce")
    public ResponseEntity<String> avoirMesListes() {
        try {
            String mailUtilisateur = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());
            Utilisateur utilisateur = utilisateurService.findByMail(mailUtilisateur).get();
            List<Annonce> annonce = annonceService.findByUtilisateurAndEtat(utilisateur.getIdUtilisateur(), 5);
            reponse = new ApiResponse("", annonce);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/mesHistoriques")
    public ResponseEntity<String> avoirHistorique() {
        try {
            String mailUtilisateur = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());
            Utilisateur utilisateur = utilisateurService.findByMail(mailUtilisateur).get();
            List<Annonce> annonce = annonceService.findByUtilisateurAndEtat(utilisateur.getIdUtilisateur(), 6);
            reponse = new ApiResponse("", annonce);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/suppressionAnnonce/{idannonce}")
    public ResponseEntity supprimerAnnonce(@PathVariable("idannonce") String idAnnonce) {
        try {
            Annonce a = annonceService.findAllByIdAnnonce(idAnnonce).get(0);
            a.setEtat(-1);
            annonceService.save(a);
            return ResponseEntity.ok("Annone id:" + idAnnonce + " supprime.");
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/rechercheAvance")
    public ResponseEntity request(@RequestBody MappingRecherche mapping) {
        try {
            List<Annonce> annonce = annonceService.rechercheAvance(mapping.getMarque(), mapping.getModele(),
                    mapping.getCategorie(), mapping.getDateMin(), mapping.getDateMax(), mapping.getPrixMin(),
                    mapping.getPrixMax());
            reponse = new ApiResponse("", annonce);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    public List<Annonce> getValidedAnnonce() {
        return annonceService.findAllByEtat(1);
    }

    public List<Annonce> getNonValidedAnnonce() {
        return annonceService.findAllByEtat(0);
    }

    @Transactional
    @PostMapping("/annonce")
    public Annonce save(@RequestBody Annonce annonce) throws Exception {
        System.out.println(annonce.getSousModele().getIdSousModele() + " ok ");
        SousModele sousModele = sousModeleService.findById(annonce.getSousModele().getIdSousModele())
                .orElseThrow(() -> new Exception(
                        "Le SousModele avec l'id " + annonce.getSousModele().getIdSousModele()
                                + " n'a pas été trouvé."));
        Utilisateur utilisateur = utilisateurService.findById(annonce.getUtilisateur().getIdUtilisateur())
                .orElseThrow(() -> new Exception(
                        "Le Utilisateur avec l'id " + annonce.getUtilisateur().getIdUtilisateur()
                                + " n'a pas été trouvé."));

        annonce.setSousModele(sousModele);
        annonce.setUtilisateur(utilisateur);
        return annonceService.save(annonce);
    }

    @Transactional
    @GetMapping("/MAJannonce/{idAnnonce}")
    public ResponseEntity<String> update(@PathVariable("idAnnonce") String idAnnonce) throws Exception {
        try {
            annonceService.update(idAnnonce, 3);
            return ResponseEntity.ok("Annonce " + idAnnonce + " validee");
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

    @Transactional
    @PutMapping("/annonceVendu/{idAnnonce}")
    public ResponseEntity<String> updateVendu(@PathVariable("idAnnonce") String idAnnonce) throws Exception {
        try {
            annonceService.update(idAnnonce, 5);
            return ResponseEntity.ok("Annonce " + idAnnonce + " validee");
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }

    @GetMapping("/listesById/{idAnnonce}")
    public ResponseEntity<String> getAllById(@PathVariable("idAnnonce") String idAnnonce) {
        try {
            List<Annonce> annonce = annonceService.findAllByIdAnnonce(idAnnonce);
            reponse = new ApiResponse("", annonce);
            return ResponseEntity.ok(gson.toJson(reponse));
        } catch (Exception e) {
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
