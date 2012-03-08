import metier.*;
import jdbc.*;
import persistance.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class test 
{
	public static void main(String [] args)
	{
		
		DAO<Enseignant> ens = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getEnseignantDAO();
		Enseignant e = new Enseignant(1);
		
		e = ens.find(e);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
