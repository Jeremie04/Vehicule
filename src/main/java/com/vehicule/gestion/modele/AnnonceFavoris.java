package com.vehicule.gestion.modele;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "annoncefavoris")
public class AnnonceFavoris {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idannonce")
    String idAnnonceFavoris;

    @ManyToOne
    @JoinColumn(name = "idutilisateur")
    Utilisateur utilisateur;

    @OneToOne
    @JoinColumn(name = "idannonce")
    Annonce annonce;

    int etat;

    @Column(name = "datefavoris")
    Date datefavoris;

    public AnnonceFavoris(Utilisateur utilisateur, Annonce annonce) {
        this.utilisateur = utilisateur;
        this.annonce = annonce;
        this.setEtat(0);
        this.setDatefavoris(Date.valueOf(LocalDate.now()));
    }

    public AnnonceFavoris() {
    }

    public String getIdAnnonceFavoris() {
        return idAnnonceFavoris;
    }

    public void setIdAnnonceFavoris(String idAnnonceFavoris) {
        this.idAnnonceFavoris = idAnnonceFavoris;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Date getDatefavoris() {
        return datefavoris;
    }

    public void setDatefavoris(Date datefavoris) {
        this.datefavoris = datefavoris;
    }

}
