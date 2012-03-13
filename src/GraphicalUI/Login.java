package GraphicalUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import ProgrammePrincipal.MainFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import persistance.*;
import metier.*;



public class Login extends JInternalFrame {
	
	private MainFrame main;
	private JTextField loginField;
	private JPasswordField passwordField;
	private JLabel frameTitle;
	private JLabel frameSubTitle;
	private JButton connexionButton;
	private JLabel missing;
	private JLabel loginLabel;
	private JLabel mdpLabel;
	
	public Login(MainFrame m) 
	{
		super("Connexion", true, true, true, true);
		this.main = m;
		//this.setBounds(100, 100, 100, 300);
		this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		this.initComponents();
		
		this.missing.setVisible(false);
		
	}
	
	

	/**
	 * Create the frame.
	 */
	private void  initComponents() {
		
		
		
		frameTitle = new JLabel("Bienvenue sur UVSP 1.0\n");
		frameSubTitle = new JLabel("Veuillez vous identifier");
		connexionButton = new JButton("Se connecter");
		missing = new JLabel("Attention, tous les champs ne sont pas remplis !");
		loginLabel = new JLabel("Login : ");
		mdpLabel = new JLabel("Mot de passe : ");
		
		
	
		missing.setVisible(false);
		
		
		frameTitle.setFont(new Font("Verdana", Font.BOLD, 18));
		frameTitle.setBounds(78, 30, 290, 22);
		frameSubTitle.setBounds(136, 64, 183, 16);
		loginLabel.setBounds(82, 108, 61, 16);
		
		
		getContentPane().setLayout(null);
		getContentPane().add(frameTitle);	
		getContentPane().add(frameSubTitle);
		getContentPane().add(loginLabel);
		
		loginField = new JTextField();
		loginField.setBounds(219, 102, 134, 28);
		getContentPane().add(loginField);
		loginField.setColumns(10);
		
		
		mdpLabel.setBounds(78, 150, 103, 16);
		getContentPane().add(mdpLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(219, 144, 134, 28);
		getContentPane().add(passwordField);
		
		
		connexionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) 
			{
				connexionButtonActionPerformed(evt);

				
			}
		
		});
		connexionButton.setBounds(149, 207, 117, 29);
		getContentPane().add(connexionButton);
		
		
		missing.setEnabled(false);
		missing.setForeground(Color.RED);
		missing.setBounds(63, 184, 316, 16);
		getContentPane().add(missing);
		pack();
	}


	private void connexionButtonActionPerformed(ActionEvent e)
	{
		

		
		
		
		
		if(loginField.getText().length() == 0 || passwordField.getPassword().length == 0)
		{
			missing.setVisible(false);
			missing.setText("Un des champs n'a pas été correctement rempli !");
			missing.setVisible(true);
		}
		else
		{
			Enseignant user = new Enseignant(loginField.getText(), String.valueOf(passwordField.getPassword()));
			DAO<Enseignant> ens = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY).getEnseignantDAO();
			
			if(ens.login(user))
			{
		
				
				main.setEnseignant(user);
				setVisible(false);
				main.displayHome();
				
			}
			else
			{
				missing.setVisible(false);
				missing.setText("           Login ou mot de passe incorrect !");
				missing.setVisible(true);
			}
		
		}
	}
}





