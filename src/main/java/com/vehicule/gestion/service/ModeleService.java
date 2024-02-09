package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.gestion.modele.Modele;
import com.vehicule.gestion.repository.ModeleRepository;

import java.util.List;

@Service
public class ModeleService {    
    @Autowired
    private ModeleRepository modeleRepository;

    public List<Modele> findAll(){
        return modeleRepository.findAll();
    }

    public List<Modele> findAllById(Iterable<String> id){
        return modeleRepository.findAllById(id);
    }
    public List<Modele> findAllByNomModele(String nom){
        return modeleRepository.findAllByNomModele(nom);
    }

    public Modele save(Modele c){
        return modeleRepository.save(c);
    }

    public void update(String idmodele,String categorie,String marque,String nom){
         modeleRepository.update(categorie,marque,nom,idmodele);
    }
    
}
