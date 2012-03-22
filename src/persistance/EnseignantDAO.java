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
     * Méthode qui exécute une requête d'ajout d'une nouvelle matière dans la base de données.
     * Cette méthode redéfinit la méthode create(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param instance Objet Enseignant qui doit être mappé dans la base
     * @return Boolean - Vrai si l'insertion s'est déroulée correctement, Faux sinon
     */
    public boolean create(Enseignant instance) {
    	boolean ok = true;
    	try {
    		this.connect.createStatement().executeUpdate("INSERT INTO enseignant(ID_ENSEIGNANT, NOM, PRENOM, MDP, SUPER_USER) VALUES(seqEnseignant.nextval, '" + instance.getNom() + "', '" + instance.getPrenom() + "', '" + instance.getMdp() + "', " + instance.getSu() + ")");
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    		ok = false;
	    }
            return ok;
    }

    /**
     * Méthode qui recherche dans la base de données l'enregistrement correspondant
     * au enseignant bat en paramêtre et retourne les résultats sous forme d'un objet Enseignant.
     * @param instance Objet Enseignant à rechercher dans la base de données
     * @return Enseignant - Objet Enseignant créé à partir des résultats trouvés dans la base
     */
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
			result.getStatement().close();
	        result.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return instance;
	}

    /**
     * Méthode qui exécute une requête de mise à jour d'un enregistrement de la table 'ENSEIGNANT' dans la base de données.
     * Cette méthode redéfint la méthode update(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param enseignant Objet Enseignant qui doit être mappé pour mettre à jour la ligne correspondante dans la base
     * @return Boolean - Vrai si la mise à jour s'est déroulée correctement, Faux sinon
     */
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

    /**
     * Méthode qui exécute une requête de suppression d'un enseignant dans la base de données.
     * Cette méthode redéfinit la méthode find(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param enseignant Objet Enseignant dont l'enregistrement correspondant dans la base doit être supprimé
     * @return Boolean - Vrai si la suppression s'est bien déroulée, Faux sinon
     */
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
	 /**
     * Méthode qui :
     *      1) récupère l'ensemble des Enseignant de la table correspondante dans la base
     *      2) les mappe en objet java Enseignant
     *      3) les stocke dans une liste d'objets Enseignant
     * @exception SQLException
     * @return ArrayList<Enseignant> - Liste des Enseignant stockées dans la base
     */
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
			result.getStatement().close();
	          result.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean update(Enseignant ancien, Enseignant nouveau) {
		return false;
	}

    /**
     * Méthode qui vérifie si le nom d'utilisateur et le mot de passe qu'à entré l'utilisateur correspond à celui en BDD
     * @exception SQLException
     * @param enseignant Objet Enseignant
     * @return Boolean - Vrai si le login s'est bien déroulée, Faux sinon
     */
	public boolean login(Enseignant ens) {
		boolean find = false;
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery("select * from ENSEIGNANT where MDP = '" + ens.getMdp() + "' and NOM = '" +ens.getNom() + "'" );
			if(result.first())
			{
				ens.setIdEns(result.getInt("id_enseignant"));
				ens.setNom(result.getString("NOM"));
				ens.setPrenom(result.getString("PRENOM"));
				ens.setMdp(result.getString("MDP"));
				ens.setSu(result.getInt("SUPER_USER"));
				find = true;
			}
			result.getStatement().close();
	          result.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return find;
		
	}
}
