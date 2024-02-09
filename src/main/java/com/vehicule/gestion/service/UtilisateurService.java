package com.vehicule.gestion.service;

import java.util.List;
import java.util.Optional;

import com.vehicule.gestion.modele.Utilisateur;
import com.vehicule.gestion.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UtilisateurService {

  @Autowired
  private UtilisateurRepository utilisateurRepository;

  public Optional<Utilisateur> findByNameAndPassword(Utilisateur utilisateur) {
    Optional<Utilisateur> user = utilisateurRepository.findByMailAndMotDePasse(
        utilisateur.getMail(),
        utilisateur.getMotDePasse());
    System.out.println(user);
    if (user.isPresent()) {
      System.out.println(user.get());
    }
    return user;
  }

  public List<Utilisateur> getAll() {
    return utilisateurRepository.findAll();
  }

  @Transactional
  public Optional<Utilisateur> findByMail(String mail) {
    Optional<Utilisateur> user = utilisateurRepository.findByMail(mail);
    return user;
  }

  @Transactional
  public Optional<Utilisateur> findById(String id) {
    Optional<Utilisateur> user = utilisateurRepository.findById(id);
    return user;
  }

}
