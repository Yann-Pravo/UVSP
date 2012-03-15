package GraphicalUI;

import java.util.ArrayList;

import javax.swing.JPanel;
import metier.Reservation;
import metier.GestionnaireReservation;
import metier.WeekDate;

public class Timetable extends JPanel {
	
	private GestionnaireReservation gr;
	private WeekDate wd;
	private ArrayList<Reservation> resa;
	
	
	public Timetable(WeekDate w) 
	{
		this.wd = w;
		this.gr = GestionnaireReservation.getInstance();
		ArrayList<Reservation> resa = gr.getListeReservation();
		initComponents();
	}
	
	
	public void initComponents()
	{
		
	}
}
