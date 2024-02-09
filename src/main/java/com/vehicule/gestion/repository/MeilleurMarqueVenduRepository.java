package com.vehicule.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import com.vehicule.gestion.modele.MeilleurMarqueVendu;


@Repository
public interface MeilleurMarqueVenduRepository extends JpaRepository<MeilleurMarqueVendu, String> {
    List<MeilleurMarqueVendu> findAll();

    @Query(value = "SELECT m FROM MeilleurMarqueVendu m where mois=:mois and annee=:annee order by nombre desc")
    List<MeilleurMarqueVendu> findAllByMoisAndAnnee(@Param("mois") int mois,@Param("annee")int annee,Pageable pageable);
}
