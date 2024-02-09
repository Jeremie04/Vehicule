package com.vehicule.gestion.modele;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmodele")
    String id;

    @ManyToOne
    @JoinColumn(name = "idmarque")
    Marque marque;
    @Column(name="nommodele")
    String nomModele;

    @ManyToOne
    @JoinColumn(name = "idcategorie")
    Categorie categorie;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getNomModele() {
        return nomModele;
    }

    public void setNomModele(String nomModele) throws Exception{
        if (nomModele.equals("") || nomModele == null) {
            throw new Exception("Inserez dabord le nom du modele");
        }
        this.nomModele = nomModele;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isNomDeplacated(List<Modele> modele){
        if(modele.size()>0){
             return true;
        }
        return false;
    }
}
