package persistance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import metier.TypeCours;

public class TypeCoursDAOTXT extends DAO<TypeCours>{

	private static final TypeCoursDAOTXT instance = new TypeCoursDAOTXT();

    /**
     * Méthode permettant de récupérer l'objet unique de type TypeCoursDAO
     * @return TypeCoursDAO - Instance unique de l'objet TypeCoursDAO
     */
    public final static TypeCoursDAOTXT getInstance() {
        return instance;
    }

	public TypeCours find(TypeCours instance) {
		String file ="BDTXT/typeCours.txt";
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
					if (instance.getIdTypeCours() == Integer.parseInt(strToken.nextToken())){
					while (strToken.hasMoreTokens()){
						instance.setNomTypeCours(strToken.nextToken());
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
		return instance;
	}

	public ArrayList<TypeCours> getListe() {
		ArrayList<TypeCours> list = new ArrayList<TypeCours>();
		String file ="BDTXT/typeCours.txt";
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
					TypeCours c = new TypeCours(Integer.parseInt(strToken.nextToken()),strToken.nextToken());
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

	public boolean update(TypeCours ancien, TypeCours nouveau) {
		return false;
	}

	public boolean login(TypeCours obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(TypeCours obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TypeCours obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TypeCours obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
