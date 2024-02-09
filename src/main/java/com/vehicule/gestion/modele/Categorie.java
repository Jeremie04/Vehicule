package com.vehicule.gestion.modele;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategorie")
    String id;
    @Column(name = "nomcategorie")
    String nomCategorie;

    public Categorie() {
    }

    public Categorie(String idCategorie, String nomCategorie) throws Exception {
        this.setNomCategorie(nomCategorie);
        this.setId(idCategorie);
    }

    public Categorie(String nomCategorie) throws Exception {
        this.setNomCategorie(nomCategorie);
        this.setId(id);
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) throws Exception {
        if (nomCategorie.equals("") || nomCategorie == null) {
            throw new Exception("Insérer d abord le nom de la categorie");
        }
        this.nomCategorie = nomCategorie;
    }

    public String getId() {
        return id;
    }

    public void setId(String idCategorie) {
        this.id = idCategorie;
    }

    public boolean isNomDuplicated(List<Categorie> categorie) {// lisye an'ilay findAllByNomCategorie
        if (categorie.size() > 0) {
            return true;
        }
        return false;
    }
}
