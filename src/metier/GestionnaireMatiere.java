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
    ArrayList<Matiere> listeMatieres;
    private static final GestionnaireMatiere instance = new GestionnaireMatiere();

    /**
     * Constructeur d'un objet GestionnaireMatiere.
     * Son accès est privé afin de contrôler l'instanciation d'un objet unique (application du design pattern Singleton).
     */
    private GestionnaireMatiere() {
        matiereDao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getMatiereDAO();
        listeMatieres = matiereDao.getListe();
    }

    /**
     * Méthode permettant de renvoyer un objet unique de type GestionnaireMatiere
     * @return GestionnaireMatiere - Instance unique de l'objet GestionnaireMatiere
     */
    public final static GestionnaireMatiere getInstance() {
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
        return listeMatieres;
    }
    
    /**
     * Méthode qui permet l'ajout d'une matière
     * @param nom Nom de la matière
     * @param ue UE correspondant à la matière
     * @param resp Enseignant responsable de la matière
     */
    public void addMatiere(String nom, UE ue, Enseignant resp) {
        Matiere matiere = new Matiere(nom, ue, resp);
        Boolean ok= matiereDao.create(matiere);
        if ( ok )
            listeMatieres.add(matiere);
    }
    
    /**
     * Méthode qui permet la modification d'une matière
     * @param nom Nom de la matière
     * @param ue UE correspondant à la matière
     * @param resp Enseignant responsable de la matière
     */
    public void updateMatiere(Matiere matiere, String nom, UE ue, Enseignant resp) {
        listeMatieres.remove(matiere);
        matiere.setNomMat(nom);
        matiere.setUEMat(ue);
        matiere.setResponsable(resp);

        Boolean ok= matiereDao.update(matiere);
        if ( ok )
            listeMatieres.add(matiere);
    }

    /**
     * Méthode qui permet de supprimer une matiere
     * @param m Matiere à supprimer
     */
    public void deleteMatiere(Matiere m) {
        Boolean ok = matiereDao.delete(m);
        if (ok) {
            listeMatieres.remove(m);
        }
    }

}
