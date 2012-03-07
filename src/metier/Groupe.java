package metier;

/**
 * Classe metier de gestion des groupes
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class Groupe {

	//Attributs
    private int idGroupe;
    public String lib;
    public Groupe pere;
    
    public Groupe(int id) {
    	this.idGroupe = id;
    }
    
    public Groupe(int id, String lib, Groupe pere) {
    	this.idGroupe = id;
        this.lib = lib;
        this.pere = pere;
    }


    public Groupe(String lib, Groupe pere) {
        this.lib = lib;
        this.pere = pere;
    }
    
    
    public Groupe(String lib) {
        this.lib = lib;
    }

   
    
    public int getIdGroupe()
    {
    	return this.idGroupe;
    }
    
    public void setIdGroupe(int id)
    {
    	this.idGroupe = id;
    }
    
    
   
    public String getLibelle() {
        return lib;
    }

  
    public void setLibelle(String lib) {
        this.lib = lib;
    }

   
    public Groupe getPere() {
        return pere;
    }

 
    public void setPere(Groupe pere) {
        this.pere = pere;
    }
}