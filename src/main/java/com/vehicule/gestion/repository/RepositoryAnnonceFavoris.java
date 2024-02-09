package com.vehicule.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.AnnonceFavoris;

@Repository
public interface RepositoryAnnonceFavoris extends JpaRepository<AnnonceFavoris, String> {
    @Query(value = "SELECT a FROM annoncefavoris a WHERE a.utilisateur.id = :idutilisateur")
    List<AnnonceFavoris> findByUtilisateur(@Param("idutilisateur") String idUtilisateur);

}
