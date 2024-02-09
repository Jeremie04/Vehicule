
package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.gestion.modele.Modele;
import com.vehicule.gestion.modele.Test;
import com.vehicule.gestion.repository.ModeleRepository;
import com.vehicule.gestion.repository.Testrepository;

import java.util.List;

@Service
public class TestService {    
    @Autowired
    private Testrepository test;

    public List<Test> findOrderBy(){
        return test.findAllByOrderByDateAsc();
    }
}