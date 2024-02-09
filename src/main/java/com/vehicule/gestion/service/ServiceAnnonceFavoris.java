
package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.jayway.jsonpath.Option;
import com.vehicule.gestion.modele.Annonce;
import com.vehicule.gestion.modele.AnnonceFavoris;
import com.vehicule.gestion.repository.AnnonceRepository;
import com.vehicule.gestion.repository.RepositoryAnnonceFavoris;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAnnonceFavoris {
    @Autowired
    private RepositoryAnnonceFavoris repositoryannoncefavoris;

    public List<AnnonceFavoris> findAll() {
        return repositoryannoncefavoris.findAll();
    }

    public List<AnnonceFavoris> findByIdUtilisateur(String id) {
        return repositoryannoncefavoris.findByUtilisateur(id);
    }

    public AnnonceFavoris save(AnnonceFavoris c) {
        return repositoryannoncefavoris.save(c);
    }

    @Transactional
    public void update(String idAnnonce, int etat) throws Exception {
        // Retrieve the user entity from the database
        Optional<AnnonceFavoris> annonceActuelle = repositoryannoncefavoris.findById(idAnnonce);

        if (annonceActuelle.isPresent()) {
            AnnonceFavoris annonce = annonceActuelle.get();

            // Update the fields with new values
            annonce.setEtat(etat);
            // Save the updated entity back to the database
            repositoryannoncefavoris.save(annonce);
        } else {
            throw new Exception("AnnonceFavoris non Existant : " + idAnnonce);
        }
    }

}
