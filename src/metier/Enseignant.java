package metier;



/**
 * Classe métier permettant la définition et la gestion des objets 'Enseignant'
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class Enseignant {

	//Attributs
	private int idEns;
	private String nom;
	private String prenom;
	private String mdp;
	private int su;
	
	public Enseignant(int id)
	{
		this.idEns = id;
	}
	
	public Enseignant(int id, String n, String p, String pwd, int supUser)
	{
		this.idEns = id;
		this.nom = n;
		this.prenom = p;
		this.mdp = pwd;
		this.su = supUser;
	}
	
	public Enseignant(String n, String p, String pwd, int supUser)
	{
		this.nom = n;
		this.prenom = p;
		this.mdp = pwd;
		this.su = supUser;
	}
	
	public Enseignant(String n, String pwd)
	{
		this.nom = n;
		this.mdp = pwd;
	}
	
	public String toString() {
		return nom + " " + prenom;
	}

    public int getIdEns()
    {
    	return this.idEns;
    }
    
    public void setIdEns(int id)
    {
    	this.idEns = id;
    }
    
    
    public String getNom()
    {
    	return this.nom;
    }
    
    public void setNom(String n)
    {
    	this.nom = n;
    }
    
    
    public String getPrenom()
    {
    	return this.prenom;
    }
    
    public void setPrenom(String p)
    {
    	this.prenom = p;
    }
    
    
    public String getMdp()
    {
    	return this.mdp;
    }
    
    public void setMdp(String pwd)
    {
    	this.mdp = pwd;
    }
    
    
    public int getSu()
    {
    	return this.su;
    }
    
    public void setSu(int s)
    {
    	this.su = s;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}