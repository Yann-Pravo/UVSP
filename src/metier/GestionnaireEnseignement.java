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
        typeEnseignementDAO = AbstractDAOFactory.getFactory(
        AbstractDAOFactory.DAO_FACTORY).getTypeEnseignementDAO();
        enseignementDAO = AbstractDAOFactory.getFactory(
        AbstractDAOFactory.DAO_FACTORY).getEnseignementDAO();
        listeTypeEnseignements = typeEnseignementDAO.getListe();
        listeEnseignements = enseignementDAO.getListe();
    }

    /** Méthode statique permettant de retourner le gestionnaire
     *  "GestionnaireEnseignement". Si il n'est pas encore crée, la méthode
     *  l'instancie.
     *  @return Retourne le gestionnaire "GestionnaireEnseignement"
     */
    public static GestionnaireEnseignement getGestionnaireEnseignement() {
        if (ges_Enseignement == null) {
            ges_Enseignement = new GestionnaireEnseignement();
        }
        return ges_Enseignement;
    }

    /** Méthode permettant de supprimer un type d'enseignement. Si la
     *  suppression est réalisée sans problème, elle met à jour la liste des
     *  types d'enseignement par la même occasion.
     *  @param typeEns Le type d'enseignement à supprimer.
     *  @return Renvoie VRAI si la suppression s'est réalisée. FAUX sinon.
     */
    public boolean deleteTypeEnseignement(TypeEnseignement typeEns) {
        Boolean ok;
        ok = typeEnseignementDAO.delete(typeEns);
        if (ok) {
            listeTypeEnseignements.remove(typeEns);
        }
        return ok;
    }

    /** Méthode permettant d'obtenir la liste des types d'enseignement.
     *
     *  @return Renvoie une liste contenant les types d'enseignement.
     */
    public ArrayList<TypeEnseignement> getListeTypeEnseignement() {
        return this.listeTypeEnseignements;
    }

    /** Méthode permettant d'ajouter un nouveau type d'enseignement.
     *
     * @param nom Nom du nouveau type d'enseignement.
     * @param heureTypeEns Nombre d'heure du nouveau type d'enseignement.
     * @param heureEquiTD Nombre d'heure de TD équivalent du nouveau type
     * d'enseignement.
     * @return Renvoie VRAI si l'ajout a réussi. FAUX sinon.
     */
    public boolean ajouterTypeEnseignement(String nom, Double heureTypeEns,
            Double heureEquiTD) {

        Boolean ok;
        TypeEnseignement typeEns = new TypeEnseignement(nom, heureTypeEns,
                heureEquiTD);
        ok = typeEnseignementDAO.create(typeEns);
        if (ok) {
            listeTypeEnseignements.add(typeEns);
        }
        return ok;
    }

    /** Méthode permmettant de modifier un type d'enseignement.
     *
     * @param nom Le nom modifié du type.
     * @param heureTypeEns Le nombre d'heure d'enseignement modifié du type.
     * @param heureEquiTD Le nombre d'heure de TD équivalent modifié du type.
     * @param typeEns Le type d'enseignement concerné par la modification.
     * @return Renvoie VRAI si la modification a réussi. FAUX sinon.
     */
    public boolean modifierTypeEnseignement(String nom, Double heureTypeEns,
            Double heureEquiTD, TypeEnseignement ancien) {

        Boolean ok;
        int index;
        TypeEnseignement nouveau = new TypeEnseignement(nom, heureTypeEns,
                heureEquiTD);
        ok = typeEnseignementDAO.update(ancien, nouveau);
        if (ok) {
            index = listeTypeEnseignements.indexOf(ancien);
            listeTypeEnseignements.remove(ancien);
            listeTypeEnseignements.add(index, nouveau);
        }
        return ok;
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
    public boolean ajouterEnseignement(TypeEnseignement typeEns,
            Matiere mat, TypeGroupe tGpe, double nbHeure) {

        Boolean ok;
        Enseignement ens = new Enseignement(mat, typeEns, nbHeure, tGpe);
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
    public boolean modifierEnseignement(TypeEnseignement typeEns,
            Matiere mat, TypeGroupe tGpe, double nbHeure,
            Enseignement ancien) {
        Boolean ok;
        int index;
        Enseignement nouveau = new Enseignement(mat, typeEns, nbHeure, tGpe);
        ok = enseignementDAO.update(ancien, nouveau);
        if (ok) {
            index = listeEnseignements.indexOf(ancien);
            listeEnseignements.remove(ancien);
            listeEnseignements.add(index, nouveau);
        }
        return ok;
    }
}
