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

public class MainFrame extends JFrame implements ActionListener, ErrorInterface{
	
	Login log;
	private Enseignant enseignant;

	public MainFrame() 
	{
		
		initComponents();

		


	}

	
	
	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
	}


	private void displayConnexion()
	{
		log = new Login(this);
		getContentPane().add(log);
		log.setVisible(true);
	}


	public void setEnseignant(Enseignant e)
	{
		this.enseignant = e;
	}


	@Override
	public void displayError(String Error) 
	{
		// TODO Auto-generated method stub
	
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
