import metier.*;
import persistance.*;

public class test 
{
	public static void main(String [] args)
	{
		
		DAO<Enseignant> ens = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getEnseignantDAO();
		DAO<Matiere> mat = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getMatiereDAO();
		DAO<TypeCours> type = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getTypeCoursDAO();
		DAO<Groupe> groupe = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getGroupeDAO();
		DAO<Salle> salle = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getSalleDAO();
		
		Enseignant e = new Enseignant(6);
		Matiere m = new Matiere(1);
		TypeCours t = new TypeCours(3);
		Groupe grp = new Groupe(1);
		Salle s = new Salle(1);
		
		e = ens.find(e);
		m = mat.find(m);
		t = type.find(t);
		//grp = groupe.find(grp);
		s = salle.find(s);
		
//		System.out.println(e.getNom());
//		System.out.println(e.getPrenom());
//		System.out.println(e.getMdp());
//		System.out.println(e.getSu());
		
//		System.out.println(m.getNomMat());
//		System.out.println(m.getResponsable().getNom());
//		System.out.println(m.getUEMat().getNomUE());
		
//		System.out.println(t.getIdTypeCours());
//		System.out.println(t.getNomTypeCours());
		
//		System.out.println(grp.getIdGroupe());
//		System.out.println(grp.getLibelle());
//		System.out.println(grp.getPere().getLibelle());
		
		System.out.println(s.getIdSalle());
		System.out.println(s.getLibelle());
		System.out.println(s.getCarSalle().get(2).getLibelle());
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
