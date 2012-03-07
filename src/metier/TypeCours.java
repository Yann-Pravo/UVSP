package metier;

/**
 * Classe métier permettant la définition et la gestion des objets 'TypeCours'
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class TypeCours {
	
    //Attributs
	private int idTypeCours;
    private String libelle;

    public TypeCours(int id)
    {
    	this.idTypeCours =id;
    }
    
    public TypeCours (int id, String nom)
    {
    	this.idTypeCours =id;
        this.libelle = nom;
    }

    
    public TypeCours(String nom)
    {
    	this.libelle = nom;
    }
  
    
    public int getIdTypeCours()
    {
    	return this.idTypeCours;
    }
    
    public void setIdTypeCours(int id)
    {
    	this.idTypeCours = id;
    }


    public String getNomTypeCours() {
        return this.libelle ;
    }

 
    public void setNomTypeCours (String nom) {
        this.libelle  = nom ;
    }
}

