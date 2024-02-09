package com.vehicule.gestion.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.Interet;

@Repository
public interface InteretRepository extends JpaRepository<Interet, String> {
    @Modifying
    @Query("update Interet i set i.date=:date,i.Taux=:taux ")
    void updateDateTauxInteret(@Param(value = "date") Date date,@Param(value = "taux") float taux);
    
}
