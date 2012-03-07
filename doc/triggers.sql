-- Création des séquences et triggers pour l'auto-incrémentation des IDs des tables --

drop sequence seqEnseignant;
drop sequence seqCrenaux;
drop sequence seqTypeCours;
drop sequence seqCaracteristique;
drop sequence seqBatiment;
drop sequence seqGroupe;
drop sequence seqSalle;
--drop sequence seqAnneeEtude;
--drop sequence seqSemestre;
drop sequence seqUE;
drop sequence seqMatiere;
drop sequence seqCours;
drop sequence seqEnseignement;
drop sequence seqReservation

drop trigger enseignantTrigger;
drop trigger crenauxTrigger;
drop trigger typeCoursTrigger;
drop trigger typeCaracteristique;
drop trigger typeBatiment;
drop trigger typeGroupe;
drop trigger typeSalle;
--drop trigger anneeEtudeTrigger;
--drop trigger semestreTrigger;
drop trigger ueTrigger;
drop trigger matiereTrigger;
drop trigger coursTrigger;
drop trigger enseignementTrigger;
drop trigger reservationTrigger;

create sequence seqEnseignant
start with 14
increment by 1
nomaxvalue;

create trigger enseignantTrigger
before insert on ENSEIGNANT
for each row
begin
select seqEnseignant.nextval into :new.ID_ENSEIGNANT from dual;
end;

--

create sequence seqCrenaux
start with 8
increment by 1
nomaxvalue;

create trigger crenauxTrigger
before insert on CRENAUX
for each row
begin
select seqCrenaux.nextval into :new.ID_CRENEAU from dual;
end;

--

create sequence seqTypeCours
start with 4
increment by 1
nomaxvalue;

create trigger typeCoursTrigger
before insert on TYPECOURS
for each row
begin
select seqTypeCours.nextval into :new.ID_TYPE_DE_COURS from dual;
end;

--

create sequence seqCaracteristique
start with 6
increment by 1
nomaxvalue;

create trigger caracteristiqueTrigger
before insert on CARACTERISTIQUE
for each row
begin
select seqCaracteristique.nextval into :new.ID_CARACTERISTIQUE from dual;
end;

--

create sequence seqBatiment
start with 2
increment by 1
nomaxvalue;

create trigger batimentTrigger
before insert on BATIMENT
for each row
begin
select seqBatiment.nextval into :new.ID_BATIMENT from dual;
end;

--

create sequence seqGroupe
start with 7
increment by 1
nomaxvalue;

create trigger groupeTrigger
before insert on GROUPE
for each row
begin
select seqGroupe.nextval into :new.ID_GROUPE from dual;
end;

--

create sequence seqSalle
start with 15
increment by 1
nomaxvalue;

create trigger salleTrigger
before insert on SALLE
for each row
begin
select seqSalle.nextval into :new.ID_SALLE from dual;
end;

--

--create sequence seqAnneeEtude
--start with 2
--increment by 1
--nomaxvalue;
--
--create trigger anneeEtudeTrigger
--before insert on ANNEEETUDE
--for each row
--begin
--select seqAnneeEtude.nextval into :new.ID_ANNEEETUDE from dual;
--end;

--

--create sequence seqSemestre
--start with 3
--increment by 1
--nomaxvalue;
--
--create trigger semestreTrigger
--before insert on SEMESTRE
--for each row
--begin
--select seqSemestre.nextval into :new.ID_SEMESTRE from dual;
--end;

--

create sequence seqUE
start with 6
increment by 1
nomaxvalue;

create trigger ueTrigger
before insert on UE
for each row
begin
select seqUE.nextval into :new.ID_UE from dual;
end;

--

create sequence seqMatiere
start with 13
increment by 1
nomaxvalue;

create trigger matiereTrigger
before insert on MATIERE
for each row
begin
select seqMatiere.nextval into :new.ID_MATIERE from dual;
end;

--

create sequence seqCours
start with 37
increment by 1
nomaxvalue;

create trigger coursTrigger
before insert on COURS
for each row
begin
select seqCours.nextval into :new.ID_COURS from dual;
end;

--

create sequence seqEnseignement
start with 37
increment by 1
nomaxvalue;

create trigger enseignementTrigger
before insert on ENSEIGNEMENT
for each row
begin
select seqEnseignement.nextval into :new.ID_ENSEIGNEMENT from dual;
end;

--

create sequence seqReservation
start with 37
increment by 1
nomaxvalue;

create trigger reservationTrigger
before insert on RESERVATION
for each row
begin
select seqReservation.nextval into :new.ID_RESERVATION from dual;
end;