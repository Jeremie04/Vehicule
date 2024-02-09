
package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.vehicule.gestion.modele.Annonce;
import com.vehicule.gestion.repository.AnnonceRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class AnnonceService {    
    @Autowired
    private AnnonceRepository annonceRepositorie;

    public List<Annonce> findAll(){
        return annonceRepositorie.findAll();
    }

    public List<Annonce> findAllByIdAnnonce(String id){
        return annonceRepositorie.findAllByIdAnnonce(id);
    }

    public Annonce save(Annonce c){
        return annonceRepositorie.save(c);
    }
    public List<Annonce> findAllByEtat(int etat){
        return annonceRepositorie.findAllByEtat(etat);
    }

    public List<Annonce> findByUtilisateurAndEtat(String idUtilisateur,int etat){
        return annonceRepositorie.findByUtilisateurAndEtat(idUtilisateur, etat);
    }

    public List<Annonce> rechercheAvance(String marque,String modele,String categorie,String date1,String date2,String prix1,String prix2){
        Annonce annonce=new Annonce();
        Specification spec=Annonce.rechercheAvancee(marque, modele, categorie, date1, date2, prix1, prix2);
        return annonceRepositorie.findAll(spec);
    }
    // public List<Annonce> findAllByU
    @Transactional
    public void update(String idAnnonce, int etat) throws Exception {
        // Retrieve the user entity from the database
        List<Annonce> annonceActuelle = annonceRepositorie.findAllByIdAnnonce(idAnnonce);

        if (annonceActuelle.size() != 0) {
            Annonce annonce = annonceActuelle.get(0);

            // Update the fields with new values
            annonce.setEtat(etat);
            // Save the updated entity back to the database
            annonceRepositorie.save(annonce);
        } else {
            throw new Exception("Annonc non Existant : " + idAnnonce);
        }
    }

}

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.jpa.domain.Specification;
// import org.springframework.stereotype.Service;
// import java.util.ArrayList;
// import java.util.List;

// @Service
// public class AnnonceService {

//     @Autowired
//     private AnnonceRepository annonceRepository;

//     public List<Annonce> rechercheAvance(String marque, String modele, String categorie, String date1, String date2, String prix1, String prix2) {
//         Specification<Annonce> spec = Specification.where(null);

//         if (marque != null && !marque.isEmpty()) {
//             spec = spec.and((root, query, builder) -> builder.equal(root.get("marque"), marque));
//         }
//         if (modele != null && !modele.isEmpty()) {
//             spec = spec.and((root, query, builder) -> builder.equal(root.get("modele"), modele));
//         }
//         // Ajoutez d'autres conditions pour les autres champs du formulaire

//         return annonceRepository.findAll(spec);
//     }
// }
