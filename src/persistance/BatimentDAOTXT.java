package persistance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import metier.Batiment;


public class BatimentDAOTXT extends DAO<Batiment>{

private static final BatimentDAOTXT instance = new BatimentDAOTXT();
	
	public final static BatimentDAOTXT getInstance()
	{
		return instance;
	}


	public boolean update(Batiment ancien, Batiment nouveau) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public Batiment find(Batiment bat) 
	{
	
		String file ="BDTXT/Batiment.txt";
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
					if (bat.getIdBat() == Integer.parseInt(strToken.nextToken())){
					while (strToken.hasMoreTokens()){
					bat.setLibelle(strToken.nextToken());
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
		return bat;
		
	}


	public ArrayList<Batiment> getListe() 
	{
		 
		ArrayList<Batiment> list = new ArrayList<Batiment>();
		String file ="BDTXT/Batiment.txt";
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
					Batiment bat = new Batiment(Integer.parseInt(strToken.nextToken()),strToken.nextToken());
					list.add(bat);
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

	public boolean login(Batiment obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean create(Batiment obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(Batiment obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(Batiment obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
