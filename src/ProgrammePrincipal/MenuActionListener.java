package ProgrammePrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand());
		
	}

}
