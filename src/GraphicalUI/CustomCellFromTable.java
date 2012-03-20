package GraphicalUI;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import metier.GestionnaireUE;
import metier.Matiere;
import metier.UE;

public class CustomCellFromTable extends DefaultTableCellRenderer{
	
	private GestionnaireUE ue = GestionnaireUE.getInstance();
	private ArrayList<UE> ueList = ue.getListeUE();
	
	
	 public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
	 {
		 Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		 cell.setBackground(Color.WHITE);
		
		 
		 
		 
		 
		 
		 if(value instanceof Matiere)
		 {
			 Matiere mat = (Matiere) value;
			 cell.setBackground(Color.WHITE);   
        
          
         if(mat.getUEMat().getIdUE() == 1)
          {
        	  cell.setBackground(Color.BLUE);
          }
          
          if(mat.getUEMat().getIdUE() == 2)
          {
        	  cell.setBackground(Color.GREEN);
          }
          
          if(mat.getUEMat().getIdUE() == 3)
          {
        	  cell.setBackground(Color.RED);
          }
          
          if(mat.getUEMat().getIdUE() == 4)
          {
        	  cell.setBackground(Color.YELLOW);
          }
          
          if(mat.getUEMat().getIdUE() == 5)
          {
        	  cell.setBackground(Color.ORANGE);
          }
         
      
          
          
          
       
      
		 }
	      return cell;
  }
	
	
	
	
	
	
	
	
	
}
