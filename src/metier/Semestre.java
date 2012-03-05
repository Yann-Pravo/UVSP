package metier;

import java.util.ArrayList;

/**
 * Classe métier permettant la définition et la gestion des objets Semestre
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class Semestre {

    // Attributs
    private String nomSemestre;
    private Integer niveau;

    // Attributs associations
    private ArrayList<UE> ue;
    private AnneeEtude anneeEtude;
    
    /**
     * Constructeur d'un objet Semestre prenant en compte uniquement son nom
     * @param nomSemestre Nom du semestre
     * @param nomAnneeEtude Nom de l'année d'étude
     */
    public Semestre(String nomSemestre, AnneeEtude anneeEtude) {
        this.nomSemestre = nomSemestre;
        this.anneeEtude = anneeEtude;
    }

    /** Constructeur d'un objet Semestre prenant en compte son nom, son année d'étude et son niveau
     * @param nomSemestre Nom du semestre
     * @param nomAnneeEtude Nom de l'année d'étude
     * @param niveau Niveau du semestre
     */
    public Semestre(String nomSemestre, AnneeEtude anneeEtude, Integer niveau) {
        this.nomSemestre = nomSemestre;
        this.anneeEtude = anneeEtude;
        this.niveau = niveau;
        this.ue = new ArrayList<UE>();
    }

    /**
     * Constructeur d'un objet Semestre prenant en compte ses 3 attributs
     * @param nomSemestre Nom du semestre
     * @param nomAnneeEtude Nom de l'année d'étude associée au semestre
     * @param niveau Niveau du semestre dans l'année d'étude
     */
    public Semestre(String nomSemestre, AnneeEtude anneeEtude, Integer niveau, ArrayList<UE> ue) {
        this.nomSemestre = nomSemestre;
        this.anneeEtude = anneeEtude;
        this.niveau = niveau;
        this.ue = ue;
    }

    /**
     * Accesseur du nom d'un objet Semestre
     * @return String - Nom du semestre
     */
    public String getNomSemestre() {
        return nomSemestre;
    }

    /**
     * Modifieur du nom d'un objet Semestre
     * @param nomSemestre - Chaîne de caractère définissant le nouveau nom du semestre
     */
    public void setNomSemestre(String nomSemestre) {
        this.nomSemestre = nomSemestre;
    }

    /**
     * Accesseur du nom de l'année d'étude d'un objet Semestre
     * @return AnneeEtude L'année d'étude du semestre
     */
    public AnneeEtude getAnneeEtude() {
        return anneeEtude;
    }

    /**
     * Modifieur du nom de l'année d'étude d'un objet Semestre
     * @param anneeEtude L'année d'étude du semestre
     */
    public void setAnneeEtud(AnneeEtude nomAnneeEtude) {
        this.anneeEtude = nomAnneeEtude;
    }

    /**
     * Accesseur du niveau d'un objet Semestre
     * @return Integer - Niveau du semestre
     */
    public Integer getNiveau() {
        return niveau;
    }

    /**
     * Modifieur du niveau d'un objet Semestre
     * @param niveau - Entier définissant le nouveau niveau du semestre
     */
    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    /**
     * Accesseur de la liste des UEs associées à un objet Semestre
     * @return ArrayList<UE> - Liste des UEs du semestre
     */
    public ArrayList<UE> getUe() {
        return ue;
    }

    /**
     * Modifieur de la liste des UEs associées à un objet Semestre
     * @param ue Liste des UEs du semestre
     */
    public void setUe(ArrayList<UE> ue) {
        this.ue = ue;
    }
}
