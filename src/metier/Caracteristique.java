package metier;

/**
 * Classe métier permettant la définition et la gestion des objets 'CaracteristiqueReservation'
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */

public class Caracteristique {

	// Attributs
	private String id;
	private String libelle;
	
	/**
     * Constructeur d'un objet CaracteristiqueReservation prenant en compte la reservation et la caractéristique
     * @param idSalle Id de la salle
     * @param idCaract Id de la caractéristique
     */
	
	public Caracteristique(String id, String libelle){
		this.id=id;
		this.libelle= libelle;
	}
	
	
	/**
     * Accesseur du id de la caracteristique
     * @return id de la caracteristique
     */
	
	public String getId() {
		return id;
	}
	
    /**
     * Modifieur de la caracteristique
     * @param id Chaîne de caractères définissant le nouvel id de la caracteristique
     */
	
	public void setId(String id) {
		this.id = id;
	}
	
	/**
     * Accesseur du libelle de la caracteristique
     * @return libelle de la caracteristique
     */
	
	public String getLibelle() {
		return libelle;
	}
	
    /**
     * Modifieur le libelle de la caracteristique
     * @param libelle Chaîne de caractères définissant la nouvelle caracteristique
     */
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
