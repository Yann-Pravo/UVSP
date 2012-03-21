package persistance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import metier.Cours;
import metier.Enseignant;
import metier.Enseignement;
import metier.Groupe;

public class EnseignementDAOTXT extends DAO<Enseignement>{
	private static final EnseignementDAOTXT instance = new EnseignementDAOTXT();

    /**
     * Méthode permettant de récupérer l'objet unique de type TypeEnseignementDAO
     * @return TypeEnseignementDAO - Instance unique de l'objet TypeEnseignementDAO
     */
    public final static EnseignementDAOTXT getInstance() {
        return instance;
    }

    

    public Enseignement find(Enseignement Enseig) {
        
    	String file ="BDTXT/Enseignement.txt";
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

					if (Enseig.getIdEnseignement() == Integer.parseInt(strToken.nextToken())){
		            	s = strToken.nextToken();
		            	CoursDAOTXT coursDAO = new CoursDAOTXT();
		            	Cours cours = new Cours(Integer.parseInt(s));
		           		cours = coursDAO.find(cours);  
		                EnseignantDAOTXT ensDAO = new EnseignantDAOTXT();
		                Enseignant ens = new Enseignant(Integer.parseInt(strToken.nextToken()));
		                ens = ensDAO.find(ens);
		                GroupeDAOTXT groupeDAO = new GroupeDAOTXT();
		                Groupe groupe = new Groupe(Integer.parseInt(strToken.nextToken()));
		                groupe = groupeDAO.find(groupe);
		                Enseig.setNbHeureReel(Double.parseDouble(strToken.nextToken()));
		                Enseig.setCours(cours);
		                Enseig.setEnseignant(ens);
		                Enseig.setGroupe(groupe);
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
		return Enseig;

    }

   

    public ArrayList<Enseignement> getListe() {
        ArrayList<Enseignement> list = new ArrayList<Enseignement>();
		String file ="BDTXT/Enseignement.txt";
		String delimiter = "|";
		String ligne = null;
		StringTokenizer strToken = null;
		BufferedReader bufferReader;
		int id;
		try {
			bufferReader = new BufferedReader(new FileReader(file));						
			try {
				while ((ligne = bufferReader.readLine())!=null)
				{
					strToken = new StringTokenizer(ligne,delimiter);
		            	id = Integer.parseInt(strToken.nextToken());
						Enseignement ensg = new Enseignement(id);
						EnseignementDAOTXT ensgDAO = new EnseignementDAOTXT();
				   	 	ensg = ensgDAO.find(ensg);
		                list.add(ensg);
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

	public boolean login(Enseignement obj) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean create(Enseignement obj) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean update(Enseignement obj) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean update(Enseignement ancien, Enseignement nouveau) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean delete(Enseignement obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
