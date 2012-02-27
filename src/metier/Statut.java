package metier;

/**
 * Classe mtier permettant la dfinition et la gestion des objets 'Statut'
 * @authors Ahardane Abdeslam, Balestrat Clment, Pravossoudovitch Yann
 * @version 1.0
 */
public class Statut
{
	//Attributs
    public String nomStatut;
    public Integer nbHeures;

    /**
     * Constructeur public d'un objet Statut prenant en compte son nom
     * @param nomStatut Nom statut
     */
    public Statut(String nomStatut) {
        this.nomStatut = nomStatut;
    }

    /**
     * Constructeur public d'un objet Statut ne prenant pas d'arguments en compte
     */
    public Statut() {}

    /**
     * Constructeur public d'un objet Statut prenant en compte ses 2 arguments
     * @param nomStatut Nom statut
     */
    public Statut(String nomStatut, Integer nbHeures) {
        this.nomStatut = nomStatut;
        this.nbHeures = nbHeures;
    }

    /**
     * Accesseur du nombre d'heure du statut
     * @return Integer - Nombre d'heures du statut
     */
    public Integer getNbHeures() {
        return nbHeures;
    }

    /**
     * Modifieur du nombre d'heures du statut
     * @param nbHeures Nombres d'heures du statut
     */
    public void setNbHeures(Integer nbHeures) {
        this.nbHeures = nbHeures;
    }

    /**
     * Accesseur du nom du statut
     * @return String - Nom du statut
     */
    public String getNomStatut() {
        return nomStatut;
    }

    /**
     * Modifieur du nom du statut
     * @param nomStatut Nom du statut
     */
    public void setNomStatut(String nomStatut) {
        this.nomStatut = nomStatut;
    }
}
