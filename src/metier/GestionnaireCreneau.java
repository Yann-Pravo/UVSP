package metier;
import persistance.AbstractDAOFactory;
import persistance.DAO;
import java.util.ArrayList;

public class GestionnaireCreneau {

	 DAO<Creneau> creneauDAO;
	 private ArrayList<Creneau> listeCreneau;
	 private static GestionnaireCreneau gestCreneau;
	 
	 private GestionnaireCreneau() 
	 {
		 creneauDAO = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getCreneauDAO();
		 listeCreneau = creneauDAO.getListe();
	 }

	 public static GestionnaireCreneau getInstance()
	 {
		 if(gestCreneau == null)
		 {
			 gestCreneau = new GestionnaireCreneau();
		 }
		 return gestCreneau;
	 }

	public ArrayList<Creneau> getListeCreneaux()
	{
		return this.listeCreneau;
	}
}
