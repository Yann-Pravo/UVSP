package persistance;

import metier.Groupe;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe permettant de mapper les objets Groupe vers la table GROUPE de la base de données.
 * Cette classe hérite de la classe DAO.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class GroupeDAO extends DAO<Groupe> {

    private static GroupeDAO instance;


    /**
     * Méthode permettant de récupérer l'instance de la classe GroupeDAO
     * @return GroupeDAO - Instance unique de l'objet GroupeDAO
     */
    public final static GroupeDAO getInstance() {
        if (instance == null)
            instance = new GroupeDAO();
        return instance;
    }

    /**
     * Méthode qui ajoute un Groupe dans la base de donnees
     * @param grp le Groupe a ajouter
     * @return vrai si l'ajout s'est bien deroule
     */
    public boolean create(Groupe grp) {
        boolean ok = false;
        try {
    		PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO GROUPE(ID_GROUPE, ID_GROUPE_A_POUR_PERE, LIBELLE_GROUPE) VALUES(?,?,?)");
    		prepare.setString(1, "seqGroupe.nextval");
    		prepare.setInt(2, grp.getPere().getIdGroupe());
    		prepare.setString(3, grp.getLibelle());
    		prepare.executeUpdate();
            ok = true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return ok;
    }

    /**
     * Methode qui cherche les informations d'un groupe dans la base de donnees
     * @param grp le Groupe a chercher
     * @return vrai si la modification s'est bien deroulee
     */
    public Groupe find(Groupe grp) {
        Groupe groupe = new Groupe(grp.getIdGroupe());
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM GROUPE " + "WHERE ID_GROUPE = '" + groupe.getIdGroupe() + "'");
            if (result.first()) {
                GroupeDAO groupeDAO = new GroupeDAO();
                Groupe pere = new Groupe(result.getInt("ID_GROUPE"));
                pere = groupeDAO.find(pere);
                
                groupe.setLibelle(result.getString("LIBELLE_GROUPE"));
                groupe.setPere(pere);

            }
        }
        catch (SQLException ex) {
            groupe = grp;
        }
        return groupe;
    }


    /**
     * Methode qui met a jour un groupe dans la base de donnees
     * @param grp le Groupe a modifier
     * @return vrai si la modification s'est bien deroulee
     */
    public boolean update(Groupe grp) {
        boolean ok = true;
        try {
            this.connect.createStatement().executeUpdate(
                            "UPDATE GROUPE " +
                            "SET ID_GROUPE_A_POUR_PERE='" + grp.getPere().getIdGroupe() + "' " +
                            "WHERE ID_GROUPE=" + grp.getIdGroupe());
            
            this.connect.createStatement().executeUpdate(
                    		"UPDATE GROUPE " +
                    		"SET LIBELLE_GROUPE='" + grp.getLibelle() + "' " +
                    		"WHERE ID_GROUPE=" + grp.getIdGroupe());
        } catch (SQLException e) {
            ok = false;
        }
        return ok;
    }

    /**
     * Methode qui met a jour un groupe dans la base de donnees
     * a partir d'un ancien groupe
     * @param ancien le Groupe a modifier
     * @param nouveau le Groupe a remplacer
     * @return vrai si la modification s'est bien deroulee
     */
    public boolean update(Groupe ancien, Groupe nouveau){
    	return false;
    }


    /**
     * Methode qui supprime un Groupe de la base de donnees
     * @param grp le Groupe a supprimer
     * @return vrai si la suppression s'est bien deroulee
     */
    public boolean delete(Groupe grp) {
               boolean ok = false;
        try {
            this.connect.createStatement()
                        .executeUpdate("DELETE FROM GROUPE " +
                                       "WHERE ID_GROUPE = '" +
                                        grp.getIdGroupe()+ "';");
            ok = true;
        }
        catch (SQLException e) {
                e.printStackTrace();
        }
        return ok;
    }


    /**
     * Methode concrete qui renvoie la liste des groupes
     * @return un ArrayList<Groupe> qui contient les groupes
     */
    public ArrayList<Groupe> getListe() {
    	ArrayList<Groupe> list = new ArrayList<Groupe>();
        try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("select * from GROUPE");
            while (result.next()) {
            	GroupeDAO groupeDAO = new GroupeDAO();
                Groupe pere = new Groupe(result.getInt("ID_GROUPE_A_POUR_PERE"));
                pere = groupeDAO.find(pere);
                
                Groupe groupe = new Groupe(result.getInt("ID_GROUPE"), result.getString("LIBELLE_GROUPE"), pere);
                list.add(groupe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
