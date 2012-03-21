package persistance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import metier.Creneau;


public class CreneauDAOTXT extends DAO<Creneau>{

    private static final CreneauDAOTXT instance = new CreneauDAOTXT();

    /**
     * Méthode permettant de récupérer l'objet unique de type CreneauDAO
     * @return CreneauDAO - Instance unique de l'objet CreneauDAO
     */
    public final static CreneauDAOTXT getInstance() {
        return instance;
    }


	public Creneau find(Creneau c) {
		String file ="BDTXT/Creneau.txt";
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
					if (c.getIdCreneau() == Integer.parseInt(strToken.nextToken())){
					while (strToken.hasMoreTokens()){
					c.setHeureDeb(strToken.nextToken());
					c.setHeureFin(strToken.nextToken());
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
		return c;
	}


	public ArrayList<Creneau> getListe() {
		ArrayList<Creneau> list = new ArrayList<Creneau>();
		String file ="BDTXT/Creneau.txt";
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
					Creneau c = new Creneau(Integer.parseInt(strToken.nextToken()),strToken.nextToken(),strToken.nextToken());
					list.add(c);
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

	public boolean update(Creneau ancien, Creneau nouveau) {
		return false;
	}

	public boolean login(Creneau obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean create(Creneau obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(Creneau obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(Creneau obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
