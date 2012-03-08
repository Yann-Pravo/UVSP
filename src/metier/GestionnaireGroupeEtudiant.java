package metier;

import persistance.AbstractDAOFactory;
import persistance.DAO;
import java.util.ArrayList;

/**
 * Classe gestionnaire pour la gestion des Groupe
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class GestionnaireGroupeEtudiant {

    /**
     * DAO des groupes
     */
    DAO<Groupe> groupeDao;

    /**
     * Liste des groupes
     */
    private ArrayList<Groupe> listeGroupes;

    /**
     * Instance unique de la classe GestionnaireGroupe -> singleton
     */
    private static GestionnaireGroupeEtudiant gesGroupe;

    /**
     * Constructeur prive pour une classe singleton
     */
    private GestionnaireGroupeEtudiant() {
    	groupeDao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY)
                                      .getGroupeDAO();
        listeGroupes = groupeDao.getListe();
    }

    /**
     * Methode qui retourne l'instance du gestionnaire si elle existe,
     * Sinon utilise le constructeur pour la creer
     * @return l'instance du gestionaire
     */
    public static GestionnaireGroupeEtudiant getGestionnaireGroupe() {
        if (gesGroupe == null)
                gesGroupe = new GestionnaireGroupeEtudiant();
        return (gesGroupe);
    }
    
    /**
     * Recuperation de la liste des groupes
     * @return un ArrayList<Groupe> qui contient les groupes
     */
    public ArrayList<Groupe> getListeGroupes() {
        return listeGroupes;
    }
}
