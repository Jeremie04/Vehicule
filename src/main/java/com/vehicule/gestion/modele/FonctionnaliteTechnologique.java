package com.vehicule.gestion.modele;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fonctionnalitetechnologique")
public class FonctionnaliteTechnologique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfonctionnalitetechnologique")
    String idFonctionnaliteTechonologique;
    @Column(name = "nomfonctionnalitetechnologique")
    String nomFonctionnaliteTechonologique;

    public FonctionnaliteTechnologique() {
    }

    public FonctionnaliteTechnologique(String idFonctionnaliteTechonologique, String nomFonctionnaliteTechonologique)
            throws Exception {
        this.setIdFonctionnaliteTechonologique(idFonctionnaliteTechonologique);
        this.setNomFonctionnaliteTechonologique(nomFonctionnaliteTechonologique);
    }

    public FonctionnaliteTechnologique(String nomFonctionnaliteTechonologique) throws Exception {
        this.setNomFonctionnaliteTechonologique(nomFonctionnaliteTechonologique);
    }

    public String getNomFonctionnaliteTechonologique() {
        return nomFonctionnaliteTechonologique;
    }

    public void setNomFonctionnaliteTechonologique(String nomFonctionnaliteTechonologique) throws Exception {
        if (nomFonctionnaliteTechonologique.equals("") || nomFonctionnaliteTechonologique == null) {
            throw new Exception("Insérez le nom de la fonctionnalite technologique");
        }
        this.nomFonctionnaliteTechonologique = nomFonctionnaliteTechonologique;
    }

    public String getIdFonctionnaliteTechonologique() {
        return idFonctionnaliteTechonologique;
    }

    public void setIdFonctionnaliteTechonologique(String idFonctionnaliteTechonologique) {
        this.idFonctionnaliteTechonologique = idFonctionnaliteTechonologique;
    }

    public boolean isNomDuplicated(List<FonctionnaliteTechnologique> fonctionnaliteTechnologiques) {// lisye an'ilay
                                                                                                    // findAllByNomCategorie
        if (fonctionnaliteTechnologiques.size() > 0) {
            return true;
        }
        return false;
    }
}
