package GraphicalUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class ErrorPopup extends JDialog {

	private static ErrorPopup instance;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabelError;
	
	public static ErrorPopup getInstance(java.awt.Frame parent, boolean modal) {
        
        if (instance==null) {
            instance=new ErrorPopup(parent,modal);
        }
        return instance;
    }

	public ErrorPopup(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
    }

	public void setErrorMsg(String errorMsg) {
        //this.jLabelError.setText(errorMsg);
    }
	

	private void initComponents()
	{
			setBounds(100, 100, 350, 200);
			getContentPane().setLayout(null);
			this.setTitle("Erreur !");
	        jButton1 = new JButton("OK");
	        jButton1.setBounds(122, 130, 117, 29);
	        getContentPane().add(jButton1);
	        
	        jLabel1 = new JLabel("Une erreur est survenue :");
	        jLabel1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
	        jLabel1.setBounds(67, 53, 263, 20);
	        getContentPane().add(jLabel1);
	        //jLabelError.setText("jLabel2");
	        
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });
	        
	}
	
	 private void jButton1ActionPerformed(ActionEvent evt) 
	 {
	       this.setVisible(false);
	 }
	
	
	
	
	
	
	
	
	
}
