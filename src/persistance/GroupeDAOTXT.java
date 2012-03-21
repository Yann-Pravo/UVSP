package persistance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import metier.Groupe;

public class GroupeDAOTXT extends DAO<Groupe>{
	private static GroupeDAOTXT instance;


    /**
     * Méthode permettant de récupérer l'instance de la classe GroupeDAO
     * @return GroupeDAO - Instance unique de l'objet GroupeDAO
     */
    public final static GroupeDAOTXT getInstance() {
        if (instance == null)
            instance = new GroupeDAOTXT();
        return instance;
    }

    public Groupe find(Groupe grp)
    {
    	Groupe pere = null;
    	GroupeDAOTXT p = new GroupeDAOTXT();
		String file ="BDTXT/Groupe.txt";
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
					if (grp.getIdGroupe() == Integer.parseInt(strToken.nextToken())){
						s = strToken.nextToken();
						while (strToken.hasMoreTokens()){
							
							if (s.length() == 0) {
								pere = new Groupe(null);
							}
							if (s.length() == 1) {	
							
								pere = new Groupe((Integer)Integer.parseInt(s));
								pere = p.find(pere);
							}
							grp.setPere(pere);
							grp.setLibelle(strToken.nextToken());
						}
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
		
        return grp;
    }


    
    /**
     * Methode concrete qui renvoie la liste des groupes
     * @return un ArrayList<Groupe> qui contient les groupes
     */
    public ArrayList<Groupe> getListe() {
		ArrayList<Groupe> list = new ArrayList<Groupe>();
		String file ="BDTXT/Groupe.txt";
		String delimiter = "|";
		String ligne = null;
		StringTokenizer strToken = null;
		BufferedReader bufferReader;
		int id;
		String lib;
		String s = null;
		String s2 = null;
		Groupe pere = null;
		try {
			bufferReader = new BufferedReader(new FileReader(file));						
			try {
				while ((ligne = bufferReader.readLine())!=null)
				{
					strToken = new StringTokenizer(ligne,delimiter);

					while (strToken.hasMoreTokens()){
						s2 = strToken.nextToken();
						id = (Integer)Integer.parseInt(s2);
						GroupeDAOTXT groupeDAO = new GroupeDAOTXT();
						Groupe groupe = new Groupe(id);	
						s = strToken.nextToken();
						if (s.length() == 1){
							pere = new Groupe((Integer)Integer.parseInt(s));
							pere = groupeDAO.find(pere);

						}
						if (s.length() == 0) {			
							pere = new Groupe(null);
	                	}
						groupe.setPere(pere);
	                	lib = strToken.nextToken();
						groupe.setLibelle(lib);
		                list.add(groupe);
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
	public boolean login(Groupe obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(Groupe obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Groupe obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Groupe ancien, Groupe nouveau) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Groupe obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
