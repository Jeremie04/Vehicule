package com.vehicule.gestion.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.vehicule.gestion.modele.MeilleurVendeur;
import com.vehicule.gestion.repository.MeilleurVendeurRepository;

@Service
public class MeilleurVendeurService {
     @Autowired
    private MeilleurVendeurRepository meilleurVendeurRepository;

     public List<MeilleurVendeur> findAllByMoisAndAnnee(int mois, int annee, int limite) {
        Pageable pageable = PageRequest.of(0, limite);
        return meilleurVendeurRepository.findAllByMoisAndAnnee(mois, annee, pageable);
    }
}
