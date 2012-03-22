package GraphicalUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import metier.Creneau;
import metier.Enseignant;
import metier.Enseignement;
import metier.GestionnaireCreneau;
import metier.GestionnaireEnseignement;
import metier.GestionnaireReservation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class GestionReservation extends JFrame {

	private GestionnaireReservation gRes;
	private GestionnaireCreneau gCreneau;
	private ArrayList<Creneau> listCreneau;
	private GestionnaireEnseignement gEns;
	private Enseignement ens;
	private ArrayList<Enseignement> listEns;
	private JTextField textFieldDateJ;
	private JLabel lblDate;
	private JLabel lblCréneau;
	private Enseignant enseignant;
	private JTextField textFieldMatiere;
	private JTextField textFieldType;
	private JTextField textFieldGroupe;
	private JComboBox comboBoxCreneau;
	private JComboBox comboBoxEnseignement;
	private JButton btnAnnuler;
	private JButton btnEnregistrer;
	
	/**
	 * Create the panel.
	 */
	public GestionReservation(Enseignant enseignant, GestionnaireReservation gRes) {
		setLayout(null);
		getContentPane().setLayout(null);
		this.enseignant = enseignant;
		this.setBounds(200, 200, 449, 429);
		this.gRes = gRes;
		gCreneau = GestionnaireCreneau.getInstance();
		gEns = GestionnaireEnseignement.getInstance();
		
		lblDate = new JLabel("Date : ");
		lblDate.setBounds(19, 38, 61, 16);
		getContentPane().add(lblDate);
		
		lblCréneau = new JLabel("Cr\u00E9neau :");
		lblCréneau.setBounds(19, 87, 76, 16);
		getContentPane().add(lblCréneau);
		
		textFieldDateJ = new JTextField();
		textFieldDateJ.setText("jj-MM-yyyy");
		textFieldDateJ.setBounds(183, 32, 157, 28);
		getContentPane().add(textFieldDateJ);
		textFieldDateJ.setColumns(10);
		
		JLabel lblEnseignement = new JLabel("Enseignement :");
		lblEnseignement.setBounds(19, 127, 119, 16);
		getContentPane().add(lblEnseignement);
		
		comboBoxCreneau = new JComboBox();
		comboBoxCreneau.setBounds(138, 83, 271, 27);
		getContentPane().add(comboBoxCreneau);
		
		comboBoxEnseignement = new JComboBox();
		comboBoxEnseignement.setBounds(138, 123, 271, 27);
		getContentPane().add(comboBoxEnseignement);
		
		JLabel lblMatiere = DefaultComponentFactory.getInstance().createLabel("Mati\u00E8re :");
		lblMatiere.setBounds(37, 189, 61, 16);
		getContentPane().add(lblMatiere);
		
		textFieldMatiere = new JTextField();
		textFieldMatiere.setEditable(false);
		textFieldMatiere.setBounds(110, 183, 299, 28);
		getContentPane().add(textFieldMatiere);
		textFieldMatiere.setColumns(10);
		
		JLabel lblType = DefaultComponentFactory.getInstance().createLabel("Type : ");
		lblType.setBounds(37, 227, 61, 16);
		getContentPane().add(lblType);
		
		textFieldType = new JTextField();
		textFieldType.setEditable(false);
		textFieldType.setBounds(110, 221, 299, 28);
		getContentPane().add(textFieldType);
		textFieldType.setColumns(10);
		
		JLabel lblGroupe = DefaultComponentFactory.getInstance().createLabel("Groupe :");
		lblGroupe.setBounds(37, 269, 120, 16);
		getContentPane().add(lblGroupe);
		
		textFieldGroupe = new JTextField();
		textFieldGroupe.setEditable(false);
		textFieldGroupe.setBounds(110, 263, 299, 28);
		getContentPane().add(textFieldGroupe);
		textFieldGroupe.setColumns(10);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setIcon(new ImageIcon(GestionReservation.class.getResource("/ProgrammePrincipal/delete-icon.png")));
		btnAnnuler.setBounds(274, 327, 117, 29);
		getContentPane().add(btnAnnuler);
		
		btnEnregistrer = new JButton("Sauver");
		btnEnregistrer.setIcon(new ImageIcon(GestionReservation.class.getResource("/ProgrammePrincipal/save.png")));
		btnEnregistrer.setBounds(67, 327, 117, 29);
		getContentPane().add(btnEnregistrer);
		
        initialize();

	}
	
	private void initialize() {
		listeCreneau();
		listeEnseignement();
		
		btnAnnuler.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
        		textFieldDateJ.setText("");
        		textFieldMatiere.setText("");
        		textFieldType.setText("");
        		textFieldGroupe.setText("");
        		
        		comboBoxEnseignement.setSelectedIndex(0);
        		comboBoxCreneau.setSelectedIndex(0);
			}
		});
		
		btnEnregistrer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
        		if(textFieldDateJ.getText().equals("") || comboBoxCreneau.getSelectedIndex() == 0 || comboBoxEnseignement.getSelectedIndex() == 0) {
        			JOptionPane.showMessageDialog(null, "Un ou plusieurs champs n'ont pas été remplis", "Erreur remplissage champ", JOptionPane.ERROR_MESSAGE);
        		}
        		else {
        			Date date;
        			try {
        				date = (new SimpleDateFormat( "dd-MM-yyyy" )).parse( textFieldDateJ.getText() );
        				gRes.addReservation((Creneau) comboBoxCreneau.getSelectedItem(), (Enseignement) comboBoxEnseignement.getSelectedItem(), date, null);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
        			
            		textFieldDateJ.setText("");
            		textFieldMatiere.setText("");
            		textFieldType.setText("");
            		textFieldGroupe.setText("");
            		
            		comboBoxEnseignement.setSelectedIndex(0);
            		comboBoxCreneau.setSelectedIndex(0);
        		}
			}
		});
		
		comboBoxEnseignement.addItemListener(new ItemListener(){
			 
            public void itemStateChanged(ItemEvent e) {
            	if(!e.getItem().equals(" -Sélectionnez un enseignement- ")) {
	            	ens = (Enseignement) e.getItem();
	        		textFieldMatiere.setText(ens.getCours().getMatiere().getNomMat());
	        		textFieldType.setText(ens.getCours().getTypeCours().getNomTypeCours());
	        		textFieldGroupe.setText(ens.getGroupe().getLibelle());
            	}
            	else {
            		textFieldMatiere.setText("");
	        		textFieldType.setText("");
	        		textFieldGroupe.setText("");
            	}
            }               
		});
	}
	
	private void listeCreneau() {
		try
        {
            this.listCreneau = gCreneau.getListeCreneaux();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erreur de récupération de la liste des créneaux dans la base de données", "Erreur BD", JOptionPane.ERROR_MESSAGE);
        }
		
		comboBoxCreneau.removeAllItems();
		comboBoxCreneau.addItem(" -Sélectionnez un créneau- ");
		int i = 0;
		while(i < listCreneau.size()) {
			comboBoxCreneau.addItem(listCreneau.get(i));
			i++;
		}
	}
	
	private void listeEnseignement() {
		try
        {
            this.listEns = gEns.getListeEnseignements();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erreur de récupération de la liste des enseignements dans la base de données", "Erreur BD", JOptionPane.ERROR_MESSAGE);
        }
		
		comboBoxEnseignement.removeAllItems();
		comboBoxEnseignement.addItem(" -Sélectionnez un enseignement- ");
		int i = 0;
		while(i < listEns.size()) {
			if (listEns.get(i).getEnseignant().getNom().compareTo(this.enseignant.getNom()) == 0 || this.enseignant.getSu() == 1) {
				comboBoxEnseignement.addItem(listEns.get(i));
			}
			i++;
		}
	}
}