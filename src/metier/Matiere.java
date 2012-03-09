package metier;

/**
 * Classe métier permettant la définition et la gestion des objets 'Matiere'
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class Matiere {

    // Attributs
    private int idMat;
    private String nomMat;
    

    // Attributs d'association
    private UE ue;
    private Enseignant resp;

    public Matiere(int id) {
        this.idMat = id;
    }
    
    public Matiere(int id, String libelle) {
        this.idMat = id;
        this.nomMat = libelle;
    }

  
    public Matiere(String libelle) {
        this.nomMat = libelle;
    }


    public Matiere(int id, String libelle, UE u) {
        this.idMat = id;
        this.nomMat = libelle;
        this.ue = u;
    }

    
    public Matiere (int id, String libelle, UE u, Enseignant ens)
    {
       this.idMat = id;
       this.nomMat = libelle;
       this.ue = u;
       this.resp = ens;
    }
    
    public Matiere (String libelle, UE u, Enseignant ens)
    {
       this.nomMat = libelle;
       this.ue = u;
       this.resp = ens;
    }


    public int getIdMat() {
        return this.idMat;
    }

   
    public void setIdMat(int id) {
        this.idMat = id;
    }
    
    public String getNomMat()
    {
    	return this.nomMat;
    }
    
    public void setNomMat(String nom)
    {
    	this.nomMat = nom;
    }
    
    public UE getUEMat()
    {
    	return this.ue;
    }
    
    public void setUEMat(UE u)
    {
    	this.ue = u;
    }
    
    public Enseignant getResponsable()
    {
    	return this.resp;
    }

    
    public void setResponsable(Enseignant resp) {
        this.resp = resp;
    }


}