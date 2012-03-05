package metier;

import java.util.Date;

/**
 * Classe mtier permettant la dfinition et la gestion des objets 'Enseignant'
 * @authors Ahardane Abdeslam, Balestrat Clment, Pravossoudovitch Yann
 * @version 1.0
 */
public class Enseignant {

	//Attributs
    private String codeEnseignant;
    private String nom;
    private String prenom;
    public Date dateNaissance;
    public String ville;
    public String codePostal;
    public String adresse;
    public String titre;
    public Integer heures;

    /**
     * Constructeur d'un objet Enseignant prenant en compte ses 7 attributs
     * @param code Code de l'enseignant
     * @param heures Nombres d'heure de l'enseignant
     * @param titre Titre de l'enseignant
     * @param nom Nom de l'enseignant
     * @param prenom Prenom de l'enseignant
     * @param adresse Adresse de l'enseignant
     * @param ville Ville de l'enseignant
     */
    public Enseignant(String code, Integer heures, String titre, String nom,
                      String prenom, String adresse, String ville)
    {
        this.codeEnseignant = code;
        this.heures = heures;
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
    }

    /**
     * Constructeur d'un objet Enseignant prenant en compte 4 attributs
     * @param codeEnseignant Code de l'enseignant
     * @param heures Nombre d'heures de l'enseignant
     * @param nom Nom de l'enseignant
     * @param prenom Prenom de l'enseignant
     */
    public Enseignant(String codeEnseignant, Integer heures, String nom, String prenom)
    {
        this.codeEnseignant = codeEnseignant;
    	this.heures = heures;
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * Constructeur d'un objet Enseignant prenant en compte 1 seul attribut
     * @param codeEnseignant Code de l'enseignant
     */
    public Enseignant(String codeEnseignant) {
        this.codeEnseignant=codeEnseignant;
    }

    /**
     * Constructeur d'un objet Enseignant prenant en compte 3 attributs
     * @param codeEnseignant Code de l'enseignant
     * @param nom Nom de l'enseignant
     * @param prenom Prenom de l'enseignant
     */
    public Enseignant(String codeEnseignant, String nom, String prenom) {
        this.codeEnseignant=codeEnseignant;
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * Accesseur du code enseignant
     * @return String - code enseignant
     */
    public String getCodeEnseignant() {
        return codeEnseignant;
    }

    /**
     * Modifieur du code enseignant
     * @param codeEnseignant Cha”ne de caractres dfinissant le nouveau code enseignant
     */
    public void setCodeEnseignant(String codeEnseignant) {
        this.codeEnseignant = codeEnseignant;
    }

    /**
     * Accesseur du code enseignant
     * @return String - code enseignant
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifieur du nom de l'enseignant
     * @param nom Cha”ne de caractres dfinissant le nouveau nom de l'enseignant
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Accesseur du code enseignant
     * @return String - code enseignant
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifieur du prnom de l'enseignant
     * @param prenom Cha”ne de caractres dfinissant le nouveau prnom de l'enseignant
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Accesseur du code enseignant
     * @return String - code enseignant
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Modifieur de l'adresse de l'enseignant
     * @param adresse Cha”ne de caractres dfinissant la nouvelle adresse de l'enseignant
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Accesseur du code code postal
     * @return String - code postal
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * Modifieur du code postal de l'enseignant
     * @param codePostal Cha”ne de caractres dfinissant le nouveau code postal de l'enseignant
     */
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * Accesseur de la date de naissance
     * @return Date - date de naissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Modifieur de la date de naissance de l'enseignant
     * @param dateNaissance Date dfinissant la nouvelle date de naissance de l'enseignant
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Accesseur du titre de l'enseignant
     * @return String - titre de l'enseignant
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Modifieur du titre de l'enseignant
     * @param titre Cha”ne de caractres dfinissant le nouveau titre de l'enseignant
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Accesseur de la ville de l'enseignant
     * @return String - ville de l'enseignant
     */
    public String getVille() {
        return ville;
    }

    /**
     * Modifieur de la ville de l'enseignant
     * @param ville Cha”ne de caractres dfinissant la nouvelle ville de l'enseignant
     */
    public void setVille(String ville) {
        this.ville = ville;
    }
    
    /**
     * Accesseur du nombre d'heures de l'enseignant
     * @return Integer - nombre d'heures de l'enseignant
     */
    public Integer getHeures() {
        return heures;
    }

    /**
     * Modifieur du nombre d'heures de l'enseignant
     * @param heures Integer dfinissant le nouveau nombre d'heures de l'enseignant
     */
    public void setHeures(Integer heures) {
        this.heures = heures;
    }
}