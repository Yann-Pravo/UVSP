package ProgrammePrincipal;
import GraphicalUI.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

import metier.Creneau;
import metier.Enseignant;
import metier.GestionnaireGroupeEtudiant;
import metier.GestionnaireReservation;
import metier.Groupe;
import metier.UE;
import metier.WeekDate;
import metier.Reservation;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JMenu;



public class MainFrame extends JFrame implements ActionListener, ItemListener, ErrorInterface{
	
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
	private JLabel weekLabel;
	private JMenu mnGestion;
	private Calendar today;
	private WeekDate currentWeek;
	private JButton nextButton;
	private JButton backButton;
	private GestionnaireReservation gr;
	private ArrayList<Reservation> listeResa;
	private JTable tableau;
	private Component cell;
	private Groupe groupeCourant;
	private JCheckBox myCourses;
	private JComboBox comboBox;
	private boolean profOnly;
	private int verifGroupe;
	private JMenuItem itemQuit;
	private JScrollPane js;
	private JLabel c1;
	private JLabel c2;
	private JLabel c3;
	private JLabel c4;
	private JLabel c5;
	private JLabel c6;
	private JLabel c7;
	

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
		
		itemDelog = new JMenuItem("Déconnexion");
		itemDelog.addActionListener(this);
		mnFichier.add(itemDelog);
		itemDelog.setVisible(false);
		
		itemQuit = new JMenuItem("Quitter");
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
		setBounds(30, 40, 1200, 750);
		//getContentPane().setLayout(null);		
		
		texte = new JLabel("Connecté(e) en tant que "+ enseignant.getPrenom()+" "+enseignant.getNom());
		texte.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		texte.setBounds(30, 10, 250, 16);
		getContentPane().add(texte);
		
		titre = new JLabel("Emploi du temps IG4");
		titre.setBounds(150, 50, 250, 25);
		titre.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		getContentPane().add(titre);
		
		mnGestion = new JMenu("Gestion");
		menuBar.add(mnGestion);
	
		itemLog.setVisible(false);
		itemDelog.setVisible(true);

		
		JMenuItem itemSalle = new JMenuItem("Gestion des salles");
		itemSalle.addActionListener(this);
		mnGestion.add(itemSalle);
		
		JMenuItem itemEnseignant = new JMenuItem("Gestion des enseignants");
		itemEnseignant.addActionListener(this);
		mnGestion.add(itemEnseignant);
		
		JMenuItem mntmGestionDesRservations = new JMenuItem("Gestion des r\u00E9servations");
		mntmGestionDesRservations.addActionListener(this);
		mnGestion.add(mntmGestionDesRservations);
		
		JMenuItem mntmGestionDemande = new JMenuItem("Gestion des demandes");
		mntmGestionDemande.addActionListener(this);
		mnGestion.add(mntmGestionDemande);
		
		JMenu mnAffichage = new JMenu("Affichage");
		menuBar.add(mnAffichage);
		
		JMenuItem mntmAfficherLeCalendrier = new JMenuItem("Afficher le calendrier");
		mnAffichage.add(mntmAfficherLeCalendrier);
		
		
		mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem itemAbout = new JMenuItem("A propos de UVSP");
		itemAbout.addActionListener(this);
		mnAbout.add(itemAbout);
		
		
		nextButton = new JButton();
		nextButton.setIcon(new ImageIcon("/Users/clementbalestrat/Desktop/projetJava/UVSP/src/ProgrammePrincipal/suivant.png"));
		nextButton.setBounds(1070, 40, 79, 44);
		nextButton.addActionListener(this);
		add(nextButton);
		
		backButton = new JButton("");
		backButton.setIcon(new ImageIcon("/Users/clementbalestrat/Desktop/projetJava/UVSP/src/ProgrammePrincipal/precedent.png"));
		backButton.setBounds(770, 40, 79, 44);
		backButton.addActionListener(this);
		add(backButton);
		
		
		
		today = Calendar.getInstance();
		today.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		today.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		
		currentWeek = new WeekDate();

		weekLabel = new JLabel();
		weekLabel.setBounds(870, 40, 200, 44);
		updateLabelWeek();
		weekLabel.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		add(weekLabel);
	
		
		

		
		comboBox = new JComboBox();
		comboBox.setBounds(520, 50, 225, 27);
		getContentPane().add(comboBox);
		
		comboBox.removeAllItems();
		comboBox.addItem(" -Sélectionnez un groupe- ");
		
