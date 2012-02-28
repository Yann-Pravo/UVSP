package metier;

import persistance.*;
import java.util.*;

/**
 * Classe servant de façade entre le package "vue" et les classe métiers du package "persistance".
 * Cette classe contient une liste des salles présentes dans la base de données,
 * et elle implémente le design pattern Singleton afin de n'être instanciée qu'une seule fois.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */

public class GestionnaireSalle {
	
    //Attributs
    DAO<Salle> salleDAO;
    ArrayList<Salle> listeSalles;
    private static final GestionnaireSalle instance = new GestionnaireSalle();

    /**
     * Constructeur d'un objet GestionnaireSalle.
     * Son accès est privé afin de contrôler l'instanciation d'un objet unique (application du design pattern Singleton).
     */
    private GestionnaireSalle () {
        salleDAO = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getSalleDAO();
       listeSalles = salleDAO.getListe();
    }


    /**
     * Méthode permettant de renvoyer un objet unique de type GestionnaireSalle
     * @return GestionnaireSalle - Instance unique de l'objet GestionnaireSalle
     */
    public final static GestionnaireSalle getGestionnaireSalle () {
        return instance;
    }

    /**
     * Méthode qui enregistre les informations d'un nouvel objet salle
     * et rajoute à la liste des salles
     * @param nom le nom de la salle
     * @param capacite la capacité de la salle
     * @return l'objet salle créé
     */
    public Salle addSalle( String nom, Integer capacite) {
        Salle salle = new Salle(nom, capacite);
        salleDAO.create(salle);
        listeSalles.add(salle);
        return salle;
    }


    /**
     * Méthode qui supprime l'objet salle de la liste des salles
     * @param salle: l'objet à supprimer de la liste
     */
    public void deleteSalle(Salle salle)
    {
        int i = 0;
        while (!salle.getNom().equals((listeSalles.get(i)).getNom()))
        {
                i++;
        }
        listeSalles.remove(i) ;
        salleDAO.delete(salle);
    }


    /**
     * Méthode qui met à jour l'objet salle
     * @param nom le nom de la salle
     * @param capacite la capacité de la salle
     */
    public void updateSalle( String nom, Integer capacite)
    {
        Salle salle = new Salle( nom, capacite);
        salleDAO.update(salle);
        listeSalles = salleDAO.getListe();
    }
}