package metier;

public class Creneau {

	private int idCreneau;
	private String heureDeb;
	private String heureFin;
	
	public Creneau(int id){
		this.idCreneau = id;
	}
	
	public Creneau(int id, String HD, String HF){
		this.idCreneau = id;
		this.heureDeb=HD;
		this.heureFin=HF;
	}
	public int getIdCreneau() {
		return this.idCreneau;
	}
	public void setIdCreneau(int id) {
		this.idCreneau = id;
	}
	
	
	public String getHeureDeb() {
		return heureDeb;
	}
	public void setHeureDeb(String heureDeb) {
		this.heureDeb = heureDeb;
	}
	public String getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}
	
	
	
}
