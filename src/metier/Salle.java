package metier;

/**
 * Classe métier permettant la définition et la gestion des objets 'Salle'
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class Salle implements java.io.Serializable {

    //Attributs
    private String nom;
    private Integer capacite;

    /**
     * Constructeur d'un objet Salle prenant en compte ses 2 attributs
     * @param nom Nom de la salle
     * @param capacite Nombre d'élèves maximum dans la salle
     */
    
    public Salle(String n, Integer c) {
        nom = n;
        capacite = c;
    }

    /**
     * Constructeur d'un objet Salle ne prenant en compte que son attribut nom
     * @param nom Nom de la salle
     */

    public Salle(String n) {
        nom = n;
    }

    /**
     * Accesseur du nom d'un objet Salle
     * @return String - Nom de la salle
     */

    public String getNom() {
        return nom;
    }

    /**
     * Accesseur de la capacité d'un objet Salle
     * @return Integer - Capacité de la salle
     */

    public Integer getCapacite() {
        return capacite;
    }

    /**
     * Modifieur du nom d'un objet Salle
     * @param nomSalle Chaîne de caractères définissant le nouveau nom de l'objet Salle
     */

    public void setNom(String nomSalle) {
        nom = nomSalle;
    }

    /**
     * Modifieur de la capacité d'un objet Salle
     * @param capSalle Entier définissant la nuvelle capacité de l'objet Salle
     */

    public void setCapacite(Integer capSalle) {
        capacite = capSalle;
    }
}

