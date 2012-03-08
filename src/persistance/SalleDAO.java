package persistance;
import metier.*;

import java.sql.*;
import java.util.ArrayList;

public class SalleDAO extends DAO<Salle>{

	
	private static final SalleDAO instance = new SalleDAO();
	
	public final static SalleDAO getInstance()
	{
		return instance;
	}

	@Override
	public boolean create(Salle sal)
	{
		 boolean ok = true;
         try {
        	 
             this.connect.createStatement().executeUpdate(
                         "INSERT INTO salle " +
                         "(id_salle, id_batiment, numero_salle) " +
                         "VALUES (seqSalle.nextval, "+ sal.getBatiment().getIdBat()+ ",'"
                                     + sal.getLibelle()+"')");
         }
         catch (SQLException e) 
         {
        	 ok = false;
         }
         return ok;
	}

	@Override
	public boolean update(Salle sal) {
		boolean ok = true; 
        try {
        
            this.connect.createStatement().executeUpdate(
                            "UPDATE salle " +
                            "SET numero_salle='" + sal.getLibelle() + "' " +
                            "WHERE id_salle=" + sal.getIdSalle());

            }
        catch (SQLException e) {
            ok = false;
        }

        return ok;
	}

	@Override
	public boolean update(Salle ancien, Salle nouveau) {
		
		return false;
	}

	@Override
	public Salle find(Salle sal) {
		BatimentDAO batDAO;
		Batiment bat;
		ArrayList<Caracteristique> car;
		try {
            
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery("select * from SALLE where ID_SALLE = " + sal.getIdSalle());
            if (result.first()) {
            	batDAO = new BatimentDAO();
            	bat = new Batiment(result.getInt("ID_BATIMENT"));
            	bat = batDAO.find(bat);
            	sal.setIdSalle(result.getInt("ID_SALLE"));
            	sal.setLibelle(result.getString("NUMERO_SALLE"));
            }
            
            result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
    				.executeQuery("SELECT s.ID_SALLE, s.NUMERO_SALLE, s.ID_BATIMENT, c.id_caracteristique from salle s, caracteristique_salle cs, caracteristique c WHERE s.id_salle = " + sal.getIdSalle() +" and s.id_salle = cs.id_salle");
            
            car = new ArrayList<Caracteristique>();
            while(result.next())
            {
            	System.out.println(result.getInt("ID_CARACTERISTIQUE"));
            	CaracteristiqueDAO cDAO= new CaracteristiqueDAO();
            	Caracteristique c = new Caracteristique(result.getInt("ID_CARACTERISTIQUE"));
            	c = cDAO.find(c);
            	
            	car.add(c);	
            }
            sal.setCarSalle(car);
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return sal;
	}

	@Override
	public boolean delete(Salle sal) {
		 boolean ok = true; 
	        try
	        {
	            
	            this.connect.createStatement().executeUpdate(
	                            "DELETE FROM salle " +
	                            "WHERE id_salle =" + sal.getIdSalle());
	        }
	        catch (SQLException e) {
	            
	            ok = false;
	        }

	        return ok;
	}

	@Override
	public ArrayList<Salle> getListe() 
	{
        Salle s;
        SalleDAO sDAO;
		 ArrayList<Salle> list = new ArrayList<Salle>();
		 
	        try {
	           
	            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Salle");

	            while (result.next())
	            {
	            	  s = new Salle(result.getInt("id_salle"));
	            	  sDAO = new SalleDAO();
	            	  s = sDAO.find(s);
	            	  list.add(s);
	            }
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
		
	}	
}