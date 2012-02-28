package metier;

/**
 * Classe métier permettant de gérer les enseignements. Un enseignement est défini par
 * le code de sa matière, le nom de son type d'enseignement, le type de groupe
 * auquel il appartient, et son nombre d'heures réel.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class Enseignement {

    //Attributs
    private Double nbHeureReel;

    //Attributs d'association
    private Cours cours;
    private Groupe groupe;
    private Enseignant enseignant;

    /** Méthode permettant d'instancier un objet de la classe "Enseignement".
     * @param groupe Groupe de l'enseignement.
     * @param enseignant L'enseignant de cet enseignement.
     * @param Inbheures Le nombre d'heures réel de l'enseignement.
     */
    public Enseignement(Groupe groupe, Double Inbheures, Enseignant enseignant, Cours cours) {
        this.groupe = groupe;
        this.enseignant = enseignant;
        this.nbHeureReel = Inbheures;
        this.cours = cours;
    }

    /** Méthode permettant d'accéder à un objet de la classe "Enseignement".
     * @return Renvoie un nombre réel représentant le nombre d'heures réel de l'enseignenemt.
     */
    public Double getNbHeureReel() {
        return this.nbHeureReel;
    }

    /** Méthode permettant d'accéder à un objet de la classe "Enseignement".
     * @return Renvoie un objet représentant le groupe de l'enseignement.
     */
    public Groupe getGroupe() {
        return this.groupe;
    }

    /** Méthode permettant d'accéder à un objet de la classe "Enseignement".
     * @return Renvoie l'objet enseignant de l'enseignement.
     */
    public Enseignant getEnseignant() {
        return this.enseignant;
    }
    
    /** Méthode permettant d'accéder à un objet de la classe "Enseignement".
     * @return Renvoie l'objet cours de l'enseignement.
     */
    public Cours getCours() {
        return this.cours;
    }

    /** Méthode permettant de modifier la valeur du champ "nbHeureReel" d'un
     *  objet de la classe "Enseignement".
     * @param InbHeure le nouveau nombre d'heures r√©el.
     */
    public void setNbHeureReel(Double InbHeure) {
        this.nbHeureReel = InbHeure;
    }

    /** Méthode permettant de modifier la valeur du champ "groupe" d'un
     *  objet de la classe "Enseignement".
     * @param groupe Le nouveau groupe de l'enseignement.
     */
    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    /** Méthode permettant de modifier la valeur du champ "enseignant" d'un
     * objet de la classe "Enseignement".
     * @param enseignant Le nouveau enseignant.
     */
    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }
    
    /** Méthode permettant de modifier la valeur du champ "cours" d'un
     * objet de la classe "Enseignement".
     * @param cours Le nouveau cours.
     */
    public void setCours(Cours cours) {
        this.cours = cours;
    }
}