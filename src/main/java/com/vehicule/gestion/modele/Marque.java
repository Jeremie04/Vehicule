package com.vehicule.gestion.modele;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;

import lombok.Data;

@Entity
@Data
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmarque")
    String id;
    @Column(name = "nommarque")
    String nom_Marque;
    @ManyToOne
    @JoinColumn(name = "pays")
    Pays pays;
    int etat;

    public void setEtat(int e){
        this.etat=e;
    }

    public int getEtat(){
        return this.etat;
    }
    public Marque() {
    }

    public Marque(String nom_Marque) throws Exception {
        this.setNomMarque(nom_Marque);
    }

    public Marque(String nom_Marque, Pays pays) throws Exception {
        this.setNomMarque(nom_Marque);
        this.setPays(pays);
    }

    public String getId_Marque() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomMarque() {
        return this.nom_Marque;
    }

    public void setNomMarque(String nom_Marque) throws Exception {
        if (nom_Marque == null || nom_Marque.equals("")) {
            throw new Exception("Les Champs ne doivent pas etre vide(s).");
        }
        this.nom_Marque = nom_Marque;
    }

    public Pays getPays() {
        return this.pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

}
