import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

import GraphicalUI.Timetable;

import metier.*;
import persistance.*;

public class test 
{
	public static void main(String [] args)
	{
//		DAO<Enseignant> ens = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getEnseignantDAO();
//		DAO<Matiere> mat = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getMatiereDAO();
//		
//		DAO<Batiment> bat = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getBatimentDAO();
//		
//		DAO<Enseignement> ense = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getEnseignementDAO();
//		
//		DAO<Cours> cours = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getCoursDAO();
//		
//		DAO<Reservation> res = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getReservationDAO();
//		
//		DAO<Caracteristique> ca = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getCaracteristiqueDAO();
//		
//		DAO<Creneau> cr = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getCreneauDAO();
//		
//		DAO<Groupe> grp = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getGroupeDAO();
//		
//		DAO<Salle> s = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getSalleDAO();
//		
//		DAO<UE> ue = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getUEDAO();
//		
//		
//		
//		UE u = new UE(1);
//		u = ue.find(u);
//		
//		Salle salle = new Salle(1);
//		Groupe g = new Groupe(1);
//		Creneau creneau = new Creneau(1);
//		Caracteristique cara = new Caracteristique(1);
//		Reservation r = new Reservation(30);
//		Cours c = new Cours(1);
//		Enseignement enseignement = new Enseignement(1);
//		Batiment batiment = new Batiment(1);
//		Enseignant e = new Enseignant("Bourdon", "isabelle");
//		Matiere m = new Matiere(2);
//		
//		
//		salle = s.find(salle);
//		g = grp.find(g);
//		creneau = cr.find(creneau);
//		cara = ca.find(cara);
//		r = res.find(r);
//		c = cours.find(c);
//		
//		//System.out.println(u.getEnseignant().getNom());
//		
//		//GestionnaireSalle Gsal = GestionnaireSalle.getGestionnaireSalle();
//		
//	     
//		//GestionnaireSalle gest_salle = GestionnaireSalle.getGestionnaireSalle();
//		ArrayList<Salle> liste = new ArrayList<Salle>();
//		//liste = gest_salle.getListeSalles();
//		
//		System.out.println(liste.get(0).toString());
		
		GestionnaireReservation gr = GestionnaireReservation.getInstance();
		ArrayList<Reservation> a = gr.getListeReservation();
		
		for(int i = 0; i<a.size(); i++)
		{
			System.out.println(a.get(i).getIdResa());
			System.out.println(a.get(i).getEns().getGroupe().getLibelle());
			System.out.println(a.get(i).getEns().getGroupe().getLibelle());
			System.out.println(a.get(i).getSalle().getLibelle());
			System.out.println(a.get(i).getEns().getCours().getMatiere().getNomMat()+" ");
			System.out.println(a.get(i).getCreneau().getHeureDeb()+" ");
			System.out.println(a.get(i).getDateResa().toString());
			System.out.println(a.get(i).getEns().getEnseignant());
			System.out.println(" ");
		}
		
		
		


		
		
		
		
		
		
	}
	
	
	
	
}
