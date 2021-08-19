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
				
	public Session() {}

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

	@Override
	public String toString() {
		return "Session [id=" + id + ", aJoueLeTours=" + aJoueLeTours + "]";
	}
	
}
