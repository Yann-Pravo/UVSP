package persistance;
import metier.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe permettant de mapper les objets Caracteristique vers la table CARACTERISTIQUE de la base de données.
 * Cette classe hérite de la classe DAO.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class CaracteristiqueDAO extends DAO<Caracteristique> {

	private static final CaracteristiqueDAO instance = new CaracteristiqueDAO();
	
    /**
     * Méthode permettant de récupérer l'objet unique de type CaracteristiqueDAO
     * @return CaracteristiqueDAO - Instance unique de l'objet CaracteristiqueDAO
     */
	public final static CaracteristiqueDAO getInstance() {
		return instance;
	}
	
    /**
     * Méthode qui exécute une requête d'ajout d'une nouvelle caractéristique dans la base de données.
     * Cette méthode redéfinit la méthode create(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param ca Objet Caracteristique qui doit être mappé dans la base
     * @return Boolean - Vrai si l'insertion s'est déroulée correctement, Faux sinon
     */
	public boolean create(Caracteristique ca) {
		 boolean ok = true;
         try {
        	 
             this.connect.createStatement().executeUpdate(
                         "INSERT INTO Caracteristique " +
                         "(id_caracteristique, libelle_caracteristique) " +
                         "VALUES (seqCaracteristique.nextval, '"+ ca.getLibelle()+"')");
         }
         catch (SQLException e) 
         {
        	 ok = false;
         }
         return ok;
	}

    /**
     * Méthode qui exécute une requête de mise à jour d'un enregistrement de la table 'CARACTERISTIQUE' dans la base de données.
     * Cette méthode redéfint la méthode update(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param ca Objet Caracteristique qui doit être mappé pour mettre à jour la ligne correspondante dans la base
     * @return Boolean - Vrai si la mise à jour s'est déroulée correctement, Faux sinon
     */
	public boolean update(Caracteristique ca) {
		boolean ok = true; 
        try {
            this.connect.createStatement().executeUpdate(
                            "UPDATE caracteristique " +
                            "SET libelle_caracteristique='" +ca.getLibelle() + "'"+
                            "WHERE id_caracteristique=" + ca.getIdCar());
            }
        catch (SQLException e) {
            ok = false;
        }
        return ok;
	}

	@Override
	public boolean update(Caracteristique ancien, Caracteristique nouveau) {
		return false;
	}

    /**
     * Méthode qui recherche dans la base de données l'enregistrement correspondant
     * à la caractéristique ca en paramêtre et retourne les résultats sous forme d'un objet Batiment.
     * @param ca Objet Caracteristique à rechercher dans la base de données
     * @return Caracteristique - Objet Caracteristique créé à partir des résultats trouvés dans la base
     */
	public Caracteristique find(Caracteristique ca) {
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery("select * from CARACTERISTIQUE where ID_CARACTERISTIQUE = " + ca.getIdCar() );     
			if(result.first()) {
				ca.setLibelle(result.getString("LIBELLE_CARACTERISTIQUE"));
			}
			result.getStatement().close();
        }
		catch (SQLException ex) {
			ex.printStackTrace();
        }
        return ca;
	}

    /**
     * Méthode qui exécute une requête de suppression d'une caractéristique dans la base de données.
     * Cette méthode redéfinit la méthode find(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param ca Objet Caractéristique dont l'enregistrement correspondant dans la base doit être supprimé
     * @return Boolean - Vrai si la suppression s'est bien déroulée, Faux sinon
     */
	public boolean delete(Caracteristique ca) {
		boolean ok = true; 
        try {
            this.connect.createStatement().executeUpdate(
                            "DELETE FROM CARACTERISTIQUE " +
                            "WHERE id_caracteristique =" + ca.getIdCar());
        }
        catch (SQLException e) {
            ok = false;
        }
        return ok;
	}

    /**
     * Méthode qui :
     *      1) récupère l'ensemble des caractéristiques de la table correspondante dans la base
     *      2) les mappe en objet java Caracteristique
     *      3) les stocke dans une liste d'objets Caracteristique
     * @exception SQLException
     * @return ArrayList<Caracteristique> - Liste des caracteristiques stockées dans la base
     */
	public ArrayList<Caracteristique> getListe() {
		Caracteristique c;
		CaracteristiqueDAO cDAO;
		ArrayList<Caracteristique> list = new ArrayList<Caracteristique>();
		try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Caracteristique");
            while (result.next())
            {
            	c = new Caracteristique(result.getInt("id_caracteristique"));
            	cDAO = new CaracteristiqueDAO();
            	c = cDAO.find(c);
            	
            	list.add(c);	
            }
            result.getStatement().close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;	
	}

	@Override
	public boolean login(Caracteristique obj) {
		// TODO Auto-generated method stub
		return false;
	}	
}