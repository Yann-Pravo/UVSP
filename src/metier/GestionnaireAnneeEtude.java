package metier;

import java.util.*;
import persistance.*;

/**
 * Classe servant de façade entre le package "vue" et les classe métiers du package "persistance".
 * Cette classe contient une liste des années d'études présentes dans la base de données,
 * et elle implémente le design pattern Singleton afin de n'être instanciée qu'une seule fois.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class GestionnaireAnneeEtude {

    // Objet de type "DAO" AnneeEtude assurant la correspondance avec la base de données
    DAO<AnneeEtude> anneeDao;
    // Objet de type "DAO" Semestre assurant la correspondance avec la base de données
    DAO<Semestre> semestreDao;
    // Liste des matières contenues dans la base
    ArrayList<AnneeEtude> listeAnnee;
    // Liste des semestres contenus dans la base
    ArrayList<Semestre> listeSemestre;
    // Instance d'un objet GestionnaireMatiere
    private static final GestionnaireAnneeEtude instance = new GestionnaireAnneeEtude();

    /**
     * Constructeur d'un objet GestionnaireAnneeEtude.
     * Son accès est privé afin de contrôler l'instanciation d'un objet unique (application du design pattern Singleton).
     */
    private GestionnaireAnneeEtude () {
        // Initialisation du DAO de AnneeEtude (une seule et unique instance)
        this.anneeDao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getAnneeEtudeDAO();
        // Initialisation de la liste des ann√©es d'√©tude
        this.listeAnnee = new ArrayList();
        // Initialisation du DAO de Semestre (une seule et unique instance)
        this.semestreDao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getSemestreDAO();
        // Initialisation de la liste des semestres
        this.listeSemestre = new ArrayList();
    }

    /**
     * Méthode permettant de renvoyer un objet unique de type GestionnaireAnneeEtude
     * @return GestionnaireAnneeEtude - Instance unique de l'objet GestionnaireAnneeEtude
     */
    public final static GestionnaireAnneeEtude getGestionnaireAnneeEtude () {
        return instance;
    }

    /**
     * Accesseur de la liste des années d'étude du gestionnaire
     * @return ArrayList<AnneeEtude> - Liste des années d'études du gestionnaire
     */
    public ArrayList<AnneeEtude> getListeAnnee() {
        return listeAnnee;
    }

    /**
     * Modifieur de la liste des années d'étude du gestionnaire
     * @param listeAnnee Nouvelle liste d'objets AnneeEtude
     */
    public void setListeAnnee(ArrayList<AnneeEtude> listeAnnee) {
        this.listeAnnee = listeAnnee;
    }

    /**
     * Accesseur de la liste des semestres du gestionnaire
     * @return ArrayList<Semestre> - Liste des semestres du gestionnairs
     */
    public ArrayList<Semestre> getListeSemestre() {
        return listeSemestre;
    }

    /**
     * Modifieur de la liste des semestres du gestionnaire
     * @param listeSemestre Nouvelle liste d'objets Semestre
     */
    public void setListeSemestre(ArrayList<Semestre> listeSemestre) {
        this.listeSemestre = listeSemestre;
    }

    /**
     * Méthode qui renvoie l'objet AnneeEtude correspondant au nom de l'année passée en paramètre
     * @param nom Nom de l'année d'étude recherchée
     * @return AnneeEtude - L'objet AnneeEtude recherché
     */
    public AnneeEtude getAnneeEtude (String nom) {
        return this.anneeDao.find(new AnneeEtude (nom));
    }

    /**
     * Méthode qui renvoie l'objet Semestre correspondant au nom du semestre et
     * de l'année d'étude passés en paramètre
     * @param nomSem Nom du semestre recherché
     * @param nom Nom de l'année d'étude correspondant au semestre recherché
     * @return Semestre - L'objet Semestre recherché
     */
    public Semestre getSemestre (String nomSem, AnneeEtude annee) {
        return this.semestreDao.find(new Semestre (nomSem, annee));
    }
    /**
     * Méthode qui retourne la liste des semestres correspondant à l'année d'étude
     * dont le nom est passé en paramètre
     * @param annee Nom de l'année d'étude pour laquelle on souhaite la liste des semestres associées
     * @return ArrayList<Semestre> - Liste des semestres associées à l'année d'étude en paramètre
     */
    public ArrayList<Semestre> getSemestre (String annee) {
        return ((SemestreDAO)this.semestreDao).getSemestreByAnnee(annee);
    }

    /**
     * Méthode qui permet de supprimer une annee d'étude
     * @param a Annne d'etude à supprimer
     */
    public void deleteAnneeEtude(AnneeEtude a) {
        Boolean ok= anneeDao.delete(a);
        if ( ok )
            listeAnnee.remove(a);
    }

    /**
     * Méthode qui permet de supprimer un semestre
     * @param s Semestre d'etude à supprimer
     */
    public void deleteSemestre(Semestre s) {
        Boolean ok= semestreDao.delete(s);
        if ( ok )
            listeSemestre.remove(s);
    }

    /**
     * Méthode qui permet de mettre à jour de l'annee d'etude
     * @param nomAnnee Nom de l'année d'étude
     * @param description Description de l'année d'étude
     * @param dureeSeance Durée d'une séance de cours
     * @param nbSeanceAM Nombre de séances de cours le matin
     * @param nbSeancePM Nombre de séances de cours le soir
     * @param nomFormation Nom de la formation à laquelle appartient l'annee d'etude
     */
    public void updateAnneeEtude(String nomAnnee,String description,
            Integer dureeSeance,Integer nbSeanceAM,Integer nbSeancePM,String nomFormation) {
        Formation f = new Formation(nomFormation);
        AnneeEtude a = new AnneeEtude(nomAnnee,description,dureeSeance,nbSeanceAM,nbSeancePM,f);
        Boolean ok= anneeDao.update(a);
        if ( ok )
            listeAnnee.add(a);
    }

    /**
     * Méthode qui permet de mettre à jour le semestre
     * @param nomSemestre Nom du semestre
     * @param nomAnneeEtude Nom de l'année d'étude
     * @param niveau Niveau du semestre
     */
    public void updateSemestre(String nomSemestre, String nomAnneeEtude, Integer niveau) {
        AnneeEtude a = new AnneeEtude(nomAnneeEtude);
        Semestre s = new Semestre(nomSemestre,a,niveau);
        Boolean ok= semestreDao.update(s);
        if ( ok )
            listeSemestre.add(s);
    }

    /**
     * Méthode qui permet l'ajout de l'anne d'etude
     * @param nomAnnee Nom de l'année d'étude
     * @param description Description de l'année d'étude
     * @param dureeSeance Durée d'une séance de cours
     * @param nbSeanceAM Nombre de séances de cours le matin
     * @param nbSeancePM Nombre de séances de cours le soir
     * @param nomFormation Nom de la formation à laquelle appartient l'annee d'etude
     */
    public void ajouterAnneeEtude(String nomAnnee,String description,
            Integer dureeSeance,Integer nbSeanceAM,Integer nbSeancePM,String nomFormation) {
        Formation f = new Formation(nomFormation);
        AnneeEtude a = new AnneeEtude(nomAnnee,description,dureeSeance,nbSeanceAM,nbSeancePM,f);
        Boolean ok= anneeDao.create(a);
        if ( ok )
            listeAnnee.add(a);
    }

    /**
     * Méthode qui permet de mettre à jour le semestre
     * @param nomSemestre Nom du semestre
     * @param nomAnneeEtude Nom de l'année d'étude
     * @param niveau Niveau du semestre
     */
    public void ajouterSemestre(String nomSemestre, String nomAnneeEtude, Integer niveau) {
        AnneeEtude a = new AnneeEtude(nomAnneeEtude);
        Semestre s = new Semestre(nomSemestre,a,niveau);
        Boolean ok= semestreDao.create(s);
        if ( ok )
            listeSemestre.add(s);
    }
}
