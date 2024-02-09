package com.vehicule.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.Pays;

@Repository
public interface RepositoryPays extends JpaRepository<Pays, String> {
}
