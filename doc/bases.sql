-- ----------------------------------------------------------------------------- -- Génération d'une base de données pour -- Oracle Version 9.xx -- (2/3/2012 10:54:38) -- ----------------------------------------------------------------------------- -- Nom de la base : MLR1 -- Projet : Espace de travail -- Date de dernière modification : 2/3/2012 10:54:21 -- -----------------------------------------------------------------------------
DROP TABLE ANNEEETUDE CASCADE CONSTRAINTS;
DROP TABLE SEMESTRE CASCADE CONSTRAINTS;
DROP TABLE UE CASCADE CONSTRAINTS;
DROP TABLE MATIERE CASCADE CONSTRAINTS;
DROP TABLE GROUPE CASCADE CONSTRAINTS;
DROP TABLE CRENAUX CASCADE CONSTRAINTS;
DROP TABLE ENSEIGNEMENT CASCADE CONSTRAINTS;
DROP TABLE CARACTERISTIQUE CASCADE CONSTRAINTS;
DROP TABLE BATIMENT CASCADE CONSTRAINTS;
DROP TABLE RESERVATION CASCADE CONSTRAINTS;
DROP TABLE SALLE CASCADE CONSTRAINTS;
DROP TABLE TYPECOURS CASCADE CONSTRAINTS;
DROP TABLE ENSEIGNANT CASCADE CONSTRAINTS;
DROP TABLE COURS CASCADE CONSTRAINTS;
DROP TABLE CARACTERISTIQUE_SALLE CASCADE CONSTRAINTS;
DROP TABLE RESERVATION_CARACTERISTIQUE CASCADE CONSTRAINTS;
-- ----------------------------------------------------------------------------- -- CREATION DE LA BASE -- -----------------------------------------------------------------------------
--CREATE DATABASE MLR1;
      -- ----------------------------------------------------------------------------- -- TABLE : ANNEEETUDE -- -----------------------------------------------------------------------------
CREATE TABLE ANNEEETUDE
  (
   ID_ANNEEETUDE NUMBER(10)  NOT NULL,
   DESCRIPTION_ANNEEETUDE VARCHAR(50)  NULL,
   LIBELLE_ANNEEETUDE VARCHAR2(5)  NULL,
   DUREESEANCE_ANNEEETUDE FLOAT(5) NULL,
   NBSEANCEAM_ANNEEETUDE NUMBER(2) NULL,
   NBSEANCEPM_ANNEEETUDE NUMBER(2) NULL
, CONSTRAINT PK_ANNEEETUDE PRIMARY KEY (ID_ANNEEETUDE)
  ) ;
   -- ----------------------------------------------------------------------------- -- TABLE : SEMESTRE -- -----------------------------------------------------------------------------
