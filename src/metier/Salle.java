package metier;

import java.util.ArrayList;

/**
 * Classe métier permettant la définition et la gestion des objets 'Salle'
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class Salle {

    //Attributs
	private int idSalle;
    private String lib;

    // Attributs d'association
    private Batiment bat;
    private ArrayList<Caracteristique> car;
    
    public Salle(int id) {
    	this.idSalle = id;
    }
    
    /**
     * Constructeur d'un objet Salle prenant en compte ses 2 attributs
     * @param lib Libellé de la salle
     * @param code Code de la salle
     * @param bat Batiment de la salle
     */
    public Salle(int id, String lib, Batiment bat, ArrayList<Caracteristique> c) {
    	this.idSalle = id;
    	this.lib = lib;
        this.bat = bat;
        this.car = c;
    }
    
    /**
     * Constructeur d'un objet Salle prenant en compte ses 2 attributs
     * @param lib Libellé de la salle
     * @param code Code de la salle
     * @param bat Batiment de la salle
     */
    public Salle(int id, String lib, Batiment bat) {
    	this.idSalle = id;
    	this.lib = lib;
        this.bat = bat;
    }

    public Salle(String lib, Batiment bat, ArrayList<Caracteristique> c) {
        this.lib = lib;
        this.bat = bat;
        this.car = c;
    }
    
    public Salle(String lib)
    {
    	this.lib = lib;
    }
    
    public Salle(int idSalle, String lib)
    {
    	this.idSalle = idSalle;
    	this.lib = lib;
    }
    
    
    
    public int getIdSalle()
    {
    	return this.idSalle;
    }
    
    public void setIdSalle(int id)
    {
    	this.idSalle = id;
    }
    
    
 
    public String getLibelle() {
        return lib;
    }


    public Batiment getBatiment() {
        return this.bat;
    }

    
    public void setLibelle(String lib) {
        this.lib = lib;
    }
    
 
    public void setBatiment(Batiment bat) {
        this.bat = bat;
    }
    
    
    public ArrayList<Caracteristique> getCarSalle()
    {
    	return this.car;
    }
    
    public void setCarSalle(ArrayList<Caracteristique> c)
    {
    	this.car = c;
    }
    
    public String toString() {
    	return lib;
    }
}