package persistance;

import metier.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe permettant de mapper les objets Enseignement vers la table ENSEIGNEMENT de la base de données.
 * Cette classe hérite de la classe DAO.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class EnseignementDAO extends DAO<Enseignement> {

    private static final EnseignementDAO instance = new EnseignementDAO();

    /**
     * Méthode permettant de récupérer l'objet unique de type TypeEnseignementDAO
     * @return TypeEnseignementDAO - Instance unique de l'objet TypeEnseignementDAO
     */
    public final static EnseignementDAO getInstance() {
        return instance;
    }

    /** Méthode permettant d'accéder à la base de données et par la même
     *  occasion, de créer un nouvel élement dans celle-ci. Dans le cadre
     *  présent, cet élement est un nouveau type de groupe.
     * @param Enseig Le nouveau type d'enseignement à ajouter dans la base.
     * @return Renvoie un booléen. VRAI si la création a réussi, FAUX sinon
     */
    public boolean create(Enseignement Enseig) {
        boolean ok = false;
        try {
                PreparedStatement prepare = this.connect
                    .prepareStatement("INSERT INTO ENSEIGNENEMENT" +
                    "(ID_ENSEIGNEMENT, ID_COURS, ID_ENSEIGNANT, ID_GROUPE, NB_HEURE_PREVUE) " +
                    "VALUES(?, ?, ?)");
                    prepare.setString(1, "seqEnseignement.nextval");
                    prepare.setInt(2, Enseig.getCours().getIdCours());
                    prepare.setInt(3, Enseig.getEnseignant().getIdEns());
                    prepare.setInt(3, Enseig.getGroupe().getIdGroupe());
                    prepare.setDouble(3, Enseig.getNbHeureReel());
                    prepare.executeUpdate();
                    ok = true;
		}
            catch (SQLException e) {
	            e.printStackTrace();
	    }
            return ok;

    }

    /**
     * Méthode qui recherche dans la base de données l'enregistrement correspondant
     * au enseignant bat en paramêtre et retourne les résultats sous forme d'un objet Enseignement.
     * @param Enseign Objet Enseignement à rechercher dans la base de données
     * @return Enseignement - Objet Enseignement créé à partir des résultats trouvés dans la base
     */
    public Enseignement find(Enseignement Enseig) {
        try {
        	ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery("select * from ENSEIGNEMENT where ID_ENSEIGNEMENT = " + Enseig.getIdEnseignement() );
            if(result.first()){
            	CoursDAO coursDAO = new CoursDAO();
                Cours cours = new Cours(result.getInt("ID_COURS"));
                cours = coursDAO.find(cours);
                
                EnseignantDAO ensDAO = new EnseignantDAO();
                Enseignant ens = new Enseignant(result.getInt("ID_ENSEIGNANT"));
                ens = ensDAO.find(ens);
                
                GroupeDAO groupeDAO = new GroupeDAO();
                Groupe groupe = new Groupe(result.getInt("ID_GROUPE"));
                groupe = groupeDAO.find(groupe);
                
                
                Enseig.setNbHeureReel(result.getDouble("NB_HEURE_PREVUE"));
                Enseig.setCours(cours);
                Enseig.setEnseignant(ens);
                Enseig.setGroupe(groupe);
            }
            result.getStatement().close();
	        result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Enseig;

    }

    /**
     * Méthode qui exécute une requête de mise à jour d'un enregistrement de la table 'ENSEIGNEMENT' dans la base de données.
     * Cette méthode redéfint la méthode update(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param ens Objet Enseignement qui doit être mappé pour mettre à jour la ligne correspondante dans la base
     * @return Boolean - Vrai si la mise à jour s'est déroulée correctement, Faux sinon
     */
    public boolean update(Enseignement ens) {
        boolean ok = true;
        try {
            this.connect.createStatement().executeUpdate(
                            "UPDATE ENSEIGNEMENT " +
                            "SET ID_COURS='" + ens.getCours().getIdCours() + "' " +
                            "WHERE ID_ENSEIGNEMENT=" + ens.getIdEnseignement());
            
            this.connect.createStatement().executeUpdate(
            				"UPDATE ENSEIGNEMENT " +
            				"SET ID_ENSEIGNANT='" + ens.getEnseignant().getIdEns() + "' " +
            				"WHERE ID_ENSEIGNEMENT=" + ens.getIdEnseignement());

            this.connect.createStatement().executeUpdate(
                    		"UPDATE ENSEIGNEMENT " +
                    		"SET ID_GROUPE='" + ens.getGroupe().getIdGroupe() + "' " +
                    		"WHERE ID_ENSEIGNEMENT=" + ens.getIdEnseignement());
            
            this.connect.createStatement().executeUpdate(
            				"UPDATE ENSEIGNEMENT " +
            				"SET NB_HEURE_PREVUE='" + ens.getNbHeureReel() + "' " +
            				"WHERE ID_ENSEIGNEMENT=" + ens.getIdEnseignement());
        } catch (SQLException e) {
            ok = false;
        }
        return ok;
    }

    public boolean update(Enseignement ancien, Enseignement nouveau) {
        return false;
    }

    /**
     * Méthode qui exécute une requête de suppression d'un Enseignement dans la base de données.
     * Cette méthode redéfinit la méthode find(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param enseign Objet Enseignement dont l'enregistrement correspondant dans la base doit être supprimé
     * @return Boolean - Vrai si la suppression s'est bien déroulée, Faux sinon
     */
    public boolean delete(Enseignement Enseig) {
        boolean resultat = false;
        try {
            PreparedStatement prepare = this.connect.prepareStatement(
                    "DELETE FROM ENSEIGNEMENT WHERE ID_ENSEIGNEMENT = ?");
            prepare.setInt(1, Enseig.getIdEnseignement());
            prepare.executeUpdate();
            resultat = true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }

	 /**
     * Méthode qui :
     *      1) récupère l'ensemble des Enseignement de la table correspondante dans la base
     *      2) les mappe en objet java Enseignement
     *      3) les stocke dans une liste d'objets Enseignement
     * @exception SQLException
     * @return ArrayList<Enseignement> - Liste des Enseignement stockées dans la base
     */
    public ArrayList<Enseignement> getListe() {
        ArrayList<Enseignement> list = new ArrayList<Enseignement>();
        try {
        	ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM ENSEIGNEMENT");
            while (result.next())
            {
            	CoursDAO coursDAO = new CoursDAO();
                Cours cours = new Cours(result.getInt("ID_COURS"));
                cours = coursDAO.find(cours);
                
                EnseignantDAO ensDAO = new EnseignantDAO();
                Enseignant ens = new Enseignant(result.getInt("ID_ENSEIGNANT"));
                ens = ensDAO.find(ens);
                
                GroupeDAO groupeDAO = new GroupeDAO();
                Groupe groupe = new Groupe(result.getInt("ID_GROUPE"));
                groupe = groupeDAO.find(groupe);
                
                Enseignement enseig = new Enseignement(result.getInt("ID_ENSEIGNEMENT"), groupe, result.getDouble("NB_HEURE_PREVUE"), ens, cours);
                
                list.add(enseig);
            }
            result.getStatement().close();
	        result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

	@Override
	public boolean login(Enseignement obj) {
		// TODO Auto-generated method stub
		return false;
	}
}