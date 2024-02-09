package com.vehicule.gestion.modele;


public class MappingRecherche {
    String marque;
    String modele;
    String categorie;
    String dateMin;
    String dateMax;
    String prixMin;
    String prixMax;

    public String getPrixMin() {
        return prixMin;
    }public String getPrixMax() {
    return prixMax;
}
public void setPrixMax(String prixMax) {
    this.prixMax = prixMax;
}

    public void setPrixMin(String prixMin) {
        this.prixMin = prixMin;
    }
    public String getDateMin() {
        return dateMin;
    }
public String getDateMax() {
    return dateMax;
}

public void setDateMax(String dateMax) {
    this.dateMax = dateMax;
}


    public void setDateMin(String dateMin) {
        this.dateMin = dateMin;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
}
