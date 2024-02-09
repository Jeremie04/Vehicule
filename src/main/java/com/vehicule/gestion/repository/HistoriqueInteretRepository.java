package com.vehicule.gestion.repository;

import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.HistoriqueInteret;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface HistoriqueInteretRepository extends JpaRepository<HistoriqueInteret, String>{
    
}
