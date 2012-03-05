package metier;

import persistance.*;
import java.util.ArrayList;

/**
 * Classe servant de fa√ßade entre le package "vue" et les classe métiers du package "persistance".
 * Cette classe contient une liste des types de groupe d'étudiants présente dans la base de données,
 * et elle implémente le design pattern Singleton afin de n'être instanciée qu'une seule fois.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class GestionnaireGroupeEtudiant {

    //Attributs
    DAO<TypeGroupe> typeGroupeDAO;
    private ArrayList<TypeGroupe> listeTypeGroupe;
    private static GestionnaireGroupeEtudiant gesGpeEtudiant;


    /**
     * Constructeur d'un objet GestionnaireGroupeEtudiant.
     * Son accès est privé afin de contrôler l'instanciation d'un objet unique (application du design pattern Singleton).
     */
    private GestionnaireGroupeEtudiant() {
        typeGroupeDAO = AbstractDAOFactory.getFactory(
                AbstractDAOFactory.DAO_FACTORY).getTypeGroupeDAO();
        listeTypeGroupe = typeGroupeDAO.getListe();
    }

    /** Méthode statique permettant de retourner le gestionnaire
     *  "GestionnaireGpeEtudiant". Si il n'est pas encore crée, la méthode
     *  l'instancie.
     *  @return Retourne le gestionnaire "GestionnaireGpeEtudiant"
     */
    public static GestionnaireGroupeEtudiant getGestionnaireGpeEtudiant() {
        if (gesGpeEtudiant == null) {
            gesGpeEtudiant = new GestionnaireGroupeEtudiant();
        }
        return gesGpeEtudiant;
    }


    /** Méthode permettant de supprimer un type de groupe. Si la
     *  suppression est réalisée sans problème, elle met à jour la liste des
     *  types de groupe par la même occasion.
     *  @param typeGpe Le type de groupe à supprimer.
     *  @return Renvoie VRAI si la suppression s'est réalisée. FAUX sinon.
     */
    public boolean deleteTypeGroupe(TypeGroupe typeGpe) {
        Boolean ok;
        ok = typeGroupeDAO.delete(typeGpe);
        if (ok) {
            listeTypeGroupe.remove(typeGpe);
        }
        return ok;
    }

    /** Méthode permettant d'obtenir la liste des types de groupe.
     *  @return Renvoie une liste contenant les types de groupe.
     */
    public ArrayList<TypeGroupe> getListeTypeGroupe() {
        return this.listeTypeGroupe;
    }

    /** Méthode permettant d'ajouter un nouveau type de groupe.
     * @param libelle Nom du nouveau type de groupe.
     * @return Renvoie VRAI si l'ajout a réussi. FAUX sinon.
     */
    public boolean ajouterTypeEnseignement(String libelle) {
        Boolean ok;
        TypeGroupe typeGpe = new TypeGroupe(libelle);
        ok = typeGroupeDAO.create(typeGpe);
        if (ok) {
            listeTypeGroupe.add(typeGpe);
        }
        return ok;
    }

    /** Méthode permmettant de modifier un type de groupe.
     * @param libelle Le libellé modifié du type.
     * @param typeGpe Le type de groupe concerné par la modification.
     * @return Renvoie VRAI si la modification a réussi. FAUX sinon.
     */
    public boolean modifierTypeGroupe(String libelle, TypeGroupe ancien) {
        Boolean ok;
        int index;
        TypeGroupe nouveau = new TypeGroupe(libelle);
        ok = typeGroupeDAO.update(ancien, nouveau);
        if (ok) {
            index = listeTypeGroupe.indexOf(ancien);
            listeTypeGroupe.remove(ancien);
            listeTypeGroupe.add(index, nouveau);
        }
        return ok;
    }
}
