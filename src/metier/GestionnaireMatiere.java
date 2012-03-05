package metier;

import persistance.*;
import java.util.*;

/**
 * Classe servant de façade entre le package "vue" et les classe métiers du package "persistance".
 * Cette classe contient une liste des matières présentes dans la base de données,
 * et elle implémente le design pattern Singleton afin de n'être instanciée qu'une seule fois.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class GestionnaireMatiere {

	//Attributs
    DAO<Matiere> matiereDao;
    ArrayList<Matiere> listeMat;
    ArrayList<Matiere> listeMatAE;
    private static final GestionnaireMatiere instance = new GestionnaireMatiere();

    /**
     * Constructeur d'un objet GestionnaireMatiere.
     * Son accès est privé afin de contrôler l'instanciation d'un objet unique (application du design pattern Singleton).
     */
    private GestionnaireMatiere() {
        matiereDao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getMatiereDAO();
        listeMat = matiereDao.getListe();
    }

    /**
     * Méthode permettant de renvoyer un objet unique de type GestionnaireMatiere
     * @return GestionnaireMatiere - Instance unique de l'objet GestionnaireMatiere
     */
    public final static GestionnaireMatiere getGestionnaireMatiere() {
        return instance;
    }

    /**
     * Méthode qui renvoie l'objet Matiere correspondant au nom en paramètre
     * @param nom Nom de la matière recherchée
     * @return Matiere - L'objet Matiere recherché
     */
    public Matiere getMatiere(String nom) {
        return this.matiereDao.find(new Matiere(nom));
    }

    /**
     * Méthode qui renvoie la liste de matières
     * @return listeMat - Liste de matières
     */
    public ArrayList<Matiere> getListeMatiere() {
        return listeMat;
    }

    /**
     * Accesseur de la liste des années d'étude du gestionnaire
     * @return ArrayList<AnneeEtude> - Liste des années d'études du gestionnaire
     */
    public ArrayList<Matiere> getListeMatiere(AnneeEtude a) {
        listeMatAE = listeMat; // copie partielle ou pas?
        for (int i=0; i<listeMatAE.size(); i++)
            if (! listeMatAE.get(i).getUE().getSem().getAnneeEtude().getNomAnnee()
                .equalsIgnoreCase(a.getNomAnnee()))
                listeMatAE.remove(i);
        return listeMatAE;
    }

    /**
     * Méthode qui permet de supprimer une matiere
     * @param m Matiere √† supprimer
     */
    public void deleteMatiere(Matiere m) {
        Boolean ok = matiereDao.delete(m);
        if (ok) {
            listeMat.remove(m);
        }
    }

    /**
     * Méthode qui permet de mettre à jour l'annee d'etude
     * @param nom Nom de la matière
     * @param descr Description de la matière
     * @param coeff Coefficient de la matière dans l'UE
     * @param nomUE Nom de l'UE associé à la matiere
     */
    public void updateAnneeEtude(String code, String nom, String descr, Integer coeff, String nomUE) {
        UE u = new UE(nomUE);
        Matiere m = new Matiere(code, nom, descr, coeff, u);
        Boolean ok = matiereDao.update(m);
        if (ok) {
            listeMat.add(m);
        }
    }

    /**
     * Méthode qui permet l'ajout de l'anne d'etude
     * @param descr Description de la matière
     * @param coeff Coefficient de la matière dans l'UE
     * @param nomUE Nom de l'UE associé à la matiere
     */
    public void ajouterAnneeEtude(String code, String lib, String nomUE, Enseignant resp) {
        UE u = new UE(nomUE);
        Matiere m = new Matiere(code, lib, u, resp);
        Boolean ok = matiereDao.create(m);
        if (ok) {
            listeMat.add(m);
        }
    }
}
