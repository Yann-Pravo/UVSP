package persistance;

/**
 * Classe permettant de mapper les objets UE vers la table 'ue' de la base de données.
 * Cette classe hérite de la classe DAO.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
import metier.UE;
import metier.Enseignant;
import persistance.EnseignantDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UEDAO extends DAO<UE> {

    private static final UEDAO instance = new UEDAO();

    /**
     * Méthode permettant de récupérer l'objet unique de type UEDAO
     * @return UEDAO - Instance unique de l'objet UEDAO
     */
    public final static UEDAO getInstance() {
        return instance;
    }

    /**
     * Méthode qui exécute une requête d'ajout d'une nouvelle UE dans la base de données.
     * Cette méthode redéfinit la méthode create(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param u Objet UE qui doit être mappé dans la base
     * @return Boolean - Vrai si l'insertion s'est déroulée correctement, Faux sinon
     */
    public boolean create(UE u) {
        boolean ok;
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO UE VALUES(?, ?, ?)");
            prepare.setString(1, "seqUE.nextval");
            prepare.setString(2, u.getNomUE());
            prepare.setInt(3, u.getEnseignant().getIdEns());
            prepare.executeUpdate();
            ok = true;
        } catch (SQLException e) {
            ok = false;
        }
        return ok;
    }

    /**
     * Méthode qui recherche dans la base de données l'enregistrement correspondant
     * à l'UE u en paramêtre et retourne les résultats sous forme d'un objet UE.
     * @param u Objet UE à rechercher dans la base de données
     * @return UE - Objet UE créé à partir des résultats trouvés dans la base
     */
    public UE find(UE u) {
        try {
        	ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery("select * from UE where ID_UE = " + u.getIdUE() );
        	if (result.first()) {
        		EnseignantDAO ensDAO = new EnseignantDAO();
        		Enseignant ens = new Enseignant(result.getInt("ID_ENSEIGNANT"));
        		ens = ensDAO.find(ens);
                u.setNomUE(result.getString("LIBELLE_UE"));
                u.setEnseignant(ens);
        	}
        }
        catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return u;
    }

    /**
     * Méthode qui exécute une requête de mise à jour d'un enregistrement de la table 'ue' dans la base de données.
     * Cette méthode redéfint la méthode update(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param u Objet UE qui doit être mappé pour mettre à jour la ligne correspondante dans la base
     * @return Boolean - Vrai si la mise à jour s'est déroulée correctement, Faux sinon
     */
    public boolean update(UE u) {
        boolean ok = true;
        try {
            this.connect.createStatement().executeUpdate(
                            "UPDATE ue " +
                            "SET LIBELLE_UE='" + u.getNomUE() + "' " +
                            "WHERE ID_UE='" + u.getIdUE() + "'");
            
            this.connect.createStatement().executeUpdate(
                            "UPDATE ue " +
                            "SET ID_ENSEIGNANT='" + u.getEnseignant().getIdEns() + "' " +
                            "WHERE ID_UE='" + u.getIdUE() + "'");
        } catch (SQLException e) {
            ok = false;
        }
        return ok;
    }

    public boolean update(UE u1, UE u2) {
    	return false;
    }

    /**
     * Méthode qui exécute une requête de suppression d'une UE dans la base de données.
     * Cette méthode redéfinit la méthode find(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param u Objet UE dont l'enregistrement correspondant dans la base doit être supprimé
     * @return Boolean - Vrai si la suppression s'est bien déroulée, Faux sinon
     */
    public boolean delete(UE u) {
        boolean resultat;
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM UE where ID_UE=?");
            prepare.setInt(1, u.getIdUE());
            prepare.executeUpdate();
            resultat = true;
        } catch (SQLException e) {
            resultat = false;
        }
        return resultat;
    }

    /**
     * Méthode qui permet de retourner la liste des UEs stockées dans la base
     * @exception SQLException
     * @return ArrayList<UE> - Liste des UEs stockées dans la base
     */
    public ArrayList<UE> getListe() {
        ArrayList<UE> list = new ArrayList<UE>();
        try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("select * from UE");
            while (result.next()) {
            	Enseignant ens =  new Enseignant(result.getInt("ID_ENSEIGNANT"));
            	UE u = new UE(
                        result.getInt("ID_UE"),
                        result.getString("LIBELLE_UE"),
                		ens);
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}