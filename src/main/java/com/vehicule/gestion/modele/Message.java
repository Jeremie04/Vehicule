package com.vehicule.gestion.modele;

import java.util.Date;
// import java.sql.Date;
// import java.text.SimpleDateFormat;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "message")
public class Message {
    @Id
    String idMessage;
    Date dateMessage;
    Utilisateur idUtilisateurEnvoyeur;
    Utilisateur idUtilisateurReceveur;
    String message;
    List<String> liensImages;

    public Message() {
    }

    public Message(Date dateMessage, Utilisateur idUtilisateurEnvoyeur, Utilisateur idUtilisateurReceveur,
            String message, List<String> liensImages) throws Exception {
        this.setDateMessage(dateMessage);
        this.idUtilisateurEnvoyeur = idUtilisateurEnvoyeur;
        this.idUtilisateurReceveur = idUtilisateurReceveur;
        this.message = message;
        this.liensImages = liensImages;
    }

    public String getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(String idMessage) {
        this.idMessage = idMessage;
    }

    public Date getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(Date dateMessage) throws Exception {
        // DateTimeFormatter formatter =
        // DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        // String pattern = "yyyy-MM-dd HH:mm:ss";
        // SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        // Date date = sdf.parse(dateMessage);
        this.dateMessage = dateMessage;
    }

    public Utilisateur getIdUtilisateurEnvoyeur() {
        return idUtilisateurEnvoyeur;
    }

    public void setIdUtilisateurEnvoyeur(Utilisateur idUtilisateurEnvoyeur) {
        this.idUtilisateurEnvoyeur = idUtilisateurEnvoyeur;
    }

    public Utilisateur getIdUtilisateurReceveur() {
        return idUtilisateurReceveur;
    }

    public void setIdUtilisateurReceveur(Utilisateur idUtilisateurReceveur) {
        this.idUtilisateurReceveur = idUtilisateurReceveur;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getLiensImages() {
        return liensImages;
    }

    public void setLiensImages(List<String> liensImages) {
        this.liensImages = liensImages;
    }

    public void controlExistanceUtilisateurReceveur(List<Utilisateur> utilisateurExistant, Utilisateur user)
            throws Exception {
        boolean existant = false;
        for (Utilisateur utilisateur : utilisateurExistant) {
            if (utilisateur.getIdUtilisateur()
                    .equalsIgnoreCase(user.getIdUtilisateur())) {
                existant = true;
            }
        }
        if (existant == false) {
            throw new Exception("Utilisateur Receveur non Existant.");
        }
    }

    public void controlExistanceUtilisateurEnvoyeur(List<Utilisateur> utilisateurExistant, Utilisateur user)
            throws Exception {
        boolean existant = false;
        for (Utilisateur utilisateur : utilisateurExistant) {
            if (utilisateur.getIdUtilisateur().equalsIgnoreCase(user.getIdUtilisateur())) {
                existant = true;
            }
        }
        if (existant == false) {
            throw new Exception("Utilisateur Envoyer non Existant.");
        }

    }

}
