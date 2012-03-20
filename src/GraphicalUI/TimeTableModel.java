package GraphicalUI;
import javax.swing.table.AbstractTableModel;


public class TimetableModel extends AbstractTableModel {
	
	private Object[][] data  = {	{" ", " ", " ", " ", " ", " "},
									{" ", " ", " ", " ", " ", " "},
									{" ", " ", " ", " ", " ", " "},
									{" ", " ", " ", " ", " ", " "},
									{" ", " ", " ", " ", " ", " "},	
									{" ", " ", " ", " ", " ", " "},
									{" ", " ", " ", " ", " ", " "},
								};
	private String[] title = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
	/**
	 * Constructeur
	 * @param data
	 * @param title
	 */
	public TimetableModel(){

			super();
			
	}
	
	/**
	 * Retourne le nombre de colonnes
	 */
	public int getColumnCount() {
		return this.title.length;
	}
	
	/**
	 * Retourne le nombre de lignes
	 */
	public int getRowCount() {
		return this.data.length;
	}
	
	/**
	 * Retourne la valeur à l'emplacement spécifié
	 */
	public Object getValueAt(int row, int col) {
		return this.data[row][col];
	}
			
	public String getColumnName(int col) {
		  return this.title[col];
		}

	  public boolean isCellEditable(int row, int col) {
	        //Note that the data/cell address is constant,
	        //no matter where the cell appears onscreen.
	        if (col < 2) {
	            return false;
	        } else {
	            return true;
	        }
	    }

	    /*
	     * Don't need to implement this method unless your table's
	     * data can change.
	     */
	    public void setValueAt(Object value, int row, int col) {
	        data[row][col] = value;
	        fireTableCellUpdated(row, col);
	    }

}
