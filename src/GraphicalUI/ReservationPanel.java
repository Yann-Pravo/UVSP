package GraphicalUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;

public class ReservationPanel extends JPanel {


	/**
	 * Create the panel.
	 */
	public ReservationPanel() {
		setLayout(null);
		
		JLabel lblRservationDunCrneau = new JLabel("R\u00E9servation d'un cr\u00E9neau dans l'emploi du temps :");
		lblRservationDunCrneau.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblRservationDunCrneau.setBounds(87, 43, 486, 16);
		add(lblRservationDunCrneau);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(42, 140, 61, 16);
		add(lblDate);
		
		
		


	}
}
