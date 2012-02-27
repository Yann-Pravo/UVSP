package metier;

/**
 * Classe métier permettant la définition et la gestion des objets 'TypeConges'
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class TypeConge {

    //Attributs
    private String nom_type_conge;

    /**
     * Constructeur d'un objet TypeConge prenant en compte un attribut
     * @param nom d'un objet TypeConge
     */
    public TypeConge (String nom_type_conge)
    {
        this.nom_type_conge = nom_type_conge;
    }

    /**
     * Accesseur du code d'un objet TypeConge
     * @return String - Nom aTypeConge
     */
    public String getNomTypeConge() {
        return nom_type_conge;
    }

    /**
     * Modifieur du code d'un objet TypeConge
     * @param nom de l'objet TypeConge
     */
    public void setNomTypeConge(String nom) {
        this.nom_type_conge = nom ;
    }
}

