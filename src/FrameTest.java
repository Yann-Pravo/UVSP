import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import GraphicalUI.Timetable;
import GraphicalUI.TimetableModel;

import metier.WeekDate;


public class FrameTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameTest frame = new FrameTest();
					frame.setVisible(true);
					
					

				
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		WeekDate w = new WeekDate();
		TimetableModel model = new TimetableModel();
		JTable t = new JTable(model);
		JScrollPane js = new JScrollPane();
		js.add(t);
		js.setBounds(100, 100, 800, 800);
		
		
		
		
		
		this.getContentPane().add(js);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
