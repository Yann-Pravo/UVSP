package persistance;
import metier.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe permettant de mapper les objets Batiment vers la table BATIMENT de la base de données.
 * Cette classe hérite de la classe DAO.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class BatimentDAO extends DAO<Batiment>{

	private static final BatimentDAO instance = new BatimentDAO();
	
    /**
     * Méthode permettant de récupérer l'objet unique de type BatimentDAO
     * @return BatimentDAO - Instance unique de l'objet BatimentDAO
     */
	public final static BatimentDAO getInstance()
	{
		return instance;
	}
	
    /**
     * Méthode qui exécute une requête d'ajout d'une nouvelle matière dans la base de données.
     * Cette méthode redéfinit la méthode create(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param bat Objet Batiment qui doit être mappé dans la base
     * @return Boolean - Vrai si l'insertion s'est déroulée correctement, Faux sinon
     */
	public boolean create(Batiment bat) 
	{
		boolean ok = true;
        try {
       	 
            this.connect.createStatement().executeUpdate(
                        "INSERT INTO batiment " +
                        "(id_batiment, libelle_batiment) " +
                        "VALUES (seqBatiment.nextval, '"+ bat.getLibelle()+"')");
        }
        catch (SQLException e) 
        {
       	 ok = false;
        }
        return ok;
	}

    /**
     * Méthode qui exécute une requête de mise à jour d'un enregistrement de la table 'BATIMENT' dans la base de données.
     * Cette méthode redéfint la méthode update(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param bat Objet Batiment qui doit être mappé pour mettre à jour la ligne correspondante dans la base
     * @return Boolean - Vrai si la mise à jour s'est déroulée correctement, Faux sinon
     */
	public boolean update(Batiment bat) 
	{
		boolean ok = true; 
        try {
        
            this.connect.createStatement().executeUpdate(
                            "UPDATE batiment " +
                            "SET libelle_batiment='" + bat.getLibelle() + "' " +
                            "WHERE id_batiment=" + bat.getIdBat());
            }
        catch (SQLException e) {
            ok = false;
        }
        return ok;
	}

	@Override
	public boolean update(Batiment ancien, Batiment nouveau) 
	{
		return false;
	}

    /**
     * Méthode qui recherche dans la base de données l'enregistrement correspondant
     * au batiment bat en paramêtre et retourne les résultats sous forme d'un objet Batiment.
     * @param bat Objet Batiment à rechercher dans la base de données
     * @return Batiment - Objet Batiment créé à partir des résultats trouvés dans la base
     */
	public Batiment find(Batiment bat) 
	{
		try
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery("select * from BATIMENT where ID_BATIMENT = " + bat.getIdBat() );
			if(result.first())
			{
				bat.setLibelle(result.getString("LIBELLE_BATIMENT"));
			}
			result.getStatement().close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return bat;
	}

    /**
     * Méthode qui exécute une requête de suppression d'un batiment dans la base de données.
     * Cette méthode redéfinit la méthode find(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param bat Objet Batiment dont l'enregistrement correspondant dans la base doit être supprimé
     * @return Boolean - Vrai si la suppression s'est bien déroulée, Faux sinon
     */
	public boolean delete(Batiment bat) 
	{
		boolean ok = true; 
        try
        {   
            this.connect.createStatement().executeUpdate(
                            "DELETE FROM BATIMENT " +
                            "WHERE id_batiment =" + bat.getIdBat());
        }
        catch (SQLException e) {
            
            ok = false;
        }
        return ok;
	}

    /**
     * Méthode qui :
     *      1) récupère l'ensemble des batiments de la table correspondante dans la base
     *      2) les mappe en objet java Batiment
     *      3) les stocke dans une liste d'ojbets Batiment
     * @exception SQLException
     * @return ArrayList<Batiment> - Liste des batiments stockées dans la base
     */
	public ArrayList<Batiment> getListe() 
	{
		Batiment bat;
		BatimentDAO batDAO;
		ArrayList<Batiment> list = new ArrayList<Batiment>();
		        try {
		            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM BATIMENT");
		            while (result.next())
		            {
		            	  bat = new Batiment(result.getInt("id_batiment"));
		            	  batDAO = new BatimentDAO();
		            	  bat = batDAO.find(bat);
		            	  list.add(bat);
		            }
		            result.getStatement().close();
		        }
		        catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return list;
	}

	@Override
	public boolean login(Batiment obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
