package persistance;
import metier.Enseignant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe permettant de mapper les objets Enseignant vers la table ENSEIGNANT de la base de données.
 * Cette classe hérite de la classe DAO.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class EnseignantDAO extends DAO<Enseignant>{

    private static final EnseignantDAO instance = new EnseignantDAO();

    /**
     * Méthode permettant de récupérer l'objet unique de type EnseignantDAO
     * @return EnseignantDAO - Instance unique de l'objet EnseignantDAO
     */
    public final static EnseignantDAO getInstance() {
        return instance;
    }

    /**
     * Méthode permettant de créer un enseignant en base de donnée
     */
    public boolean create(Enseignant instance) {
    	boolean ok = true;
    	try {
    		// Si le statut n'existe pas en base on le cr√©e
    		this.connect.createStatement().executeUpdate("INSERT INTO enseignant(ID_ENSEIGNANT, NOM, PRENOM, MDP, SUPER_USER) VALUES(seqEnseignant.nextval, '" + instance.getNom() + "', '" + instance.getPrenom() + "', '" + instance.getMdp() + "', " + instance.getSu() + ")");
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    		ok = false;
	    }
            return ok;
    }

	public Enseignant find(Enseignant instance) {
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery("select * from ENSEIGNANT where ID_ENSEIGNANT = " + instance.getIdEns() );
			if(result.first())
			{
				instance.setNom(result.getString("NOM"));
				instance.setPrenom(result.getString("PRENOM"));
				instance.setMdp(result.getString("MDP"));
				instance.setSu(result.getInt("SUPER_USER"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return instance;
	}

	
	public boolean update(Enseignant enseignant) {
		boolean resultat = false;
		try {
			PreparedStatement prepare = this.connect
					.prepareStatement("update ENSEIGNANT set NOM=?, PRENOM=?, MDP=?, SUPER_USER=? where ID_ENSEIGNANT=?");
                        prepare.setString(1, enseignant.getNom());
                        prepare.setString(2, enseignant.getPrenom());
                        prepare.setString(3, enseignant.getMdp());
                        prepare.setInt(4, enseignant.getSu());
                        prepare.setInt(5, enseignant.getIdEns());
                        prepare.executeUpdate();
                        resultat=true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	public boolean delete(Enseignant enseignant) {
		boolean resultat=false;
		try {
			PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM ENSEIGNANT where ID_ENSEIGNANT=?");
			prepare.setInt(1, enseignant.getIdEns());
			prepare.executeUpdate();
			resultat=true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	public ArrayList<Enseignant> getListe() {
		ArrayList<Enseignant> list = new ArrayList<Enseignant>();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery("select * from ENSEIGNANT ORDER BY NOM ASC");
			while (result.next())
			{
				Enseignant ens = new Enseignant(result.getInt("ID_ENSEIGNANT"),result.getString("NOM"),result.getString("PRENOM"),result.getString("MDP"),result.getInt("SUPER_USER"));
				list.add(ens);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean update(Enseignant ancien, Enseignant nouveau) {
		return false;
	}

	@Override
	public boolean login(Enseignant ens) {
		boolean find = false;
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery("select * from ENSEIGNANT where MDP = '" + ens.getMdp() + "' and NOM = '" +ens.getNom() + "'" );
			if(result.first())
			{
				ens.setNom(result.getString("NOM"));
				ens.setPrenom(result.getString("PRENOM"));
				ens.setMdp(result.getString("MDP"));
				ens.setSu(result.getInt("SUPER_USER"));
				find = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return find;
		
	}









}
