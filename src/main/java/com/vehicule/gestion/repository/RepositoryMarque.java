package com.vehicule.gestion.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.Marque;

@Repository
public interface RepositoryMarque extends JpaRepository<Marque, String> {
    @Modifying
    @Query("update Marque m set m.pays.id=:pays where id=:marque")
    void update(@Param(value = "pays") String pays,@Param(value = "marque") String marque);
}


//marque 20