CREATE TABLE SEMESTRE
  (
   ID_SEMESTRE NUMBER(10)  NOT NULL,
   LIBELLE_SEMESTRE VARCHAR2(30)  NULL,
   NIVEAU_SEMESTRE NUMBER(2)  NULL,
   ID_ANNEEETUDE NUMBER(10) NULL
, CONSTRAINT PK_SEMESTRE PRIMARY KEY (ID_SEMESTRE)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE SEMESTRE -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_SEMESTRE_ANNEEETUDE
    ON SEMESTRE (ID_ANNEEETUDE ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : UE -- -----------------------------------------------------------------------------
CREATE TABLE UE
  (
   ID_UE NUMBER(10)  NOT NULL,
   LIBELLE_UE CHAR(255)  NULL,
   ID_ENSEIGNANT NUMBER(10)  NULL,
--   ID_SEMESTRE NUMBER(10) NULL
, CONSTRAINT PK_UE PRIMARY KEY (ID_UE)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE UE -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_UE_ENSEIGNANT
    ON UE (ID_ENSEIGNANT ASC)
   ;
   CREATE INDEX I_FK_UE_SEMESTRE
    ON UE (ID_SEMESTRE ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : MATIERE -- -----------------------------------------------------------------------------
CREATE TABLE MATIERE
  (
   ID_MATIERE NUMBER(10)  NOT NULL,
   ID_UE NUMBER(10)  NULL,
   ID_ENSEIGNANT NUMBER(10)  NULL,
   LIBELLE_MATIERE CHAR(255)  NULL
, CONSTRAINT PK_MATIERE PRIMARY KEY (ID_MATIERE)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE MATIERE -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_MATIERE_UE
    ON MATIERE (ID_UE ASC)
   ;
CREATE INDEX I_FK_MATIERE_ENSEIGNANT
    ON MATIERE (ID_ENSEIGNANT ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : GROUPE -- -----------------------------------------------------------------------------
CREATE TABLE GROUPE
  (
   ID_GROUPE NUMBER(10)  NOT NULL,
   ID_GROUPE_A_POUR_PERE NUMBER(10)  NULL,
   LIBELLE_GROUPE CHAR(255)  NULL
, CONSTRAINT PK_GROUPE PRIMARY KEY (ID_GROUPE)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE GROUPE -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_GROUPE_GROUPE
    ON GROUPE (ID_GROUPE_A_POUR_PERE ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : CRENAUX -- -----------------------------------------------------------------------------
CREATE TABLE CRENAUX
  (
   ID_CRENEAU NUMBER(10)  NOT NULL,
   HEURE_DEBUT CHAR(255)  NULL,
   HEURE_FIN CHAR(255)  NULL
, CONSTRAINT PK_CRENAUX PRIMARY KEY (ID_CRENEAU)
  ) ;
-- ----------------------------------------------------------------------------- -- TABLE : ENSEIGNEMENT -- -----------------------------------------------------------------------------
CREATE TABLE ENSEIGNEMENT
  (
   ID_ENSEIGNEMENT NUMBER(10)  NOT NULL,
   ID_COURS NUMBER(10)  NULL,
   ID_ENSEIGNANT NUMBER(10)  NULL,
   ID_GROUPE NUMBER(10)  NULL,
   NB_HEURE_PREVUE NUMBER(4)  NULL
, CONSTRAINT PK_ENSEIGNEMENT PRIMARY KEY (ID_ENSEIGNEMENT)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE ENSEIGNEMENT -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_ENSEIGNEMENT_COURS
    ON ENSEIGNEMENT (ID_COURS ASC)
   ;
CREATE INDEX I_FK_ENSEIGNEMENT_ENSEIGNANT
    ON ENSEIGNEMENT (ID_ENSEIGNANT ASC)
   ;
CREATE INDEX I_FK_ENSEIGNEMENT_GROUPE
    ON ENSEIGNEMENT (ID_GROUPE ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : CARACTERISTIQUE -- -----------------------------------------------------------------------------
CREATE TABLE CARACTERISTIQUE
  (
   ID_CARACTERISTIQUE NUMBER(10)  NOT NULL,
   LIBELLE_CARACTERISTIQUE CHAR(255)  NULL
, CONSTRAINT PK_CARACTERISTIQUE PRIMARY KEY (ID_CARACTERISTIQUE)
  ) ;
-- ----------------------------------------------------------------------------- -- TABLE : BATIMENT -- -----------------------------------------------------------------------------
CREATE TABLE BATIMENT
  (
   ID_BATIMENT NUMBER(10)  NOT NULL,
   LIBELLE_BATIMENT CHAR(255)  NULL
, CONSTRAINT PK_BATIMENT PRIMARY KEY (ID_BATIMENT)
  ) ;
-- ----------------------------------------------------------------------------- -- TABLE : RESERVATION -- -----------------------------------------------------------------------------
CREATE TABLE RESERVATION
  (
   ID_RESERVATION NUMBER(10)  NOT NULL,
   ID_SALLE NUMBER(10)  NULL,
   ID_CRENEAU NUMBER(10)  NULL,
   ID_ENSEIGNEMENT NUMBER(10)  NULL,
   DATE_RESERVATION DATE  NULL
, CONSTRAINT PK_RESERVATION PRIMARY KEY (ID_RESERVATION)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE RESERVATION -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_RESERVATION_SALLE
    ON RESERVATION (ID_SALLE ASC)
   ;
CREATE INDEX I_FK_RESERVATION_CRENAUX
    ON RESERVATION (ID_CRENEAU ASC)
   ;
CREATE INDEX I_FK_RESERVATION_ENSEIGNEMENT
    ON RESERVATION (ID_ENSEIGNEMENT ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : SALLE -- -----------------------------------------------------------------------------
CREATE TABLE SALLE
  (
   ID_SALLE NUMBER(10)  NOT NULL,
   ID_BATIMENT NUMBER(10)  NULL,
   NUMERO_SALLE CHAR(255)  NULL
, CONSTRAINT PK_SALLE PRIMARY KEY (ID_SALLE)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE SALLE -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_SALLE_BATIMENT
    ON SALLE (ID_BATIMENT ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : TYPECOURS -- -----------------------------------------------------------------------------
CREATE TABLE TYPECOURS
  (
   ID_TYPE_DE_COURS NUMBER(10)  NOT NULL,
   LIBELLE_TYPE_DE_COURS CHAR(255)  NULL
, CONSTRAINT PK_TYPECOURS PRIMARY KEY (ID_TYPE_DE_COURS)
  ) ;
-- ----------------------------------------------------------------------------- -- TABLE : ENSEIGNANT -- -----------------------------------------------------------------------------
CREATE TABLE ENSEIGNANT
  (
   ID_ENSEIGNANT NUMBER(10)  NOT NULL,
   NOM CHAR(255)  NULL,
   PRENOM CHAR(255)  NULL,
   MDP CHAR(255)  NULL,
   SUPER_USER NUMBER(1)  NULL
, CONSTRAINT PK_ENSEIGNANT PRIMARY KEY (ID_ENSEIGNANT)
  ) ;
-- ----------------------------------------------------------------------------- -- TABLE : COURS -- -----------------------------------------------------------------------------
CREATE TABLE COURS
  (
   ID_COURS NUMBER(10)  NOT NULL,
   ID_MATIERE NUMBER(10)  NULL,
   ID_TYPE_DE_COURS NUMBER(10)  NULL,
   LIBELLE_COURS CHAR(255)  NULL
, CONSTRAINT PK_COURS PRIMARY KEY (ID_COURS)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE COURS -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_COURS_MATIERE
    ON COURS (ID_MATIERE ASC)
   ;
CREATE INDEX I_FK_COURS_TYPECOURS
    ON COURS (ID_TYPE_DE_COURS ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : CARACTERISTIQUE_SALLE -- -----------------------------------------------------------------------------
CREATE TABLE CARACTERISTIQUE_SALLE
  (
   ID_SALLE NUMBER(10)  NOT NULL,
   ID_CARACTERISTIQUE NUMBER(10)  NOT NULL
, CONSTRAINT PK_CARACTERISTIQUE_SALLE PRIMARY KEY (ID_SALLE, ID_CARACTERISTIQUE)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE CARACTERISTIQUE_SALLE -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_CARACTERISTIQUE_SALLE_SAL
    ON CARACTERISTIQUE_SALLE (ID_SALLE ASC)
   ;
CREATE INDEX I_FK_CARACTERISTIQUE_SALLE_CAR
    ON CARACTERISTIQUE_SALLE (ID_CARACTERISTIQUE ASC)
   ;
-- ----------------------------------------------------------------------------- -- TABLE : RESERVATION_CARACTERISTIQUE -- -----------------------------------------------------------------------------
CREATE TABLE RESERVATION_CARACTERISTIQUE
  (
   ID_CARACTERISTIQUE NUMBER(10)  NOT NULL,
   ID_RESERVATION NUMBER(10)  NOT NULL
, CONSTRAINT PK_RESERVATION_CARACTERISTIQUE PRIMARY KEY (ID_CARACTERISTIQUE, ID_RESERVATION)
  ) ;
-- ----------------------------------------------------------------------------- -- INDEX DE LA TABLE RESERVATION_CARACTERISTIQUE -- -----------------------------------------------------------------------------
CREATE INDEX I_FK_RESERVATION_CARACTERISTIQ
    ON RESERVATION_CARACTERISTIQUE (ID_CARACTERISTIQUE ASC)
   ;
CREATE INDEX I_FK_RESERVATION_CARACTERISTI1
    ON RESERVATION_CARACTERISTIQUE (ID_RESERVATION ASC)
   ;

-- ----------------------------------------------------------------------------- -- CREATION DES REFERENCES DE TABLE -- -----------------------------------------------------------------------------

ALTER TABLE UE ADD (
    CONSTRAINT FK_UE_ENSEIGNANT
         FOREIGN KEY (ID_ENSEIGNANT)
              REFERENCES ENSEIGNANT (ID_ENSEIGNANT))   ;
ALTER TABLE MATIERE ADD (
    CONSTRAINT FK_MATIERE_UE
         FOREIGN KEY (ID_UE)
              REFERENCES UE (ID_UE))   ;
ALTER TABLE MATIERE ADD (
    CONSTRAINT FK_MATIERE_ENSEIGNANT
         FOREIGN KEY (ID_ENSEIGNANT)
              REFERENCES ENSEIGNANT (ID_ENSEIGNANT))   ;
ALTER TABLE GROUPE ADD (
    CONSTRAINT FK_GROUPE_GROUPE
         FOREIGN KEY (ID_GROUPE_A_POUR_PERE)
              REFERENCES GROUPE (ID_GROUPE))   ;
ALTER TABLE ENSEIGNEMENT ADD (
    CONSTRAINT FK_ENSEIGNEMENT_COURS
         FOREIGN KEY (ID_COURS)
              REFERENCES COURS (ID_COURS))   ;
ALTER TABLE ENSEIGNEMENT ADD (
    CONSTRAINT FK_ENSEIGNEMENT_ENSEIGNANT
         FOREIGN KEY (ID_ENSEIGNANT)
              REFERENCES ENSEIGNANT (ID_ENSEIGNANT))   ;
ALTER TABLE ENSEIGNEMENT ADD (
    CONSTRAINT FK_ENSEIGNEMENT_GROUPE
         FOREIGN KEY (ID_GROUPE)
              REFERENCES GROUPE (ID_GROUPE))   ;
ALTER TABLE RESERVATION ADD (
    CONSTRAINT FK_RESERVATION_SALLE
         FOREIGN KEY (ID_SALLE)
              REFERENCES SALLE (ID_SALLE))   ;
ALTER TABLE RESERVATION ADD (
    CONSTRAINT FK_RESERVATION_CRENAUX
         FOREIGN KEY (ID_CRENEAU)
              REFERENCES CRENAUX (ID_CRENEAU))   ;
ALTER TABLE RESERVATION ADD (
    CONSTRAINT FK_RESERVATION_ENSEIGNEMENT
         FOREIGN KEY (ID_ENSEIGNEMENT)
              REFERENCES ENSEIGNEMENT (ID_ENSEIGNEMENT))   ;
ALTER TABLE SALLE ADD (
    CONSTRAINT FK_SALLE_BATIMENT
         FOREIGN KEY (ID_BATIMENT)
              REFERENCES BATIMENT (ID_BATIMENT))   ;
ALTER TABLE COURS ADD (
    CONSTRAINT FK_COURS_MATIERE
         FOREIGN KEY (ID_MATIERE)
              REFERENCES MATIERE (ID_MATIERE))   ;
ALTER TABLE COURS ADD (
    CONSTRAINT FK_COURS_TYPECOURS
         FOREIGN KEY (ID_TYPE_DE_COURS)
              REFERENCES TYPECOURS (ID_TYPE_DE_COURS))   ;
ALTER TABLE CARACTERISTIQUE_SALLE ADD (
    CONSTRAINT FK_CARACTERISTIQUE_SALLE_SALLE
         FOREIGN KEY (ID_SALLE)
              REFERENCES SALLE (ID_SALLE))   ;
ALTER TABLE CARACTERISTIQUE_SALLE ADD (
    CONSTRAINT FK_CARACTERISTIQUE_SALLE_CARAC
         FOREIGN KEY (ID_CARACTERISTIQUE)
              REFERENCES CARACTERISTIQUE (ID_CARACTERISTIQUE))   ;
ALTER TABLE RESERVATION_CARACTERISTIQUE ADD (
    CONSTRAINT FK_RESERVATION_CARACTERISTIQUE
         FOREIGN KEY (ID_CARACTERISTIQUE)
              REFERENCES CARACTERISTIQUE (ID_CARACTERISTIQUE))   ;
ALTER TABLE RESERVATION_CARACTERISTIQUE ADD (
    CONSTRAINT FK_RESERVATION_CARACTERISTIQU1
         FOREIGN KEY (ID_RESERVATION)
              REFERENCES RESERVATION (ID_RESERVATION))   ;

-- ----------------------------------------------------------------------------- -- FIN DE GENERATION -- -----------------------------------------------------------------------------







-- on commence par vider toutes les tables
delete from enseignant;
delete from crenaux;
delete from typecours;
delete from caracteristique;
delete from batiment;
delete from groupe;
delete from salle;
delete from ue;
delete from caracteristique_salle;
delete from matiere;

--Enseignant :
insert into enseignant VALUES(1,'Laurent', 'Anne', 'anne', 0);
insert into enseignant VALUES(2,'Fallery', 'Bernard', 'bernard', 0);
insert into enseignant VALUES(3,'Bourdon','Isabelle','isabelle',0);
insert into enseignant VALUES(4,'Buisson','Lysianne','lysianne',0);
insert into enseignant VALUES(5,'Cart', 'Michelle','michelle',0);
insert into enseignant VALUES(6,'Ruiz','Jacque','jacque',0);
insert into enseignant VALUES(7,'Izard','Thomas','thomas',0);
insert into enseignant VALUES(8,'Pacitti','Esther','esther',0);
insert into enseignant VALUES(9,'Seguin','Corrine','corinne',0);
insert into enseignant VALUES(10,'De Lauzun', 'Anne-laure','anne-laure',1);
insert into enseignant VALUES(11,'Stratulat', 'Tiberiu','tiberiu', 1);
insert into enseignant VALUES(12,'Sala', 'Michel','michel', 0);
insert into enseignant VALUES(13,'Dulas', 'Marc','marc', 0);
--Créneaux :
insert into crenaux values(1, '8h00', '9h30');
insert into crenaux values(2, '9h45', '11h15');
insert into crenaux values(3, '11h30', '13h00');
insert into crenaux values(4, '13h15', '14h45');
insert into crenaux values(5, '15h00', '16h30');
insert into crenaux values(6, '16h45', '18h15');
insert into crenaux values(7, '18h30', '20h00');

--Type de Cours :
insert into typeCours values (1,'Cours');
insert into typeCours values (2,'TD');
insert into typeCours values (3,'TP');

--Caractéristiques :
insert into caracteristique values (1,'videoprojecteur');
insert into caracteristique values (2,'grande');
insert into caracteristique values (3,'moyenne');
insert into caracteristique values (4,'petite');
insert into caracteristique values (5,'TP');

--Batiment :
insert into Batiment values (1,'polytech');

--Groupe :
insert into groupe values (1,NULL,'IG4');
insert into groupe values (2,1,'IG4 G1');
insert into groupe values (3,1,'IG4 G2');
insert into groupe values (4,1,'IG4 anglais G1');
insert into groupe values (5,1,'IG4 anglais G2');
insert into groupe values (6,1,'IG4 anglais G3');

--Salle :
insert into Salle values (1,1,'amphi polytech');
insert into Salle values (2,1,'SC001');
insert into Salle values (3,1,'SC002');
insert into Salle values (4,1,'SC003');
insert into Salle values (5,1,'SC004');
insert into Salle values (6,1,'TP1');
insert into Salle values (7,1,'TP2');
insert into Salle values (8,1,'TP3');
insert into Salle values (9,1,'TP4');
insert into Salle values (10,1,'TP5');
insert into Salle values (11,1,'SC101');
insert into Salle values (12,1,'SC102');
insert into Salle values (13,1,'SC201');
insert into Salle values (14,1,'SC202');

--ANNEEETUDE:
insert into ANNEEETUDE values(1, '4ème année d"étude de la formation IG', 'IG4', '1,5', '3', '3');

--SEMESTRE:
insert into SEMESTRE values(1, 'Semestre 7', 7, 1);
insert into SEMESTRE values(2, 'Semestre 8', 8, 1);

--UE:
insert into UE values(1, 'Conception de bases de donnees',  1, 2);
insert into UE values(2, 'Système et réseaux', 8, 2);
insert into UE values(3, 'Entreprendre et agir', 4, 2);
insert into UE values(4, 'Entrepreneuriale: projet et stage', 6, 2);
insert into UE values(5, 'Langues et communication', 9, 2);

--caracteristique_salle :
insert into CARACTERISTIQUE_SALLE values (1,2);
insert into CARACTERISTIQUE_SALLE values (1,1);
insert into CARACTERISTIQUE_SALLE values (2,2);
insert into CARACTERISTIQUE_SALLE values (2,1);
insert into CARACTERISTIQUE_SALLE values (3,3);
insert into CARACTERISTIQUE_SALLE values (3,1);
insert into CARACTERISTIQUE_SALLE values (4,3);
insert into CARACTERISTIQUE_SALLE values (4,1);
insert into CARACTERISTIQUE_SALLE values (5,3);
insert into CARACTERISTIQUE_SALLE values (5,1);
insert into CARACTERISTIQUE_SALLE values (6,4);
insert into CARACTERISTIQUE_SALLE values (6,1);
insert into CARACTERISTIQUE_SALLE values (6,5);
insert into CARACTERISTIQUE_SALLE values (7,4);
insert into CARACTERISTIQUE_SALLE values (7,1);
insert into CARACTERISTIQUE_SALLE values (7,5);
insert into CARACTERISTIQUE_SALLE values (8,1);
insert into CARACTERISTIQUE_SALLE values (8,4);
insert into CARACTERISTIQUE_SALLE values (8,5);
insert into CARACTERISTIQUE_SALLE values (9,1);
insert into CARACTERISTIQUE_SALLE values (9,4);
insert into CARACTERISTIQUE_SALLE values (9,5);
insert into CARACTERISTIQUE_SALLE values (10,1);
insert into CARACTERISTIQUE_SALLE values (10,4);
insert into CARACTERISTIQUE_SALLE values (10,5);
insert into CARACTERISTIQUE_SALLE values (11,1);
insert into CARACTERISTIQUE_SALLE values (11,3);
insert into CARACTERISTIQUE_SALLE values (12,1);
insert into CARACTERISTIQUE_SALLE values (12,3);
insert into CARACTERISTIQUE_SALLE values (13,1);
insert into CARACTERISTIQUE_SALLE values (13,3);
insert into CARACTERISTIQUE_SALLE values (14,1);
insert into CARACTERISTIQUE_SALLE values (14,3);

--Matières :
insert into matiere values(1, 1, 12, 'Conception par objets');
insert into matiere values(2, 1, 8, 'Bases de données relationnelles Objet et multidimensionnelles');
insert into matiere values(3, 2, 5, 'Système d exploitation');
insert into matiere values(4, 2, 7, 'Réseaux');
insert into matiere values(5, 3, 3, 'Simulation d entreprise');
insert into matiere values(6, 3, 4, 'Si et marketing');
insert into matiere values(7, 3, 2, 'Management des systèmes d information');
insert into matiere values(8, 4, 6, 'Technique de gestion de projets.');
insert into matiere values(9, 4, 6, 'Méthodologie de gestion de projets');
insert into matiere values(10, 5, 9, 'Langue 1: anglais');
insert into matiere values(11, 5, 4, 'Insertion professionnelle');
insert into matiere values(12, 5, 13, 'Communication');

--Cours :
insert into cours values (1,1,1,'cours 1');
insert into cours values (2,1,2,'cours 2');
insert into cours values (3,1,3,'cours 3');
insert into cours values (4,2,1,'cours 1');
insert into cours values (5,2,2,'cours 2');
insert into cours values (6,2,3,'cours 3');
insert into cours values (7,3,1,'cours 1');
insert into cours values (8,3,2,'cours 2');
insert into cours values (9,3,3,'cours 3');
insert into cours values (10,4,1,'cours 1');
insert into cours values (11,4,2,'cours 2');
insert into cours values (12,4,3,'cours 3');
insert into cours values (13,5,1,'cours 1');
insert into cours values (14,5,2,'cours 2');
insert into cours values (15,5,3,'cours 3');
insert into cours values (16,6,1,'cours 1');
insert into cours values (17,6,2,'cours 2');
insert into cours values (18,6,3,'cours 3');
insert into cours values (19,7,1,'cours 1');
insert into cours values (20,7,2,'cours 2');
insert into cours values (21,7,3,'cours 3');
insert into cours values (22,8,1,'cours 1');
insert into cours values (23,8,2,'cours 2');
insert into cours values (24,8,3,'cours 3');
insert into cours values (25,9,1,'cours 1');
insert into cours values (26,9,2,'cours 2');
insert into cours values (27,9,3,'cours 3');
insert into cours values (28,10,1,'cours 1');
insert into cours values (29,10,2,'cours 2');
insert into cours values (30,10,3,'cours 3');
insert into cours values (31,11,1,'cours 1');
insert into cours values (32,11,2,'cours 2');
insert into cours values (33,11,3,'cours 3');
insert into cours values (34,12,1,'cours 1');
insert into cours values (35,12,2,'cours 2');
insert into cours values (36,12,3,'cours 3');

-- Enseignement :
insert into enseignement values (1,36,13,6,30);
insert into enseignement values (2,2,12,4,5);
insert into enseignement values (3,3,11,5,15);
insert into enseignement values (4,7,10,1,20);
insert into enseignement values (5,33,9,2,13);
insert into enseignement values (6,30,1,3,14);
insert into enseignement values (7,1,4,5,20);
insert into enseignement values (8,4,3,1,10);
insert into enseignement values (9,5,13,2,5);
insert into enseignement values (10,6,2,3,30);
insert into enseignement values (11,8,1,6,10);
insert into enseignement values (12,9,13,3,10);
insert into enseignement values (13,13,7,4,4);
insert into enseignement values (14,12,8,1,5);
insert into enseignement values (15,17,5,1,10);
insert into enseignement values (16,16,9,4,3);
insert into enseignement values (17,11,10,5,2);
insert into enseignement values (18,15,12,6,4);
insert into enseignement values (19,19,13,2,10);
insert into enseignement values (20,18,11,6,10);
insert into enseignement values (21,21,10,1,14);
insert into enseignement values (22,20,8,3,20);
insert into enseignement values (23,14,9,4,13);
insert into enseignement values (24,22,4,1,11);
insert into enseignement values (25,23,3,1,10);
insert into enseignement values (26,25,1,2,12);
insert into enseignement values (27,26,2,5,3);
insert into enseignement values (28,32,5,5,4);
insert into enseignement values (29,31,12,1,5);
insert into enseignement values (30,29,13,6,5);
insert into enseignement values (31,28,3,3,8);
insert into enseignement values (32,27,7,6,7);
insert into enseignement values (33,34,2,4,15);
insert into enseignement values (34,35,3,6,3);
insert into enseignement values (35,10,13,3,10);
insert into enseignement values (36,24,13,3,10);

-- Reservation
insert into reservation values (1,14,1,36,'10-03-2012');
insert into reservation values (2,13,1,34,'10-03-2012');
insert into reservation values (3,12,2,33,'10-03-2012');
insert into reservation values (4,NULL,2,31,'10-03-2012');
insert into reservation values (5,10,5,30,'10-03-2012');
insert into reservation values (6,2,6,10,'10-03-2012');
insert into reservation values (7,1,7,1,'10-03-2012');
insert into reservation values (8,NULL,1,2,'11-03-2012');
insert into reservation values (9,7,2,4,'11-03-2012');
insert into reservation values (10,8,3,17,'11-03-2012');
insert into reservation values (11,11,4,16,'11-03-2012');
insert into reservation values (12,13,5,26,'11-03-2012');
insert into reservation values (13,14,6,6,'11-03-2012');
insert into reservation values (14,NULL,7,5,'11-03-2012');
insert into reservation values (15,5,1,15,'12-03-2012');
insert into reservation values (16,NULL,2,13,'12-03-2012');
insert into reservation values (17,2,3,11,'12-03-2012');
insert into reservation values (18,9,4,10,'12-03-2012');
insert into reservation values (19,6,5,1,'12-03-2012');
insert into reservation values (20,7,6,2,'12-03-2012');
insert into reservation values (21,9,7,3,'12-03-2012');
insert into reservation values (22,14,1,5,'13-03-2012');
insert into reservation values (23,NULL,2,18,'13-03-2012');
insert into reservation values (24,6,3,19,'13-03-2012');
insert into reservation values (25,8,4,2,'13-03-2012');
insert into reservation values (26,7,5,7,'13-03-2012');
insert into reservation values (27,NULL,6,17,'13-03-2012');
insert into reservation values (28,14,7,16,'13-03-2012');
insert into reservation values (29,6,1,27,'14-03-2012');
insert into reservation values (30,7,2,22,'14-03-2012');
insert into reservation values (31,5,3,21,'14-03-2012');
insert into reservation values (32,14,4,34,'14-03-2012');
insert into reservation values (33,5,5,32,'14-03-2012');
insert into reservation values (34,NULL,6,31,'14-03-2012');
insert into reservation values (35,3,7,16,'14-03-2012');
insert into reservation values (36,9,1,3,'15-03-2012');

-- Reservation_Caracteristique
insert into reservation_caracteristique values (1,1);
insert into reservation_caracteristique values (1,2);
insert into reservation_caracteristique values (2,3);
insert into reservation_caracteristique values (2,4);
insert into reservation_caracteristique values (3,5);
insert into reservation_caracteristique values (4,6);
insert into reservation_caracteristique values (4,7);
insert into reservation_caracteristique values (5,8);
insert into reservation_caracteristique values (4,9);
insert into reservation_caracteristique values (4,10);
insert into reservation_caracteristique values (3,11);
insert into reservation_caracteristique values (2,12);
insert into reservation_caracteristique values (1,13);
insert into reservation_caracteristique values (3,14);
insert into reservation_caracteristique values (5,15);
insert into reservation_caracteristique values (1,16);
insert into reservation_caracteristique values (2,17);
insert into reservation_caracteristique values (3,18);
insert into reservation_caracteristique values (4,19);
insert into reservation_caracteristique values (4,20);
insert into reservation_caracteristique values (5,21);
insert into reservation_caracteristique values (3,22);
insert into reservation_caracteristique values (1,23);
insert into reservation_caracteristique values (2,24);
insert into reservation_caracteristique values (1,25);
insert into reservation_caracteristique values (1,26);
insert into reservation_caracteristique values (4,27);
insert into reservation_caracteristique values (2,28);
insert into reservation_caracteristique values (2,29);
insert into reservation_caracteristique values (3,30);
insert into reservation_caracteristique values (2,31);
insert into reservation_caracteristique values (4,32);
insert into reservation_caracteristique values (3,33);
insert into reservation_caracteristique values (1,34);
insert into reservation_caracteristique values (2,35);
insert into reservation_caracteristique values (2,36);
insert into reservation_caracteristique values (5,19);
insert into reservation_caracteristique values (4,36);
insert into reservation_caracteristique values (1,35);
insert into reservation_caracteristique values (2,26);
insert into reservation_caracteristique values (3,20);
insert into reservation_caracteristique values (3,34);
insert into reservation_caracteristique values (3,12);
insert into reservation_caracteristique values (2,10);
insert into reservation_caracteristique values (4,2);
insert into reservation_caracteristique values (4,14);
insert into reservation_caracteristique values (4,8);
insert into reservation_caracteristique values (3,3);
insert into reservation_caracteristique values (3,31);
insert into reservation_caracteristique values (2,9);
insert into reservation_caracteristique values (3,28);