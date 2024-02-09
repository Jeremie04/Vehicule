package com.vehicule.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.Modele;

@Repository
public interface ModeleRepository extends JpaRepository<Modele, String> {
    List<Modele> findAll();

    List<Modele> findAllById(String id);

    List<Modele> findAllByNomModele(String nomModele);

     @Modifying
    @Query("update Modele m set m.marque.id=:marque,m.categorie=:categorie,nomModele=:nom where id=:idmodele")
    void update(@Param(value = "categorie") String categorie,@Param(value = "marque") String marque,@Param(value = "nom") String nom,@Param(value = "idmodele") String idmodele);
}
