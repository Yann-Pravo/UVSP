package metier;

import java.util.ArrayList;
import java.util.Date;

public class Reservation {

	private int idResa;
	private Date date;
	
	private Salle salle;
	private Creneau creneau;
	private Enseignement ens;
	private ArrayList<Caracteristique> caract;
	
	public Reservation(int id)
	{
		this.idResa = id;
	}
	
	public Reservation(int id, Date d, Salle s, Creneau c, Enseignement e, ArrayList<Caracteristique> car)
	{
		this.idResa = id;
		this.date = d;
		this.salle = s;
		this.creneau = c;
		this.ens = e;
		this.caract = car;
	}
	
	public Reservation(Date d, Salle s, Creneau c, Enseignement e, ArrayList<Caracteristique> car)
	{
		this.date = d;
		this.salle = s;
		this.creneau = c;
		this.ens = e;
		this.caract = car;
	}
	
	public Reservation(Date d, Creneau c, Enseignement e, ArrayList<Caracteristique> car)
	{
		this.date = d;
		this.creneau = c;
		this.ens = e;
		this.caract = car;
	}
	
	public String toString() {
		return this.getEns().getEnseignant().getNom() + " " + this.getIdResa();
	}
	
	public int getIdResa()
	{
		return this.idResa;
	}
	
	public void setIdResa(int id)
	{
		this.idResa = id;
	}
	
	
	
	public Date getDateResa()
	{
		return this.date;
	}
	
	public void setDateResa(Date d)
	{
		this.date = d;
	}
	

	
	public Salle getSalle() 
	{
		return this.salle;
	}
	public void setSalle(Salle salle) 
	{
		this.salle = salle;
	}
	
	
	public Enseignement getEns() 
	{
		return this.ens;
	}
	public void setEns(Enseignement ens) 
	{
		this.ens = ens;
	}
	
	
	
	
	public Creneau getCreneau() 
	{
		return this.creneau;
	}
	public void setCreneau(Creneau creneau) 
	{
		this.creneau = creneau;
	}
	
	
	
	public ArrayList<Caracteristique> getCarResa()
	{
		return this.caract;
	}
	
	public void setCarResa(ArrayList<Caracteristique> c)
	{
		this.caract = c;
	}
	
	
	
}
