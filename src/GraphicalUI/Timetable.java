package GraphicalUI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import metier.GestionnaireReservation;
import metier.Reservation;
import metier.WeekDate;

public class Timetable extends JPanel {
	private TimetableModel model;
	GestionnaireReservation gr;
	private WeekDate wd;
	
	/**
	 * Create the panel.
	 */
	public Timetable(WeekDate d) 
	{
		this.wd = d;
		initComponents();
	


	}




	public void initComponents()
	{
		String m;
		gr = GestionnaireReservation.getInstance();
		ArrayList<Reservation> resa = gr.getListeReservation();
		SimpleDateFormat dateM = new SimpleDateFormat("dd/MM/yyyy");
		
		for(int i = 0; i<resa.size(); i++)
		{
			dateM = new SimpleDateFormat("dd/MM/yyy");
			m = dateM.format(resa.get(i).getDateResa());
			if(m.compareTo(this.wd.getMonday()) >= 0 && m.compareTo(this.wd.getSaturday()) <=0)
			{
				System.out.println(resa.get(i).getDateResa());
			}
		}
	}
}
