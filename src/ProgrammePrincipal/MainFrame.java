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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;


public class MainFrame extends JFrame implements ActionListener, ErrorInterface{
	
	Login log;
	private Enseignant enseignant;
	private JMenuBar menuBar;
	private JMenu mnAbout;
	private JMenu mnFichier;
	private JMenuItem itemSalle;
	private JMenuItem itemLog;
	private JMenuItem itemDelog;
	private JLabel texte;
	private JLabel titre;
	private JMenu mnGestion;

	public MainFrame() 
	{
		
		
		initComponents();
		displayConnexion();
        //this.setSize(461,292);
        
		


	}

	
	
	private void initComponents()
	{
		
		setBounds(350, 200, 450, 300);
		setTitle("UVSP 1.0");
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		itemLog = new JMenuItem("Connexion");
		itemLog.addActionListener(this);
		mnFichier.add(itemLog);
		
		JMenuItem itemQuit = new JMenuItem("Quitter");
		itemQuit.addActionListener(this);
		mnFichier.add(itemQuit);
		
		
		
	}


	private void displayConnexion()
	{
		log = new Login(this);
		log.setSize(450, 300);
		log.setVisible(true);
		getContentPane().add(log);
		this.setSize(log.getWidth(),log.getHeight()+50);
		
		
		
		
	}

	public void displayHome()
	{
		this.getContentPane().setLayout(null);
		setBounds(50, 50, 1200, 700);
		//getContentPane().setLayout(null);		
		
		texte = new JLabel("Connecté en tant que "+ enseignant.getPrenom()+" "+enseignant.getNom());
		texte.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		texte.setBounds(30, 10, 250, 16);
		getContentPane().add(texte);
		
		titre = new JLabel("Emploi du temps IG4");
		titre.setBounds(350, 50, 250, 25);
		titre.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		getContentPane().add(titre);
		
		mnGestion = new JMenu("Gestion");
		menuBar.add(mnGestion);
	
		itemLog.setVisible(false);
		
		itemDelog = new JMenuItem("Déconnexion");
		itemDelog.addActionListener(this);
		mnFichier.add(itemDelog);
		
		JMenuItem itemSalle = new JMenuItem("Gestion des salles");
		itemSalle.addActionListener(this);
		mnGestion.add(itemSalle);
		
	
		
		JMenuItem mntmGestionDesRservations = new JMenuItem("Gestion des r\u00E9servations");
		mnGestion.add(mntmGestionDesRservations);
		
		JMenu mnAffichage = new JMenu("Affichage");
		menuBar.add(mnAffichage);
		
		JMenuItem mntmAfficherLeCalendrier = new JMenuItem("Afficher le calendrier");
		mnAffichage.add(mntmAfficherLeCalendrier);
		
		
		mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem itemAbout = new JMenuItem("A propos de UVSP");
		itemAbout.addActionListener(this);
		mnAbout.add(itemAbout);
		
		
		JButton nextButton = new JButton();
		nextButton.setIcon(new ImageIcon("/Users/clementbalestrat/Desktop/projetJava/UVSP/suivant.png"));
		nextButton.setBounds(1000, 40, 79, 44);
		add(nextButton);
		
		JButton backButton = new JButton("");
		backButton.setIcon(new ImageIcon("/Users/clementbalestrat/Desktop/projetJava/UVSP/precedent.png"));
		backButton.setBounds(700, 40, 79, 44);
		add(backButton);
		
		JLabel weekLabel = new JLabel();
		weekLabel.setBounds(815, 40, 200, 44);
		weekLabel.setText("01/01/12 au 07/01/12");
		weekLabel.setBorder(BorderFactory.createCompoundBorder());
		weekLabel.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		add(weekLabel);
	
		
	    //Les données du tableau
			Object[][] data = {	{" ", " ", " ", " ", " ", " "},
					{" ", " ", " ", " ", " ", " "},
					{" ", " ", " ", " ", " ", " "},
					{" ", " ", " ", " ", " ", " "},
					{" ", " ", " ", " ", " ", " "},
					{" ", " ", " ", " ", " ", " "},
			};
		        //Les titres des colonnes
			String  title[] = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
			JTable tableau = new JTable(data, title);
		
		
	                //On ajoute notre tableau à notre contentPane dans un scroll
	                //Sinon les titres des colonnes ne s'afficheront pas ! !	
		
			JScrollPane js = new JScrollPane(tableau);
		
			js.setBounds(350, 100, 800, 500);
			
			this.getContentPane().add(js);
		
			
		

			
			
		
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
		if(ae.getActionCommand().equals("A propos de UVSP"))
		{
			About a = new About();
			a.setVisible(true);
		}
		if(ae.getActionCommand().equals("Quitter"))
		{
			System.out.println("test");
			System.exit(0);
		}
		
		if(ae.getActionCommand().equals("Connexion"))
		{
			displayConnexion();
		}
	
		if(ae.getActionCommand().equals("Déconnexion"))
		{
			this.enseignant = null;
			getContentPane().remove(texte);
			texte.setVisible(false);
			initComponents();
			displayConnexion();
			
			
		}
		
		
		
		
		
		
		
		
	}
	
}
