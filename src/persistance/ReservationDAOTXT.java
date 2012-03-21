package persistance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import metier.Caracteristique;
import metier.Creneau;
import metier.Enseignement;
import metier.Reservation;
import metier.Salle;
import java.util.Date;

public class ReservationDAOTXT extends DAO<Reservation> {
	private static final ReservationDAOTXT instance = new ReservationDAOTXT();



	public final static ReservationDAOTXT getInstance()
	{
		return instance;
	}


	public boolean update(Reservation ancien, Reservation nouveau) {

		return false;
	}

	public Reservation find(Reservation res)
	{
		Salle s = null;
		SalleDAOTXT sDAO= new SalleDAOTXT(); 
		Creneau c;
		CreneauDAOTXT cDAO;
		Enseignement ens;
		EnseignementDAOTXT ensDAO;
		ArrayList<Caracteristique> car;
		String file ="BDTXT/Reservation.txt";
		String delimiter = "|";
		String ligne = null;
		StringTokenizer strToken = null;
		BufferedReader bufferReader;
		String str = null;
		String str2 = null;
		String file2 ="BDTXT/Reservation_Caracteristique.txt";
		String ligne2 = null;
		StringTokenizer strToken2 = null;
		BufferedReader bufferReader2;
		car = new ArrayList<Caracteristique>();
		try {
			bufferReader = new BufferedReader(new FileReader(file));						
			try {
				while ((ligne = bufferReader.readLine())!=null)
				{
					strToken = new StringTokenizer(ligne,delimiter);
					
					if (res.getIdResa() == Integer.parseInt(strToken.nextToken())){
						while (strToken.hasMoreTokens()){
							c = new Creneau(Integer.parseInt(strToken.nextToken()));
							cDAO = new CreneauDAOTXT();
							c = cDAO.find(c);

							ens = new Enseignement(Integer.parseInt(strToken.nextToken()));
							ensDAO = new EnseignementDAOTXT();
							ens = ensDAO.find(ens);



							SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
							try {
							bufferReader2 = new BufferedReader(new FileReader(file2));						
							try {
								while ((ligne2 = bufferReader2.readLine())!=null)
								{
									strToken2 = new StringTokenizer(ligne2,delimiter);
									if (res.getIdResa() == Integer.parseInt(strToken2.nextToken())){
										CaracteristiqueDAOTXT caDAO= new CaracteristiqueDAOTXT();
										Caracteristique ca = new Caracteristique(Integer.parseInt(strToken2.nextToken()));
										ca = caDAO.find(ca);
										car.add(ca);	
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

							str2 = strToken.nextToken();
							try {
								res.setDateResa(sdf.parse(str2));
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							if(strToken.hasMoreTokens()){
							str = strToken.nextToken();
							if (str.length()==0){
								s = new Salle(null);
							}
							if (str.length()>0){
								s = new Salle((Integer)Integer.parseInt(str));
								s = sDAO.find(s);	
							}
							}
							res.setSalle(s);
							res.setCreneau(c);
							res.setEns(ens);
							res.setCarResa(car);
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

		return res;

	}

	public ArrayList<Reservation> getListe() 
	{
		Reservation res;
		ReservationDAOTXT resDAO;
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		String file ="BDTXT/Reservation.txt";
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
					res = new Reservation(Integer.parseInt(strToken.nextToken()));
					resDAO = new ReservationDAOTXT();
					res = resDAO.find(res);
					list.add(res);
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

	public boolean login(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean create(Reservation obj){
		boolean ok = true;
		ArrayList<Reservation> lres = new ArrayList<Reservation>();
		ReservationDAOTXT DAOres = new ReservationDAOTXT();
		lres = DAOres.getListe();

		int id, idCreneau, idLensg;
		id = lres.get(lres.size()-1).getIdResa() +1;
		idCreneau = obj.getCreneau().getIdCreneau();
		idLensg = obj.getEns().getIdEnseignement();
		Date date = obj.getDateResa();	
		String s = id + "|" + idCreneau + "|" + idLensg+ "|" ;
//		if (String.valueOf(date.getDay()).length() == 1){
//			s = s + "0" + date.getDay() + "/";
//		}
//		if (String.valueOf(date.getDay()).length() == 2){
//			s = s+ date.getDay()+ "/";
//		}
//		if (String.valueOf(date.getMonth()).length() == 1){
//			s = s + "0" + date.getMonth()+ "/";
//		}
//		if (String.valueOf(date.getMonth()).length() == 2){
//			s = s+ date.getMonth()+ "/";
//		}
//			s = s + (date.getYear()+1900) +"|"; 
		SimpleDateFormat formatter = new SimpleDateFormat ("dd/mm/yyyy" ); 
		String dateString = formatter.format(date);
		s = s + dateString + "|";
		BufferedWriter bufWriter = null;
		FileWriter fileWriter = null;
		String filename = "BDTXT/Reservation.txt";
		try {
			fileWriter = new FileWriter(filename, true);
			bufWriter = new BufferedWriter(fileWriter);
			bufWriter.newLine();
			bufWriter.write(s);
			bufWriter.close();
			fileWriter.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} 
		return ok;
	}



	public boolean update(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}	
}
