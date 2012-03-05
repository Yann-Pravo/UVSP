package metier;

import java.util.ArrayList;

/**
 * Classe métier permettant la définition et la gestion d'un objet UE
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class UE {
	// Attributs
	private String codeUE;
	private String nomUE;
	private String description;
	private Integer nbEcts;
	private Integer noteMin;

	//Attributs associations
	private Semestre sem;
	private ArrayList<Matiere> matieres = new ArrayList<Matiere>();

	/**
     * Constructeur d'un objet UE prenant en compte ses 5 attributs et l'attribut d'association
     * @param code Code de l'UE
     * @param n Nom de l'UE
     * @param d Description de l'UE
     * @param nbE Nombre d'ECTS pour l'UE
     * @param noteM Note minimum pour l'UE
     * @param s Semestre auquel appartient l'UE
     */
    public UE(String code, String n, String d, Integer nbE, Integer noteM, Semestre s) {
        codeUE = code;
        nomUE = n;
        description = d;
        nbEcts = nbE;
        noteMin = noteM;
        sem = s;
    }

    /**
     * Constructeur d'un objet UE ne prenant pas d'attributs
     * @param code Code de l'UE
     * @param n Nom de l'UE
     * @param d Description de l'UE
     * @param nbE Nombre d'ECTS pour l'UE
     * @param noteM Note minimum pour l'UE
     */
    public UE(){}

    /**
     * Constructeur d'un objet UE prenant en compte ses 5 attributs
     * @param code Code de l'UE
     * @param n Nom de l'UE
     * @param d Description de l'UE
     * @param nbE Nombre d'ECTS pour l'UE
     * @param noteM Note minimum pour l'UE
     */
    public UE(String code, String n, String d, Integer nbE, Integer noteM) {
        codeUE = code;
        nomUE = n;
        description = d;
        nbEcts = nbE;
        noteMin = noteM;
    }

    /**
     * Constructeur d'un objet UE prenant le code de l'UE
     * @param c Code de l'UE
     */
    public UE(String c) {
        codeUE = c;
    }

    /**
     * Constructeur d'un objet UE prenant le code et le nom de l'UE
     * @param code Code de l'UE
     * @param nom Nom de l'UE
     */
    public UE(String code,String nom) {
        codeUE = code;
        nomUE = nom;
    }

    /**
     * Accesseur du code d'un objet UE
     * @return String - Code de l'UE
     */
    public String getCodeUE() {
        return codeUE;
    }

    /**
     * Modifieur du code d'un objet UE
     * @param description Chaine de caractère définissant la nouveau code de l'UE
     */
    public void setCodeUE(String codeUE) {
        this.codeUE = codeUE;
    }

    /**
     * Accesseur du code d'un objet UE
     * @return String - Nom de l'UE
     */
    public String getNomUE() {
        return nomUE;
    }

    /**
     * Modifieur du code d'un objet UE
     * @param description Chaine de caractère définissant le nouveau nom de l'UE
     */
    public void setNomUE(String nomUE) {
        this.nomUE = nomUE;
    }

    /**
     * Accesseur du code d'un objet UE
     * @return String - Description de l'UE
     */
    public String getDescrption() {
        return description;
    }

    /**
     * Modifieur du code d'un objet UE
     * @param description Chaine de caractère définissant la nouvelle description de l'UE
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Accesseur du code d'un objet UE
     * @return Integer - Le nombre d'ECTS pour l'UE
     */
    public Integer getNbEcts() {
        return nbEcts;
    }

    /**
     * Modifieur du code d'un objet UE
     * @param nnEcts Integer définissant le nouvel nombre d'ECTS pour l'UE
     */
    public void setNbEcts(Integer nbEcts) {
        this.nbEcts = nbEcts;
    }

    /**
     * Accesseur du code d'un objet UE
     * @return Integer - Description de l'UE
     */
    public Integer getNoteMin() {
        return noteMin;
    }

    /**
     * Modifieur du code d'un objet UE
     * @param noteMin Integer définissant la nouvelle note minimum pour l'UE
     */
    public void setNoteMin(Integer noteMin) {
        this.noteMin = noteMin;
    }

    /**
     * Accesseur du code d'un objet UE
     * @return Semestre - Semestre auquel appartient l'UE
     */
    public Semestre getSem() {
        return sem;
    }

    /**
     * Modifieur du code d'un objet UE
     * @param Sem Semestre définissant le semestre auquel appartient l'UE
     */
    public void setSem(Semestre sem) {
        this.sem = sem;
    }

	public ArrayList<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(ArrayList<Matiere> matieres) {
		this.matieres = matieres;
	}
}