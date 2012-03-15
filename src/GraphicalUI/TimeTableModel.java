package GraphicalUI;
import javax.swing.table.AbstractTableModel;


public class TimetableModel extends AbstractTableModel {
	
	private Object[][] data  = {	{" ", " ", " ", " ", " ", " "},
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



}
