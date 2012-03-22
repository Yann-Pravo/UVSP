package persistance;

import metier.TypeCours;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe permettant de mapper les objets TypeCours vers la table TYPECOURS de la base de données.
 * Cette classe hérite de la classe DAO.
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class TypeCoursDAO extends DAO<TypeCours> {

    private static final TypeCoursDAO instance = new TypeCoursDAO();

    /**
     * Méthode permettant de récupérer l'objet unique de type TypeCoursDAO
     * @return TypeCoursDAO - Instance unique de l'objet TypeCoursDAO
     */
    public final static TypeCoursDAO getInstance() {
        return instance;
    }

    /**
     * Méthode qui exécute une requête d'ajout d'une nouvelle TypeCours dans la base de données.
     * Cette méthode redéfinit la méthode create(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param instance Objet TypeCours qui doit être mappé dans la base
     * @return Boolean - Vrai si l'insertion s'est déroulée correctement, Faux sinon
     */
    public boolean create(TypeCours instance) {
    	boolean ok = false;
    	try {
    		PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO TYPECOURS(ID_TYPE_DE_COURS, LIBELLE_TYPE_DE_COURS) VALUES(?,?)");
    		prepare.setString(1, "seqEnseignant.nextval");
    		prepare.setString(2, instance.getNomTypeCours());
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
     * à la TypeCours instance en paramêtre et retourne les résultats sous forme d'un objet TypeCours.
     * @param instance Objet TypeCours à rechercher dans la base de données
     * @return TypeCours - Objet TypeCours créé à partir des résultats trouvés dans la base
     */
	public TypeCours find(TypeCours instance) {
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery("select * from TYPECOURS where ID_TYPE_DE_COURS = " + instance.getIdTypeCours() );
			if(result.first())
			{
				instance.setNomTypeCours(result.getString("LIBELLE_TYPE_DE_COURS"));
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
     * Méthode qui exécute une requête de mise à jour d'un enregistrement de la table 'TypeCours' dans la base de données.
     * Cette méthode redéfint la méthode update(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param type Objet TypeCours qui doit être mappé pour mettre à jour la ligne correspondante dans la base
     * @return Boolean - Vrai si la mise à jour s'est déroulée correctement, Faux sinon
     */
	public boolean update(TypeCours type) {
		boolean resultat = false;
		try {
			PreparedStatement prepare = this.connect
					.prepareStatement("update TYPECOURS set LIBELLE_TYPE_DE_COURS=? where ID_TYPE_DE_COURS=?");
                        prepare.setString(1, type.getNomTypeCours());
                        prepare.setInt(7, type.getIdTypeCours());
                        prepare.executeUpdate();
                        resultat=true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

    /**
     * Méthode qui exécute une requête de suppression d'une TypeCours dans la base de données.
     * Cette méthode redéfinit la méthode find(T obj) de la superclasse DAO.
     * @exception SQLException
     * @param type Objet TypeCours dont l'enregistrement correspondant dans la base doit être supprimé
     * @return Boolean - Vrai si la suppression s'est bien déroulée, Faux sinon
     */
	public boolean delete(TypeCours type) {
		boolean resultat=false;
		try {
			PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM TYPECOURS where ID_TYPE_DE_COURS=?");
			prepare.setInt(1, type.getIdTypeCours());
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
     *      1) récupère l'ensemble des TypeCours de la table correspondante dans la base
     *      2) les mappe en objet java TypeCours
     *      3) les stocke dans une liste d'objets TypeCours
     * @exception SQLException
     * @return ArrayList<TypeCours> - Liste des TypeCours stockées dans la base
     */
	public ArrayList<TypeCours> getListe() {
		ArrayList<TypeCours> list = new ArrayList<TypeCours>();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
					.executeQuery("select * from TYPECOURS");
			while (result.next())
			{
				TypeCours type = new TypeCours(result.getInt("ID_TYPE_DE_COURS"),result.getString("LIBELLE_TYPE_DE_COURS"));
				list.add(type);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean update(TypeCours ancien, TypeCours nouveau) {
		return false;
	}

	@Override
	public boolean login(TypeCours obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
