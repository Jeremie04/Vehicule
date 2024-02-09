
package com.vehicule.gestion.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.vehicule.gestion.modele.MeilleurMarqueVendu;
import com.vehicule.gestion.repository.MeilleurMarqueVenduRepository;

@Service
public class MeilleurMarqueVenduService {
     @Autowired
    private MeilleurMarqueVenduRepository meilleurMarqueVenduRepository;

     public List<MeilleurMarqueVendu> findAllByMoisAndAnnee(int mois, int annee, int limite) {
        Pageable pageable = PageRequest.of(0, limite);
        return meilleurMarqueVenduRepository.findAllByMoisAndAnnee(mois, annee, pageable);
    }
}
