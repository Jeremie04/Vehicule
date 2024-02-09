package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import com.vehicule.gestion.modele.Marque;
import com.vehicule.gestion.repository.RepositoryMarque;

@Service
public class ServiceMarque {
    @Autowired
    private RepositoryMarque repositoryMarque;

    public List<Marque> findAll() {
        return repositoryMarque.findAll();
    }

    public Marque save(Marque marque) {
        return repositoryMarque.save(marque);
    }

    public Optional<Marque> findById(String id_marque) {
        return repositoryMarque.findById(id_marque);
    }

    public void deleteById(String idmarque) {
        repositoryMarque.deleteById(idmarque);
    }

    public void updateMarque(String pays,String idMarque){
        repositoryMarque.update(pays, idMarque);
    }

}
