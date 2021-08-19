package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Partie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="nbrDeTour")
	private int nbrDeTour;
	@Column(name="partieEnCours")
	private boolean partieEnCours;
		
	@OneToMany
	private List<Session> sessions = new ArrayList<Session>();
	
	public Partie() {}

	public Partie(int nbrDeTour, boolean partieEnCours) {
		super();
		this.nbrDeTour = nbrDeTour;
		this.partieEnCours = partieEnCours;
	}

	public Partie(int id, int nbrDeTour, boolean partieEnCours) {
		super();
		this.id = id;
		this.nbrDeTour = nbrDeTour;
		this.partieEnCours = partieEnCours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getnbrDeTour() {
		return nbrDeTour;
	}

	public void setnbrDeTour(int nbrDeTour) {
		this.nbrDeTour = nbrDeTour;
	}

	public boolean ispartieEnCours() {
		return partieEnCours;
	}

	public void setpartieEnCours(boolean partieEnCours) {
		this.partieEnCours = partieEnCours;
	}

	@Override
	public String toString() {
		return "Partie [id=" + id + ", nbrDeTour=" + nbrDeTour + ", partieEnCours=" + partieEnCours + "]";
	}
	
}
