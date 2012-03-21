package persistance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import metier.Cours;
import metier.Matiere;
import metier.TypeCours;

public class CoursDAOTXT extends DAO<Cours> {
    
	private static final CoursDAOTXT instance = new CoursDAOTXT();
	
	/**
     * Méthode permettant de récupérer l'objet unique de type CoursDAO
     * @return CoursDAO - Instance unique de l'objet CoursDAO
     */
    public final static CoursDAOTXT getInstance() {
        return instance;
    }

   
    /**
     * Méthode qui recherche dans la base de données l'enregistrement correspondant
     * à la cours m en paramêtre et retourne les résultats sous forme d'un objet Cours.
     * @param m Objet Cours à rechercher dans la base de données
     * @return Cours - Objet Cours créé à partir des résultats trouvés dans la base
     */
    public Cours find(Cours c) {
       
    	String file ="BDTXT/Cours.txt";
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
					
					if (c.getIdCours() == Integer.parseInt(strToken.nextToken())){
					s = strToken.nextToken();
						MatiereDAOTXT matDAO = new MatiereDAOTXT();
						Matiere mat = new Matiere(Integer.parseInt(s));
						mat = matDAO.find(mat);
						
						TypeCoursDAOTXT typeDAO = new TypeCoursDAOTXT();
						TypeCours type = new TypeCours(Integer.parseInt(strToken.nextToken()));
						type = typeDAO.find(type);
						
						c.setMatiere(mat);
						c.setTypeCours(type);
						c.setLibelle(strToken.nextToken());
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
		return c;
    }

   
    public ArrayList<Cours> getListe() {
		ArrayList<Cours> list = new ArrayList<Cours>();
		String file ="BDTXT/Cours.txt";
		String delimiter = "|";
		String ligne = null;
		StringTokenizer strToken = null;
		BufferedReader bufferReader;
		int id;
		String libelle;
		try {
			bufferReader = new BufferedReader(new FileReader(file));						
			try {
				while ((ligne = bufferReader.readLine())!=null)
				{
					strToken = new StringTokenizer(ligne,delimiter);
					while (strToken.hasMoreTokens()){
		            	id =Integer.parseInt(strToken.nextToken());
						MatiereDAOTXT matDAO = new MatiereDAOTXT();
		                Matiere mat = new Matiere(Integer.parseInt(strToken.nextToken()));
		                mat = matDAO.find(mat);
		                
		                TypeCoursDAOTXT typeDAO = new TypeCoursDAOTXT();
		                TypeCours type = new TypeCours(Integer.parseInt(strToken.nextToken()));
		                type = typeDAO.find(type);	
		                
		                libelle = strToken.nextToken();
		                
		                Cours c = new Cours(id,libelle,mat,type);
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

    

    public boolean update(Cours ancien, Cours nouveau) {
        return false;
    }

	public boolean login(Cours obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean create(Cours obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(Cours obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(Cours obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
