package com.vehicule.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.SousModele;

@Repository
public interface SousModeleRepository extends JpaRepository<SousModele, String> {
    List<SousModele> findAll();

    List<SousModele> findAllByIdSousModele(String id);

    List<SousModele> findAllByNomSous(String nomSous);

    
     @Modifying
    @Query("update SousModele m set m.modele.id=:modele,m.nomSous=:nom,vitesseMax=:vitesse,consommation=:consommation,typeCarburant.id=:carburant,estManuel=:manuel,puissanceMoteur=:moteur,batterie=:batterie where idSousModele=:idSousModele")
    void update(@Param(value = "idSousModele") String idSousModele,@Param(value = "modele") String modele,@Param(value = "nom") String nom,@Param(value = "vitesse") float vitesse,@Param(value = "consommation") float consommation,@Param(value = "carburant") String carburant,@Param(value = "manuel") boolean manuel,@Param(value = "moteur") float moteur,@Param(value = "batterie") float batterie);
}
