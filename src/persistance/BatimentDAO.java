package persistance;
import metier.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BatimentDAO extends DAO<Batiment>{

	private static final BatimentDAO instance = new BatimentDAO();
	
	public final static BatimentDAO getInstance()
	{
		return instance;
	}
	
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

	@Override
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Batiment find(Batiment bat) 
	{
		
		Batiment batiment;
		try
		{
			ResultSet result = this.connect.createStatement().executeQuery(
	                 "SELECT * from BATIMENT" +
	                 "WHERE id_batiment = " + bat.getIdBat());
			batiment = new Batiment(result.getInt("id_batiment"), result.getString("libelle_batiment"));
		}
		
		catch(SQLException ex)
		{
			batiment = bat;
		}
		
		return batiment;
		
	}

	@Override
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

	@Override
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
		        }
		        catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return list;
			
	}

}
