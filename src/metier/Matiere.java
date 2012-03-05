package metier;

/**
 * Classe métier permettant la définition et la gestion des objets 'Matiere'
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class Matiere {

    // Attributs
    private String code;
    private String lib;

    // Attributs d'association
    private UE u;
    private Enseignant resp;
    
    /**
     * Constructeur d'un objet Matiere prenant en compte le nom uniquement
     * @param lib Libellé de la matière
     */
    public Matiere(String lib) {
        this.lib = lib;
    }

    /**
     * Constructeur d'un objet Matiere prenant en compte son code et son nom
     * @param code Code de la matière
     * @param lib Libellé de la matière
     */
    public Matiere(String code, String lib) {
        this.code = code;
        this.lib = lib;
    }

    /**
     * Constructeur d'un objet Matiere prenant en compte son code et son nom
     * @param code Code de la matière
     * @param lib Libellé de la matière
     * @param u L'unité d'enseignement associé à la matière
     */
    public Matiere(String code, String lib, UE u) {
        this.code = code;
        this.lib = lib;
        this.u = u;
    }

    /**
     * Constructeur d'un objet Matiere prenant en compte son nom, sa description
     * et son coefficient
     * @param code Code de la matière
     * @param lib Libellé de la matière
     * @param u UE associé à la matiere
     * @param resp Responsable de la matiere
     */
    public Matiere (String code, String lib, UE u, Enseignant resp)
    {
        this.code = code;
        this.lib = lib;
        this.u = u;
        this.resp = resp;
    }

    public Matiere(String code, int db) {
        this.code = code;
    }

    /**
     * Accesseur du code de m'objet Matiere
     * @return code de la matière
     */
    public String getCode() {
        return code;
    }

    /**
     * Modifieur du code de la matière
     * @param code Chaîne de caractères définissant le nouveau code de la matière
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Accesseur du coefficient d'un objet Matiere
     * @return Integer - Coefficient de l'objet Matière
     */
    public Enseignant getResponsable() {
        return resp;
    }

    /**
     * Modifieur du coefficient d'un objet Matiere
     * @param coeff Entier définissant le nouveau coefficient de l'objet Matiere
     */
    public void setResponsable(Enseignant resp) {
        this.resp = resp;
    }

    /**
     * Accesseur du nom d'un objet Matiere
     * @return String - Nom de l'objet Matière
     */
    public String getLibelle() {
        return lib;
    }

    /**
     * Modifieur du nom d'un objet Matiere
     * @param nom Chaîne de caractères définissant le nouveau nom de l'objet Matiere
     */
    public void setLibelle(String lib) {
        this.lib = lib;
    }

    /**
     * Accesseur sur l'UE associées à un objet Matiere
     * @return UE L'UE associés à une matière
     */
    public UE getUE() {
        return u;
    }

    /**
     * Modificateur de l'UE associée à un objet Matiere
     * @param u L'UE associée à une matière
     */
    public void setUE(UE u) {
        this.u = u;
    }
}