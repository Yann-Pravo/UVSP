package GraphicalUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class About extends JDialog {

	private final JPanel contentPanel = new JPanel();


	public About() 
	{
		initComponents();
	}
	
	private void initComponents()
	{
		setBounds(100, 100, 470, 247);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnOk.setBounds(172, 171, 117, 29);
		contentPanel.add(btnOk);
		
		JLabel lblProjetDeJava = new JLabel("Projet de Java 2011/2012 r\u00E9alis\u00E9 par : ");
		lblProjetDeJava.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblProjetDeJava.setBounds(78, 32, 315, 16);
		contentPanel.add(lblProjetDeJava);
		
		JLabel lblClmentBalestrat = new JLabel("Cl\u00E9ment BALESTRAT");
		lblClmentBalestrat.setBounds(38, 102, 138, 16);
		contentPanel.add(lblClmentBalestrat);
		
		JLabel lblAbdeslamAhardane = new JLabel("Abdeslam AHARDANE");
		lblAbdeslamAhardane.setBounds(38, 74, 149, 16);
		contentPanel.add(lblAbdeslamAhardane);
		
		JLabel lblYannPravossoudovitch = new JLabel("Yann PRAVOSSOUDOVITCH");
		lblYannPravossoudovitch.setBounds(38, 130, 174, 16);
		contentPanel.add(lblYannPravossoudovitch);
		
		JLabel lblclementbalestratgmailcom = new JLabel("(clement.balestrat@gmail.com)");
		lblclementbalestratgmailcom.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblclementbalestratgmailcom.setBounds(242, 102, 194, 16);
		contentPanel.add(lblclementbalestratgmailcom);
		
		JLabel lblAbdeslamahardanegmailcom = new JLabel("(abdeslam.ahardane@gmail.com)");
		lblAbdeslamahardanegmailcom.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblAbdeslamahardanegmailcom.setBounds(242, 74, 222, 16);
		contentPanel.add(lblAbdeslamahardanegmailcom);
		
		JLabel lblYannpravogmailcom = new JLabel("(yann.pravo@gmail.com)");
		lblYannpravogmailcom.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblYannpravogmailcom.setBounds(242, 130, 194, 16);
		contentPanel.add(lblYannpravogmailcom);
		
		
	}
	
	private void close()
	{
		this.dispose();
	}
	
	
	
	
	
	
	
}
