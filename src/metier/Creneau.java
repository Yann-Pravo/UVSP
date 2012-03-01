package metier;

public class Creneau {

	private String id;
	private String heureDeb;
	private String heureFin;
	
	public Creneau(String id, String HD, String HF){
		this.id = id;
		this.heureDeb=HD;
		this.heureFin=HF;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
