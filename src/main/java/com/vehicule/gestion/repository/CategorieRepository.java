package com.vehicule.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, String> {
    List<Categorie> findAll();

    List<Categorie> findAllById(String id);

    List<Categorie> findAllByNomCategorie(String nomCategorie);

    @Modifying
    @Query("update Categorie c set c.nomCategorie=:nom where id=:id")
    void update(@Param(value = "nom") String nom,@Param(value = "id") String id);
}
