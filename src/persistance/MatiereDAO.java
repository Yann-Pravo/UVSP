package persistance;
import metier.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Classe permettant de mapper les objets Matiere vers la table mati�re de la base de donn�es.
 * Cette classe h�rite de la classe DAO.
 * @authors Ahardane Abdeslam, Balestrat Cl�ment, Pravossoudovitch Yann
 * @version 1.0
 */
public class MatiereDAO extends DAO<Matiere> {
    
    // Instanciation d'un objet unique de type MatiereDAO
    private static final MatiereDAO instance = new MatiereDAO();
    
    /**
     * M�thode permettant de r�cup�rer l'objet unique de type MatiereDAO
     * @return MatiereDAO - Instance unique de l'objet MatiereDAO
     */
    public final static MatiereDAO getInstance() {
        return instance;
    }

    /**
     * Méthode qui exécute une requête d'ajout d'une nouvelle matière dans la base de données.
     * Cette méthode redéfinit la méthode create(T obj) de la superclasse DAO.
     * @author Laëtitia Vigroux
     * @author Ophelie Mak
     * @exception SQLException
     * @param m Objet Matière qui doit être mappé dans la base
     * @return Boolean - True (Vrai) si l'insertion s'est déroulée correctement, False (Faux) si elle n'a pas pu être effectuée
     * @version 1.0
     */
    public boolean create(Matiere m) {
        boolean ok = true; // Vaut True si l'insertion s'est déroulée correctement, False sinon
        try {
                // Création et exécution de la requête d'ajout d'une nouvelle matière
                PreparedStatement prepare = this.connect.prepareStatement(
                    "INSERT INTO matiere VALUES(?, ?, ?, ?, ?)");
            prepare.setString(1, m.getCode());
            prepare.setString(2, m.getUE().getCodeUE());
            prepare.setString(3, m.getNom());
            prepare.setString(4, m.getDescription());
            prepare.setInt(5, m.getCoeff());

            prepare.executeUpdate();
            }
        catch (SQLException e) {
            // Si exception, on indique que l'insertion ne s'est pas déroulée correctement
            ok = false;
        }
        // L'ajout s'est bien déroulé si 1 ligne a été créée dans la base
        return ok;
    }

    /**
     * Méthode qui exécute une requête de mise à jour d'un enregistrement de la table 'matiere' dans la base de données.
     * Cette méthode redéfint la méthode update(T obj) de la superclasse DAO.
     * @author Laëtitia Vigroux
     * @exception SQLException
     * @param m Objet Matiere qui doit être mappé pour mettre à jour la ligne correspondante dans la base
     * @return Boolean - True (Vrai) si la mise à jour s'est déroulée correctement, False (Faux) si elle n'a pas pu être effectuée
     * @version 1.0
     */
    public boolean update(Matiere m) {
        boolean ok = true; // Vaut True si la mise à jour s'est correctement déroulée, False sinon
        try {
            // Excécution de la requête de mise à jour du code de l'UE de la matière m
            this.connect.createStatement().executeUpdate(
                            "UPDATE matiere " +
                            "SET code_UE='" + m.getUE().getCodeUE() + "' " +
                            "WHERE code_matiere=" + m.getCode());

            // Excécution de la requête de mise à jour du nom la matière m
            this.connect.createStatement().executeUpdate(
                            "UPDATE matiere " +
                            "SET nom_matiere='" + m.getNom() + "' " +
                            "WHERE code_matiere=" + m.getCode());
            
            // Excécution de la requête de mise à jour de la description de la matière m
            this.connect.createStatement().executeUpdate(
                            "UPDATE matiere " +
                            "SET description='" + m.getDescription() + "' " +
                            "WHERE code_matiere=" + m.getCode());
            
            // Excécution de la requête de mise à jour du coefficient de la matière m
            this.connect.createStatement().executeUpdate(
                            "UPDATE matiere " +
                            "SET coefficient=" + m.getCoeff() + " " +
                            "WHERE code_matiere=" + m.getCode());
        } catch (SQLException e) {
            // Si exception, on indique que la mise à jour ne s'est pas déroulée correctement
            ok = false;
        }
        
        return ok;
    }

