package com.vehicule.gestion.modele;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="meilleurvendeur")
public class MeilleurVendeur {
   @Id
   @Column(name="idvendeur")
   String idVendeur;
    @Column(name="nom")
    String nomVendeur;
    int annee;
    int mois;
    int nombre;

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

public int getMois() {
    return mois;
}

public void setMois(int mois) {
    this.mois = mois;
}

public int getAnnee() {
    return annee;
}

public void setAnnee(int annee) {
    this.annee = annee;
}

public String getNomVendeur() {
        return nomVendeur;
    }

    public void setNomVendeur(String nomVendeur) {
        this.nomVendeur = nomVendeur;
    }

public String getIdVendeur() {
    return idVendeur;
}

public void setIdVendeur(String idVendeur) {
    this.idVendeur = idVendeur;
}
}
