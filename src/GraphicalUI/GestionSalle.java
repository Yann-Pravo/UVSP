package GraphicalUI;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import metier.Salle;
import metier.GestionnaireSalle;

public class GestionSalle extends JPanel {

	private GestionnaireSalle gSalle;
	private ArrayList<Salle> listSalle;
	
	JComboBox comboBox;
	
	/**
	 * Create the panel.
	 */
	public GestionSalle() {
		setLayout(null);
		
		gSalle = GestionnaireSalle.getInstance();
		
		comboBox = new JComboBox();
		comboBox.setBounds(6, 6, 150, 27);
		add(comboBox);
		
        initialize();

	}
	
	private void initialize() {
		int i = 0;
		try
        {
            this.listSalle = gSalle.getListeSalles();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erreur de récupération de la liste des salles dans la base de données", "Erreur BD", JOptionPane.ERROR_MESSAGE);
        }
		while(i < listSalle.size()) {
			comboBox.addItem(listSalle.get(i));
			i++;
		}
	}

}
