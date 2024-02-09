package com.vehicule.gestion.modele;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pays")
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpays")
    String id;
    @Column(name = "nompays")
    String nomPays;

    public Pays() {
    }

    public Pays(String nomPays) throws Exception {
        this.setNomPays(nomPays);
    }

    public String getId() {
        return id;
    }

    public void setId(String idPays) {
        this.id = idPays;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) throws Exception {
        if (nomPays.equals(null)) {
            throw new Exception("Le Champ nom est vide");
        }
        this.nomPays = nomPays;
    }
}
