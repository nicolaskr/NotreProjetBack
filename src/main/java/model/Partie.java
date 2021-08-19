package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Partie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int nbr_de_tour;
	private boolean partie_en_cours;
		
	public Partie() {}

	public Partie(int nbr_de_tour, boolean partie_en_cours) {
		super();
		this.nbr_de_tour = nbr_de_tour;
		this.partie_en_cours = partie_en_cours;
	}

	public Partie(int id, int nbr_de_tour, boolean partie_en_cours) {
		super();
		this.id = id;
		this.nbr_de_tour = nbr_de_tour;
		this.partie_en_cours = partie_en_cours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbr_de_tour() {
		return nbr_de_tour;
	}

	public void setNbr_de_tour(int nbr_de_tour) {
		this.nbr_de_tour = nbr_de_tour;
	}

	public boolean isPartie_en_cours() {
		return partie_en_cours;
	}

	public void setPartie_en_cours(boolean partie_en_cours) {
		this.partie_en_cours = partie_en_cours;
	}

	@Override
	public String toString() {
		return "Partie [id=" + id + ", nbr_de_tour=" + nbr_de_tour + ", partie_en_cours=" + partie_en_cours + "]";
	}
	
}
