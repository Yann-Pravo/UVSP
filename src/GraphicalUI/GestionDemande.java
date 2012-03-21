package GraphicalUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import metier.GestionnaireReservation;
import metier.GestionnaireSalle;
import metier.Reservation;
import metier.Salle;

import ProgrammePrincipal.MainFrame;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class GestionDemande extends JPanel {

	private Reservation res;
	private GestionnaireReservation gRes;
	private ArrayList<Reservation> listRes;
	private Salle salle;
	private GestionnaireSalle gSalle;
	private ArrayList<Salle> listSalle;
	private JTextField textFieldMatiere;
	private JTextField textFieldType;
	private JTextField textFieldGroupe;
	private JComboBox comboBoxRes;
	private JComboBox comboBoxSalle;
	private JButton btnSupprimer;
	private JButton btnEnregistrer;
	private JTextField textFieldDate;
	private JTextField textFieldCren;
	private MainFrame mainFrame;
	
	/**
	 * Create the panel.
	 */
	public GestionDemande(MainFrame mainFrame, GestionnaireReservation gRes) {
		setLayout(null);
		
		this.mainFrame = mainFrame;
		this.gRes = gRes;
		gSalle = GestionnaireSalle.getInstance();
		
		comboBoxRes = new JComboBox();
		comboBoxRes.setBounds(6, 6, 124, 27);
		add(comboBoxRes);
		
		comboBoxSalle = new JComboBox();
		comboBoxSalle.setBounds(175, 6, 112, 27);
		add(comboBoxSalle);
		
		JLabel lblMatiere = DefaultComponentFactory.getInstance().createLabel("Mati\u00E8re :");
		lblMatiere.setBounds(6, 93, 61, 16);
		add(lblMatiere);
		
		textFieldMatiere = new JTextField();
		textFieldMatiere.setEditable(false);
		textFieldMatiere.setBounds(81, 87, 299, 28);
		add(textFieldMatiere);
		textFieldMatiere.setColumns(10);
		
		JLabel lblType = DefaultComponentFactory.getInstance().createLabel("Type : ");
		lblType.setBounds(7, 118, 61, 16);
		add(lblType);
		
		textFieldType = new JTextField();
		textFieldType.setEditable(false);
		textFieldType.setBounds(82, 112, 177, 28);
		add(textFieldType);
		textFieldType.setColumns(10);
		
		JLabel lblGroupe = DefaultComponentFactory.getInstance().createLabel("Groupe :");
		lblGroupe.setBounds(6, 142, 120, 16);
		add(lblGroupe);
		
		textFieldGroupe = new JTextField();
		textFieldGroupe.setEditable(false);
		textFieldGroupe.setBounds(82, 136, 177, 28);
		add(textFieldGroupe);
		textFieldGroupe.setColumns(10);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setIcon(new ImageIcon(GestionDemande.class.getResource("/ProgrammePrincipal/delete-icon.png")));
		btnSupprimer.setBounds(6, 176, 117, 32);
		add(btnSupprimer);
		
		btnEnregistrer = new JButton("Sauver");
		btnEnregistrer.setIcon(new ImageIcon(GestionDemande.class.getResource("/ProgrammePrincipal/save.png")));
		btnEnregistrer.setBounds(142, 176, 117, 32);
		add(btnEnregistrer);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(6, 55, 61, 16);
		add(lblDate);
		
		textFieldDate = new JTextField();
		textFieldDate.setEditable(false);
		textFieldDate.setBounds(81, 47, 97, 28);
		add(textFieldDate);
		textFieldDate.setColumns(10);
		
		JLabel lblCrneau = new JLabel("Cr\u00E9neau :");
		lblCrneau.setBounds(190, 55, 61, 16);
		add(lblCrneau);
		
		textFieldCren = new JTextField();
		textFieldCren.setEditable(false);
		textFieldCren.setBounds(263, 47, 117, 28);
		add(textFieldCren);
		textFieldCren.setColumns(10);
		
		initialize();

	}
	
	private void initialize() {
		listeReservation();
		
		btnSupprimer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
        		textFieldMatiere.setText("");
        		textFieldType.setText("");
        		textFieldGroupe.setText("");
        		textFieldDate.setText("");
        		textFieldCren.setText("");
        		
        		comboBoxRes.setSelectedIndex(0);
        		comboBoxSalle.setSelectedIndex(0);
        		
        		gRes.deleteReservation(res);
        		res = null;
        		listeReservation();
			}
		});
		
		btnEnregistrer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
        		if(comboBoxRes.getSelectedIndex() == 0 || comboBoxSalle.getSelectedIndex() == 0) {
        			JOptionPane.showMessageDialog(null, "Un ou plusieurs champs n'ont pas été remplis", "Erreur remplissage champ", JOptionPane.ERROR_MESSAGE);
        		}
        		else {
        			gRes.updateReservation(res, salle, res.getEns(), res.getDateResa(), res.getCarResa());
        			
            		textFieldMatiere.setText("");
            		textFieldType.setText("");
            		textFieldGroupe.setText("");
            		textFieldDate.setText("");
            		textFieldCren.setText("");

            		gRes = GestionnaireReservation.getInstance();
            		mainFrame.setGr(gRes);
            		
            		listeReservation();
            		listeSalle();
        		}
			}
		});
		
		comboBoxRes.addItemListener(new ItemListener(){
			 
            public void itemStateChanged(ItemEvent e) {
            	if(!e.getItem().equals(" -Sélectionnez une réservation- ")) {
	            	res = (Reservation) e.getItem();
	            	
                	SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy");
            		String dateString = formatter.format(res.getDateResa());
            		
	        		textFieldMatiere.setText(res.getEns().getCours().getMatiere().getNomMat());
	        		textFieldType.setText(res.getEns().getCours().getTypeCours().getNomTypeCours());
	        		textFieldGroupe.setText(res.getEns().getGroupe().getLibelle());
	        		textFieldDate.setText(dateString);
	        		textFieldCren.setText(res.getCreneau().toString());
	        		
	        		listeSalle();
            	}
            	else {
            		textFieldMatiere.setText("");
	        		textFieldType.setText("");
	        		textFieldGroupe.setText("");
	        		textFieldDate.setText("");
	        		textFieldCren.setText("");
            	}
            }               
		});
		
		comboBoxSalle.addItemListener(new ItemListener(){
			 
            public void itemStateChanged(ItemEvent e) {
            	if(!e.getItem().equals(" -Sélectionnez une salle- ")) {
	            	salle = (Salle) e.getItem();
            	}
            }               
		});
	}
	
	private void listeReservation() {
		try
        {
            this.listRes = gRes.getListeReservation();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erreur de récupération de la liste des réservations dans la base de données", "Erreur BD", JOptionPane.ERROR_MESSAGE);
        }
		
		comboBoxRes.removeAllItems();
		comboBoxRes.addItem(" -Sélectionnez une réservation- ");
		int i = 0;
		while(i < listRes.size()) {
			if(listRes.get(i).getSalle().getLibelle() == null) {
				comboBoxRes.addItem(listRes.get(i));
			}
			i++;
		}
	}
	
	private void listeSalle() {
		try
        {
			this.listSalle = gSalle.getListeSalles();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erreur de récupération de la liste des salles dans la base de données", "Erreur BD", JOptionPane.ERROR_MESSAGE);
        }
		
		comboBoxSalle.removeAllItems();
		comboBoxSalle.addItem(" -Sélectionnez une salle- ");
		
		boolean dispo = true;
		int j;
		for(int i = 0; i < listSalle.size(); i++) {
			j = 0;
			while(j < listRes.size() && dispo) {
				if(listRes.get(j).getSalle().getLibelle() != null && res.getCreneau().getIdCreneau() == listRes.get(j).getCreneau().getIdCreneau() && res.getDateResa().equals(listRes.get(j).getDateResa())) {
					if(listRes.get(j).getSalle().getIdSalle() == listSalle.get(i).getIdSalle()) {
						dispo = false;
					}
				}
				j++;
			}
			if (dispo) {
				comboBoxSalle.addItem(listSalle.get(i));
			}
			dispo = true;
		}

	}
}
