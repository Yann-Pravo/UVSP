package metier;

public class Reservation {

	private String cara;
	private Salle salle;
	private Enseignement ens;
	private Creneau creneau;
	
	public Reservation(String cara, Salle salle, Enseignement ens, Creneau creneau){
		this.cara = cara;
		this.salle = salle;
		this.ens = ens;
		this.creneau= creneau;
	}
	
	public Reservation(String cara, Enseignement ens, Creneau creneau){
		this.cara = cara;
		this.ens = ens;
		this.creneau= creneau;
	}
	
	public Reservation(String cara, Salle salle, Enseignement ens){
		this.cara = cara;
		this.salle = salle;
		this.ens = ens;
	}
	
	public String getCara() {
		return cara;
	}
	public void setCara(String cara) {
		this.cara = cara;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Enseignement getEns() {
		return ens;
	}
	public void setEns(Enseignement ens) {
		this.ens = ens;
	}
	public Creneau getCreneau() {
		return creneau;
	}
	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}
	
	
}
