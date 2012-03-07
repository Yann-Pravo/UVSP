package persistance;

import metier.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Classe permettant de mapper les objets Cours vers la table COURS de la base de données.
 * Cette classe hérite de la classe DAO.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class CoursDAO extends DAO<Cours> {
    
    private static final CoursDAO instance = new CoursDAO();
    
    /**
     * Méthode permettant de récupérer l'objet unique de type CoursDAO
     * @return CoursDAO - Instance unique de l'objet CoursDAO
     */
    public final static CoursDAO getInstance() {
        return instance;
    }

    /**
     * Méthode qui exécute une requête d'ajout d'une nouvelle matière dans la base de données.
     * Cette méthode redéfinit la méthode create(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param m Objet Matière qui doit être mappé dans la base
     * @return Boolean - Vrai si l'insertion s'est déroulée correctement, Faux sinon
     */
    public boolean create(Cours c) {
        boolean ok = true;
        try {
        	PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO COURS VALUES(?, ?, ?, ?)");
        	prepare.setString(1, "seqCours.nextval");
            prepare.setInt(2, c.getMatiere().getIdMat());
            prepare.setInt(3, c.getTypeCours().getIdTypeCours());
            prepare.setString(4, c.getLibelle());
            prepare.executeUpdate();
        }
        catch (SQLException e) {
            ok = false;
        }
        return ok;
    }

    /**
     * Méthode qui exécute une requête de mise à jour d'un enregistrement de la table 'COURS' dans la base de données.
     * Cette méthode redéfint la méthode update(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param m Objet Cours qui doit être mappé pour mettre à jour la ligne correspondante dans la base
     * @return Boolean - Vrai si la mise à jour s'est déroulée correctement, Faux sinon
     */
    public boolean update(Cours c) {
        boolean ok = true;
        try {
            this.connect.createStatement().executeUpdate(
                            "UPDATE COURS " +
                            "SET ID_MATIERE='" + c.getMatiere().getIdMat() + "' " +
                            "WHERE ID_COURS=" + c.getIdCours());
            
            this.connect.createStatement().executeUpdate(
                            "UPDATE COURS " +
                            "SET ID_TYPE_DE_COURS='" + c.getTypeCours().getIdTypeCours() + "' " +
                            "WHERE ID_COURS=" + c.getIdCours());

            this.connect.createStatement().executeUpdate(
                            "UPDATE COURS " +
                            "SET LIBELLE_COURS='" + c.getLibelle() + "' " +
                            "WHERE ID_COURS=" + c.getIdCours());
        } catch (SQLException e) {
            ok = false;
        }
        return ok;
    }

    /**
     * Méthode qui recherche dans la base de données l'enregistrement correspondant
     * à la cours m en paramêtre et retourne les résultats sous forme d'un objet Cours.
     * @param m Objet Cours à rechercher dans la base de données
     * @return Cours - Objet Cours créé à partir des résultats trouvés dans la base
     */
    public Cours find(Cours c) {
        Cours cou = new Cours(c.getIdCours());
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM COURS " + "WHERE ID_COURS = '" + c.getIdCours() + "'");
            if (result.first()) {
            	MatiereDAO matDAO = new MatiereDAO();
                Matiere mat = new Matiere(result.getInt("ID_MATIERE"));
                mat = matDAO.find(mat);
                
                TypeCoursDAO typeDAO = new TypeCoursDAO();
                TypeCours type = new TypeCours(result.getInt("ID_TYPE_DE_COURS"));
                type = typeDAO.find(type);
                
                cou.setLibelle(result.getString("LIBELLE_MATIERE"));
                cou.setMatiere(mat);
                cou.setTypeCours(type);
            }
        }
        catch (SQLException ex) {
            cou = c;
        }
        return cou;
    }

    /**
     * Méthode qui exécute une requête de suppression d'une cours dans la base de données.
     * Cette méthode redéfinit la méthode find(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param m Objet Cours dont l'enregistrement correspondant dans la base doit être supprimé
     * @return Boolean - Vrai si la suppression s'est bien déroulée, Faux sinon
     */
    public boolean delete(Cours c) {
        boolean ok = true;
        try {
            this.connect.createStatement().executeUpdate("DELETE FROM COURS " + "WHERE ID_COURS ='" + c.getIdCours() + "'");
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
    public ArrayList<Cours> getListe() {
        ArrayList<Cours> list = new ArrayList<Cours>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM COURS");
            while (result.next()) {
            	MatiereDAO matDAO = new MatiereDAO();
                Matiere mat = new Matiere(result.getInt("ID_MATIERE"));
                mat = matDAO.find(mat);
                
                TypeCoursDAO typeDAO = new TypeCoursDAO();
                TypeCours type = new TypeCours(result.getInt("ID_TYPE_DE_COURS"));
                type = typeDAO.find(type);
                
                Cours c = new Cours(result.getInt("ID_COURS"), result.getString("LIBELLE_COURS"), mat, type);
                list.add(c);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Méthode qui permet de retourner la liste des cours associées à la matière
     * dont le code est en paramètre. Les objets Cours de la liste sont renseignés
     * par tous leurs attributs.
     * @param mat ID de la matière pour laquelle on veut les cours associées
     * @return ArrayList<Cours> - Liste des objets Cours associés à la matière en paramètre
     */
    public ArrayList<Cours> getCoursByMatiere (Integer mat) {
        ArrayList<Cours> list = new ArrayList<Cours>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM COURS WHERE ID_MATIERE = '" + mat + "'");
            while (result.next()) {
            	MatiereDAO matDAO = new MatiereDAO();
                Matiere m = new Matiere(result.getInt("ID_MATIERE"));
                m = matDAO.find(m);
                
                TypeCoursDAO typeDAO = new TypeCoursDAO();
                TypeCours type = new TypeCours(result.getInt("ID_TYPE_DE_COURS"));
                type = typeDAO.find(type);
                
                Cours c = new Cours(result.getInt("ID_COURS"), result.getString("LIBELLE_COURS"), m, type);
                list.add(c);
            }
        }
        catch (SQLException e) {
        	list.clear();
        }
        return list;
    }

    public boolean update(Cours ancien, Cours nouveau) {
        return false;
    }
}
