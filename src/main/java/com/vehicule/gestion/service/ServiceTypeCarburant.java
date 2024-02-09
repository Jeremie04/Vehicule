package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import com.vehicule.gestion.modele.TypeCarburant;
import com.vehicule.gestion.repository.RepositoryTypeCarburant;

@Service
public class ServiceTypeCarburant {

    @Autowired
    private RepositoryTypeCarburant repositorytypecarburant;

    public List<TypeCarburant> findAll() {
        return repositorytypecarburant.findAll();
    }

    public TypeCarburant save(TypeCarburant marque) {
        return repositorytypecarburant.save(marque);
    }

    @Transactional
    public Optional<TypeCarburant> findById(String id) {
        return repositorytypecarburant.findById(id);
    }

    public void deleteById(String id) {
        repositorytypecarburant.deleteById(id);
    }

}
