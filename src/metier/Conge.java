package metier;

import java.util.* ;
//import persistance.DAO;

/**
 * Classe métier permettant la définition et la gestion des objets 'Conge'
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class Conge extends TypeConge{

    // Attributs
    private String nomConge;
    private Date dateDebut;
    private Date dateFin ;

    //Attributs de l'association
    AnneeUniversitaire anneeAU;

    /**
     * Constructeur d'un objet Conge prenant en compte ses 5 attributs
     * @param nomC Nom du congé
     * @param nomT Nom du type de congé
     * @param anneeU Objet année univerisitaire
     * @param dateD date début du congé
     * @param dateF date fin du congé
     */
    public Conge (String nomC, String nomT, AnneeUniversitaire anneeU, Date dateD, Date dateF)
    {
        super(nomT);
        this.nomConge = nomC;
        this.anneeAU = anneeU;
        this.dateDebut = dateD;
        this.dateFin = dateF;
    }

    /**
     * Accesseur du nom du congé
     * @return String - nom du congé
     */
    public String getNomConge() {
        return nomConge;
    }

    /**
     * Modifieur du nom du congé
     * @param nomC Chaîne de caractères définissant le nouveau nom de l'objet Conge
     */
    public void setNomConge(String nomC) {
        this.nomConge = nomC;
    }

    /**
     * Accesseur à la date de début de congé
     * @return Date - date de début de l'objet Conge
     */
    public Date getDateDebut() {
        return dateDebut ;
    }

    /**
     * Modifieur de la date début de l'objet conge
     * @param dateD date de début de l'objet Conge
     */
    public void setDateDebut(Date dateD) {
        this.dateDebut = dateD;
    }


    /**
     * Accesseur à l'objet AnnéeUniversitaire d'un objet Conge
     * @return  anneeAU -  Objet ann√©eUniversitaire de l'objet Conge
     */
    public AnneeUniversitaire getAnneeAU() {
        return anneeAU;
    }

     /**
     * Modifieur de l'objet AnnéeUniversitaire de l'objet conge
     * @param anneeAU Objet ann√©e universitaire correspondant √† l'objet Conge
     */
    public void setAnneeAU(AnneeUniversitaire anneeAU) {
        this.anneeAU = anneeAU;
    }

      /**
     * Accesseur à la date de fin d'un objet Conge
     * @return Date - date de fin de l'objet Conge
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * Modifieur de la date fin du Conge
     * @param dateF -  date fin de l'objet Conge
     */
    public void setDateFin(Date dateF) {
        this.dateFin = dateF;
    }
}