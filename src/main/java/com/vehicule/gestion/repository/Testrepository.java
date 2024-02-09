package com.vehicule.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vehicule.gestion.modele.Test;

@Repository
public interface Testrepository extends JpaRepository<Test, String> {
    // Exemple de requête JPQL avec @Query
   //@Query("SELECT t FROM test t order by t.date asc")
   List<Test> findAllByOrderByDateAsc();

}
