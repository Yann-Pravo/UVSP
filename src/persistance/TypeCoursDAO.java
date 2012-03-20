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
     * Méthode permettant de créer un typecours en base de donnée
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
