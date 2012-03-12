package metier;

import persistance.AbstractDAOFactory;
import persistance.DAO;
import java.util.ArrayList;

/**
 * Classe servant de façade entre le package "vue" et les classe métiers du package "persistance".
 * Cette classe contient une liste des enseignements présentes dans la base de données,
 * et elle implémente le design pattern Singleton afin de n'être instanciée qu'une seule fois.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class GestionnaireEnseignement {

    //Attributs
    DAO<Enseignement> enseignementDAO;
    private ArrayList<Enseignement> listeEnseignements;
    private static GestionnaireEnseignement ges_Enseignement;

    /**
     * Constructeur d'un objet GestionnaireEnseignement.
     * Son accès est privé afin de contrôler l'instanciation d'un objet unique (application du design pattern Singleton).
     */
    private GestionnaireEnseignement() {
        enseignementDAO = AbstractDAOFactory.getFactory(
        AbstractDAOFactory.DAO_FACTORY).getEnseignementDAO();
        listeEnseignements = enseignementDAO.getListe();
    }

    /** Méthode statique permettant de retourner le gestionnaire
     *  "GestionnaireEnseignement". Si il n'est pas encore crée, la méthode
     *  l'instancie.
     *  @return Retourne le gestionnaire "GestionnaireEnseignement"
     */
    public static GestionnaireEnseignement getInstance() {
        if (ges_Enseignement == null) {
            ges_Enseignement = new GestionnaireEnseignement();
        }
        return ges_Enseignement;
    }

    /** Méthode permettant de supprimer un enseignement. Si la
     *  suppression est réalisée sans problème, elle met à jour la liste des
     *  enseignements par la même occasion.
     *  @param ens L'enseignement à supprimer.
     *  @return Renvoie VRAI si la suppression s'est réalisée. FAUX sinon.
     */
    public boolean deleteEnseignement(Enseignement ens) {
        Boolean ok;
        ok = enseignementDAO.delete(ens);
        if (ok) {
            listeEnseignements.remove(ens);
        }
        return ok;
    }

    /** Méthode permettant d'obtenir la liste des enseignements.
     *  @return Renvoie une liste contenant les enseignements.
     */
    public ArrayList<Enseignement> getListeEnseignements() {
        return this.listeEnseignements;
    }

    /** Méthode permettant d'ajouter un nouvel enseignement.
     * @param typeEns Le type de l'enseignement.
     * @param mat La code de la matière de l'enseignement.
     * @param tGpe Le type de groupe de l'enseignement.
     * @param nbHeure Le nombre d'heures réel de l'enseignement.
     * @return Renvoie VRAI si l'ajout a réussi. FAUX sinon.
     */
    public boolean addEnseignement(Matiere mat,Cours cours, Groupe groupe, Enseignant enseignant, double nbHeure) {

        Boolean ok;
        Enseignement ens = new Enseignement(groupe, nbHeure, enseignant, cours);
        ok = enseignementDAO.create(ens);
        if (ok) {
            listeEnseignements.add(ens);
        }
        return ok;
    }

    /** Méthode permettant de modifier un enseignement.
     * @param typeEns Le type d'enseignement modifié.
     * @param mat La matière maodifiée.
     * @param tGpe Le type de groupe modifié.
     * @param nbHeure Le nombre d'heures réel modifié, de l'enseignement.
     * @param ancien L'enseignement à modifier.
     * @return Renvoie VRAI si la modification a réussi. FAUX sinon.
     */
    public void updateEnseignement(Enseignement ens, Cours cours, Groupe groupe, Enseignant enseignant, double nbHeure) {
        listeEnseignements.remove(ens);
        ens.setCours(cours);
        ens.setGroupe(groupe);
        ens.setEnseignant(enseignant);
        ens.setNbHeureReel(nbHeure);

        Boolean ok= enseignementDAO.update(ens);
        if ( ok )
            listeEnseignements.add(ens);
    }
}
