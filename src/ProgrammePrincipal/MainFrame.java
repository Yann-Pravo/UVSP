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

	public MainFrame() 
	{
		
		
		initComponents();
		displayConnexion();
        this.setSize(log.getWidth()+10,log.getHeight()+50);
        
		


	}

	
	
	private void initComponents()
	{
		
		setBounds(100, 100, 450, 300);
		setTitle("UVSP 1.0");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmSeLogguer = new JMenuItem("Connexion");
		mnFichier.add(mntmSeLogguer);
		
		JMenu mnAbout = new JMenu("About");
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
		JLabel lblVoustesConnect = new JLabel("Bonjour "+ enseignant.getPrenom()+" !");
		lblVoustesConnect.setBounds(126, 48, 171, 16);
		getContentPane().add(lblVoustesConnect);
		
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
