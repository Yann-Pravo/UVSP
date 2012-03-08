import metier.*;
import persistance.*;

public class test 
{
	public static void main(String [] args)
	{
		DAO<Enseignant> ens = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getEnseignantDAO();
		DAO<Matiere> mat = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getMatiereDAO();
		
		DAO<Batiment> bat = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getBatimentDAO();
		
		DAO<Enseignement> ense = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getEnseignementDAO();
		
		DAO<Cours> cours = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getCoursDAO();
		
		DAO<Reservation> res = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getReservationDAO();
		
		DAO<Caracteristique> ca = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getCaracteristiqueDAO();
		
		DAO<Creneau> cr = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getCreneauDAO();
		
		DAO<Groupe> grp = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getGroupeDAO();
		
		Groupe g = new Groupe(1);
		Creneau creneau = new Creneau(1);
		Caracteristique cara = new Caracteristique(1);
		Reservation r = new Reservation(30);
		Cours c = new Cours(1);
		Enseignement enseignement = new Enseignement(1);
		Batiment batiment = new Batiment(1);
		Enseignant e = new Enseignant(2);
		Matiere m = new Matiere(1);
		
		
		g = grp.find(g);
		creneau = cr.find(creneau);
		cara = ca.find(cara);
		r = res.find(r);
		c = cours.find(c);
		enseignement = ense.find(enseignement);
		e = ens.find(e);
		m = mat.find(m);
		batiment = bat.find(batiment);
		
		
		System.out.println(r.getCarResa().get(0).getLibelle());
		System.out.println(r.getCarResa().get(1).getLibelle());
		System.out.println(r.getCarResa().get(2).getLibelle());
		//System.out.println(c.getMatiere().getNomMat());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
