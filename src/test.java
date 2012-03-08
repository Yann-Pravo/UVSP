import metier.*;
import persistance.*;

public class test 
{
	public static void main(String [] args)
	{
		
		DAO<Enseignant> ens = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getEnseignantDAO();
		Enseignant e = new Enseignant(2);
		
		e = ens.find(e);
		
		System.out.println(e.getNom());
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
