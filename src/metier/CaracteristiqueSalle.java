package metier;

/**
 * Classe métier permettant la définition et la gestion des objets 'CaracteristiqueSalle'
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class CaracteristiqueSalle {

    // Attributs
    private Salle sal;
    private Caracteristique caract;
    
    /**
     * Constructeur d'un objet CaracteristiqueSalle prenant en compte la salle et la caractéristique
     * @param sal Id de la salle
     * @param caract Id de la caractéristique
     */
    public CaracteristiqueSalle(Salle sal, Caracteristique caract) {
        this.sal = sal;
        this.caract = caract;
    }
    
    /**
     * Accesseur du id de la salle
     * @return id de la salle
     */
    public Salle getSalle() {
        return sal;
    }

    /**
     * Modifieur de la salle
     * @param res Chaîne de caractères définissant la nouvelle réservation de la salle
     */
    public void setSalle(Salle sal) {
        this.sal = sal;
    }
    
    /**
     * Accesseur de la caractéristique
     * @return caractéristique de la réservation
     */
    public Caracteristique getCaract() {
        return caract;
    }

    /**
     * Modifieur du id de la caractéristique
     * @param id Chaîne de caractères définissant le nouveau id de la caractéristique
     */
    public void setCaract(Caracteristique caract) {
        this.caract = caract;
    }
}