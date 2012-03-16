package persistance;

import java.sql.Connection;
import java.util.ArrayList;
import jdbc.ConnectionToOracle;

public abstract class DAO<T> {

	public Connection connect = ConnectionToOracle.getInstance();

    /**
     * Méthode abstraite qui fait apelle à la méthode concrête de la classe DAO de l'objet T permettant l'ajout de celui-ci en base de données
     * @param obj Objet T qui doit être mappé dans la base
     */
	public abstract boolean create(T obj);
	
    /**
     * Méthode abstraite qui fait apelle à la méthode concrête de la classe DAO de l'objet T permettant la modification de celui-ci en base de données
     * @param obj Objet T qui doit être mappé dans la base
     */
	public abstract boolean update(T obj);
	
    /**
     * Méthode abstraite qui fait apelle à la méthode concrête de la classe DAO de l'objet T permettant le remplacement de celui-ci en base de données
     * @param ancien Objet T qui doit être remplacé dans la base
     * @param ancien Objet T qui doit remplacer l'ancien objet dans la base
     */
	public abstract boolean update(T ancien, T nouveau);
	
    /**
     * Méthode abstraite qui fait apelle à la méthode concrête de la classe DAO de l'objet T permettant de trouver celui-ci en base de données
     * @param obj Objet T qui doit être mappé dans la base
     */
	public abstract T find(T obj);
	
    /**
     * Méthode abstraite qui fait apelle à la méthode concrête de la classe DAO de l'objet T permettant la suppression de celui-ci en base de données
     * @param obj Objet T qui doit être mappé dans la base
     */
	public abstract boolean delete(T obj);
	
    /**
     * Méthode abstraite qui fait apelle à la méthode concrête de la classe DAO de l'objet T permettant de de créer une liste de ceux-ci à partir de la base de données
     */
	public abstract ArrayList<T> getListe();
	
    /**
     * Méthode abstraite qui fait apelle à la méthode concrête de la classe DAO de l'objet T permettant de vérifier la connexion de celui-ci en base de données
     * @param obj Objet T qui doit être mappé dans la base
     */
	public abstract boolean login(T obj);


}