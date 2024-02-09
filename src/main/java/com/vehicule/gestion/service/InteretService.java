package com.vehicule.gestion.service;
import org.springframework.stereotype.Service;

import com.vehicule.gestion.modele.Interet;
import com.vehicule.gestion.repository.InteretRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class InteretService {
    @Autowired
    InteretRepository interetRepository;

    public void updateInteret(Date date,float taux){
        if(date==null){
            date=Date.valueOf(LocalDate.now());
        }
        interetRepository.updateDateTauxInteret(date, taux);
    }

    public Interet save(Interet interet){
        return interetRepository.save(interet);
    }

    public List<Interet> findAll(){
        return interetRepository.findAll();
    }
}
