package persistance;

import metier.Creneau;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe permettant de mapper les objets Creneau vers la table CRENAUX de la base de données.
 * Cette classe hérite de la classe DAO.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class CreneauDAO extends DAO<Creneau> {

    private static final CreneauDAO instance = new CreneauDAO();

    /**
     * Méthode permettant de récupérer l'objet unique de type CreneauDAO
     * @return CreneauDAO - Instance unique de l'objet CreneauDAO
     */
    public final static CreneauDAO getInstance() {
        return instance;
    }

    /**
     * Méthode permettant de créer un créneau en base de donnée
     */
    public boolean create(Creneau instance) {
    	boolean ok = false;
    	try {
    		PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO CRENAUX(ID_CRENAU, HEURE_DEBUT, HEURE_FIN) VALUES(?,?,?)");
    		prepare.setString(1, "seqCreneau.nextval");
    		prepare.setString(2, instance.getHeureDeb());
    		prepare.setString(3, instance.getHeureFin());
    		prepare.executeUpdate();
    		ok = true;
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
	    }
            return ok;
    }

	public Creneau find(Creneau c) {
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery("select * from CRENAUX where ID_CRENEAU = " + c.getIdCreneau() );
			if(result.first())
			{
				c.setHeureDeb(result.getString("HEURE_DEBUT"));
				c.setHeureFin(result.getString("HEURE_FIN"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public boolean update(Creneau creneau) {
		boolean resultat = false;
		try {
            this.connect.createStatement().executeUpdate(
                    "UPDATE CRENAUX " +
                    "SET HEURE_DEBUT='" + creneau.getHeureDeb() + "' " +
                    "WHERE ID_CRENAU=" + creneau.getIdCreneau());
    
            this.connect.createStatement().executeUpdate(
                    "UPDATE CRENAUX " +
                    "SET HEURE_FIN='" + creneau.getHeureFin() + "' " +
                    "WHERE ID_CRENAU=" + creneau.getIdCreneau());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	public boolean delete(Creneau creneau) {
		boolean resultat=false;
		try {
			PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM CRENAUX where ID_CRENAU=?");
			prepare.setInt(1, creneau.getIdCreneau());
			prepare.executeUpdate();
			resultat=true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	public ArrayList<Creneau> getListe() {
		ArrayList<Creneau> list = new ArrayList<Creneau>();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery("select * from CRENAUX");
			while (result.next())
			{
				Creneau creneau = new Creneau(result.getInt("ID_CRENAU"), result.getString("HEURE_DEBUT"), result.getString("HEURE_FIN"));
				list.add(creneau);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean update(Creneau ancien, Creneau nouveau) {
		return false;
	}
}
