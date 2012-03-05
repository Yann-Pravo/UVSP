package metier;

/**
 * Classe metier de gestion des groupes
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class Groupe {

	//Attributs
    private String code;
    public String lib;
    public Groupe pere;
    
    /**
     * Constructeur d'un groupe
     * @param code Code du groupe
     * @param lib Libellé du groupe
     * @param père Groupe père du groupe
     */
    public Groupe(String code, String lib, Groupe pere) {
        this.code = code;
        this.lib = lib;
        this.pere = pere;
    }

    /**
     * Constructeur d'un groupe qu'avec le code
     * @param code Code du groupe
     */
    public Groupe(String code) {
        this.code = code;
    }
    
    /**
     * Constructeur d'un groupe qu'avec le code
     * @param code Code du groupe
     */
    public Groupe(String code, String lib) {
        this.code = code;
        this.lib = lib;
    }

    /**
     * Recuperation du code du groupe
     * @return le code du groupe
     */
    public String getCode() {
        return code;
    }

    /**
     * Affectation du code du groupe
     * @param unNom le code du groupe
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    /**
     * Recuperation du libellé du groupe
     * @return Libellé du groupe
     */
    public String getLibelle() {
        return lib;
    }

    /**
     * Affectation du nombre d'étudiants du groupe
     * @param nbEtudiants le nombre d'étudiants du groupe
     */
    public void setLibelle(String lib) {
        this.lib = lib;
    }

    /**
     * Recuperation du père du groupe
     * @return Père du groupe
     */
    public Groupe getPere() {
        return pere;
    }

    /**
     * Affectation père du groupe
     * @param père du groupe
     */
    public void setPere(Groupe pere) {
        this.pere = pere;
    }
}