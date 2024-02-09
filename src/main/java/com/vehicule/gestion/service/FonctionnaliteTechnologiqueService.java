package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.gestion.modele.FonctionnaliteTechnologique;
import com.vehicule.gestion.repository.FonctionnaliteTechnologiqueRepository;

import java.util.List;

@Service
public class FonctionnaliteTechnologiqueService {
    @Autowired
    private FonctionnaliteTechnologiqueRepository fonctionnaliteTechnologiqueRepository;

    public List<FonctionnaliteTechnologique> findAll() {
        return fonctionnaliteTechnologiqueRepository.findAll();
    }

    public List<FonctionnaliteTechnologique> findAllById(Iterable<String> id) {
        return fonctionnaliteTechnologiqueRepository.findAllById(id);
    }

    public List<FonctionnaliteTechnologique> findAllByNomFonctionnaliteTechnologique(String nom) {
        return fonctionnaliteTechnologiqueRepository.findAllByNomFonctionnaliteTechonologique(nom);
    }

    public FonctionnaliteTechnologique save(FonctionnaliteTechnologique c) {
        return fonctionnaliteTechnologiqueRepository.save(c);
    }

    public void delete(String id) {
        fonctionnaliteTechnologiqueRepository.deleteById(id);
    }
}
