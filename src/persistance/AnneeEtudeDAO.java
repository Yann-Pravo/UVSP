package persistance;
import metier.*;

import java.sql.*;
import java.util.ArrayList;


public class AnneeEtudeDAO extends DAO<AnneeEtude>{

	private static final AnneeEtudeDAO instance = new AnneeEtudeDAO();
	
	public final static AnneeEtudeDAO getInstance()
	{
		return instance;
	}
	
	
	@Override
	public boolean create(AnneeEtude ae) {
		 boolean ok = true; // Vaut True si l'insertion s'est déroulée correctement, False sinon
	        try {
	                // Création et exécution de la requête d'ajout d'une nouvelle année d'étude
	                PreparedStatement prepare = this.connect.prepareStatement(
	                    "INSERT INTO annee_etude VALUES(?, ?, ?, ?, ?)");
	            prepare.setString(1, ae.getNomAnnee());
	            prepare.setString(3, ae.getDescription());
	            prepare.setInt(4, ae.getDureeSeance());
	            prepare.setInt(5, ae.getNbSeanceAM());
	            prepare.setInt(6, ae.getNbSeancePM());

	            prepare.executeUpdate();
	            }
	        catch (SQLException e) {
	            // Si exception, on indique que l'insertion ne s'est pas déroulée correctement
	            ok = false;
	        }
	        // L'ajout s'est bien déroulé si 1 ligne a été créée dans la base
	        return ok;

	}

	@Override
	public boolean update(AnneeEtude ae) {
		boolean ok = true; // Vaut True si la mise à jour s'est correctement déroulée, False sinon
        try {
           
            // Excécution de la requête de mise à jour de la description de l'année d'étude ae
            this.connect.createStatement().executeUpdate(
                            "UPDATE annee_etude " +
                            "SET description='" + ae.getDescription() + "' " +
                            "WHERE nom_annee_etude='" + ae.getNomAnnee() + "'");

            // Excécution de la requête de mise à jour de la durée des séances de l'année d'étude ae
            this.connect.createStatement().executeUpdate(
                            "UPDATE annee_etude " +
                            "SET duree_seance=" + ae.getDureeSeance() + " " +
                            "WHERE nom_annee_etude='" + ae.getNomAnnee() + "'");

            // Excécution de la requête de mise à jour du nombre de séances le matin de l'année d'étude ae
            this.connect.createStatement().executeUpdate(
                            "UPDATE annee_etude " +
                            "SET nb_seances_am=" + ae.getNbSeanceAM() + " " +
                            "WHERE nom_annee_etude='" + ae.getNomAnnee() + "'");

            // Excécution de la requête de mise à jour du nombre de séances l'après midi de l'année d'étude ae
            this.connect.createStatement().executeUpdate(
                            "UPDATE annee_etude " +
                            "SET nb_seances_pm=" + ae.getNbSeancePM() + " " +
                            "WHERE nom_annee_etude='" + ae.getNomAnnee() + "'");
        } catch (SQLException e) {
            // Si exception, on indique que la mise à jour ne s'est pas déroulée correctement
            ok = false;
        }

        return ok;

	}

	@Override
	public boolean update(AnneeEtude ancien, AnneeEtude nouveau) {
		return false;
	}

	@Override
	public AnneeEtude find(AnneeEtude ae) {
		
		ArrayList<AnneeUniversitaire> list = new ArrayList<AnneeUniversitaire>(); // Liste des années universitaires
        AnneeEtude annee = null;
        ResultSet result; // Résultat des requêtes

        try {
            // Requête de sélection des informations dans la table annee_etude
            result = this.connect.createStatement().executeQuery(
                        "SELECT * FROM annee_etude " +
                        "WHERE nom_annee_etude = '" + ae.getNomAnnee() + "'");  

            if (result.first()) {

                // Création de l'objet AnneeEtude avec les informations trouvées dans la base
               
                annee = new AnneeEtude (result.getString("nom_annee_etude"),
                                        result.getString("description"),
                                        result.getInt("duree_seance"),
                                        result.getInt("nb_seances_am"),
                                        result.getInt("nb_seances_pm"));
                
                // Requête de sélection des années universitaires associées à l'année d'étude
                result = this.connect.createStatement().executeQuery(
                            "SELECT nom_annee_univ FROM conge " +
                            "WHERE nom_annee_etude = '" + ae.getNomAnnee() + "' " +
                            "GROUP BY nom_annee_univ");

                // Stockage des enregistrements dans une liste d'années universitaires
                while (result.next()) {
                    list.add(new AnneeUniversitaire (result.getString("nom_annee_univ")));
                }

                // Mise à jour de l'année d'étude avec la liste des années universitaires
                annee.setAnnneUniv(list);

                // Requête de sélection des semestres associés à une année d'étude
                result = this.connect.createStatement().executeQuery(
                            "SELECT * FROM semestre " +
                            "WHERE nom_annee_etude = '" + ae.getNomAnnee() + "'");

                // Création des objets Semestre
                Semestre s1 = null;
                Semestre s2 = null;
                if (result.first()) {
                    // Création de l'objet correspondant au 1er semestre
                    s1 = new Semestre (result.getString("nom_semestre"),
                                       annee,
                                       result.getInt("niveau"));
                    if (result.next()) {
                        // Création de l'objet correspondant au 2nd semestre
                        s2 = new Semestre (result.getString("nom_semestre"),
                                           annee,
                                           result.getInt("niveau"));
                    }
                }

                // Mise à jour de l'année d'étude avec les semstres
                annee.setS1(s1);
                annee.setS2(s2);
            }
        } catch (SQLException ex) {
            // Si exception, la méthode retourne l'objet Matiere initial
            annee = ae;
        }
        return annee;

	}

