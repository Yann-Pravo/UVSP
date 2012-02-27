package metier;

import java.util.*;

/**
 * Classe metier de gestion des groupes
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class Groupe extends TypeGroupe {

	//Attributs
    public String nomGroupe;
    public Integer nbEtudiants;
    ArrayList<Groupe> groupesIncompatibles;

    /**
     * Constructeur d'un groupe
     * @param nomGroupe le nom du groupe
     * @param nomTypeGrp le nom du type de groupe
     * @param nbEt le nombre d'etudiants
     */
    public Groupe(String nomGrp, String nomTypeGrp, Integer nbEt) {
        super(nomTypeGrp);
        this.nomGroupe = nomGrp;
        this.nbEtudiants = nbEt;
    }

    /**
     * Constructeur d'un groupe avec le tableau des groupes incompatibles
     * @param nomGrp le nom du groupe
     * @param nomTypeGrp le nom du type de groupe
     * @param nbEt le nombre d'etudiants
     * @param listeGroupes la liste des groupes incompatibles
     */
    public Groupe(String nomGrp, String nomTypeGrp, Integer nbEt, ArrayList<Groupe> listeGroupes) {
        super(nomTypeGrp);
        this.nomGroupe = nomGrp;
        this.nbEtudiants = nbEt;
        this.groupesIncompatibles = listeGroupes;
    }


    /**
     * Constructeur d'un groupe qu'avec le nom
     * @param nomGroupe le nom du groupe
     */
    public Groupe(String nomGrp) {
        super();
        this.nomGroupe = nomGrp;
    }

    /**
     * Recuperation du nom du groupe
     * @return le nom du groupe
     */
    public String getNomGroupe() {
        return nomGroupe;
    }

    /**
     * Affectation du nom du groupe
     * @param unNom le nom du groupe
     */
    public void setNomGroupe(String unNom) {
        this.nomGroupe = unNom;
    }
    
    /**
     * Recuperation du nombre d'étudiants du groupe
     * @return le nombre d'étudiants du groupe
     */
    public int getNbEtudiants() {
        return nbEtudiants;
    }

    /**
     * Affectation du nombre d'étudiants du groupe
     * @param nbEtudiants le nombre d'étudiants du groupe
     */
    public void setNbEtudiants(Integer nbEt) {
        this.nbEtudiants = nbEt;
    }

    /**
     * Recuperation de la liste des groupes incompatibles
     * @return la liste des groupes incompatiblese
     */
    public ArrayList<Groupe> getGroupesIncompatibles() {
        return  groupesIncompatibles;
    }

    /**
     * Affectation de la liste des groupes incompatibles
     * @param listeGrp la liste des groupes incompatibles
     */
    public void setNbEtudiants(ArrayList<Groupe> listeGrp) {
        this.groupesIncompatibles = listeGrp;
    }
}