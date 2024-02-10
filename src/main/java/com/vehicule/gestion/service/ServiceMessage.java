package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.vehicule.gestion.modele.Message;
import com.vehicule.gestion.modele.Utilisateur;
// import com.vehicule.gestion.modele.Utilisateur;
import com.vehicule.gestion.repository.RepositoryMessage;

@Service
public class ServiceMessage {
    @Autowired
    private RepositoryMessage repositoryMessage;

    public List<Message> findAll() {
        return repositoryMessage.findAll();
    }

    public Message save(Message message) {
        return repositoryMessage.save(message);
    }

    public Optional<Message> findById(String id) {
        return repositoryMessage.findById(id);
    }

    public void deleteById(String id) {
        repositoryMessage.deleteById(id);
    }

    public List<Message> getMessages(Utilisateur i, Utilisateur j) {
        return repositoryMessage.findByUtilisateurs(i, j);
    }

}
