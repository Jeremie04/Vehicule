package com.vehicule.gestion.modele;

public class DetailAnnonce {
    SousModele sousModele;
    Kitage kitage;

    public void setKitage(Kitage kitage) {
        this.kitage = kitage;
    }

    public Kitage getKitage() {
        return kitage;
    }

    public SousModele getSousModele() {
        return sousModele;
    }

    public void setSousModele(SousModele sousModele) {
        this.sousModele = sousModele;
    }

    
}
