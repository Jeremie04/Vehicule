package com.vehicule.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.Kitage;

@Repository
public interface KitageRepository extends JpaRepository<Kitage, String> {
    List<Kitage> findAll();

    List<Kitage> findAllByIdKitage(String  id);
   // List<Kitage> findAllByIdAnnonce(String  id);


    // List<Categorie> findAllByNomCategorie(String nomCategorie);
}
