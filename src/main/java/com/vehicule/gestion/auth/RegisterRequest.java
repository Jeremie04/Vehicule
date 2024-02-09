package com.vehicule.gestion.auth;

import java.sql.Date;

import com.vehicule.gestion.tools.Role;

public class RegisterRequest {
  private String nom;
  private String prenom;
  private String dateNaissance; 
  private String sexe;
  private String login;
  private String motDePasse;
  private String role;
  private String adresse;

  public String getAdresse() {
    return adresse;
}

public void setAdresse(String adresse) {
    this.adresse = adresse;
}

public String getSexe() {
    return sexe;
  }

  public void setSexe(String sexe) {
    this.sexe = sexe;
  }
  public String getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(String dateNaissace) {
    this.dateNaissance = dateNaissace;
  }
 public String getPrenom() {
    return prenom;
  }

public void setPrenom(String prenom) {
    this.prenom = prenom;
}
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getRole(){return  role;}

  public void setRole(String role){this.role = role;}

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getMotDePasse() {
    return motDePasse;
  }

  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }
}
