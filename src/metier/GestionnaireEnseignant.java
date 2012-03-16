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

    private ArrayList<Enseignant> listeEnseignants;
    private static GestionnaireEnseignant ges_ens;

    /**
     * Constructeur d'un objet GestionnaireEnseignant.
     * * @return GestionnaireAnneeEtude - Instance unique de l'objet GestionnaireEnseignant
     */
    private GestionnaireEnseignant() {
        enseignantDao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getEnseignantDAO();
        listeEnseignants = enseignantDao.getListe();
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
        int i = 0;
        while (ens.getIdEns() != listeEnseignants.get(i).getIdEns())
        {
                i++;
        }
        listeEnseignants.remove(i);
        enseignantDao.delete(ens);
    }

    /**
     * Accesseur de la liste des enseignants du gestionnaire
     * @return listeEnseignants - Liste des enseignants
     */
     public ArrayList<Enseignant> getListeEnseignants(){
        return listeEnseignants;
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
    public void addEnseignant(String nom, String prenom, String mdp, int su) {
        Enseignant enseignant = new Enseignant(nom, prenom, mdp, su);
        Boolean ok= enseignantDao.create(enseignant);
        if ( ok )
            listeEnseignants.add(enseignant);
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
    public void updateEnseignant(Enseignant ens, String nom, String prenom, String mdp, int su) {
        int i = 0;
        while (ens.getIdEns() != listeEnseignants.get(i).getIdEns())
        {
                i++;
        }
        listeEnseignants.remove(i);
        ens.setNom(nom);
        ens.setPrenom(prenom);
        ens.setMdp(mdp);
        ens.setSu(su);

        Boolean ok= enseignantDao.update(ens);
        if ( ok )
            listeEnseignants.add(ens);
    }
}
