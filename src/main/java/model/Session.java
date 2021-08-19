package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


@Entity
public class Session {

	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name="liste_ressource",inverseJoinColumns=@JoinColumn(name="ressources"))
	protected List<Ressource> stock = new ArrayList <Ressource>();
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name="liste_batiments",inverseJoinColumns=@JoinColumn(name="batiments"))
	protected List<Batiment> constructions = new ArrayList <Batiment>();
		
	@EmbeddedId 
	private SessionId id;
	
	@Column(name = "a_joue_le_tours")
	private boolean aJoueLeTours;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @MapsId("idPartie")
    private Partie partie;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @MapsId("idCompte")
    private Compte compte;
				
	public Session() {}
		
	public Session(boolean aJoueLeTours, Partie partie, Compte compte) {	
		this.id = new SessionId(compte.getId(),partie.getId());
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

	public List<Ressource> getStock() {
		return stock;
	}

	public void setStock(List<Ressource> stock) {
		this.stock = stock;
	}

	public List<Batiment> getConstructions() {
		return constructions;
	}

	public void setConstructions(List<Batiment> constructions) {
		this.constructions = constructions;
	}
	
	@Override
	public String toString() {
		return "Session [id=" + id + ", aJoueLeTours=" + aJoueLeTours + "]";
	}
		
}
