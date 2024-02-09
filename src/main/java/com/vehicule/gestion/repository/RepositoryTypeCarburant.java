package com.vehicule.gestion.repository;

// import java.util.List;
// import java.util.Optional;

import com.vehicule.gestion.modele.TypeCarburant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import java.util.List;

@Repository
public interface RepositoryTypeCarburant extends JpaRepository<TypeCarburant, String> {
}