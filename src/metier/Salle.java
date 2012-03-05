package metier;

/**
 * Classe métier permettant la définition et la gestion des objets 'Salle'
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class Salle {

    //Attributs
	private String code;
    private String lib;

    // Attributs d'association
    private Batiment bat;
    
    /**
     * Constructeur d'un objet Salle prenant en compte ses 2 attributs
     * @param lib Libellé de la salle
     * @param code Code de la salle
     * @param bat Batiment de la salle
     */
    public Salle(String lib, String code, Batiment bat) {
        this.lib = lib;
        this.code = code;
        this.bat = bat;
    }

    /**
     * Constructeur d'un objet Salle ne prenant en compte que son attribut code
     * @param code Code de la salle
     */
    public Salle(String code) {
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
     * Accesseur du batiment d'un objet Salle
     * @return Batiment - Batiment de la salle
     */
    public Batiment getBatiment() {
        return this.bat;
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
    
    /**
     * Modifieur de la capacité d'un objet Salle
     * @param code Code de la salle Salle
     */
    public void setBatiment(Batiment bat) {
        this.bat = bat;
    }
}