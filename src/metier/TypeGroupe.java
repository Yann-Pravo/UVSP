package metier;

/**
 * Classe métier permettant de gérer les types de groupe d'étudiants.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class TypeGroupe {

    //Attributs
    private String nomTypeGroupe;

    /** Méthode permettant d'instancier un objet de la classe "TypeGroupe".
     * @param nomTypeGroupe Le nom du type de groupe.
     */
    public TypeGroupe(String nomTypeGroupe) {
        this.nomTypeGroupe = nomTypeGroupe;
    }

    public TypeGroupe() {}

    /** Méthode permettant d'accéder à la valeur du champ "nomTypeGroupe" d'un
     *  objet de la classe "TypeGroupe".
     * @return Renvoie une chaine de caractères représentant le nom du type
     *  de groupe.
     */
    public String getNomTypeGroupe() {
        return this.nomTypeGroupe;
    }

    /** Méthode permettant de modifier la valeur du champ "nomTypeGroupe" d'un
     *  objet de la classe "TypeGroupe".
     * @param nomTypeGroupe Le nouveau nom du type de groupe.
     */
    public void setNomTypeGroupe(String nomTypeGroupe) {
        this.nomTypeGroupe = nomTypeGroupe;
    }
}
