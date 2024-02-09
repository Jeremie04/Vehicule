
package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.gestion.modele.Kitage;
import com.vehicule.gestion.repository.KitageRepository;

import java.util.List;

@Service
public class KitageService {    
    @Autowired
    private KitageRepository kitageRepository;

    public List<Kitage> findAll(){
        return kitageRepository.findAll();
    }

    public List<Kitage> findAllById(String id){
        return kitageRepository.findAllByIdKitage(id);
    }

    //public List<Kitage> findAllByIdAnnonce(String idAnnonce){
      //  return kitageRepository.findAllByIdAnnonce(idAnnonce);
    //}

    public Kitage save(Kitage c){
        return kitageRepository.save(c);
    }
    
}
