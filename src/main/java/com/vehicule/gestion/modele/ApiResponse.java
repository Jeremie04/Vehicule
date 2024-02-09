package com.vehicule.gestion.modele;

public class ApiResponse {
    private String erreur;
    private Object data;

    // Constructeur pour une réponse réussie
    public ApiResponse(String erreur, Object data) {
        this.erreur = erreur;
        this.data = data;
    }

    public String getErreur() {
        return erreur;
    }

    public void setErreur(String erreur) {
        this.erreur = erreur;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