    /**
     * Méthode qui recherche dans la base de données l'enregistrement correspondant
     * à la matière m en paramètre et retourne les résultats sous forme d'un objet Matiere.
     * @author Laëtitia Vigroux
     * @param m Objet Matiere à rechercher dans la base de données
     * @return Matiere - Objet Matiere créé à partir des résultats trouvés dans la base
     * @version 1.0
     */
    public Matiere find(Matiere m) {
        Matiere mat=null; // Matiere retournée par la méthode
        try {
            // Requête de sélection des informations dans la table matière
            ResultSet result = this.connect.createStatement().executeQuery(
                    "SELECT * FROM matiere " +
                    "WHERE code_matiere = '" + m.getCode() + "'");

            if (result.first()) {
                // Création de l'objet Matiere avec les informations trouvées dans la base
                UE u = new UE(result.getString("code_UE"),null);
                mat = new Matiere (result.getString("code_matiere"),
                                   result.getString("nom_matiere"),
                                   result.getString("description"),
                                   result.getInt("coefficient"),u);

                // Recherche des types d'enseignements de cette matiere
                result = this.connect.createStatement().executeQuery(
                            "SELECT T.nom_type_enseignement," +
                                   "T.nb_heures_enseignement," +
                                   "T.nb_heures_equivalentTD " +
                            "FROM type_enseignement T, enseignement E " +
                            "WHERE T.nom_type_enseignement = E.nom_type_enseignement " +
                            "AND E.code_matiere = '" + mat.getCode() + "'" +
                            "GROUP by T.nom_type_enseignement," +
                                     "T.nb_heures_enseignement," +
                                     "T.nb_heures_equivalentTD");

                // Création des types d'enseignement et stockage dans une liste
                ArrayList<TypeEnseignement> list = new ArrayList ();
                while (result.next()) {
                    list.add(new TypeEnseignement (result.getString("nom_type_enseignement"),
                                                   result.getDouble("nb_heures_enseignement"),
                                                   result.getDouble("nb_heures_equivalentTD")));
                }

                // Ajout de cette liste à la matière créée
                mat.setTypeEns(list);
            }
            
        } catch (SQLException ex) {
            // Si exception, la méthode retourne l'objet Matiere initial
            mat = m;
        }
        return mat;
    }

    /**
     * Méthode qui exécute une requête de suppression d'une matière dans la base de données.
     * Cette méthode redéfinit la méthode find(T obj) de la superclasse DAO.
     * @author Laëtitia Vigroux
     * @exception SQLException
     * @param m Objet Matiere dont l'enregistrement correspondant dans la base doit être supprimé
     * @return Boolean - True (Vrai) si la suppression s'est bien déroulée, False (Faux) si elle n'a pas pu être effectuée
     * @version 1.0
     */
    public boolean delete(Matiere m) {
        boolean ok = true; // Vaut True si la suppression s'est déroulée correctement, False sinon
        try {
            // Création et exécution de la requête de suppression
            this.connect.createStatement().executeUpdate(
                            "DELETE FROM matiere " +
                            "WHERE code_matiere ='" + m.getCode() + "'");
        }
        catch (SQLException e) {
            // Si exception, on indique que la suppression ne s'est pas déroulée correctement
            ok = false;
        }
        
        // La suppression s'est bien déroulée lorsqu'1 seule ligne a été supprimée de la base
        return ok;
    }

