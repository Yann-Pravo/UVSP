package GraphicalUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import metier.Batiment;
import metier.Salle;
import metier.GestionnaireSalle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class GestionSalle extends JFrame {

	private GestionnaireSalle gSalle;
	private ArrayList<Salle> listSalle;
	private Salle salle;
	
	JComboBox comboBox;
	private JTextField textFieldBatiment;
	private JTextField textFieldLibelle;
	private JTextField textFieldID;
	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JList listCar;
	private JButton btnModifier;
	private JButton btnEnregistrer;
	private JButton btnAnnuler;
	private JLabel lblId;
	private JLabel lblLibell;
	private JLabel lblBatiment;
	
	/**
	 * Create the panel.
	 */
	public GestionSalle() {
		getContentPane().setLayout(null);
		this.setTitle("Gestion des salles");
		this.setBounds(200, 200, 449, 429);
		gSalle = GestionnaireSalle.getInstance();
		
		comboBox = new JComboBox();
		comboBox.setBounds(107, 48, 222, 27);
		getContentPane().add(comboBox);
		
		lblId = new JLabel("ID : ");
		lblId.setBounds(32, 131, 61, 16);
		getContentPane().add(lblId);
		
		lblLibell = new JLabel("Libell\u00E9 : ");
		lblLibell.setBounds(32, 171, 61, 16);
		getContentPane().add(lblLibell);
		
		lblBatiment = new JLabel("Batiment : ");
		lblBatiment.setBounds(32, 211, 76, 16);
		getContentPane().add(lblBatiment);
		
		textFieldBatiment = new JTextField();
		textFieldBatiment.setEditable(false);
		textFieldBatiment.setBounds(163, 205, 204, 28);
		getContentPane().add(textFieldBatiment);
		textFieldBatiment.setColumns(10);
		
		textFieldLibelle = new JTextField();
		textFieldLibelle.setEditable(false);
		textFieldLibelle.setBounds(163, 165, 204, 28);
		getContentPane().add(textFieldLibelle);
		textFieldLibelle.setColumns(10);
		
		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setBounds(163, 125, 204, 28);
		getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblCaractristique = new JLabel("Caract\u00E9ristiques : ");
		lblCaractristique.setBounds(32, 250, 119, 16);
		getContentPane().add(lblCaractristique);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setIcon(new ImageIcon("./src/ProgrammePrincipal/add.png"));
		btnAjouter.setBounds(71, 346, 110, 32);
		getContentPane().add(btnAjouter);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setIcon(new ImageIcon("./src/ProgrammePrincipal/delete-icon.png"));
		btnSupprimer.setBounds(265, 346, 110, 32);
		getContentPane().add(btnSupprimer);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setIcon(new ImageIcon("./src/ProgrammePrincipal/update.png"));
		btnModifier.setBounds(71, 346, 110, 32);
		getContentPane().add(btnModifier);
		
		btnEnregistrer = new JButton("Sauver");
		btnEnregistrer.setIcon(new ImageIcon("./src/ProgrammePrincipal/save.png"));
		btnEnregistrer.setBounds(265, 346, 110, 32);
		getContentPane().add(btnEnregistrer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setIcon(new ImageIcon("./src/ProgrammePrincipal/delete-icon.png"));
		btnAnnuler.setBounds(71, 346, 110, 32);
		getContentPane().add(btnAnnuler);
		
		btnSupprimer.setVisible(false);
		btnEnregistrer.setVisible(false);
		btnModifier.setVisible(false);
		btnAnnuler.setVisible(false);
		

		
        initialize();

	}
	
	private void initialize() {
		listeSalle();
		
		btnAjouter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				textFieldLibelle.setEditable(true);
				
				btnEnregistrer.setVisible(true);
            	btnAjouter.setVisible(false);
            	btnModifier.setVisible(false);
            	btnSupprimer.setVisible(false);
            	btnAnnuler.setVisible(true);
            	
            	textFieldBatiment.setText("Polytech");
			}
		});
		
		btnAnnuler.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
        		textFieldID.setText("");
        		textFieldLibelle.setText("");
        		textFieldBatiment.setText("");
        		
				textFieldID.setEditable(false);
				textFieldLibelle.setEditable(false);
				textFieldBatiment.setEditable(false);
				
				btnEnregistrer.setVisible(false);
            	btnAjouter.setVisible(true);
            	btnAnnuler.setVisible(false);
			}
		});
		
		btnEnregistrer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				textFieldLibelle.setEditable(false);
				textFieldBatiment.setEditable(false);
				
				btnEnregistrer.setVisible(false);
            	btnAjouter.setVisible(true);
            	btnAnnuler.setVisible(false);
        		if(textFieldLibelle.getText().equals("")) {
        			JOptionPane.showMessageDialog(null, "Un ou plusieurs champs n'ont pas été remplis", "Erreur remplissage champ", JOptionPane.ERROR_MESSAGE);
        		}
        		else {
	            	if(textFieldID.getText().equals("")) {
	            		gSalle.addSalle(textFieldLibelle.getText(), new Batiment(1,textFieldBatiment.getText()), null);
	            	}
	            	else {
	            		gSalle.updateSalle(new Salle(Integer.parseInt(textFieldID.getText())), Integer.parseInt(textFieldID.getText()), textFieldLibelle.getText(), new Batiment(1,textFieldBatiment.getText()), null);
	            	}
	            	listeSalle();
        		}
			}
		});
		
		btnSupprimer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {		
				btnSupprimer.setVisible(false);
				btnEnregistrer.setVisible(false);
				btnModifier.setVisible(false);
				btnAnnuler.setVisible(false);
				
				
				gSalle.deleteSalle(new Salle(Integer.parseInt(textFieldID.getText())));

				comboBox.setSelectedIndex(0);
				listeSalle();
			}
		});
		
		btnModifier.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {		
				btnSupprimer.setVisible(false);
				btnEnregistrer.setVisible(true);
				btnModifier.setVisible(false);
				btnAnnuler.setVisible(true);
				
				textFieldLibelle.setEditable(true);
			}
		});
		
		listCar = new JList();
		listCar.setVisibleRowCount(4);
		listCar.setBounds(163, 250, 204, 73);
		getContentPane().add(listCar);
		
		comboBox.addItemListener(new ItemListener(){
			 
            public void itemStateChanged(ItemEvent e) {
            	if(!e.getItem().equals(" -Sélectionnez une salle- ")) {
	            	salle = (Salle) e.getItem();
	            	textFieldID.setText(Integer.toString( salle.getIdSalle() ));
	            	textFieldLibelle.setText(salle.getLibelle());
	            	textFieldBatiment.setText(salle.getBatiment().getLibelle());
	            	listCar.setListData(salle.getCarSalle().toArray());
	            	
	            	btnSupprimer.setVisible(true);
	            	btnModifier.setVisible(true);
	            	btnAjouter.setVisible(false);
	            	
					textFieldID.setEditable(false);
					textFieldLibelle.setEditable(false);
					textFieldBatiment.setEditable(false);
	            	
            	}
            	else {
            		textFieldID.setText("");
            		textFieldLibelle.setText("");
            		textFieldBatiment.setText("");
            		
	            	btnSupprimer.setVisible(false);
	            	btnAjouter.setVisible(true);
            	}
            }               
		});
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
		
		comboBox.removeAllItems();
		comboBox.addItem(" -Sélectionnez une salle- ");
		int i = 0;
		while(i < listSalle.size()) {
			comboBox.addItem(listSalle.get(i));
			i++;
		}
	}
}
