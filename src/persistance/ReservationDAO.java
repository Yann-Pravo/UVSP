package persistance;
import metier.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class ReservationDAO extends DAO<Reservation>
{
	
	private static final ReservationDAO instance = new ReservationDAO();
	
	public final static ReservationDAO getInstance()
	{
		return instance;
	}

	@Override
	public boolean create(Reservation res)
	{

		boolean ok = true;
        try {
       	 
            this.connect.createStatement().executeUpdate(
                        "INSERT INTO Reservation " +
                        "(id_reservation, id_salle, id_creneau, id_enseignement, date_reservation) " +
                        "VALUES (seqReservation.nextval, "+ res.getSalle().getIdSalle()+ ","
                        + res.getCreneau().getIdCreneau()+","+res.getEns().getIdEnseignement()+",'"+
                    	res.getDateResa()+"')");
        }
        catch (SQLException e) 
        {
       	 ok = false;
        }
        return ok;
		
	}

	@Override
	public boolean update(Reservation res)
	{
		boolean ok = true; 
        try {
        
            this.connect.createStatement().executeUpdate(
                            "UPDATE Reservation " +
                            "SET id_salle=" + res.getSalle().getIdSalle()+
                            "WHERE id_reservation=" + res.getIdResa());
            
            this.connect.createStatement().executeUpdate(
                    "UPDATE Reservation " +
                    "SET id_creneau=" + res.getCreneau().getIdCreneau()+
                    "WHERE id_reservation=" + res.getIdResa());
            
            this.connect.createStatement().executeUpdate(
                    "UPDATE Reservation " +
                    "SET id_enseignement=" + res.getEns().getIdEnseignement()+
                    "WHERE id_reservation=" + res.getIdResa());
            
            this.connect.createStatement().executeUpdate(
                    "UPDATE Reservation " +
                    "SET date_reservation='" + res.getDateResa()+"'"+
                    "WHERE id_reservation=" + res.getIdResa());

            }
        catch (SQLException e) {
            ok = false;
        }

        return ok;
	}

	@Override
	public boolean update(Reservation ancien, Reservation nouveau) {
		
		return false;
	}

	@Override
	public Reservation find(Reservation res) 
	{
		Salle s;
		SalleDAO sDAO;
		Creneau c;
		CreneauDAO cDAO;
		Enseignement ens;
		EnseignementDAO ensDAO;
		ArrayList<Caracteristique> car;
		
		try {
            
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery(
            		"SELECT r.id_reservation, id_salle, id_creneau, id_enseignement, rc.id_caracteristique, r.date_reservation"+
            		"FROM reservation r, reservation_caracteristique rc"+
            		"WHERE id_reservation =" +res.getIdResa()+
            		"AND r.id_reservation = rc.id_reservation");
           
			if(result.first())
			{
				s = new Salle(result.getInt("id_salle"));
	            sDAO = new SalleDAO();
	            s = sDAO.find(s);
	            
	            c = new Creneau(result.getInt("id_creneau"));
	            cDAO = new CreneauDAO();
	            c = cDAO.find(c);
	            
	            ens = new Enseignement(result.getInt("id_enseignement"));
	            ensDAO = new EnseignementDAO();
	            ens = ensDAO.find(ens);
	                     
	            car = new ArrayList<Caracteristique>();
	            while(result.next())
	            {
	            	CaracteristiqueDAO caDAO= new CaracteristiqueDAO();
	            	Caracteristique ca = new Caracteristique(result.getInt("rc.id_caracteristique"));
	            	ca = caDAO.find(ca);
	            	car.add(ca);	
	            }
	            
	            res.setSalle(s);
	            res.setCreneau(c);
	            res.setEns(ens);
	            res.setCarResa(car);
	            
			}
 
             
        } catch (SQLException ex) {
            
      
        }
        return res;
		
	}

	@Override
	public boolean delete(Reservation res)
	{
		 boolean ok = true; 
	        try
	        {
	            this.connect.createStatement().executeUpdate(
	                            "DELETE FROM RESERVATION " +
	                            "WHERE id_reservation =" + res.getIdResa());
	        }
	        catch (SQLException e) {
	            
	            ok = false;
	        }

	        return ok;
	}

	@Override
	public ArrayList<Reservation> getListe() 
	{
		Reservation res;
		ReservationDAO resDAO;
		 ArrayList<Reservation> list = new ArrayList<Reservation>();
		 
	        try {
	           
	            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Salle");

	            while (result.next())
	            {
	            	  res = new Reservation(result.getInt("id_reservation"));
	            	  resDAO = new ReservationDAO();
	            	  res = resDAO.find(res);
	            	  list.add(res);
	            }
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
		
		
	}	
}