		GestionnaireGroupeEtudiant g = GestionnaireGroupeEtudiant.getInstance();
		ArrayList<Groupe> gList = g.getListeGroupes();
		for(int cpt=0; cpt<gList.size(); cpt++)
		{
			comboBox.addItem(gList.get(cpt));
		}
			
		
		comboBox.addItemListener(this);

		
		myCourses = new JCheckBox("Mes cours");
		myCourses.setBounds(420, 50, 128, 23);
		myCourses.addActionListener(this);
		getContentPane().add(myCourses);
		
		
	
		
		
		
		
		
		
		c1 = new JLabel("8h00");
		c2 = new JLabel("9h45");
		c3 = new JLabel("11h30");
		c4 = new JLabel("13h15");
		c5 = new JLabel("15h00");
		c6 = new JLabel("16h45");
		c7 = new JLabel("18h30");
		
		c1.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		c1.setBounds(90, 110, 250, 16);
		getContentPane().add(c1);
		
		c2.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		c2.setBounds(90, 185, 250, 16);
		getContentPane().add(c2);
		
		c3.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		c3.setBounds(90, 260, 250, 16);
		getContentPane().add(c3);
		
		c4.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		c4.setBounds(90, 335, 250, 16);
		getContentPane().add(c4);
		
		c5.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		c5.setBounds(90, 410, 250, 16);
		getContentPane().add(c5);
		
		c6.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		c6.setBounds(90, 485, 250, 16);
		getContentPane().add(c6);
		
		c7.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		c7.setBounds(90, 560, 250, 16);
		getContentPane().add(c7);
		
		
		
			

			TimetableModel t = new TimetableModel();
			tableau = new JTable(t);
			
			tableau.setShowHorizontalLines(true);
			js = new JScrollPane(tableau);
			
			tableau.setGridColor(Color.black);
			tableau.setRowHeight(75);
			tableau.getColumnModel().getColumn(0).setPreferredWidth(120);
			tableau.getColumnModel().getColumn(1).setPreferredWidth(120);
			tableau.getColumnModel().getColumn(2).setPreferredWidth(120);
			tableau.getColumnModel().getColumn(3).setPreferredWidth(120);
			tableau.getColumnModel().getColumn(4).setPreferredWidth(120);
			tableau.getColumnModel().getColumn(5).setPreferredWidth(120);
			tableau.setCellSelectionEnabled(true);
			js.setViewportView(tableau);
			js.setBounds(150, 100, 1000, 545);
			
			gr = GestionnaireReservation.getInstance();
			listeResa = gr.getListeReservation();
			
			
			this.getContentPane().add(js);

			
			setTimetable(tableau, currentWeek, listeResa);
			
		
		
			
			
		
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
		
