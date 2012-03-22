package persistance;

import metier.*;

/**
 * Classe abstraite permettant reprsentant une fabrique abstraite.
 * Cette classe implmente le design pattern AbstractFactory, et permet donc de
 * construire des fabriques concrtes hritant d'AbstractDAOFactory.
 * @authors Ahardane Abdeslam, Balestrat Clment, Pravossoudovitch Yann
 * @version 1.0
 */
public abstract class AbstractDAOFactory {

    public static final int DAO_FACTORY = 0;
    //public static final int TXT_DAO_FACTORY = 1;

    /**
     * Mthode statique permettant de rcuprer les Factory
     * @param type Type de la fabrique ˆ instancier
     * @return AbstractDAOFactory - La fabrique instancie
     */
    public static AbstractDAOFactory getFactory(int type){
        switch(type){
            case 0:
                return DAOFactory.getDAOFactory();
            case 1:
                return DAOTXTFactory.getDAOTXTFactory();
            default:
                return null;
        }
    }

    /**
     * Mthode abstraite permettant de retourner un objet Matiere intragissant avec la base de donnes
     * @return DAO - Objet MatiereDAO -> objet Matiere interagisant avec la base de donnes
     */
    public abstract DAO<Matiere> getMatiereDAO();

    /**
     * Mthode abstraite permettant de retourner un objet Batiment intragissant avec la base de donnes
     * @return DAO - Objet BatimentDAO -> objet Batiment interagisant avec la base de donnes
     */
    public abstract DAO<Batiment> getBatimentDAO();

    /**
     * Mthode abstraite permettant de retourner un objet Matiere intragissant avec la base de donnes
     * @return DAO - Objet MatiereDAO -> objet Enseignant interagisant avec la base de donnes
     */
    public abstract DAO<Enseignant> getEnseignantDAO();

    /**
     * Mthode abstraite permettant de retourner un objet Caracteristique intragissant avec la base de donnes
     * @return DAO - Objet CaracteristiqueDAO -> objet Caracteristique interagisant avec la base de donnes
     */
    public abstract DAO<Caracteristique> getCaracteristiqueDAO();

    /**
     * Mthode abstraite permettant de retourner un objet Matiere intragissant avec la base de donnes
     * @return DAO - Objet MatiereDAO -> objet Matiere interagisant avec la base de donnÃ©es
     */
    public abstract DAO<UE> getUEDAO();

    /**
     * Mthode abstraite permettant de retourner un objet Cours intragissant avec la base de donnes
     * @return DAO - Objet CoursDAO -> objet Cours interagisant avec la base de donnes
     */
    public abstract DAO<Cours> getCoursDAO();

    /**
     * Mthode abstraite permettant de retourner un objet Creneau intragissant avec la base de donnes
     * @return DAO - Objet CreneauDAO -> objet Creneau interagisant avec la base de donnes
     */
    public abstract DAO<Creneau> getCreneauDAO();

    /**
     * Mthode abstraite permettant de retourner un objet Reservation intragissant avec la base de donnes
     * @return DAO - Objet ReservationDAO -> objet Reservation interagisant avec la base de donnes
     */
    public abstract DAO<Reservation> getReservationDAO();

    /**
     * Mthode abstraite permettant de retourner un objet Groupe intragissant avec la base de donnes
     * @return DAO - Objet GroupeDAO -> objet Groupe interagisant avec la base de donnes
     */
    public abstract DAO<Groupe> getGroupeDAO();

    /**
     * Mthode abstraite permettant de retourner un objet TypeCours intragissant avec la base de donnes
     * @return DAO - Objet TypeCoursDAO -> objet TypeCours interagisant avec la base de donnes
     */
    public abstract DAO<TypeCours> getTypeCoursDAO();

    /**
     * Mthode abstraite permettant de retourner un objet Enseignement intragissant avec la base de donnes
     * @return DAO - Objet EnseignementDAO -> objet Enseignement interagisant avec la base de donnes
     */
    public abstract DAO<Enseignement> getEnseignementDAO();

    /**
     * Mthode abstraite permettant de retourner un objet Salle intragissant avec la base de donnes
     * @return DAO - Objet SalleDAO -> objet Salle interagisant avec la base de donnes
     */
    public abstract DAO<Salle> getSalleDAO();
}