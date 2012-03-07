package metier;

public class Cours {

	
    // Attributs
    private int idCours;
    private String lib;

    // Attributs d'association
    private Matiere mat;
    private TypeCours type;
    
 
    public Cours(String lib) {
        this.lib = lib;
    }

    public Cours(int idCours) {
        this.idCours = idCours;
    }

    public Cours(int id, String lib) {
        this.idCours = id;
        this.lib = lib;
    }


    public Cours(int id, String lib, Matiere mat) {
        this.idCours = id;
        this.lib = lib;
        this.mat = mat;
    }


    public Cours(int id, String lib, Matiere mat, TypeCours type)
    {
        this.idCours = id;
        this.lib = lib;
        this.mat = mat;
        this.type = type;
    }

    public Cours(String lib, Matiere mat, TypeCours type)
    {
    	this.lib = lib;
    	this.mat = mat;
    	this.type = type;
    }
    
    public Cours(String lib, Matiere mat)
    {
    	this.lib = lib;
    	this.mat = mat;
  
    }
    
   
    
    public int getIdCours()
    {
    	return this.idCours;
    }
    
    public void setIdCours(int id)
    {
    	this.idCours = id;
    }
    
    
   
    public Matiere getMatiere() {
        return mat;
    }

 
    public void setMatiere(Matiere mat) {
        this.mat = mat;
    }

  
    public String getLibelle() {
        return lib;
    }

 
    public void setLibelle(String lib) {
        this.lib = lib;
    }


    public TypeCours getTypeCours() {
        return type;
    }

 
    public void setTypeCours(TypeCours type) {
        this.type = type;
    }
}
