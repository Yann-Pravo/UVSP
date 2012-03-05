package metier;

/**
 * Classe métier permettant la définition et la gestion des objets 'CaracteristiqueReservation'
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class CaracteristiqueReservation {

    // Attributs
    private Reservation res;
    private Caracteristique caract;
    
    /**
     * Constructeur d'un objet CaracteristiqueReservation prenant en compte la reservation et la caractéristique
     * @param idSalle Id de la salle
     * @param idCaract Id de la caractéristique
     */
    public CaracteristiqueReservation(Reservation res, Caracteristique caract) {
        this.res = res;
        this.caract = caract;
    }
    
    /**
     * Accesseur du id de la reservation
     * @return id de la reservation
     */
    public Reservation getReservation() {
        return res;
    }

    /**
     * Modifieur de la reservation
     * @param res Chaîne de caractères définissant la nouvelle réservation
     */
    public void setReservation(Reservation res) {
        this.res = res;
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
