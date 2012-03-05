package metier;

/**
 * Classe métier permettant la définition et la gestion des objets 'Salle'
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class Batiment{

    //Attributs
	private String code;
    private String lib;
    
    /**
     * Constructeur d'un objet Batiment prenant en compte ses 2 attributs
     * @param lib Libellé de la salle
     * @param code Code de la salle
     */
    public Batiment(String lib, String code) {
        this.lib = lib;
        this.code = code;
    }

    /**
     * Constructeur d'un objet Batiment ne prenant en compte que son attribut code
     * @param code Code du batiment
     */
    public Batiment(String code) {
        this.code = code;
    }

    /**
     * Accesseur du libellé d'un objet Salle
     * @return String - Libellé de la salle
     */
    public String getLibelle() {
        return lib;
    }

    /**
     * Accesseur du code d'un objet Salle
     * @return String - Code de la salle
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Modifieur du libellé d'un objet Salle
     * @param lib - Chaîne de caractères définissant le nouveau nom de l'objet Salle
     */
    public void setLibelle(String lib) {
        this.lib = lib;
    }

    /**
     * Modifieur de la capacité d'un objet Salle
     * @param code Code de la salle Salle
     */
    public void setCode(String code) {
        this.code = code;
    }
}