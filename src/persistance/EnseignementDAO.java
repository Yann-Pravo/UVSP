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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Enseig;

    }

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

    public ArrayList<Enseignement> getListe() {
        ArrayList<Enseignement> list = new ArrayList<Enseignement>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery(
                    "SELECT * FROM ENSEIGNEMENT");
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