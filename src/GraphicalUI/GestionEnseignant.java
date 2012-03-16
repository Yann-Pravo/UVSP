package GraphicalUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import metier.Enseignant;
import metier.GestionnaireEnseignant;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class GestionEnseignant extends JPanel {

	private GestionnaireEnseignant gEns;
	private ArrayList<Enseignant> listEns;
	private Enseignant ens;
	private JTextField textFieldPrenom;
	private JTextField textFieldNom;
	private JTextField textFieldID;
	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JButton btnModifier;
	private JButton btnEnregistrer;
	private JButton btnAnnuler;
	private JLabel lblId;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JPasswordField passwordField;
	private JCheckBox chckbxNewCheckBox;
	JComboBox comboBox;
	
	/**
	 * Create the panel.
	 */
	public GestionEnseignant() {
		setLayout(null);
		
		gEns = GestionnaireEnseignant.getInstance();
		
		lblId = new JLabel("ID : ");
		lblId.setBounds(19, 63, 61, 16);
		add(lblId);
		
		lblNom = new JLabel("Nom : ");
		lblNom.setBounds(19, 103, 61, 16);
		add(lblNom);
		
		lblPrenom = new JLabel("Pr\u00E9nom :");
		lblPrenom.setBounds(19, 143, 76, 16);
		add(lblPrenom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setEditable(false);
		textFieldPrenom.setBounds(94, 137, 157, 28);
		add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		textFieldNom = new JTextField();
		textFieldNom.setEditable(false);
		textFieldNom.setBounds(94, 97, 157, 28);
		add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setBounds(94, 57, 157, 28);
		add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblMDP = new JLabel("Password :");
		lblMDP.setBounds(19, 183, 119, 16);
		add(lblMDP);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setIcon(new ImageIcon("./src/ProgrammePrincipal/add.png"));
		btnAjouter.setBounds(19, 250, 110, 32);
		add(btnAjouter);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setIcon(new ImageIcon("./src/ProgrammePrincipal/delete-icon.png"));
		btnSupprimer.setBounds(141, 250, 110, 32);
		add(btnSupprimer);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setIcon(new ImageIcon("./src/ProgrammePrincipal/update.png"));
		btnModifier.setBounds(19, 250, 110, 32);
		add(btnModifier);
		
		btnEnregistrer = new JButton("Sauver");
		btnEnregistrer.setIcon(new ImageIcon("./src/ProgrammePrincipal/save.png"));
		btnEnregistrer.setBounds(141, 250, 110, 32);
		add(btnEnregistrer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setIcon(new ImageIcon("./src/ProgrammePrincipal/delete-icon.png"));
		btnAnnuler.setBounds(19, 250, 110, 32);
		add(btnAnnuler);
		
		passwordField = new JPasswordField();
		passwordField.setEditable(false);
		passwordField.setBounds(94, 177, 157, 28);
		add(passwordField);
		
		chckbxNewCheckBox = new JCheckBox("Super-Utilisateur");
		chckbxNewCheckBox.setEnabled(false);
		chckbxNewCheckBox.setBounds(94, 216, 157, 23);
		add(chckbxNewCheckBox);
		
		comboBox = new JComboBox();
		comboBox.setBounds(19, 6, 252, 27);
		add(comboBox);
		
		btnSupprimer.setVisible(false);
		btnEnregistrer.setVisible(false);
		btnModifier.setVisible(false);
		btnAnnuler.setVisible(false);
		

		
        initialize();

	}
	
	private void initialize() {
		listeEnseignant();
		
		btnAjouter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				textFieldNom.setEditable(true);
				textFieldPrenom.setEditable(true);
				passwordField.setEditable(true);
				chckbxNewCheckBox.setEnabled(true);
				
				btnEnregistrer.setVisible(true);
            	btnAjouter.setVisible(false);
            	btnModifier.setVisible(false);
            	btnSupprimer.setVisible(false);
            	btnAnnuler.setVisible(true);
			}
		});
		
		btnAnnuler.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
        		textFieldID.setText("");
        		textFieldNom.setText("");
        		textFieldPrenom.setText("");
        		passwordField.setText("");
        		chckbxNewCheckBox.setSelected(false);
        		
				textFieldNom.setEditable(false);
				textFieldPrenom.setEditable(false);
				passwordField.setEditable(false);
				chckbxNewCheckBox.setEnabled(false);
				
				btnEnregistrer.setVisible(false);
            	btnAjouter.setVisible(true);
            	btnAnnuler.setVisible(false);
			}
		});
		
		btnEnregistrer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				textFieldNom.setEditable(false);
				textFieldPrenom.setEditable(false);
				passwordField.setEditable(false);
				chckbxNewCheckBox.setEnabled(false);
				
				btnEnregistrer.setVisible(false);
            	btnAjouter.setVisible(true);
            	btnAnnuler.setVisible(false);
            	
        		if(textFieldNom.getText().equals("") || textFieldPrenom.getText().equals("") || passwordField.getPassword().equals("")) {
        			JOptionPane.showMessageDialog(null, "Un ou plusieurs champs n'ont pas été remplis", "Erreur remplissage champ", JOptionPane.ERROR_MESSAGE);
        		}
        		else {
        			int su = 0;
        			if(chckbxNewCheckBox.isSelected()) {
        				su = 1;
        			}
        			if(textFieldID.getText().equals("")) {
            			gEns.addEnseignant(textFieldNom.getText(), textFieldPrenom.getText(), new String(passwordField.getPassword()), su);
        			}
        			else
        			{
        				System.out.println("test");
        				gEns.updateEnseignant(new Enseignant(Integer.parseInt(textFieldID.getText())), textFieldNom.getText(), textFieldPrenom.getText(), new String(passwordField.getPassword()), su);
        			}
        			listeEnseignant();
        		}
			}
		});
		
		btnSupprimer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {		
				btnSupprimer.setVisible(false);
				btnEnregistrer.setVisible(false);
				btnModifier.setVisible(false);
				btnAnnuler.setVisible(false);
				
				gEns.deleteEnseignant(new Enseignant(Integer.parseInt(textFieldID.getText())));

				comboBox.setSelectedIndex(0);
				listeEnseignant();
			}
		});
		
		btnModifier.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {		
				btnSupprimer.setVisible(false);
				btnEnregistrer.setVisible(true);
				btnModifier.setVisible(false);
				btnAnnuler.setVisible(true);
				
				textFieldNom.setEditable(true);
				textFieldPrenom.setEditable(true);
				passwordField.setEditable(true);
				chckbxNewCheckBox.setEnabled(true);
			}
		});
		comboBox.addItemListener(new ItemListener(){
			 
            public void itemStateChanged(ItemEvent e) {
            	if(!e.getItem().equals(" -Sélectionnez un enseignant- ")) {
	            	ens = (Enseignant) e.getItem();
	            	textFieldID.setText(Integer.toString( ens.getIdEns() ));
	            	textFieldNom.setText(ens.getNom());
	            	textFieldPrenom.setText(ens.getPrenom());
	            	passwordField.setText(ens.getMdp());
	            	if(ens.getSu() == 1){
	            		chckbxNewCheckBox.setSelected(true);
	            	}
	            	else {
	            		chckbxNewCheckBox.setSelected(false);
	            	}
	            	
	            	
	            	
	            	btnSupprimer.setVisible(true);
	            	btnModifier.setVisible(true);
	            	btnAjouter.setVisible(false);
	            	
					textFieldID.setEditable(false);
					textFieldNom.setEditable(false);
					textFieldPrenom.setEditable(false);
	            	
            	}
            	else {
            		textFieldID.setText("");
            		textFieldNom.setText("");
            		textFieldPrenom.setText("");
            		passwordField.setText("");
            		
	            	btnSupprimer.setVisible(false);
	            	btnAjouter.setVisible(true);
	            	chckbxNewCheckBox.setSelected(false);
            	}
            }               
		});
	}
	
	private void listeEnseignant() {
		try
        {
            this.listEns = gEns.getListeEnseignants();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erreur de récupération de la liste des enseignants dans la base de données", "Erreur BD", JOptionPane.ERROR_MESSAGE);
        }
		
		comboBox.removeAllItems();
		comboBox.addItem(" -Sélectionnez un enseignant- ");
		int i = 0;
		while(i < listEns.size()) {
			comboBox.addItem(listEns.get(i));
			i++;
		}
	}
}