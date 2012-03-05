package metier;

/**
 * Classe métier permettant la définition et la gestion des objets 'AnneeUniveristaire'
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class AnneeUniversitaire {
    
    // Attributs
    private String nom_annee_univ;
    
    /**
     * Constructeur d'un objet AnneeUniversitaire prenant en compte un attribut
     * @param nom d'un objet année universitaire
     */
    public AnneeUniversitaire (String nom_annee_univ)
    {
        this.nom_annee_univ = nom_annee_univ;
    }

    /**
     * Accesseur du code d'un objet Année Universitaire
     * @return String - Nom année universitaire
     */
    public String getNomAnneeUniversitaire() {
        return nom_annee_univ;
    }

    /**
     * Modifieur du code d'un objet AnnéeUniversitaire
     * @param nom de l'objet AnnéeUniversitaire
     */
    public void setAnneeUniversitaire(String nom) {
        this.nom_annee_univ = nom ;
    }
}