    /**
     * Méthode qui :
     *      1) récupère l'ensemble des matières de la table correspondante dans la base
     *      2) les mappe en objet java Matiere
     *      3) les stocke dans une liste d'ojbets Matiere
     * @author Laëtitia Vigroux
     * @exception SQLException
     * @return ArrayList<Matiere> - Liste des matières stockées dans la base
     * @version 1.0
     */
    public ArrayList<Matiere> getListe() {

        ArrayList<Matiere> list = new ArrayList();

        try {
            // Requête de sélection de l'ensemble des matières de la base
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Matiere");

            // Ajout des matières dans la liste
            while (result.next()) {
                UE u = new UE(result.getString("code_UE"),null);
                list.add(new Matiere (result.getString("code_matiere"),
                                      result.getString("nom_matiere"),
                                      result.getString("description"),
                                      result.getInt("coefficient"),u)
                         );
            }

            // Recherche des types d'enseignements des matières
            for (Integer i=0; i<list.size(); i++) {

                // Recherche des types d'enseignements de la matière parcourue dans la liste
                result = this.connect.createStatement().executeQuery(
                            "SELECT T.nom_type_enseignement," +
                                   "T.nb_heures_enseignement," +
                                   "T.nb_heures_equivalentTD " +
                            "FROM type_enseignement T, enseignement E " +
                            "WHERE T.nom_type_enseignement = E.nom_type_enseignement " +
                            "AND E.code_matiere = '" + list.get(i).getCode() + "'" +
                            "GROUP by T.nom_type_enseignement," +
                                     "T.nb_heures_enseignement," +
                                     "T.nb_heures_equivalentTD");

                // Création des types d'enseignement et stockage dans une liste
                ArrayList<TypeEnseignement> type = new ArrayList ();
                while (result.next()) {
                    type.add(new TypeEnseignement (result.getString("nom_type_enseignement"),
                                                   result.getDouble("nb_heures_enseignement"),
                                                   result.getDouble("nb_heures_equivalentTD")));
                }

                // Ajout de cette liste à la matière créée
                list.get(i).setTypeEns(type);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getNewCodeMatiere () {
        String code = "";
        try {
            // Recherche du code matière le plus élevé
            ResultSet result = this.connect.createStatement().executeQuery(
                        "SELECT MAX(code_matiere) AS code FROM matiere");
            
            if (result.first()) {
                // Récupération du code trouvé
                code = result.getString("code");
                // Incrémentation de la valeur entière de ce code de 1
                Integer temp = Integer.parseInt(code) + 1;
                // Re conversion du code en chaîne de 4 caractères
                if (temp < 10) {
                    code = "000";
                }
                else if (temp <100) {
                    code = "00";
                }
                else if (temp < 1000) {
                    code = "000";
                }
                code = code + temp.toString();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return code;
    }

    /**
     * Méthode qui permet de retourner la liste des matières associées à l'UE
     * dont le code est en paramètre. Les objets Matiere de la liste sont renseignés
     * par tous leurs attributs.
     * @author Laëtitia Vigroux
     * @author Ophelie Mak
     * @param ue Code de l'UE pour laquelle on veut les matières associées
     * @return ArrayList<Matiere> - Liste des objets Matiere associés à l'UE en paramètre
     * @version 1.0
     */
    public ArrayList<Matiere> getMatiereByUE (String ue) {
        ArrayList<Matiere> list = new ArrayList(); // Liste à retourner
        try {
            // Requête de sélection des matières selon l'UE donnée
            ResultSet result = this.connect.createStatement().executeQuery(
                                "SELECT * FROM matiere " +
                                "WHERE code_ue = '" + ue + "'");

            // Remplissage de la liste des matières
            while (result.next()) {
                UE u = new UE(result.getString("code_UE"),null);
                list.add(new Matiere (result.getString("code_matiere"),
                                      result.getString("nom_matiere"),
                                      result.getString("description"),
                                      result.getInt("coefficient"),u
                                     ));
            }
        }
        catch (SQLException e) {
            // Si exception, on renvoie la liste vide
            list.clear();
        }
        return list;
    }

    @Override
    public boolean update(Matiere ancien, Matiere nouveau) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
