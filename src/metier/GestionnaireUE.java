package metier;

import persistance.*;
import java.util.ArrayList;

/**
 * Classe servant de façade entre le package "vue" et les classe métiers du package "persistance".
 * Cette classe contient une liste des Ues présentes dans la base de données,
 * et elle implémente le design pattern Singleton afin de n'être instanciée qu'une seule fois.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */

public class GestionnaireUE {

	//Attributs
    DAO<UE> UEDao;
    DAO<Semestre> semestreDao;
    DAO<AnneeEtude> anneeEtudeDao;
    DAO<Matiere> matiereDao;

    private ArrayList<UE> listeUEs;
    private ArrayList<Semestre> listeSemestre;
    private ArrayList<AnneeEtude> listeAnneeEtude;
    private static GestionnaireUE gestUE;

    /**
     * Constructeur d'un objet GestionnaireUE.
     * Son accès est privé afin de contrôler l'instanciation d'un objet unique (application du design pattern Singleton).
     */
    private GestionnaireUE() {
        UEDao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getUEDAO();
        listeUEs = new ArrayList();
        semestreDao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getSemestreDAO();
        listeSemestre = semestreDao.getListe();
        anneeEtudeDao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getAnneeEtudeDAO();
        listeAnneeEtude = anneeEtudeDao.getListe();
    }

    /**
     * Méthode permettant de renvoyer un objet unique de type GestionnaireUE
     * @return GestionnaireUE - Instance unique de l'objet GestionnaireUE
     */
    public static GestionnaireUE getGestionnaireUE()
    {
        if (gestUE == null)
        {
                gestUE = new GestionnaireUE();
        }
        return (gestUE);
    }

    /**
     * Accesseur de la liste des UEs du gestionnaire
     * @return ArrayList<UE> - Liste des UEs du gestionnaire
     */
    public ArrayList<UE> getListeUE(){
        return UEDao.getListe();
    }

    /**
     * Modifieur de la liste des UEs du gestionnaire
     * @param listeUEs - Liste des UEs du gestionnaire
     */
    public void setListeUEs(ArrayList<UE> listeUEs) {
        this.listeUEs = listeUEs;
    }

    /**
     * Méthode qui retourne la liste des UEs correspondant au semestre dont le nom est passé en paramètre
     * @param semestre Nom du semestre pour laquelle on souhaite la liste des UEs associées
     * @return ArrayList<UE> - Liste des UEs associées au semestre en paramètre
     */
    public ArrayList<UE> getUEs (String semestre) {
        return ((UEDAO)this.UEDao).getUEBySemestre(semestre);
    }

    /**
     * Méthode qui retourne la liste des matieres correspondant à l'UE dont le nom est passé en paramètre
     * @param annee Nom de l'UE pour laquelle on souhaite la liste des matieres associ√©es
     * @return ArrayList<Matiere> - Liste des matieres associées à l'UE en paramètre
     */
    public ArrayList<Matiere> getMatiere (String u) {
        return ((MatiereDAO)this.matiereDao).getMatiereByUE(u);
    }

    /**
     * Méthode qui retourne la liste des UEs correspondant à l'année d'étude et
     * au semestre dont les noms sont passés en paramètre
     * @param annee Nom de l'année d'étude pour laquelle on souhaite la liste des UEs associées
     * @param semestre Nom du semestre pour lequel on souhaite la liste des UEs asociées
     * @return ArrayList<UE> - Liste des UEs associées à l'année d'étude et au semestre en paramètre
     */
    public ArrayList<UE> getUE (String annee, String semestre) {
        return ((UEDAO)this.UEDao).getUEByAnneeSemestre(annee, semestre);
    }

    /**
     * Méthode qui retourne la liste des semestres correspondant à l'année d'étude et
     * au semestre dont les noms sont passés en paramètre
     * @return ArrayList<Semestre> - Liste des semestre associées à l'année d'étude
     */
    public ArrayList<Semestre> getListeSemestre() {
        return listeSemestre;
    }

    /**
     * Méthode qui retourne la liste des l'années d'études
     * @return ArrayList<AnneeEtude> - Liste des années d'études
     */    
    public Iterable<AnneeEtude> getListeAnneeEtude() {
        return listeAnneeEtude;
    }

    /**
     * Méthode qui permet de supprimer une UE
     * @param u L' UE à supprimer
     */
    public void deleteUE(UE u) {
        Boolean ok= UEDao.delete(u);
        if ( ok )
            listeUEs.remove(u);
    }

    /**
     * Méthode qui permet de mettre à jour l'UE
     * @param code Code de l'UE
     * @param nomSem Nomde du semestre de l'UE
     * @param nomAE Nom de l'année d'etude à laquelle l'ue appartient
     * @param nomUE Nom de l'UE
     * @param d Description de l'UE
     * @param nbE Nombre d'ECTS pour l'UE
     * @param noteM Note minimum pour l'UE
     * @param s Semestre auquel appartient l'UE
     */
    public void updateUE(String code,String nomSem, String nomAE, String nomUE, String description, int nbEcts, int noteM) {
        AnneeEtude a = new AnneeEtude(nomAE);
        Semestre s = new Semestre(nomSem,a);
        UE u = new UE(code,nomUE,description,nbEcts,noteM,s);
        Boolean ok= UEDao.update(u);
        if ( ok )
            listeUEs.add(u);
    }

    /**
     * Méthode qui permet l'ajout de l'UE
     * @param code Code de l'UE
     * @param nomSem Nomde du semestre de l'UE
     * @param nomAE Nom de l'année d'etude à laquelle l'ue appartient
     * @param nomUE Nom de l'UE
     * @param d Description de l'UE
     * @param nbE Nombre d'ECTS pour l'UE
     * @param noteM Note minimum pour l'UE
     * @param s Semestre auquel appartient l'UE
     */
    public void ajouterUE(String code,String nomSem, String nomAE, String nomUE, String description, int nbEcts, int noteM) {
        AnneeEtude a = new AnneeEtude(nomAE);
        Semestre s = new Semestre(nomSem,a);
        UE u = new UE(code,nomUE,description,nbEcts,noteM,s);
        Boolean ok= UEDao.create(u);
        if ( ok )
            listeUEs.add(u);
    }
}