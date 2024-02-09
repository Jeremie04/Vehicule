package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.gestion.modele.HistoriqueInteret;
import com.vehicule.gestion.repository.HistoriqueInteretRepository;
import com.vehicule.gestion.repository.InteretRepository;

    
@Service
public class HistoriqueInteretService {
    @Autowired
    HistoriqueInteretRepository historiqueInteretRepository;

    public HistoriqueInteret save(HistoriqueInteret histo){
        return historiqueInteretRepository.save(histo);
    }
}
