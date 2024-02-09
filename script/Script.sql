--  --------------------------------------BACK OFFICE-----------------------------------------------------------

create sequence seqPays;
create table Pays(
    idPays varchar(20) default concat('PAY' || nextval('seqPays')) primary key,
    nomPays varchar(50)
);

-- Marque (idmarque, nomMarque, Pays)
create sequence seqMarque;
create table Marque (
    idMarque varchar(20) default concat('MAR' || nextval('seqMarque')) primary key,
    nomMarque varchar(30) unique,
    Pays varchar(20) references Pays(idPays)
);

-- Categorie (idcategorie, nomCategorie)
create sequence seqCategorie;
create table Categorie(
    idCategorie varchar(20) default concat('CAT' || nextval('seqCAtegorie')) primary key,
    nomCategorie varchar(50) unique
);

-- TypeCarburant (idTypeCarburant, nomTypeCarburant)
create sequence seqTypeCarburant;
create table TypeCarburant(
    idTypeCarburant varchar(20) default concat('TYCAR' || nextval('seqTypeCarburant')) primary key,
    nomTypeCarburant varchar(50) unique
);

-- FonctionnaliteTechnologique (idFonctionnaliteTechnologique, nomFonctionnaliteTechnologique)
create sequence seqFonctionnalite;
create table FonctionnaliteTechnologique(
    idFonctionnaliteTechnologique varchar(20) default concat('TECH' || nextval('seqFonctionnalite')) primary key,
    nomFonctionnaliteTechnologique varchar(50) unique
);

-- Modele (idModele, nomModele, idMarque [Marque] , idCategorie [Categorie])
create sequence seqModele;
create table Modele(
    idModele varchar(20) default concat('MOD' || nextval('seqModele')) primary key,
    idMarque varchar(20) references Marque(idMarque),
    idCategorie varchar(20) references Categorie(idCategorie)
);

-- SousModele (idSousModele, nomSousModele, VitesseMax, Consommation, IdTypeCarburant [TypeCarburant], Automatique (Boolean), PuissanceMoteur, Batterie, Compte (Serial) )
create sequence seqSousModele;
create table SousModele(
    idSousModele varchar(20) default concat('SMOD' || nextval('seqSousModele')) primary key,
    nomSousModele varchar(50),
    vitesseMax float,
    Consommation float,
    idTypeCarburant varchar(20) references TypeCarburant(idTypeCarburant),
    automatique Boolean,
    puissanceMoteur float,
    Batterie float,
    compte serial
);

-- ImageSousModele (idImageSousModele, isSousModele [SousModele], nomImage ) 
create sequence seqImageSousModele;
create table ImageSousModele(
    idImageSousModele varchar(20) default concat('ISMOD' || nextval('seqImageSousModele')) primary key,
    idSousModele varchar(20) references SousModele(idSousModele),
    nomImage varchar(100)
);

-- FonctionnaliteTechnologiqueSousModele (idFonctionnaliteTechnologiqueSousModele, idSousModele [sousModele], idFocntionnaliteTechnologique [Fonctionnalitetechnologique])
create sequence seqFonctionnaliteSousModele;
create table FonctionnaliteTechnologiqueSousModele(
    idFonctionnaliteTechnologiqueSousModele varchar(20) default concat('TECHSMOD' || nextval('seqFonctionnaliteSousModele')) primary key,
    idSousModele varchar(20) references SousModele(idSousModele),
    idFonctionnaliteTechnologique varchar(20) references FonctionnaliteTechnologique(idFonctionnaliteTechnologique)
);

-- Interet (idInteret, taux)
create sequence seqInteret;
create table Interet(
    idInteret varchar(20) default concat('INT' || nextval('seqInteret')) primary key,
    taux float
);

--  --------------------------------------FRONT OFFICE-----------------------------------------------------------

-- Utilisateur (idUtilisateur, nom, prenom, mail, motdepasse, adresse)
create sequence seqUtilisateur;
create table Utilisateur(
    idUtilisateur varchar(20) default concat('UTI' || nextval('seqUtilisateur')) primary key,
    nom varchar(30),
    prenom varchar(30),
    mail varchar(60),
    motdepasse varchar(50),
    adresse varchar(30)
);

-- Annonce (idAnnonce, idUtilisateur [Utilisateur], idSousModele [SousModele], Couleur, prix, prixMinimum, DateAnnonce (timestamp), estvendue(Boolean) ) 
create sequence seqAnnonce;
create table Annonce(
    idAnnonce varchar(20) default concat('ANN' || nextval('seqAnnonce')) primary key,
    idUtilisateur varchar(20) references Utilisateur(idUtilisateur),
    idSousModele varchar(20) references SousModele(idSousModele),
    Couleur varchar(20),
    prix float,
    prixMinimum float,
    DateAnnonce timestamp,
    estVendue Boolean
);

-- ImageAnnonce(idImageAnnonce, idAnnonce [Annonce], nomimage)
create sequence seqImageAnnonce;
create table ImageAnnonce(
    idImageAnnonce varchar(20) default concat('IMGA' || nextval('seqImageAnnonce')) primary key,
    idAnnonce varchar(20) references Annonce(idAnnonce),
    nomImage varchar(50)
);

-- Mail (idMail, idUtilisateurEnvoyeur,  idUtilisateurReceveur)
-- create sequence seqMail;
-- create table Mail(
--     idMail varchar(20) default concat('MAIL' || nextval('seqMail')) primary key,
--     idUtilisateurEnvoyeur varchar(20) references Utilisateur(idUtilisateur),
--     idUtilisateurReceveur varchar(20) references Utilisateur(idUtilisateur)
-- );

-- Message (idMessage, idMail [Mail], message, estVue(Boolean) )
-- BASE NOSQL (tsy maninona na tsy ampidirina any anaty base ary fa tonga dia ampidiriny ho azy ilay document)
create sequence seqMessage;
create table Message(
    idMessage varchar(20) primary key,
    dateMessage timestamp,
    idUtilisateurEnvoyeur varchar(20) references Utilisateur(idUtilisateur),
    idUtilisateurReceveur varchar(20) references Utilisateur(idUtilisateur),
    message varchar(100),
    listePieceJointe
);

-- ImagePJMail(idImagePJMail, idMessage [Message], nomfichier)
-- create sequence seqImagePJMail;
-- create table ImagePJMail(
--     idImagePJMail varchar(20) default concat('IMGMAIL' || nextval('seqImagePJMAil')) primary key,
--     idMessage varchar(20) references Message(idMessage),
--     nomfichier varchar(50)
-- );

-- Caracteristique(idcaracteristique, nomCaracteristique)
create sequence seqCaracteristique;
create table Caracteristique(
    idCaracteristique varchar(20) default concat('CAR' || nextval('seqCaracteristique')) primary key,
    nomCaracteristique varchar(50)
);

-- Kitage (idKitage,  idAnnonce [Annonce], Action (batterie?Puissance?...?), valeur, compte(serial) )
create sequence seqKitage;
create table Kitage(
    idKitage varchar(20) default concat('KIT' || nextval('seqKitage')) primary key,
    idAnnonce varchar(20) references Annonce(idAnnonce),
    idCaracteristique varchar(20) references Caracteristique(idCaracteristique),
    valeur float,
    compte serial
);


------------------------------------09-02-24--------------------------------------
-- alter table marque add etat int;
-- alter table Categorie add etat int;
-- alter table modele add etat