package persistance;

import metier.Batiment;
import metier.Caracteristique;
import metier.Cours;
import metier.Creneau;
import metier.Enseignant;
import metier.Enseignement;
import metier.Groupe;
import metier.Matiere;
import metier.Reservation;
import metier.Salle;
import metier.TypeCours;
import metier.UE;

/**
 * Classe permettant de modéliser une fabrique concrête de DAOs.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class DAOTXTFactory extends AbstractDAOFactory {
    
    private static final DAOTXTFactory instance = new DAOTXTFactory();
    
    /**
     * Méthode permettant de retourner l'instance unique de type DAOFactory
     * @return DAOFactory - Instance unique de l'objet DAOFactory
     */
    public final static DAOTXTFactory getDAOTXTFactory () {
        return instance;
    }

    /**
     * Méthode instanciatrice d'un objet DAO pour les matières.
     * Cette méthode utilise le design pattern singleton : l'objet MatiereDAO est instancié une seule fois
     * @return MatiereDAO - Un nouvel objet MatiereDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<Matiere> getMatiereDAO(){
        return MatiereDAOTXT.getInstance();
    }

    /**
     * Méthode instanciatrice d'un objet DAO pour les batiments.
     * Cette méthode utilise le design pattern singleton : l'objet BatimentDAO est instancié une seule fois
     * @return BatimentDAO - Un nouvel objet BatimentDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<Batiment> getBatimentDAO(){
        return BatimentDAOTXT.getInstance();
    }

    /**
     * Méthode instanciatrice d'un objet DAO pour les enseignants.
     * Cette méthode utilise le design pattern singleton : l'objet EnseignantDAO est instancié une seule fois
     * @return EnseignantDAO - Un nouvel objet EnseignantDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<Enseignant> getEnseignantDAO(){
        return EnseignantDAOTXT.getInstance();
    }

    /**
     * Méthode instanciatrice d'un objet DAO pour les caractéristiques.
     * Cette méthode utilise le design pattern singleton : l'objet CaracteristiqueDAO est instancié une seule fois
     * @return CaracteristiqueDAO - Un nouvel objet CaracteristiqueDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<Caracteristique> getCaracteristiqueDAO(){
        return CaracteristiqueDAOTXT.getInstance();
    }

    /**
     * M√©thode instanciatrice d'un objet DAO pour les UEs.
     * Cette méthode utilise le design pattern singleton : l'objet UEDAO est instancié une seule fois
     * @return UEDAO - Un nouvel objet UEDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<UE> getUEDAO() {
        return UEDAOTXT.getInstance();
    }

    /**
     * Méthode instanciatrice d'un objet DAO pour les réservations.
     * Cette méthode utilise le design pattern singleton : l'objet ReservationDAO est instancié une seule fois
     * @return ReservationDAO - Un nouvel objet ReservationDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<Reservation> getReservationDAO() {
        return ReservationDAOTXT.getInstance();
    }

    /**
     * Méthode instanciatrice d'un objet DAO pour les cours.
     * Cette méthode utilise le design pattern singleton : l'objet CoursDAO est instancié une seule fois
     * @return CoursDAO - Un nouvel objet CoursDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<Cours> getCoursDAO() {
        return CoursDAOTXT.getInstance();
    }
    
    /**
     * Méthode instanciatrice d'un objet DAO pour les types de cours.
     * Cette méthode utilise le design pattern singleton : l'objet TypeCoursDAO est instancié une seule fois
     * @return TypeCoursDAO - Un nouvel objet TypeCoursDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<TypeCours> getTypeCoursDAO() {
        return TypeCoursDAOTXT.getInstance();
    }

    /**
     * Méthode instanciatrice d'un objet DAO pour les créneaux
     * Cette méthode utilise le design pattern singleton : l'objet CreneauDAO est instancié une seule fois
     * @return CreneauDAO - Un nouvel objet CreneauDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<Creneau> getCreneauDAO() {
    	return CreneauDAOTXT.getInstance();
    }

    /**
     * Méthode instanciatrice d'un objet DAO pour les Groupes
     * Cette m√©thode utilise le design pattern singleton : l'objet GroupeDAO est instanci√© une seule fois
     * @author Fanny Couturier
     * @return SEEDAO - Un nouvel objet GroupeDAO s'il n'a pas d√©j√† √©t√© instanci√©, l'objet existant sinon
     * @version 1.0
     */
    public DAO<Groupe> getGroupeDAO() {
    	return GroupeDAOTXT.getInstance();
    }

     /**
     * M√©thode instanciatrice d'un objet DAO pour les salles.
     * Cette m√©thode utilise le design pattern singleton : l'objet SalleDAO est instanci√© une seule fois
     * @author Maxime Vali√®re
     * @return SalleDAO - Un nouvel objet SalleDAO s'il n'a pas d√©j√† √©t√© instanci√©, l'objet existant sinon
     * @version 1.0
     */
     public DAO<Salle> getSalleDAO() {
        return SalleDAOTXT.getInstance();
     }
     
     /**
     * M√©thode instanciatrice d'un objet DAO pour les enseignements.
     * Cette m√©thode utilise le design pattern singleton : l'objet EnseignementDAO est instanci√© une seule fois
     * @author Boris Kuete
     * @return EnseignementDAO - Un nouvel objet EnseignementDAO s'il n'a pas d√©j√† √©t√© instanci√©, l'objet existant sinon
     * @version 1.0
     */
     public DAO<Enseignement> getEnseignementDAO() {
    	 return EnseignementDAOTXT.getInstance();
     }

	
}