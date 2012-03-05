package metier;

import java.util.ArrayList;

/**
 * Classe qui définit les attributs et les méthodes d'une année d'étude
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class AnneeEtude {
	
    // Attributs classe
    private String nomAnnee;
    private String description;
    private Integer dureeSeance;
    private Integer nbSeanceAM;
    private Integer nbSeancePM;

    // Attributs Association
    private Semestre s1;
    private Semestre s2;
    private ArrayList<AnneeUniversitaire> annneUniv;

    /**
     * Constructeur de la classe AnneeEtude ne prenant en compte que le nom de l'année
     * @param nomAnnee Nom de l'année d'étude
     */
    public AnneeEtude(String nomAnnee) {
        this.nomAnnee = nomAnnee;
    }

    /**
     * Constructeur de la classe AnneeEtude prenant en compte son nom, sa description,
     * la durée d'une séance de cours, le nombre de séances le matin et l'après-midi.
     * Les deux semestres et les années universitaires sont nulls par défaut.
     * @param nomAnnee Nom de l'année d'étude
     * @param description Description de l'année d'étude
     * @param dureeSeance Durée d'une séance de cours
     * @param nbSeanceAM Nombre de séances de cours le matin
     * @param nbSeancePM Nombre de séances de cours le soir
     * @param formation Formation à laquelle appartient l'annee d'etude
     */
    public AnneeEtude(String nomAnnee,
                      String description,
                      Integer dureeSeance,
                      Integer nbSeanceAM,
                      Integer nbSeancePM)
    {
        this.nomAnnee = nomAnnee;
        this.description = description;
        this.dureeSeance = dureeSeance;
        this.nbSeanceAM = nbSeanceAM;
        this.nbSeancePM = nbSeancePM;
        this.s1 = null;
        this.s2 = null;
        this.annneUniv = new ArrayList<AnneeUniversitaire>();
    }

    /**
     * Constructeur de la classe AnneeEtude prenant en compte ses 6 attributs
     * @param nomAnnee Nom de l'année d'étude
     * @param description Description de l'année d'étude
     * @param dureeSeance Durée d'une séance de cours
     * @param nbSeanceAM Nombre de séances de cours le matin
     * @param nbSeancePM Nombre de séances de cours le soir
     * @param formation Formation à laquelle appartient l'annee d'etude
     * @param s1 Premier semestre de l'année d'étude
     * @param s2 Second semestre de l'année d'étude
     * @param anneeUniv Liste des années universitaires associées à l'année d'étude
     */
    public AnneeEtude(String nomAnnee,
                      String description,
                      Integer dureeSeance,
                      Integer nbSeanceAM,
                      Integer nbSeancePM,
                      Semestre s1,
                      Semestre s2,
                      ArrayList<AnneeUniversitaire> anneeUniv)
    {
        this.nomAnnee = nomAnnee;
        this.description = description;
        this.dureeSeance = dureeSeance;
        this.nbSeanceAM = nbSeanceAM;
        this.nbSeancePM = nbSeancePM;
        this.s1 = s1;
        this.s2 = s2;
        this.annneUniv = anneeUniv;
    }
    
    /**
     * Accesseur du nom d'un objet AnneeEtude
     * @return String - Nom de l'année d'étude
     */
    public String getNomAnnee() {
        return nomAnnee;
    }

    /**
     * Modifieur du nom d'un objet AnneeEtude
     * @param nomAnnee Chaîne de caractères définissant le nouveau nom de l'année d'étude
     */
    public void setNomAnnee(String nomAnnee) {
        this.nomAnnee = nomAnnee;
    }

    /**
     * Accesseur de la description d'un objet AnneeEtude
     * @return String - Description de l'année d'étude
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifieur de la description d'un objet AnneeEtude
     * @param description Chaîne de caractères définissant la nouvelle description de l'année d'étude
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Accesseur de la durée d'une séance d'un objet AnneeEtude
     * @return Integer - Durée des séance d'une année d'étude
     */
    public Integer getDureeSeance() {
        return dureeSeance;
    }

    /**
     * Modifieur de la durée d'une séance d'un objet AnneeEtude
     * @param dureeSeance Entier définissant la nouvelle durée des séances de l'année d'étude
     */
    public void setDureeSeance(Integer dureeSeance) {
        this.dureeSeance = dureeSeance;
    }

    /**
     * Accesseur du nombre de séances le matin d'un objet AnneeEtude
     * @return Integer - Nombre de séances prévues le matin pour une année d'étude
     */
    public Integer getNbSeanceAM() {
        return nbSeanceAM;
    }

    /**
     * Modifieur du nombre de séance le matin d'un objet AnneeEtude
     * @param nbSeanceAM Entier définissant le nouveau nombre de séances le matin de l'année d'étude
     */
    public void setNbSeanceAM(Integer nbSeanceAM) {
        this.nbSeanceAM = nbSeanceAM;
    }

    /**
     * Accesseur du nombre de séances l'après midi d'un objet AnneeEtude
     * @return Integer - Nombre de séances prévues l'après midi pour une année d'étude
     */
    public Integer getNbSeancePM() {
        return nbSeancePM;
    }

    /**
     * Modifieur du nombre de séance l'après midi d'un objet AnneeEtude
     * @param nbSeancePM Entier définissant le nouveau nombre de séances l'après midi de l'année d'étude
     */
    public void setNbSeancePM(Integer nbSeancePM) {
        this.nbSeancePM = nbSeancePM;
    }

    /**
     * Accesseur de la liste des années universitaires associées à un objet AnneeEtude
     * @return ArrayList<AnneeUniversitaire> - Liste des années universitaires d'une année d'étude
     */
    public ArrayList<AnneeUniversitaire> getAnnneUniv() {
        return annneUniv;
    }

    /**
     * Modifieur de la liste des années universitaires associées à un objet AnneeEtude
     * @param annneUniv Liste des ann√©es universitaires associées à l'année d'étude
     */
    public void setAnnneUniv(ArrayList<AnneeUniversitaire> annneUniv) {
        this.annneUniv = annneUniv;
    }

    /**
     * Accesseur du premier semestre associé à un objet AnneeEtude
     * @return Semestre - Objet Semestre correspondant au 1er semestre associé à une année d'étude
     */
    public Semestre getS1() {
        return s1;
    }

    /**
     * Modifieur du premier semestre associé à un objet AnneeEtude
     * @param s1 Objet Semestre correspondant au 1er semestre associé à une année d'étude
     */
    public void setS1(Semestre s1) {
        this.s1 = s1;
    }

    /**
     * Accesseur du second semestre associé à un objet AnneeEtude
     * @return Semestre - Objet Semestre correspondant au 2nd semestre associé à une année d'étude
     */
    public Semestre getS2() {
        return s2;
    }

    /**
     * Modifieur du second semestre associé à un objet AnneeEtude
     * @param s2 Objet Semestre correspondant au 2nd semestre associé à une année d'étude
     */
    public void setS2(Semestre s2) {
        this.s2 = s2;
    }
}
