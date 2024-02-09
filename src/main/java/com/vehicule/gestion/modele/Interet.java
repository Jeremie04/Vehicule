package com.vehicule.gestion.modele;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Interet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idInteret;
    float Taux;
    Date date;
    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTaux() {
        return Taux;
    }

    public void setTaux(float Taux) {
        this.Taux = Taux;
    }

    public String getIdInteret() {
        return idInteret;
    }

    public void setIdInteret(String idInteret) {
        this.idInteret = idInteret;
    }
}
