package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.gestion.modele.Categorie;
import com.vehicule.gestion.repository.CategorieRepository;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    public List<Categorie> findAllById(String id) {
        return categorieRepository.findAllById(id);
    }

    public List<Categorie> findAllByNomCategorie(String nom) {
        return categorieRepository.findAllByNomCategorie(nom);
    }

    public Categorie save(Categorie c) {
        return categorieRepository.save(c);
    }

    public void delete(String id) {
        categorieRepository.deleteById(id);
    }


}
