package metier;

/**
 * Classe métier permettant la définition et la gestion d'un objet UE
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class UE {
	// Attributs
	private int idUE;
	private String nomUE;

	//Attributs associations
	private Enseignant ens;

    public UE(int id) {
        this.idUE = id;
    }
	
    public UE(int id, String nom) {
        this.idUE = id;
        this.nomUE = nom;
    }
    
    public UE(int id, String nom, Enseignant ens)
    {
    	this.idUE = id;
    	this.nomUE = nom;
    	this.ens = ens;
    }
 
    public UE(){}

    /**
     * Constructeur d'un objet UE prenant le code de l'UE
     * @param c Code de l'UE
     */
    public UE(String nom) {
        this.nomUE = nom;
    }


    public int getIdUE() {
        return this.idUE;
    }


    public void setIdUE(int codeUE) {
        this.idUE = codeUE;
    }

 
    public String getNomUE() {
        return this.nomUE;
    }


    public void setNomUE(String nomUE) {
        this.nomUE = nomUE;
    }


	public Enseignant getEnseignant() {
		return this.ens;
	}

	public void setEnseignant(Enseignant e) {
		this.ens = e;
	}
}