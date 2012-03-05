package metier;

/**
 * Classe métier permettant la définition et la gestion des objets 'TypeCours'
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class TypeCours {
	
    //Attributs
    private String nom_type_cours;
    /**
     * Constructeur d'un objet TypeCours prenant en compte un attribut
     * @param nom d'un objet TypeCours
     */
    public TypeCours (String nom_type_cours)
    {
        this.nom_type_cours = nom_type_cours;
    }

    /**
     * Accesseur du code d'un objet Typecours 
     * @return String - Nom a TypeCours 
     */
    public String getNomTypeCours() {
        return nom_type_cours ;
    }

    /**
     * Modifieur du code d'un objet TypeCours 
     * @param nom de l'objet TypeCours 
     */
    public void setNomTypeCours (String nom) {
        this.nom_type_cours  = nom ;
    }
}

