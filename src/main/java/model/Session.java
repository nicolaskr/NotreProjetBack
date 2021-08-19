package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import metier.Attaque;
import metier.Batiment;
import metier.Carriere;
import metier.Fonderie;
import metier.Four;
import metier.Joueur;
import metier.Mine;
import metier.Partie;
import metier.Ressource;
import metier.Scierie;
import metier.TypeCompte;
import model.*;
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
	@JoinTable(name="liste_ressources",inverseJoinColumns=@JoinColumn(name="ressources"))
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
	
	public void construitBastide(){ // OK
		Bastide bastide = new Bastide();
		this.getConstructions().add(bastide);
		Context.getInstance().getDaoS().update(this);
	}
		
	public ArrayList<Batiment> actuDef() //Permet d'actualiser les points de defense du joueur ainsi que la liste des batiments du joueur (ATTENTION RENVOI UNE LISTE !!)
	{
		ArrayList <Batiment> batiments = new ArrayList <Batiment>();
		this.def=0;
		
		for (Batiment batiment : this.constructions)
		{
			if (batiment.getDef()>0) {
				batiments.add(batiment);
				this.def += batiment.getDef();
			}
		}			
		return batiments;
	}
	
	public ArrayList <Batiment> actuAtt()  //Permet d'actualiser les point d'attaque du joueur ainsi que la liste des batiments du joueur (ATTENTION RENVOI UNE LISTE !!)
	{
		ArrayList <Batiment> batiments = new ArrayList <Batiment>();
		this.att=0;
		
		for (Batiment batiment : this.constructions)
		{
			if (batiment.getDef()>0) {
				batiments.add(batiment);
				this.att += batiment.getAtt();
			}
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
			Context.getInstance().getDaoB().update(batiment); 
		}
		ennemi.setConstructions(ennemi.actuDef());
	}
	
	public void attaque(Session ennemi, Batiment batiment, double ptsAttaque) // Attaque d'un batiment d'un autre joueur
	{
		batiment.setDef(batiment.getDef()-ptsAttaque);
		System.out.println("Il reste " + batiment.getDef() + " de defence a " + batiment.toStringName());
		ennemi.setConstructions(ennemi.actuDef());	
				
		Context.getInstance().getDaoB().update(batiment); 	
	}
	
	public void attaque (Session ennemi, Attaque batimentDAttaque, Batiment batimentDEfense) //Attaque d'un batiment d'un autre joueur par un batiment d'attaque
	{
		if (batimentDAttaque.isUsed()==false)
		{
		for (Batiment b : ennemi.getConstructions())
		{
			if (b.getClass()==batimentDEfense.getClass()) {b.setDef(b.getDef()-batimentDAttaque.getAtt());}
			batimentDAttaque.setUsed(true);
		}
		}else {System.out.println("Ce batiment d'attaque est indisponible");}
				
	}
	
	public void transformation(String batiment,int nbRessource,String nomRessource)
	{

		if (batiment.equalsIgnoreCase("Four"))
		{
			for (Batiment b: this.constructions)
			{
				if (b instanceof Four)
				{
					((Four) b).transformation(nomRessource, nbRessource, this.ressources);
				}
			}
		}
		else if(batiment.equalsIgnoreCase("Fonderie"))
		{
			for (Batiment b: this.constructions)
			{
				if (b instanceof Fonderie)
				{
					((Fonderie) b).transformation(nomRessource, nbRessource, this.ressources);
				}
			}
		}
			
	}
	
	public void constructBat(Batiment batiment)  // Construction d'un batiment (ajout a la liste/actuAtt/ActuDef/ActuRessources)
	{
		this.getConstructions().add(batiment);
		Context.getInstance().getDaoS().update(this);
		
		this.setConstructions(this.actuDef());
		this.setConstructions(this.actuAtt());

		for (Ressource r : this.getRessources())	//modification du stock de ressources du joueur en fonction du cout (cf. methode actuAchat de la classe ressources)
		{
			r.actuAchat(batiment.getCost());
		}
	}
	
	
	public void joueTour(){
	     
		// TODO: choix de jeu menuJoueur (1- construire 2-attaquer 3-fin de tour)
		this.menuJoueur();
		
	}
		
	public void piocherRessources()
	{
		int bois = 0;
		int pierre = 0;
		int minerais = 0;
		
		for(int i=0; i<10; i++)
		{
			int d = (int)Math.round(Math.random()*2);
			switch(d)
			{
				case 0 : bois++; break;
				case 1 : pierre++;  break;
				case 2 : minerais++;  break;
			}
		}
		
		System.out.println("\nVous avez obtenu " + bois + " bois, " + pierre + " pierre(s), " + minerais + " minerais !");	
		
		for (Batiment b : this.constructions)
		{
			if(b instanceof Carriere)
			{
				pierre+=3;
				System.out.println("\nVotre carriere vous a rapporte 3 pierres supplementaires ("+pierre+" pierre(s) au total !)\n");	
			}
			else if (b instanceof Mine)
			{
				minerais+=3;
				System.out.println("\nVotre mine vous a rapporte 3 minerais supplementaires ("+minerais+" minerais au total !)\n");	
			}
			else if (b instanceof Scierie)
			{
				bois+=3;
				System.out.println("\nVotre scierie vous a rapporte3 bois supplementaires ("+bois+" bois au total !)\n");	
			}
		}
		
		for (Ressource r : this.ressources)	//modification du stock de ressources du joueur en fonction du cout (cf. methode actuAchat de la classe ressources)
		{
			
			switch(r.getClass().getName()) {
			  case "bois":
				  r.actuGain(bois);
				  break;
			  case "pierre":
				  r.actuGain(bois);
			      break;
			  case "minerais":
				  r.actuGain(bois);    
				  break;
			  default:
			  
			}	
		}

//		b.actuGain(bois);
//		p.actuGain(pierre);
//		m.actuGain(minerais);
	}
	
	
	public void menuJoueur(){
		
		if(this.def>0)
		{
			System.out.printf("%s\n","MENU JOUEUR" + " - " + this.compte.getPrenom() + " " + this.compte.getNom() + " " + this.compte.getSurnom());
			System.out.printf("%s\n","1- Construire");
			System.out.printf("%s\n","2- Ameliorer");
			System.out.printf("%s\n","3- Attaquer");
			System.out.printf("%s\n","4- Tranformer ressources");
			System.out.printf("%s\n","5- Fin de tour");
			
			int choix =10;
			this.afficheListeRessources();
			try {
				choix = Context.getInstance().saisieInt("Choisir un menu");
			}
			catch (Exception e) {
				System.out.println("Rentrez un chiffre !");
			}
			
			switch(choix) 
			{
				case 1 : menuConstruction(); break;
				case 2 : menuAmeliorer(); break; // TODO: a finir en int�grant la m�thode pour upgrader le batiment
				case 3 : menuAttaquer();break; // TODO: Menu attaque
				case 4 : menuTransformation();break; // TODO: Menu Transformatino
				case 5 : menuFinDeTour();break; // TODO: fin de tour
				default : System.out.println("Mauvaise valeur");
			}
		}
		else
		{
			System.out.printf("%s\n","JOUEUR ELIMINE" + " - " + this.compte.getPrenom() + " " + this.compte.getNom() + " " + this.compte.getSurnom());
			menuFinDeTour();
		}
		
	}
	
	public void afficheListeRessources() {
		System.out.println("Ressources disponibles:");
		for (Ressource r: this.ressources) {
			System.out.print(r.toStringName() + ": "+r.getStock() + "  ");
		}
		
		System.out.println("\n-------------------------------- \n");
	}
	
	
	
	
	
	
		
}
