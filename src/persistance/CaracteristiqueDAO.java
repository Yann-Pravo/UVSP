package persistance;
import metier.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CaracteristiqueDAO extends DAO<Caracteristique>{

	private static final CaracteristiqueDAO instance = new CaracteristiqueDAO();
	
	public final static CaracteristiqueDAO getInstance()
	{
		return instance;
	}
	
	
	
	@Override
	public boolean create(Caracteristique ca)
	{
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

	@Override
	public boolean update(Caracteristique ca) 
	{
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
	public boolean update(Caracteristique ancien, Caracteristique nouveau)
	{
		return false;
	}

	@Override
	public Caracteristique find(Caracteristique ca) {
		
		Caracteristique c;
		try {
            
            ResultSet result = this.connect.createStatement().executeQuery(
                    "SELECT * from CARACTERISTIQUE"+
                	"WHERE id_caracteristique = "+ca.getIdCar());
                    
            c = new Caracteristique(result.getInt("id_caracteristique"), result.getString("libelle_caracteristique"));
             
        } catch (SQLException ex) {
            
            c = ca;
        }
        return c;
	}

	@Override
	public boolean delete(Caracteristique ca) 
	{
		boolean ok = true; 
        try
        {
            
            this.connect.createStatement().executeUpdate(
                            "DELETE FROM CARACTERISTIQUE " +
                            "WHERE id_caracteristique =" + ca.getIdCar());
        }
        catch (SQLException e) {
            
            ok = false;
        }

        return ok;
	}

	@Override
	public ArrayList<Caracteristique> getListe() 
	{
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
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;	
	}	
}