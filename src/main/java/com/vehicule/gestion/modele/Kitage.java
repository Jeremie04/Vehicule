package com.vehicule.gestion.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Kitage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idKitage;
    @OneToOne
    @JoinColumn(name = "idAnnonce")
    Annonce annonce;
    String action;
    String valeur;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public String getIdKitage() {
        return idKitage;
    }

    public void setIdKitage(String idKitage) {
        this.idKitage = idKitage;
    }
}
