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
	private JMenu mnFichier;
	private JMenuItem itemSalle;
	private JMenuItem itemLog;
	private JMenuItem itemDelog;
	private JLabel texte;
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
		setBounds(350, 200, 600, 400);
		getContentPane().setLayout(null);		
		 texte = new JLabel("Bonjour "+ enseignant.getPrenom()+" !");
		texte.setBounds(126, 48, 171, 16);
		getContentPane().add(texte);
		mnGestion = new JMenu("Gestion");
		menuBar.add(mnGestion);
	
		itemLog.setVisible(false);
		
		itemDelog = new JMenuItem("DŽconnexion");
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
	
		if(ae.getActionCommand().equals("DŽconnexion"))
		{
			this.enseignant = null;
			getContentPane().remove(texte);
			texte.setVisible(false);
			initComponents();
			displayConnexion();
			
			
		}
		
		
		
		
		
		
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
