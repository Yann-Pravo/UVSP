package metier;

import persistance.AbstractDAOFactory;
import persistance.DAO;
import java.util.ArrayList;

/**
 * Classe servant de faade entre le package "vue" et les classe mtiers du package "persistance".
 * Cette classe contient une liste des annes d'tudes prsentes dans la base de donnes,
 * et elle implmente le design pattern Singleton afin de n'tre instancie qu'une seule fois.
 * @authors Ahardane Abdeslam, Balestrat Clment, Pravossoudovitch Yann
 * @version 1.0
 */
public class GestionnaireEnseignant {

    DAO<Enseignant> enseignantDao;
    DAO<Statut> statutDao;

    private ArrayList<Enseignant> listeEnseignants;
    private ArrayList<Statut> listeStatuts;
    private static GestionnaireEnseignant ges_ens;

    /**
     * Constructeur d'un objet GestionnaireEnseignant.
     * * @return GestionnaireAnneeEtude - Instance unique de l'objet GestionnaireEnseignant
     */
    private GestionnaireEnseignant() {
        enseignantDao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getEnseignantDAO();
        statutDao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getStatutDAO();
        listeEnseignants = enseignantDao.getListe();
        listeStatuts = statutDao.getListe();
    }

    /**
     * Mthode permettant de renvoyer un objet unique de type GestionnaireEnseignant
     * @return GestionnaireEnseignant - Instance unique de l'objet GestionnaireEnseignant
     */
    public static GestionnaireEnseignant getInstance()
    {
        if (ges_ens == null)
        {
                ges_ens = new GestionnaireEnseignant();
        }
        return (ges_ens);
    }

    /**
     * Mthode qui permet de supprimer un enseignant
     * @param ens Enseignant ˆ supprimer
     */
    public void deleteEnseignant(Enseignant ens) {
        Boolean ok= enseignantDao.delete(ens);
        if ( ok )
            listeEnseignants.remove(ens);
    }

    /**
     * Mthode qui permet de supprimer un statut
     * @param statut Statut ˆ supprimer
     */
    public void deleteStatut(Statut statut) {
        Boolean ok= statutDao.delete(statut);
        if ( ok )
            listeStatuts.remove(statut);
    }

    /**
     * Accesseur de la liste des enseignants du gestionnaire
     * @return listeEnseignants - Liste des enseignants
     */
     public ArrayList<Enseignant> getListeEnseignants(){
        return listeEnseignants;
    }

     /**
      * Accesseur de la liste des statuts du gestionnaire
      * @return listeEnseignants - Liste des enseignants
      */
    public ArrayList<Statut> getListeStatuts() {
        return listeStatuts;
    }

    /**
     * Mthode qui permet l'ajout d'un enseignant
     * @param statut Statut de l'enseignant
     * @param code Code de l'enseignant
     * @param titre Titre de l'enseignant
     * @param nom Nom de l'enseignant
     * @param prenom Prenom de l'enseignant
     * @param adresse Adresse de l'enseignant
     * @param ville Ville de l'enseignant
     */
    public void ajouterEnseignant(String statut,String code,String titre,String nom, String prenom,String adresse, String ville) {
        Enseignant enseignant = new Enseignant(statut,code,titre,nom,prenom,adresse,ville);
        Boolean ok= enseignantDao.create(enseignant);
        if ( ok )
            listeEnseignants.add(enseignant);
    }

    /**
     * Mthode qui permet l'ajout d'un statut
     * @param s Nom du statut
     * @param h Nombres d'heures du statut
     */
    public void ajouterStatut(String s, Integer h) {
        Statut statut = new Statut(s,h);
        Boolean ok= statutDao.create(statut);
        if ( ok )
            listeStatuts.add(statut);
    }

    /**
     * Mthode qui permet de mettre ˆ jour un enseignant
     * @param ens Code de l'enseignant
     * @param statut Statut de l'enseignant
     * @param titre Titre de l'enseignant
     * @param nom Nom de l'enseignant
     * @param prenom Prenom de l'enseignant
     * @param adresse Adresse de l'enseignant
     * @param ville Ville de l'enseignant
     */
    public void modifierEnseignant(Enseignant ens, String statut, String titre, String nom, String prenom, String adresse, String ville) {
        listeEnseignants.remove(ens);
        ens.setNomStatut(statut);
        ens.setTitre(titre);
        ens.setNom(nom);
        ens.setPrenom(prenom);
        ens.setAdresse(adresse);
        ens.setVille(ville);

        Boolean ok= enseignantDao.update(ens);
        if ( ok )
            listeEnseignants.add(ens);
    }
}
