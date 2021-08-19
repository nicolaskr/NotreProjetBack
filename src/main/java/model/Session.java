package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import metier.Bastide;
import metier.Batiment;
import metier.Joueur;
import metier.Ressource;
import util.Context;


@Entity
public class Session {


	@EmbeddedId 
	private SessionId id;
	
	@Column(name = "a_joue_le_tours")
	private boolean aJoueLeTours;
	@Column(name = "tour_en_tours")
	private boolean tourEnCours;
	@Column(name = "a_commence")
	protected boolean aCommence;
	private int def;
	private int att;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @MapsId("idPartie")
    private Partie partie;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @MapsId("idCompte")
    private Compte compte;
				
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name="liste_ressource",inverseJoinColumns=@JoinColumn(name="ressources"))
	protected List<Ressource> ressources = new ArrayList <Ressource>();
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name="liste_batiments",inverseJoinColumns=@JoinColumn(name="batiments"))
	protected List<Batiment> constructions = new ArrayList <Batiment>();
			
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

	public List<Ressource> getRessources() {
		return ressources;
	}

	public void setRessources(List<Ressource> ressources) {
		this.ressources = ressources;
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
	
	public void construitBastide()	{
		Bastide bastide = new Bastide();
		this.getConstructions().add(bastide);
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		Context.getInstance().getDaoS().update(this);
		
		em.getTransaction().commit();		
		em.close();
	}
		
	public ArrayList<Batiment> actuDef() //Permet d'actualiser les points de defense du joueur ainsi que la liste des batiments du joueur (ATTENTION RENVOI UNE LISTE !!)
	{
		ArrayList <Batiment> batiments = new ArrayList <Batiment>();
		this.def=0;
		
		for (Batiment batiment : this.constructions)
		{
			if (batiment.getDef()>0) {batiments.add(batiment);}
		}
		
		for (Batiment batiment : constructions)
		{
			this.def += batiment.getDef();
		}
		
		return batiments;
	}
	
	
	public boolean verification(Batiment batiment) // Verification du nombre de ressources du joueur pour acheter un batiment (renvoie un bool)
	{
		for (Ressource ressourceSession : this.ressources)
		{
			for (Ressource ressourceBatiment: batiment.getCost())
			{
				if (ressourceBatiment.getClass().getName().equals(ressourceSession.getClass().getName()) && ressourceBatiment.getStock()>ressourceSession.getStock())
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public void attaque(Session ennemi) // Attaque de tous les batiments d'un autre joueur
	{
		double ptsAtt = this.att/ennemi.getConstructions().size();
		for (Batiment batiment : ennemi.getConstructions())
		{
			batiment.setDef(batiment.getDef()-ptsAtt);
		}
	}
	
	public void attaque(Session ennemi, Batiment batiment, double ptsAttaque) // Attaque d'un batiment d'un autre joueur
	{
		batiment.setDef(batiment.getDef()-ptsAttaque);
		System.out.println("Il reste " + batiment.getDef() + " de defence a " + batiment.toStringName());
		ennemi.setConstructions(ennemi.actuDef());
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		Context.getInstance().getDaoB().update(batiment); 
		
		em.getTransaction().commit();		
		em.close();
	}
	
	
		
}
