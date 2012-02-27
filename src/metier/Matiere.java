package metier;

import java.util.ArrayList;

/**
 * Classe métier permettant la définition et la gestion des objets 'Matiere'
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class Matiere {

    // Attributs
    private String code;
    private String nom;
    private String description;
    private Integer coeff;

    // Attributs d'association
    private UE u;
    private ArrayList<TypeEnseignement> typeEns;

    /**
     * Constructeur d'un objet Matiere prenant en compte le nom uniquement
     * @param nom Nom de la matière
     */
    public Matiere(String nom) {
        this.nom = nom;
    }

    /**
     * Constructeur d'un objet Matiere prenant en compte son code et son nom
     * @param code Code de la matière
     * @param nom Nom de la matière
     */
    public Matiere(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    /**
     * Constructeur d'un objet Matiere prenant en compte son code et son nom
     * @param code Code de la matière
     * @param nom Nom de la matière
     * @param u L'unité d'enseignement associé à la matière
     */
    public Matiere(String code, String nom, UE u) {
        this.code = code;
        this.nom = nom;
        this.u = u;
    }

    /**
     * Constructeur d'un objet Matiere prenant en compte son nom, sa description
     * et son coefficient
     * @param code Code de la matière
     * @param nom Nom de la matière
     * @param descr Description de la matière
     * @param coeff Coefficient de la matière dans l'UE
     * @param u UE associé à la matiere
     */
    public Matiere (String code, String nom, String descr, Integer coeff, UE u)
    {
        this.code = code;
        this.nom = nom;
        this.description = descr;
        this.coeff = coeff;
        this.u = u;
        this.typeEns = new ArrayList();
    }

    /**
     * Constructeur d'un objet Matiere prenant en compte ses 4 attributs
     * @param code Code de la matière
     * @param nom Nom de la matière
     * @param descr Description de la matière
     * @param coeff Coefficient de la matière dans l'UE
     * @param u UE associé à la matière
     * @param typeEns Liste des types d'enseignement qui lui sont associés
     */
    public Matiere(String code, String nom, String description, Integer coeff,UE u, ArrayList<TypeEnseignement> typeEns) {
        this.code = code;
        this.nom = nom;
        this.description = description;
        this.coeff = coeff;
        this.u = u;
        this.typeEns = typeEns;
    }

    public Matiere(String code, int db) {
        this.code = code;
    }

    /**
     * Accesseur du code de m'objet Matiere
     * @return code de la matière
     */
    public String getCode() {
        return code;
    }

    /**
     * Modifieur du code de la matière
     * @param code Cha√Æne de caractères définissant le nouveau code de la matière
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Accesseur du coefficient d'un objet Matiere
     * @return Integer - Coefficient de l'objet Matière
     */
    public Integer getCoeff() {
        return coeff;
    }

    /**
     * Modifieur du coefficient d'un objet Matiere
     * @param coeff Entier définissant le nouveau coefficient de l'objet Matiere
     */
    public void setCoeff(Integer coeff) {
        this.coeff = coeff;
    }

    /**
     * Accesseur de la description d'un objet Matiere
     * @return String - Coefficient de l'objet Matiere
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifieur de la description d'un objet Matiere
     * @param description Chaîne de caractères définissant la nouvelle description d'un objet Matiere
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Accesseur du nom d'un objet Matiere
     * @return String - Nom de l'objet Matière
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifieur du nom d'un objet Matiere
     * @param nom Chaîne de caractères définissant le nouveau nom de l'objet Matiere
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Accesseur sur l'UE associées à un objet Matiere
     * @author Oph√©lie Mak
     * @return UE L'UE associés à une matière
     */
    public UE getUE() {
        return u;
    }

    /**
     * Modificateur de l'UE associée à un objet Matiere
     * @param u L'UE associée à une matière
     */
    public void setUE(UE u) {
        this.u = u;
    }

    /**
     * Accesseur de la liste des types denseignements d'un objet Matiere
     * @return ArrayList<TypeEnseignement> - Liste des types d'enseignements associés à une matière
     */
    public ArrayList<TypeEnseignement> getTypeEns() {
        return typeEns;
    }

    /**
     * Modifieur de la liste des types d'enseignement d'un objet Matiere
     * @param typeEns Liste es types d'enseignements associés à une matière	
     */
    public void setTypeEns(ArrayList<TypeEnseignement> typeEns) {
        this.typeEns = typeEns;
    }
}