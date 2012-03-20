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
    DAO<UE> ueDAO;

    private ArrayList<UE> listeUEs;
    private static GestionnaireUE gestUE;

    /**
     * Constructeur d'un objet GestionnaireUE.
     * Son accès est privé afin de contrôler l'instanciation d'un objet unique (application du design pattern Singleton).
     */
    private GestionnaireUE() {
        ueDAO = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getUEDAO();
        listeUEs = new ArrayList<UE>();
    }

    /**
     * Méthode permettant de renvoyer un objet unique de type GestionnaireUE
     * @return GestionnaireUE - Instance unique de l'objet GestionnaireUE
     */
    public static GestionnaireUE getInstance()
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
        return ueDAO.getListe();
    }

    /**
     * Méthode qui permet de supprimer une UE
     * @param u L' UE à supprimer
     */
    public void deleteUE(UE u) {
        Boolean ok= ueDAO.delete(u);
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
    public void updateUE(UE ue, String nom, Enseignant ens) {
        listeUEs.remove(ue);
        ue.setNomUE(nom);
        ue.setEnseignant(ens);

        Boolean ok= ueDAO.update(ue);
        if ( ok )
            listeUEs.add(ue);
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
    public void addUE(String nom, Enseignant ens) {
        UE u = new UE(nom, ens);
        Boolean ok= ueDAO.create(u);
        if ( ok )
            listeUEs.add(u);
    }

    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}