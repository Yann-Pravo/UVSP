package GraphicalUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import metier.Matiere;
import metier.Reservation;

public class MultiLineCellRenderer extends JTextArea implements TableCellRenderer{

	
	  public MultiLineCellRenderer() 
	  {
		    setLineWrap(true);
		    setWrapStyleWord(true);
		    setOpaque(true);
	  }
	
	@Override
	 public Component getTableCellRendererComponent(JTable table, Object value,
		      boolean isSelected, boolean hasFocus, int row, int column) 
	{
		 setBackground(Color.WHITE);
		setFont(new Font("Lucida Grande", Font.BOLD, 10));
		if(value instanceof Reservation)
		{
			Reservation res = (Reservation) value;
			  
       
         
        if(res.getEns().getCours().getMatiere().getUEMat().getIdUE() == 1)
         {
       	   setBackground(Color.BLUE);
         }
        
        if(res.getEns().getCours().getMatiere().getUEMat().getIdUE() == 2)
        {
      	  setBackground(Color.GREEN);
        }
        
        if(res.getEns().getCours().getMatiere().getUEMat().getIdUE() == 3)
        {
      	  setBackground(Color.RED);
        }
        
        if(res.getEns().getCours().getMatiere().getUEMat().getIdUE() == 4)
        {
      	  setBackground(Color.YELLOW);
        }
        
        if(res.getEns().getCours().getMatiere().getUEMat().getIdUE() == 5)
        {
      	  setBackground(Color.ORANGE);
        } 
        
        
        
        
        
        
        
		}
			
	
		    
		    if (hasFocus) {
		      setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
		      if (table.isCellEditable(row, column)) {
		    	setForeground(UIManager.getColor("Table.focusCellForeground"));
		        setBackground(UIManager.getColor("Table.focusCellBackground"));
		        
		        
		      }
		    } else {
		      setBorder(new EmptyBorder(1, 2, 1, 2));
		    }
		    setText((value == null) ? "" : value.toString());
			
		    return this;
		  }

}
