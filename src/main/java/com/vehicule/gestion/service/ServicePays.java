package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import com.vehicule.gestion.modele.Pays;
import com.vehicule.gestion.repository.RepositoryPays;

@Service
public class ServicePays {
    @Autowired
    private RepositoryPays repositoryPays;

    public List<Pays> findAll() {
        return repositoryPays.findAll();
    }

    public Pays save(Pays marque) {
        return repositoryPays.save(marque);
    }

    @Transactional
    public Optional<Pays> findById(String id_marque) {
        return repositoryPays.findById(id_marque);
    }

    public void deleteById(String idmarque) {
        repositoryPays.deleteById(idmarque);
    }

}
