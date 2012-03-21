package persistance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import metier.Caracteristique;

public class CaracteristiqueDAOTXT extends DAO<Caracteristique>{

private static final CaracteristiqueDAOTXT instance = new CaracteristiqueDAOTXT();
	
	public final static CaracteristiqueDAOTXT getInstance()
	{
		return instance;
	}
	
	
	

	public boolean update(Caracteristique ancien, Caracteristique nouveau)
	{
		return false;
	}

	public Caracteristique find(Caracteristique ca) {
		
		String file ="BDTXT/Caracteristique.txt";
		String delimiter = "|";
		String ligne = null;
		StringTokenizer strToken = null;
		BufferedReader bufferReader;
		String s = null;
		try {
			bufferReader = new BufferedReader(new FileReader(file));						
			try {
				while ((ligne = bufferReader.readLine())!=null)
				{
					strToken = new StringTokenizer(ligne,delimiter);
					if (ca.getIdCar() == Integer.parseInt(strToken.nextToken())){
					s = strToken.nextToken();
					ca.setLibelle(s);
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
        return ca;
	}


	public ArrayList<Caracteristique> getListe() 
	{
		ArrayList<Caracteristique> list = new ArrayList<Caracteristique>();
		String file ="BDTXT/Caracteristique.txt";
		String delimiter = "|";
		String ligne = null;
		StringTokenizer strToken = null;
		BufferedReader bufferReader;
		try {
			bufferReader = new BufferedReader(new FileReader(file));						
			try {
				while ((ligne = bufferReader.readLine())!=null)
				{
					strToken = new StringTokenizer(ligne,delimiter);
					while (strToken.hasMoreTokens()){
					Caracteristique Cara = new Caracteristique(Integer.parseInt(strToken.nextToken()),strToken.nextToken());
					list.add(Cara);
					}
				}
				bufferReader.close();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;	
	}

	public boolean login(Caracteristique obj) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean create(Caracteristique obj) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean update(Caracteristique obj) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean delete(Caracteristique obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
