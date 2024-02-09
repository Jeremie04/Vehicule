create or replace view v_venteVoiture as
    select  v.idVente,v.dateVente,v.idVendeur,v.idMpividy,v.prix,a.couleur,
    a.prix as prixAnnonce,a.prixminimum,a.dateannonce,a.etat,
    sm.*,
    m.idmarque,m.idcategorie
    from Vente v
      join Annonce a on a.idAnnonce = v.idAnnonce
      join sousModele sm on sm.idSousModele = a.idSousModele
      join modele m on m.idModele = sm.idmodele;

create or replace view venteVoiture as
    select v.* , 
    extract(year from v.dateVente) as annee,
    extract(month from v.dateVente) as mois
      from v_venteVoiture v;

create or replace view v_meilleurVendeur as   
    select count(*) as nombre, idVendeur , mois , annee 
      from venteVoiture
        group by idVendeur , mois , annee ;

create or replace view v_meilleurMarqueVendu as   
    select count(*) as nombre , idMarque , mois , annee
    from venteVoiture
      group by idMarque , mois , annee;

create or replace view meilleurMarqueVendu as 
    select mmv.*,nomMarque from v_meilleurMarqueVendu mmv
        JOIN Marque m on m.idMarque=mmv.idMarque;

create or replace view meilleurVendeur as 
    select mv.*, u.nom from v_meilleurVendeur mv
        JOIN Utilisateur u on u.idUtilisateur=mv.idVendeur; 

create or replace view v_AnnonceFavoris as
  select AnnonceFavoris.*,
  Annonce.
  from AnnonceFavoris
  join Annonce on Annonce.idAnnonce = AnnonceFavoris.idAnnonce