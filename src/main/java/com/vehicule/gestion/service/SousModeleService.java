package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.gestion.modele.SousModele;
import com.vehicule.gestion.repository.SousModeleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SousModeleService {
    @Autowired
    private SousModeleRepository sousService;

    public List<SousModele> findAll() {
        return sousService.findAll();
    }

    public Optional<SousModele> findById(String id) {
        return sousService.findById(id);
    }

    public List<SousModele> findAllByIdSousModele(String id) {
        return sousService.findAllByIdSousModele(id);
    }

    public List<SousModele> findAllByNomSous(String nom) {
        return sousService.findAllByNomSous(nom);
    }

    public SousModele save(SousModele c) {
        return sousService.save(c);
    }

    public void update(String id, String modele, String nom, float vitesse, float conso, String carbu, boolean manuel,
            float moteur, float batterie) {
        System.out.println("huhu");
        sousService.update(modele, modele, nom, vitesse, conso, carbu, manuel, moteur, batterie);
        System.out.println("huhu");
    }

}
