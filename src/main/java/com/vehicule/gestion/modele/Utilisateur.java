package com.vehicule.gestion.modele;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vehicule.gestion.tools.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Utilisateur implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idutilisateur")
    String id;
    @Column(name = "nom")
    String nomUtilisateur;
    String prenom;
    String adresse;
    String mail;
    @Column(name = "motdepasse")
    String motDePasse;
    int sexe;
    @Column(name = "datenaissance")
    Date dateNaissance;

    @Enumerated(EnumType.STRING)
    Role role;

    public Utilisateur(String nomUtilisateur, String prenom, String adresse, String mail, String motDePasse, int sexe,
            Date dateNaissance, Role role) throws Exception {
        this.nomUtilisateur = nomUtilisateur;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.motDePasse = motDePasse;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.role = role;
    }

    public Utilisateur() {
    }

    public Utilisateur(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Utilisateur [login=" + mail + ", motdepasse=" + motDePasse + "]";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return getMotDePasse();
    }

    @Override
    public String getUsername() {
        return getMail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) throws Exception {
        if (motDePasse.equals("") || motDePasse == null) {
            throw new Exception("Insertion mot de passe obligatoire");
        }
        this.motDePasse = motDePasse;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) throws Exception {
        if (mail.equals("") || mail == null) {
            throw new Exception("Insertion mail obligatoire");
        }
        this.mail = mail;
    }

    public void setAdresse(String adresse) throws Exception {
        if (adresse.equals("") || adresse == null) {
            throw new Exception("Insertion adresse obligatoire");
        }
        this.adresse = adresse;
    }

    public String getNom() {
        return nomUtilisateur;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws Exception {
        if (prenom.equals("") || prenom == null) {
            throw new Exception("Insertion prenom obligatoire");
        }
        this.prenom = prenom;
    }

    public void setNom(String nom) throws Exception {
        if (nom.equals("") || nom == null) {
            throw new Exception("Insertion nom obligatoire");
        }
        this.nomUtilisateur = nom;
    }

    public boolean isNomDuplacated(Optional<Utilisateur> modele) {
        if (modele.isEmpty()) {
            return true;
        }
        return false;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public void setSexe(String sexe) {
        this.setSexe(Integer.valueOf(sexe));
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.setDateNaissance(dateFormat.parse(dateNaissance));
    }

    public String getIdUtilisateur() {
        return id;
    }

    public void setIdUtilisateur(String id) {
        this.id = id;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

}
