package metier;

/**
 * Classe metier de gestion des SEE
 * @authors Ahardane Abdeslam, Balestrat Clment, Pravossoudovitch Yann
 * @version 1.0
 */
public class SEE {
	
    //Attributs
    private Enseignant lEnseignant;
    private Enseignement lEnseignement;
    private Groupe leGroupe;
    private String numStatutaire;

    /**
     * Constructeur d'un SEE avec tous les parametres
     * @param unEnseignant l'enseignant a affecter au SEE
     * @param unEnseignement l'enseignement a affecter au SEE
     * @param unGroupe le groupe a affecter au SEE
     * @param numStat le numero statutaire a affecter au SEE
     */
    public SEE(Enseignant unEnseignant, Enseignement unEnseignement, Groupe unGroupe, String numStat) {
        this.lEnseignant   = unEnseignant;
        this.lEnseignement = unEnseignement;
        this.leGroupe      = unGroupe;
        this.numStatutaire = numStat;
    }


    /**
     * Constructeur d'un SEE avec les parametre pour une liste
     * @param unCodeEnseignant le code de l'enseignant du SEE
     * @param nomEnseignant le nom de l'enseignant du SEE
     * @param prenomEnseignant le prenom de l'enseignant du SEE
     * @param codeMatiere le code de la matiere de l'enseignement du SEE
     * @param nomMatiere le nom de la matiere de l'enseignement du SEE
     * @param nomTypeEnseignement le nom du type de l'enseignement du SEE
     * @param nbHeuresReel le nombre d'heures reel de l'enseignement du SEE
     * @param nomGroupe le nom du groupe du SEE
     * @param numStat le numero statutaire du SEE
     */
    public SEE(String codeEnseignant, String nomEnseignant,
               String prenomEnseignant, String codeMatiere,
               String nomMatiere, String nomTypeEnseignement,
               Double nbHeuresReel, String nomGroupe, String numStat) {
    	this.lEnseignant   = new Enseignant(codeEnseignant, nomEnseignant, prenomEnseignant);
        this.lEnseignement = new Enseignement(new Matiere(codeMatiere, nomMatiere),
        				      new TypeEnseignement(nomTypeEnseignement),
                                              new TypeGroupe(),
                                              nbHeuresReel);
        this.leGroupe      = new Groupe(nomGroupe);
        this.numStatutaire = numStat;
    }

    /**
     * Recuperation de l'enseignant
     * @return l'enseignant concerne par le SEE
     */
    public Enseignant getEnseignant() {
        return lEnseignant;
    }

    /**
     * Affectation de l'enseignant
     * @param unEnseignant l'enseignant a affecter au SEE
     */
    public void setEnseignant(Enseignant unEnseignant) {
        this.lEnseignant = unEnseignant;
    }

    /**
     * Recuperation de l'enseignement
     * @return l'enseignement concerne par le SEE
     */
    public Enseignement getEnseignement() {
        return lEnseignement;
    }

    /**
     * Affectation de l'enseignement
     * @param unEnseignement l'enseignement a affecter au SEE
     */
    public void setEnseignement(Enseignement unEnseignement) {
        this.lEnseignement = unEnseignement;
    }

    /**
     * Recuperation du groupe
     * @return le groupe concerne par le SEE
     */
    public Groupe getGroupe() {
        return leGroupe;
    }

    /**
     * Affectation du groupe
     * @param unGroupe le groupe a affecter au SEE
     */
    public void setGroupe(Groupe unGroupe) {
        this.leGroupe = unGroupe;
    }

    /**
     * Recuperation du numero statutaire
     * @return le numero statutaire du SEE
     */
    public String getNumStatutaire() {
        return numStatutaire;
    }

    /**
     * Affectation du numero statutaire
     * @param numStat le numero statutaire a affecter au SEE
     */
    public void setNumStatutaire(String numStat) {
        this.numStatutaire = numStat;
    }
}
