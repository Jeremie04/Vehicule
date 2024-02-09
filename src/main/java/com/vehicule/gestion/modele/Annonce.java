package com.vehicule.gestion.modele;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity(name = "annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idannonce")
    String idAnnonce;

    @ManyToOne
    @JoinColumn(name = "idutilisateur")
    Utilisateur utilisateur;

    @OneToOne
    @JoinColumn(name = "idsousmodele")
    SousModele sousModele;
    String couleur;
    float prix;
    @Column(name="prixminimum")
    float prixMinimum;
    @Column(name="dateannonce")
    Timestamp dateAnnonce;
    int etat;

    public int getEtat() {
        return etat;
    }

  

 public void setEtat(int etat) {
        this.etat = etat;
    }

    public Timestamp getDateAnnonce() {
        return dateAnnonce;
    }

    public void setDateAnnonce(Timestamp dateAnnonce) {
        this.dateAnnonce = dateAnnonce;
        if(dateAnnonce==null){
            dateAnnonce=Timestamp.valueOf(LocalDateTime.now());
        }
    }

    public float getPrixMinimum() {
        return prixMinimum;
    }

    public void setPrixMinimum(float prixMinimum) throws Exception{
        if(prixMinimum<=0){
            throw new Exception("Prix minimum non valide");
        }
        this.prixMinimum = prixMinimum;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) throws Exception{
        if(prix<=0){
            throw new Exception("Prix  non valide");
        }
        this.prix = prix;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        
        this.couleur = couleur;
    }

    public SousModele getSousModele() {
        return sousModele;
    }

    public void setSousModele(SousModele sousModele) {
        this.sousModele = sousModele;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(String idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

     public static Specification<Annonce> rechercheAvancee(String marque, String modele, String categorie, String dateMin, String dateMax, String prixMin, String prixMax) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Join<Annonce, SousModele> sousModeleJoin = root.join("sousModele");
            Join<SousModele, Modele> modeleJoin = sousModeleJoin.join("modele");
            Join<Modele, Marque> marqueJoin = modeleJoin.join("marque");
            Join<Modele,Categorie> categorieJoin=modeleJoin.join("categorie");

            if (marque != null ) {
                predicates.add(criteriaBuilder.equal(marqueJoin.get("id"), marque));
            }

            if (modele != null ) {
                predicates.add(criteriaBuilder.equal(modeleJoin.get("id"), modele));
            }

            if (categorie != null) {
                predicates.add(criteriaBuilder.equal(categorieJoin.get("id"), categorie));
            }

            //if (!dateMin.isEmpty() && !dateMax.isEmpty()) {
            if (dateMin != null && dateMax != null) {
                System.out.println(dateMin);
                System.out.println(dateMax);

                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dateAnnonce"), Timestamp.valueOf(dateMin)));
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dateAnnonce"), Timestamp.valueOf(dateMax)));
            }

            if (prixMin != null  && prixMax != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("prix"), prixMin));
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("prix"), prixMax));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
    // public boolean isNomDuplacated(List<SousModele> modele){
    //     if(modele.size()>0){
    //          return true;
    //     }
    // }
}
