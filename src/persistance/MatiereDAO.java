package persistance;

import metier.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Classe permettant de mapper les objets Matiere vers la table matière de la base de données.
 * Cette classe hérite de la classe DAO.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class MatiereDAO extends DAO<Matiere> {
    
    private static final MatiereDAO instance = new MatiereDAO();
    
    /**
     * Méthode permettant de récupérer l'objet unique de type MatiereDAO
     * @return MatiereDAO - Instance unique de l'objet MatiereDAO
     */
    public final static MatiereDAO getInstance() {
        return instance;
    }

    /**
     * Méthode qui exécute une requête d'ajout d'une nouvelle matière dans la base de données.
     * Cette méthode redéfinit la méthode create(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param m Objet Matière qui doit être mappé dans la base
     * @return Boolean - Vrai si l'insertion s'est déroulée correctement, Faux sinon
     */
    public boolean create(Matiere m) {
        boolean ok = true;
        try {
        	PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO MATIERE VALUES(?, ?, ?, ?)");
        	prepare.setString(1, "seqMatiere.nextval");
            prepare.setInt(2, m.getUEMat().getIdUE());
            prepare.setInt(3, m.getResponsable().getIdEns());
            prepare.setString(4, m.getNomMat());
            prepare.executeUpdate();
        }
        catch (SQLException e) {
            ok = false;
        }
        return ok;
    }

    /**
     * Méthode qui exécute une requête de mise à jour d'un enregistrement de la table 'matiere' dans la base de données.
     * Cette méthode redéfint la méthode update(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param m Objet Matiere qui doit être mappé pour mettre à jour la ligne correspondante dans la base
     * @return Boolean - Vrai si la mise à jour s'est déroulée correctement, Faux sinon
     */
    public boolean update(Matiere m) {
        boolean ok = true;
        try {
            this.connect.createStatement().executeUpdate(
                            "UPDATE matiere " +
                            "SET ID_UE='" + m.getUEMat().getIdUE() + "' " +
                            "WHERE ID_MATIERE=" + m.getIdMat());
            
            this.connect.createStatement().executeUpdate(
                            "UPDATE matiere " +
                            "SET LIBELLE_MATIERE='" + m.getNomMat() + "' " +
                            "WHERE ID_MATIERE=" + m.getIdMat());

            this.connect.createStatement().executeUpdate(
                            "UPDATE matiere " +
                            "SET ID_ENSEIGNANT='" + m.getResponsable().getIdEns() + "' " +
                            "WHERE ID_MATIERE=" + m.getIdMat());
        } catch (SQLException e) {
            ok = false;
        }
        return ok;
    }

    /**
     * Méthode qui recherche dans la base de données l'enregistrement correspondant
     * à la matière m en paramêtre et retourne les résultats sous forme d'un objet Matiere.
     * @param m Objet Matiere à rechercher dans la base de données
     * @return Matiere - Objet Matiere créé à partir des résultats trouvés dans la base
     */
    public Matiere find(Matiere m) {
        try {
        	ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery("select * from MATIERE where ID_MATIERE = " + m.getIdMat() );
            if (result.first()) {
            	UEDAO ueDAO = new UEDAO();
                UE ue = new UE(result.getInt("ID_UE"));
                ue = ueDAO.find(ue);
                
                EnseignantDAO ensDAO = new EnseignantDAO();
                Enseignant ens = new Enseignant(result.getInt("ID_ENSEIGNANT"));
                ens = ensDAO.find(ens);
                
                m.setNomMat(result.getString("LIBELLE_MATIERE"));
                m.setUEMat(ue);
                m.setResponsable(ens);
            }
        }
        catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return m;
    }

    /**
     * Méthode qui exécute une requête de suppression d'une matière dans la base de données.
     * Cette méthode redéfinit la méthode find(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param m Objet Matiere dont l'enregistrement correspondant dans la base doit être supprimé
     * @return Boolean - Vrai si la suppression s'est bien déroulée, Faux sinon
     */
    public boolean delete(Matiere m) {
        boolean ok = true;
        try {
            this.connect.createStatement().executeUpdate("DELETE FROM MATIERE " + "WHERE ID_MATIERE ='" + m.getIdMat() + "'");
        }
        catch (SQLException e) {
            ok = false;
        }
        return ok;
    }

    /**
     * Méthode qui :
     *      1) récupère l'ensemble des matières de la table correspondante dans la base
     *      2) les mappe en objet java Matiere
     *      3) les stocke dans une liste d'ojbets Matiere
     * @exception SQLException
     * @return ArrayList<Matiere> - Liste des matières stockées dans la base
     */
    public ArrayList<Matiere> getListe() {
        ArrayList<Matiere> list = new ArrayList<Matiere>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM MATIERE");
            while (result.next()) {
            	UEDAO ueDAO = new UEDAO();
                UE ue = new UE(result.getInt("ID_UE"));
                ue = ueDAO.find(ue);
                
                EnseignantDAO ensDAO = new EnseignantDAO();
                Enseignant ens = new Enseignant(result.getInt("ID_ENSEIGNANT"));
                ens = ensDAO.find(ens);
                
                Matiere m = new Matiere(result.getInt("ID_MATIERE"), result.getString("LIBELLE_MATIERE"), ue, ens);
                list.add(m);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Méthode qui permet de retourner la liste des matières associées à l'UE
     * dont le code est en paramètre. Les objets Matiere de la liste sont renseignés
     * par tous leurs attributs.
     * @param ue Code de l'UE pour laquelle on veut les matières associées
     * @return ArrayList<Matiere> - Liste des objets Matiere associés à l'UE en paramètre
     */
    public ArrayList<Matiere> getMatiereByUE (Integer ue) {
        ArrayList<Matiere> list = new ArrayList<Matiere>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM MATIERE WHERE ID_UE = '" + ue + "'");
            while (result.next()) {
            	UEDAO ueDAO = new UEDAO();
                UE u = new UE(result.getInt("ID_UE"));
                u = ueDAO.find(u);
                
                EnseignantDAO ensDAO = new EnseignantDAO();
                Enseignant ens = new Enseignant(result.getInt("ID_ENSEIGNANT"));
                ens = ensDAO.find(ens);
                
                Matiere m = new Matiere(result.getInt("ID_MATIERE"), result.getString("LIBELLE_MATIERE"), u, ens);
                list.add(m);
            }
        }
        catch (SQLException e) {
        	list.clear();
        }
        return list;
    }

    public boolean update(Matiere ancien, Matiere nouveau) {
        return false;
    }
}
