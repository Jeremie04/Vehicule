package com.vehicule.gestion.modele;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ImageAnnonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idImageAnnonce;

    @ManyToOne //ilay betsaka no mandeha ao amin'ilay kely
    @JoinColumn(name = "idannonce")
    Annonce annonce;
    @ManyToOne
    @JoinColumn(name = "idsousmodele")
    SousModele sousModele;
    String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public SousModele getSousModele() {
        return sousModele;
    }

    public void setSousModele(SousModele sousModele) {
        this.sousModele = sousModele;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public String getIdImageAnnonce() {
        return idImageAnnonce;
    }

    public void setIdImageAnnonce(String idImageAnnonce) {
        this.idImageAnnonce = idImageAnnonce;
    }
}
