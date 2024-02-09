package com.vehicule.gestion.tools;

public class MappingSousModeleUpdate {
    String id;
    String modele;
    String nom;
    float vitesse;
    float conso;
    String carbu; 
    boolean manuel;
    float moteur;
    float batterie;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getModele() {
        return modele;
    }
    public void setModele(String modele) {
        this.modele = modele;
    }
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public float getVitesse() {
        return vitesse;
    }
    public void setVitesse(float vitesse) {
        this.vitesse = vitesse;
    }
    
    public float getConso() {
        return conso;
    }
    public void setConso(float conso) {
        this.conso = conso;
    }
    
    public String getCarbu() {
        return carbu;
    }
    public void setCarbu(String carbu) {
        this.carbu = carbu;
    }
   
    public boolean isManuel() {
        return manuel;
    }
    public void setManuel(boolean manuel) {
        this.manuel = manuel;
    }
    
    public float getMoteur() {
        return moteur;
    }
    public void setMoteur(float moteur) {
        this.moteur = moteur;
    }
    
    public float getBatterie() {
        return batterie;
    }
    public void setBatterie(float batterie) {
        this.batterie = batterie;
    }
}
