package com.vehicule.gestion.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.vehicule.gestion.modele.Message;
import com.vehicule.gestion.modele.Utilisateur;

@Repository
public interface RepositoryMessage extends MongoRepository<Message, String> {

    @Query("{ $or: [ " +
            "{ $and: [ { 'idUtilisateurEnvoyeur': ?0 }, { 'idUtilisateurReceveur': ?1 } ] }, " +
            "{ $and: [ { 'idUtilisateurEnvoyeur': ?1 }, { 'idUtilisateurReceveur': ?0 } ] } ] }" +
            "sort:{dateMessage:1}")
    List<Message> findByUtilisateurs(Utilisateur idUtilisateurEnvoyeur, Utilisateur idUtilisateurDestinataire);
}
