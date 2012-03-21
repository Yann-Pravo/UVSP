package persistance;
import metier.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;



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
		Date d;
		ArrayList<Caracteristique> car;

		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery(
            		"SELECT * FROM Reservation WHERE id_reservation =" +res.getIdResa());
            	
      
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

	            d = (result.getDate("date_reservation"));

	            res.setSalle(s);
	            res.setCreneau(c);
	            res.setEns(ens);
	            res.setDateResa(d);
	            result.getStatement().close();
	           result.close(); 
			} 


			 result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery(
							"select rc.id_caracteristique from Reservation r, reservation_caracteristique rc where r.id_reservation ="+ res.getIdResa()+" and r.id_reservation = rc.id_reservation");
            	
			 car = new ArrayList<Caracteristique>();

	            while(result.next())
	            {
	            	CaracteristiqueDAO caDAO= new CaracteristiqueDAO();
	            	Caracteristique ca = new Caracteristique(result.getInt("id_caracteristique"));
	            	ca = caDAO.find(ca);
	            	car.add(ca);	
	            }

	          res.setCarResa(car);

	          result.getStatement().close();
	          result.close();
             
        } catch (SQLException ex) 
        {
            
      
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

	            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Reservation");

	            while (result.next())
	            {
	            	  res = new Reservation(result.getInt("id_reservation"));
	            	  resDAO = new ReservationDAO();
	            	  res = resDAO.find(res);
	            	  list.add(res);
	            }
	            result.getStatement().close();
		          result.close();
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;


	}

	@Override
	public boolean login(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}	
}