	@Override
	public boolean delete(AnneeEtude ae) {
		boolean ok = true; // Vaut True si la suppression s'est déroulée correctement, False sinon
        try {
            // Création et exécution de la requête de suppression
            this.connect.createStatement().executeUpdate(
                            "DELETE FROM annee_etude " +
                            "WHERE nom_annee_etude = '" + ae.getNomAnnee() + "'");
        }
        catch (SQLException e) {
            // Si exception, on indique que la suppression ne s'est pas déroulée correctement
            ok = false;
        }

        // La suppression s'est bien déroulée lorsqu'1 seule ligne a été supprimée de la base
        return ok;

	}

	@Override
	public ArrayList<AnneeEtude> getListe() {
		ArrayList<AnneeEtude> listAE = new ArrayList<AnneeEtude>();
        //ArrayList<AnneeUniversitaire> listAU = new ArrayList<AnneeUniversitaire>();
        ResultSet anneeEt, semestre; // Résultats de requêtes de sélection
        Semestre s1 = null; // Objet correspondant au 1er semestre
        Semestre s2 = null; // Objet correspondant au 2nd semestre

        try {
            // Requête de sélection de l'ensemble des années d'étude de la base
            anneeEt = this.connect.createStatement().executeQuery("SELECT * FROM annee_etude");

            // Ajout des années d'étude dans la liste
            while (anneeEt.next()) {

                /*// Requête de sélection des années universitaires associées à l'année d'étude
                anneeUniv = this.connect.createStatement().executeQuery(
                        "SELECT nom_annee_univ FROM conge " +
                        "WHERE nom_annee_etude = '" + anneeEt.getString("nom_annee_etude") + "' " +
                        "GROUP BY nom_annee_univ");
                // Stockage des enregistrements dans une liste d'années universitaires
                while (anneeUniv.next()) {
                    listAU.add(new AnneeUniversitaire (anneeUniv.getString("nom_annee_univ")));
                }*/

               
                AnneeEtude a = new AnneeEtude(anneeEt.getString("nom_annee_etude"),
                                           anneeEt.getString("description"),
                                           anneeEt.getInt("duree_seance"),
                                           anneeEt.getInt("nb_seances_am"),
                                           anneeEt.getInt("nb_seances_pm"));
                // Requête de sélection des semestres associés à une année d'étude
                semestre = this.connect.createStatement().executeQuery(
                            "SELECT * FROM semestre " +
                            "WHERE nom_annee_etude = '" + anneeEt.getString("nom_annee_etude") + "'");
                // Création des objets Semestre
                if (semestre.first()) {
                    // Création de l'objet correspondant au 1er semestre
                    s1 = new Semestre (semestre.getString("nom_semestre"),a,
                                       semestre.getInt("niveau"));
                    a.setS1(s1);
                    if (semestre.next()) {
                        // Création de l'objet correspondant au 2nd semestre
                        s2 = new Semestre (semestre.getString("nom_semestre"),a,
                                           semestre.getInt("niveau"));
                        a.setS2(s2);
                    }
                }

                // Ajout de la nouvelle année d'étude à la liste
                listAE.add(a);
            }
        }
        catch (SQLException e) {
            // Si exception, on renvoie la liste vide
            listAE.clear();
        }
        return listAE;

	}

	
	
	
	
	
	
	
	
	
	
	
	
}
