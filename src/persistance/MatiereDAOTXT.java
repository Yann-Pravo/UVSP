package persistance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import metier.Enseignant;
import metier.Matiere;
import metier.UE;

public class MatiereDAOTXT extends DAO<Matiere>{
	 private static final MatiereDAOTXT instance = new MatiereDAOTXT();
	    
	    /**
	     * Méthode permettant de récupérer l'objet unique de type MatiereDAO
	     * @return MatiereDAO - Instance unique de l'objet MatiereDAO
	     */
	    public final static MatiereDAOTXT getInstance() {
	        return instance;
	    }

	    /**
	     * Méthode qui recherche dans la base de données l'enregistrement correspondant
	     * à la matière m en paramêtre et retourne les résultats sous forme d'un objet Matiere.
	     * @param m Objet Matiere à rechercher dans la base de données
	     * @return Matiere - Objet Matiere créé à partir des résultats trouvés dans la base
	     */
	    public Matiere find(Matiere m) {
	 
	    	String file ="BDTXT/Matiere.txt";
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
						if (m.getIdMat() == Integer.parseInt(strToken.nextToken())){
							UEDAOTXT ueDAO = new UEDAOTXT();
			                UE ue = new UE(Integer.parseInt(strToken.nextToken()));
			                ue = ueDAO.find(ue);
			                
			                EnseignantDAOTXT ensDAO = new EnseignantDAOTXT();
			                Enseignant ens = new Enseignant(Integer.parseInt(strToken.nextToken()));
			                ens = ensDAO.find(ens);
			                s = strToken.nextToken();
			                m.setNomMat(s);
			                m.setUEMat(ue);
			                m.setResponsable(ens);
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
	        return m;
	    }


	    /**
	     * Méthode qui :
	     *      1) récupère l'ensemble des matières de la table correspondante dans la base
	     *      2) les mappe en objet java Matiere
	     *      3) les stocke dans une liste d'ojbets Matiere
	     * @exception SQLException
	     * @return ArrayList<Matiere> - Liste des matières stockées dans la base
	     */
	    public ArrayList<Matiere> getListe() {
	        ArrayList<Matiere> list = new ArrayList<Matiere>();
	        String file ="BDTXT/Matiere.txt";
			String delimiter = "|";
			String ligne = null;
			StringTokenizer strToken = null;
			BufferedReader bufferReader;
			int id;
			String lib;
			try {
				bufferReader = new BufferedReader(new FileReader(file));						
				try {
					while ((ligne = bufferReader.readLine())!=null)
					{
						strToken = new StringTokenizer(ligne,delimiter);
						while (strToken.hasMoreTokens()){
							id = Integer.parseInt(strToken.nextToken());
							UEDAOTXT ueDAO = new UEDAOTXT();
							UE ue = new UE(Integer.parseInt(strToken.nextToken()));
							ue = ueDAO.find(ue);
							
							EnseignantDAOTXT ensDAO = new EnseignantDAOTXT();
							Enseignant ens = new Enseignant(Integer.parseInt(strToken.nextToken()));
							ens = ensDAO.find(ens);
							lib = strToken.nextToken();
							Matiere m = new Matiere(id,lib, ue, ens);
							list.add(m);
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


	    public boolean update(Matiere ancien, Matiere nouveau) {
	        return false;
	    }

		public boolean login(Matiere obj) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean create(Matiere obj) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean update(Matiere obj) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean delete(Matiere obj) {
			// TODO Auto-generated method stub
			return false;
		}
}
