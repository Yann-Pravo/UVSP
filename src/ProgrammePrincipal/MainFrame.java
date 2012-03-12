package ProgrammePrincipal;
import GraphicalUI.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.Enseignant;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;


public class MainFrame extends JFrame implements ActionListener, ErrorInterface{
	
	Login log;
	private Enseignant enseignant;
	private JMenuBar menuBar;
	private JMenu mnAbout;
	private JMenuItem itemSalle;
	private JLabel texte;
	private JMenu mnGestion;

	public MainFrame() 
	{
		
		
		initComponents();
		displayConnexion();
        this.setSize(461,292);
        
		


	}

	
	
	private void initComponents()
	{
		
		setBounds(100, 100, 450, 300);
		setTitle("UVSP 1.0");
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmSeLogguer = new JMenuItem("Connexion");
		mnFichier.add(mntmSeLogguer);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mnFichier.add(mntmQuitter);
		
		
		mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmAProposDe = new JMenuItem("A propos de UVSP");
		mnAbout.add(mntmAProposDe);
	}


	private void displayConnexion()
	{
		log = new Login(this);
		getContentPane().add(log);
		log.setVisible(true);
		this.setSize(511,318);
		
	}

	public void displayHome()
	{
		
		getContentPane().setLayout(null);		
		 texte = new JLabel("Bonjour "+ enseignant.getPrenom()+" !");
		texte.setBounds(126, 48, 171, 16);
		getContentPane().add(texte);
		mnGestion = new JMenu("Gestion");
		menuBar.add(mnGestion);
		menuBar.remove(mnAbout);
		
		JMenuItem itemSalle = new JMenuItem("Gestion des salles");
		itemSalle.addActionListener(this);
		mnGestion.add(itemSalle);
		
	
		
		JMenuItem mntmGestionDesRservations = new JMenuItem("Gestion des r\u00E9servations");
		mnGestion.add(mntmGestionDesRservations);
		
		JMenu mnAffichage = new JMenu("Affichage");
		menuBar.add(mnAffichage);
		
		JMenuItem mntmAfficherLeCalendrier = new JMenuItem("Afficher le calendrier");
		mnAffichage.add(mntmAfficherLeCalendrier);
		
		menuBar.add(mnAbout);
		
		
		
		
	}
	
	

	public void setEnseignant(Enseignant e)
	{
		this.enseignant = e;
	}


	@Override
	public void displayError(String errorMsg) 
	{
		ErrorPopup err = ErrorPopup.getInstance(this, true);
        err.setErrorMsg(errorMsg);
        err.setVisible(true);
	
	}


	@Override
	public void actionPerformed(ActionEvent ae) 
	{

		
		if(ae.getActionCommand().equals("Gestion des salles"))
		{
			GestionSalle gs = new GestionSalle();
			this.getContentPane().setLayout(new BorderLayout());
			this.getContentPane().remove(log);
			this.getContentPane().remove(texte);
			this.getContentPane().add(gs, BorderLayout.CENTER);
			this.validate();
			
			gs.setVisible(true);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
