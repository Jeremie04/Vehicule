package com.vehicule.gestion.modele;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name="Historiqueinteret")
public class HistoriqueInteret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idhistoriqueinteret;
    Date date;
    float taux;
    

    public HistoriqueInteret(Date date, float taux) {
        this.setDate(date);
        this.setTaux(taux);
    }

    public float getTaux() {
        return taux;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIdhistoriqueinteret() {
        return idhistoriqueinteret;
    }

    public void setIdhistoriqueinteret(String idhistoriqueinteret) {
        this.idhistoriqueinteret = idhistoriqueinteret;
    }
}
