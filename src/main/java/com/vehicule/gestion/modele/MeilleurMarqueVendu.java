package com.vehicule.gestion.modele;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="meilleurmarquevendu")
public class MeilleurMarqueVendu {
    @Id
    @Column(name="idmarque")
    String idMarque;
    @Column(name="nommarque")
    String nomMarque;
    int mois;
    int nombre;
    int annee;

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

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public String getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(String idMarque) {
        this.idMarque = idMarque;
    }
}
