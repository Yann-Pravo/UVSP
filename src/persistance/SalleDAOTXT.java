package persistance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import metier.Batiment;
import metier.Caracteristique;
import metier.Salle;

public class SalleDAOTXT extends DAO<Salle>{
private static final SalleDAOTXT instance = new SalleDAOTXT();
	
	public final static SalleDAOTXT getInstance()
	{
		return instance;
	}
	
	public boolean login(Salle sal){ return false;}



	public boolean update(Salle ancien, Salle nouveau) {
		
		return false;
	}


	public Salle find(Salle sal) {
		BatimentDAOTXT batDAO;
		Batiment bat;
		ArrayList<Caracteristique> car;
		String file ="BDTXT/Salle.txt";
		String delimiter = "|";
		String ligne = null;
		StringTokenizer strToken = null;
		BufferedReader bufferReader;
        String file2 ="BDTXT/CARACTERISTIQUE_SALLE.txt";
		String ligne2 = null;
		StringTokenizer strToken2 = null;
		BufferedReader bufferReader2;
        car = new ArrayList<Caracteristique>();
        String s = null;
        String s2 = null;
		try {
			bufferReader = new BufferedReader(new FileReader(file));						
			try {
				while ((ligne = bufferReader.readLine())!=null)
				{
					strToken = new StringTokenizer(ligne,delimiter);
					if (sal.getIdSalle() == Integer.parseInt(strToken.nextToken())){
					while (strToken.hasMoreTokens()){
						batDAO = new BatimentDAOTXT();
		            	bat = new Batiment(Integer.parseInt(strToken.nextToken()));
		            	bat = batDAO.find(bat);
		            	sal.setBatiment(bat);
		            	sal.setLibelle(strToken.nextToken());
		        		try {
		        			bufferReader2 = new BufferedReader(new FileReader(file2));						
		        			try {
		        				while ((ligne2 = bufferReader2.readLine())!=null)
		        				{
		        					strToken2 = new StringTokenizer(ligne2,delimiter);
		        					s = strToken2.nextToken();
		        					if (sal.getIdSalle() == Integer.parseInt(s)){
		        		            	CaracteristiqueDAOTXT cDAO= new CaracteristiqueDAOTXT();
			        					s2 = strToken2.nextToken();
		        		            	Caracteristique c = new Caracteristique(Integer.parseInt(s2));
		        		            	c = cDAO.find(c);    	
		        		            	car.add(c);
		        					
		        					}
		        				}
		        			}
		        			catch (NumberFormatException e) {
		        				e.printStackTrace();
		        			} catch (IOException e) {
		       					e.printStackTrace();
		       				}
		       			}
		       			catch (FileNotFoundException e) {
		       				e.printStackTrace();
		       			}
		        		sal.setCarSalle(car);
					}}	
				}
			}	
			catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        return sal;
	}



	public ArrayList<Salle> getListe() 
	{

		ArrayList<Salle> list = new ArrayList<Salle>();
		String file ="BDTXT/Salle.txt";
		String delimiter = "|";
		String ligne = null;
		StringTokenizer strToken = null;
		BufferedReader bufferReader;
		String s = null;
		try {
				bufferReader = new BufferedReader(new FileReader(file));
				try {
					while ((ligne = bufferReader.readLine())!=null) {				
						strToken = new StringTokenizer(ligne,delimiter);
							s = strToken.nextToken();
							Salle salle = new Salle(Integer.parseInt(s));
							SalleDAOTXT salleDAO = new SalleDAOTXT();
					   	 	salle = salleDAO.find(salle);
					   	 	list.add(salle);				
					}
					bufferReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		return list;
		
	}

	@Override
	public boolean create(Salle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Salle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Salle obj) {
		// TODO Auto-generated method stub
		return false;
	}	
}
