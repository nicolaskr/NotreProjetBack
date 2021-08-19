package model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


@Entity
public class Session {

	@EmbeddedId private SessionId id;
	@Column(name = "a_joue_le_tours")
	private boolean aJoueLeTours;
	
	@ManyToOne
    @MapsId("idPartie")
    private Partie partie;
	
	@ManyToOne
    @MapsId("idCompte")
    private Compte compte;
				
	public Session() {}
		
	public Session(boolean aJoueLeTours, Partie partie, Compte compte) {	
		this.aJoueLeTours = aJoueLeTours;
		this.partie = partie;
		this.compte = compte;
	}

	public SessionId getId() {
		return id;
	}

	public void setId(SessionId id) {
		this.id = id;
	}

	public boolean isaJoueLeTours() {
		return aJoueLeTours;
	}

	public void setaJoueLeTours(boolean aJoueLeTours) {
		this.aJoueLeTours = aJoueLeTours;
	}
		
	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", aJoueLeTours=" + aJoueLeTours + "]";
	}
	
}
