package com.vehicule.gestion.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vehicule.gestion.modele.FonctionnaliteTechnologique;

@Repository
public interface FonctionnaliteTechnologiqueRepository extends JpaRepository<FonctionnaliteTechnologique, String> {
    List<FonctionnaliteTechnologique> findAll();

    List<FonctionnaliteTechnologique> findAllByidFonctionnaliteTechonologique(String id);

    List<FonctionnaliteTechnologique> findAllByNomFonctionnaliteTechonologique(String nomFonctionnaliteTechonologique);
}
