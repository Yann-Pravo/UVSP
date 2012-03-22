package metier;
import persistance.AbstractDAOFactory;
import persistance.DAO;
import java.util.ArrayList;
import java.util.Date;



public class GestionnaireReservation {

	 DAO<Reservation> resaDAO;
	 private ArrayList<Reservation> listeReservation;
	 private static GestionnaireReservation gestResa;
	 
	 
	 private GestionnaireReservation() 
	 {
		 resaDAO = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getReservationDAO();
		 listeReservation = resaDAO.getListe();
	 }

	 
	 public static GestionnaireReservation getInstance()
	 {
		 gestResa = new GestionnaireReservation();
		 return gestResa;
	 }
	 
	 
	 public boolean deleteReservation(Reservation res)
	 {
		 boolean ok;
		 ok = resaDAO.delete(res);
		 if(ok)
		 {
			 listeReservation.remove(res);
		 }
		 return ok;
	 }
	
	 
	public ArrayList<Reservation> getListeReservation()
	{
		return this.listeReservation;
	}
	
	
	public boolean addReservation(Creneau c, Enseignement e, Date d, ArrayList<Caracteristique> car)
	{
		boolean ok;
		
		Reservation resa = new Reservation(d, c, e, car);
		ok = resaDAO.create(resa);
		if(ok)
		{
			this.listeReservation.add(resa);
		}
		return ok;
	}
	
	public void updateReservation(Reservation r, Salle s, Enseignement e, Date d, ArrayList<Caracteristique> car)
	{
        int i = 0;
        while (r.getIdResa() != listeReservation.get(i).getIdResa())
        {
                i++;
        }
        listeReservation.remove(i);
		r.setSalle(s);
		r.setEns(e);
		r.setDateResa(d);
		r.setCarResa(car);
		
		boolean ok = resaDAO.update(r);
		if(ok)
		{
			this.listeReservation.add(r);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
