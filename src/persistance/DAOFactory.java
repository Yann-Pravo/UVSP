package persistance;
import metier.*;

/**
 * Classe permettant de modéliser une fabrique concrête de DAOs.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class DAOFactory extends AbstractDAOFactory {
    
    private static final DAOFactory instance = new DAOFactory();
    
    /**
     * Méthode permettant de retourner l'instance unique de type DAOFactory
     * @return DAOFactory - Instance unique de l'objet DAOFactory
     */
    public final static DAOFactory getDAOFactory () {
        return instance;
    }

    /**
     * Méthode instanciatrice d'un objet DAO pour les matières.
     * Cette méthode utilise le design pattern singleton : l'objet MatiereDAO est instancié une seule fois
     * @return MatiereDAO - Un nouvel objet MatiereDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<Matiere> getMatiereDAO(){
        return MatiereDAO.getInstance();
    }

    /**
     * Méthode instanciatrice d'un objet DAO pour les batiments.
     * Cette méthode utilise le design pattern singleton : l'objet BatimentDAO est instancié une seule fois
     * @return BatimentDAO - Un nouvel objet BatimentDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<Batiment> getBatimentDAO(){
        return BatimentDAO.getInstance();
    }

    /**
     * Méthode instanciatrice d'un objet DAO pour les enseignants.
     * Cette méthode utilise le design pattern singleton : l'objet EnseignantDAO est instancié une seule fois
     * @return EnseignantDAO - Un nouvel objet EnseignantDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<Enseignant> getEnseignantDAO(){
        return EnseignantDAO.getInstance();
    }

    /**
     * Méthode instanciatrice d'un objet DAO pour les caractéristiques.
     * Cette méthode utilise le design pattern singleton : l'objet CaracteristiqueDAO est instancié une seule fois
     * @return CaracteristiqueDAO - Un nouvel objet CaracteristiqueDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<Caracteristique> getCaracteristiqueDAO(){
        return CaracteristiqueDAO.getInstance();
    }

    /**
     * M√©thode instanciatrice d'un objet DAO pour les UEs.
     * Cette méthode utilise le design pattern singleton : l'objet UEDAO est instancié une seule fois
     * @return UEDAO - Un nouvel objet UEDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<UE> getUEDAO() {
        return UEDAO.getInstance();
    }

    /**
     * Méthode instanciatrice d'un objet DAO pour les réservations.
     * Cette méthode utilise le design pattern singleton : l'objet ReservationDAO est instancié une seule fois
     * @return ReservationDAO - Un nouvel objet ReservationDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<Reservation> getReservationDAO() {
        return ReservationDAO.getInstance();
    }

    /**
     * Méthode instanciatrice d'un objet DAO pour les cours.
     * Cette méthode utilise le design pattern singleton : l'objet CoursDAO est instancié une seule fois
     * @return CoursDAO - Un nouvel objet CoursDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<Cours> getCoursDAO() {
        return CoursDAO.getInstance();
    }
    
    /**
     * Méthode instanciatrice d'un objet DAO pour les types de cours.
     * Cette méthode utilise le design pattern singleton : l'objet TypeCoursDAO est instancié une seule fois
     * @return TypeCoursDAO - Un nouvel objet TypeCoursDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<TypeCours> getTypeCoursDAO() {
        return TypeCoursDAO.getInstance();
    }

    /**
     * Méthode instanciatrice d'un objet DAO pour les créneaux
     * Cette méthode utilise le design pattern singleton : l'objet CreneauDAO est instancié une seule fois
     * @return CreneauDAO - Un nouvel objet CreneauDAO s'il n'a pas déjà été instancié, l'objet existant sinon
     */
    public DAO<Creneau> getCreneauDAO() {
    	return CreneauDAO.getInstance();
    }

    /**
     * Méthode instanciatrice d'un objet DAO pour les Groupes
     * Cette m√©thode utilise le design pattern singleton : l'objet GroupeDAO est instanci√© une seule fois
     * @author Fanny Couturier
     * @return SEEDAO - Un nouvel objet GroupeDAO s'il n'a pas d√©j√† √©t√© instanci√©, l'objet existant sinon
     * @version 1.0
     */
    public DAO<Groupe> getGroupeDAO() {
    	return GroupeDAO.getInstance();
    }

     /**
     * M√©thode instanciatrice d'un objet DAO pour les salles.
     * Cette m√©thode utilise le design pattern singleton : l'objet SalleDAO est instanci√© une seule fois
     * @author Maxime Vali√®re
     * @return SalleDAO - Un nouvel objet SalleDAO s'il n'a pas d√©j√† √©t√© instanci√©, l'objet existant sinon
     * @version 1.0
     */
     public DAO<Salle> getSalleDAO() {
        return SalleDAO.getInstance();
     }
     
     /**
     * M√©thode instanciatrice d'un objet DAO pour les enseignements.
     * Cette m√©thode utilise le design pattern singleton : l'objet EnseignementDAO est instanci√© une seule fois
     * @author Boris Kuete
     * @return EnseignementDAO - Un nouvel objet EnseignementDAO s'il n'a pas d√©j√† √©t√© instanci√©, l'objet existant sinon
     * @version 1.0
     */
     public DAO<Enseignement> getEnseignementDAO() {
    	 return EnseignementDAO.getInstance();
     }
}