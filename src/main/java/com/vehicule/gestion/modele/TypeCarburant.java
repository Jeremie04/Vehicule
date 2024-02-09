package com.vehicule.gestion.modele;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "typecarburant")
public class TypeCarburant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtypecarburant")
    String id;
    @Column(name = "nomtypecarburant")
    String nomTypeCarburant;

    public TypeCarburant() {
    }

    public TypeCarburant(String nomTypeCarburant) throws Exception {
        this.setNomTypeCarburant(nomTypeCarburant);
    }

    public TypeCarburant(String id, String nomTypeCarburant) throws Exception {
        this.setId(id);
        this.setNomTypeCarburant(nomTypeCarburant);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomTypeCarburant() {
        return this.nomTypeCarburant;
    }

    public void setNomTypeCarburant(String nomTypeCarburant) throws Exception {
        if (nomTypeCarburant == null || nomTypeCarburant.equals("")) {
            throw new Exception("Les Champs ne doivent pas etre vide(s).");
        }
        this.nomTypeCarburant = nomTypeCarburant;
    }

    public boolean controlExistanceTypeCarburantByName(List<TypeCarburant> typeExistant) throws Exception {
        for (TypeCarburant carburant : typeExistant) {
            if (carburant.getNomTypeCarburant().equalsIgnoreCase(this.getNomTypeCarburant())) {
                return true;
            }
        }
        return false;
    }

    public boolean controlExistanceTypeCarburantById(List<TypeCarburant> typeExistant) throws Exception {
        for (TypeCarburant carburant : typeExistant) {
            if (carburant.getId().equalsIgnoreCase(this.getId())) {
                return true;
            }
        }
        return false;
    }

}