		//	this.getContentPane().setLayout(new BorderLayout());
			//this.getContentPane().add(gs, BorderLayout.CENTER);
			//this.validate();			
			gs.setVisible(true);			
		}
		if(ae.getActionCommand().equals("Gestion des enseignants"))
		{
			GestionEnseignant ge = new GestionEnseignant();
			this.getContentPane().setLayout(new BorderLayout());
			this.getContentPane().remove(log);
			this.getContentPane().remove(texte);
			this.getContentPane().add(ge, BorderLayout.CENTER);
			this.validate();			
			ge.setVisible(true);			
		}
		if(ae.getActionCommand().equals("Gestion des r\u00E9servations"))
		{
			GestionReservation gre = new GestionReservation(enseignant, gr);
			this.getContentPane().setLayout(new BorderLayout());
			this.getContentPane().remove(log);
			this.getContentPane().remove(texte);
			this.getContentPane().add(gre, BorderLayout.CENTER);
			this.validate();			
			gre.setVisible(true);			
		}
		if(ae.getActionCommand().equals("Gestion des demandes"))
		{
			GestionDemande gd = new GestionDemande(this, gr);
			this.getContentPane().setLayout(new BorderLayout());
			this.getContentPane().remove(log);
			this.getContentPane().remove(texte);
			this.getContentPane().add(gd, BorderLayout.SOUTH);
			this.validate();			
			gd.setVisible(true);			
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
			removeComponents("déco");
			initComponents();
			displayConnexion();
		}
		if(ae.getSource().equals(nextButton))
		{
			currentWeek.setNextWeek();
			updateLabelWeek();
			setTimetable(tableau, currentWeek, listeResa);
		}
		
		if(ae.getSource().equals(backButton))
		{
			currentWeek.setPreviousWeek();
			updateLabelWeek();
			setTimetable(tableau, currentWeek, listeResa);
		}
		if(ae.getSource().equals(myCourses))
		{
			if(myCourses.isSelected())
			{
				this.comboBox.setEnabled(false);
				this.profOnly = true;
				setTimetable(tableau, currentWeek, listeResa);
				
			}
			else
			{
				this.comboBox.setEnabled(true);
				this.profOnly = false;
				setTimetable(tableau, currentWeek, listeResa);
			}
			
		}
	}
	
	public void updateLabelWeek()
	{
		weekLabel.setText(currentWeek.getMonday()+" au "+currentWeek.getSaturday());
	}
	
	
	public void setTimetable(JTable t, WeekDate w, ArrayList<Reservation> r)
	{
		resetTimetable(t);
		String d;
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		
	
		if(this.profOnly)
		{
			
			for(int i=0; i<r.size(); i++)
			{
				
				d = date.format(r.get(i).getDateResa());
				if(d.compareTo(w.getMonday()) == 0 &&  r.get(i).getSalle().getLibelle() != null && r.get(i).getEns().getEnseignant().getIdEns() == this.enseignant.getIdEns())
				{	
						t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 0);
	
				}
				else if(d.compareTo(w.getTuesday()) == 0 &&  r.get(i).getSalle().getLibelle() != null && r.get(i).getEns().getEnseignant().getIdEns() == this.enseignant.getIdEns())
				{
					t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 1);
				}
				else if(d.compareTo(w.getWednesday()) == 0 &&  r.get(i).getSalle().getLibelle() != null && r.get(i).getEns().getEnseignant().getIdEns() == this.enseignant.getIdEns())
				{
					t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 2);
					
				}
				else if(d.compareTo(w.getThursday()) == 0 &&  r.get(i).getSalle().getLibelle() != null && r.get(i).getEns().getEnseignant().getIdEns() == this.enseignant.getIdEns())
				{
					t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 3);
				}
				else if(d.compareTo(w.getFriday()) == 0 &&  r.get(i).getSalle().getLibelle() != null && r.get(i).getEns().getEnseignant().getIdEns() == this.enseignant.getIdEns())
				{
					t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 4);
				}
				else if(d.compareTo(w.getSaturday()) == 0 &&  r.get(i).getSalle().getLibelle() != null && r.get(i).getEns().getEnseignant().getIdEns() == this.enseignant.getIdEns())
				{	
						t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 5);	
				}
			}
		}
		else
		{
			if(this.verifGroupe == 0)
			{
				for(int i=0; i<r.size(); i++)
				{
					d = date.format(r.get(i).getDateResa());
					if(d.compareTo(w.getMonday()) == 0 &&  r.get(i).getSalle().getLibelle() != null)
					{	
							t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 0);	
					}
					else if(d.compareTo(w.getTuesday()) == 0 &&  r.get(i).getSalle().getLibelle() != null)
					{
						t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 1);
					}
					else if(d.compareTo(w.getWednesday()) == 0 &&  r.get(i).getSalle().getLibelle() != null)
					{
						t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 2);
						
					}
					else if(d.compareTo(w.getThursday()) == 0 &&  r.get(i).getSalle().getLibelle() != null)
					{
						t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 3);
					}
					else if(d.compareTo(w.getFriday()) == 0 &&  r.get(i).getSalle().getLibelle() != null)
					{
						t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 4);
					}
					else if(d.compareTo(w.getSaturday()) == 0 &&  r.get(i).getSalle().getLibelle() != null)
					{	
							t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 5);	
					}
				}
				
				
			}
			else
			{
				for(int i=0; i<r.size(); i++)
				{
					d = date.format(r.get(i).getDateResa());
					if(d.compareTo(w.getMonday()) == 0 &&  r.get(i).getSalle().getLibelle() != null && r.get(i).getEns().getGroupe().getIdGroupe() == this.groupeCourant.getIdGroupe())
					{	
							t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 0);
						
						
						
					}
					else if(d.compareTo(w.getTuesday()) == 0 &&  r.get(i).getSalle().getLibelle() != null && r.get(i).getEns().getGroupe().getIdGroupe() == this.groupeCourant.getIdGroupe())
					{
						t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 1);
					}
					else if(d.compareTo(w.getWednesday()) == 0 &&  r.get(i).getSalle().getLibelle() != null && r.get(i).getEns().getGroupe().getIdGroupe() == this.groupeCourant.getIdGroupe())
					{
						t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 2);
						
					}
					else if(d.compareTo(w.getThursday()) == 0 &&  r.get(i).getSalle().getLibelle() != null && r.get(i).getEns().getGroupe().getIdGroupe() == this.groupeCourant.getIdGroupe())
					{
						t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 3);
					}
					else if(d.compareTo(w.getFriday()) == 0 &&  r.get(i).getSalle().getLibelle() != null && r.get(i).getEns().getGroupe().getIdGroupe() == this.groupeCourant.getIdGroupe())
					{
						t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 4);
					}
					else if(d.compareTo(w.getSaturday()) == 0 &&  r.get(i).getSalle().getLibelle() != null && r.get(i).getEns().getGroupe().getIdGroupe() == this.groupeCourant.getIdGroupe())
					{	
							t.setValueAt(r.get(i), getNumCreneau(r.get(i).getCreneau()), 5);	
					}
				}
			}
			
		}
		
		
		
		
		TableCellRenderer renderer = new CustomCellFromTable();
		t.setDefaultRenderer(Object.class, new MultiLineCellRenderer());
	
		
		
	}
	
	public int getNumCreneau(Creneau c)
	{
		int i = 0;
		
		if(c.getHeureDeb().compareTo("8h00") == 0)
		{
			i = 0;
		}
		if(c.getHeureDeb().compareTo("9h45") == 0)
		{
			i = 1;
		}
		if(c.getHeureDeb().compareTo("11h30") == 0)
		{
			i = 2;
		}
		if(c.getHeureDeb().compareTo("13h15") == 0)
		{
			i = 3;
		}
		if(c.getHeureDeb().compareTo("15h00") == 0)
		{
			i = 4;
		}
		if(c.getHeureDeb().compareTo("16h45") == 0)
		{
			i = 5;
		}
		if(c.getHeureDeb().compareTo("18h30") == 0)
		{
			i = 6;
		}
		
		return i;
			
	}
	
	
		public void resetTimetable(JTable t)
		{
			for(int i = 0; i< t.getRowCount(); i++)
			{
				for(int j = 0; j<t.getColumnCount(); j++)
				{
					t.setValueAt(" ", i, j);
				}
			}
		}



		public void itemStateChanged(ItemEvent e) 
		{
        	if(!e.getItem().equals(" -Sélectionnez un groupe- ")) 
        	{
        		if(e.getItem() instanceof Groupe)
        		{
        			this.groupeCourant = (Groupe)e.getItem();
        			this.verifGroupe = 1;
        			setTimetable(tableau, currentWeek, listeResa);
        		}
        	}
        	else
        	{
        	 	this.verifGroupe = 0;
        		setTimetable(tableau, currentWeek, listeResa);
        	}
        	
        		
       
        	
        	
        }  
	
		public void setGr(GestionnaireReservation gr) {
			this.gr = gr;
		}
		
	
		public void removeComponents(String s)
		{
			if(s.compareTo("déco") == 0)
			{
				this.enseignant = null;
				getContentPane().remove(comboBox);
				getContentPane().remove(backButton);
				getContentPane().remove(myCourses);
				getContentPane().remove(nextButton);
				getContentPane().remove(tableau);
				getContentPane().remove(texte);
				getContentPane().remove(titre);
				getContentPane().remove(weekLabel);	
				getContentPane().remove(js);
				getContentPane().remove(c1);
				getContentPane().remove(c2);
				getContentPane().remove(c3);
				getContentPane().remove(c4);
				getContentPane().remove(c5);
				getContentPane().remove(c6);
				getContentPane().remove(c7);
				
			}
			else if(s.compareTo("gestionSalle") == 0)
			{
				getContentPane().remove(comboBox);
				getContentPane().remove(backButton);
				getContentPane().remove(myCourses);
				getContentPane().remove(nextButton);
				getContentPane().remove(tableau);
				getContentPane().remove(texte);
				getContentPane().remove(titre);
				getContentPane().remove(weekLabel);	
				getContentPane().remove(js);
				getContentPane().remove(c1);
				getContentPane().remove(c2);
				getContentPane().remove(c3);
				getContentPane().remove(c4);
				getContentPane().remove(c5);
				getContentPane().remove(c6);
				getContentPane().remove(c7);
			}
			
			
		}
	
	
	
	
	
	
	
	
	
	
}
