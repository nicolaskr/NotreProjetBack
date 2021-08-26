package notreProjetBack.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import model.Ressource;
import notreProjetBack.repositories.BatimentRepository;
import notreProjetBack.repositories.RessourceRepository;



@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Batiment")
public class Batiment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;
	protected String nom;
	protected double def;
	protected double att=0;
	protected int level=1;
	
	@ManyToOne
	protected CoutBatiment cost;
	
	protected BatimentRepository batRepo = new BatimentRepository();
	protected RessourceRepository ressourceRepo = new RessourceRepository();
	
	
	
	

	public Batiment() {
		super();
	}
	
	public Batiment(String nom, int level, double def)
	{
		this.nom = nom;
		this.level = level;
		this.def = def;
	}
	
	public Batiment(int id, String nom, int level, double def)
	{
		this.id = id;
		this.nom = nom;
		this.level = level;
		this.def = def;
	}
	
	public Batiment(int id, String nom, int level, double def,double att)
	{
		this.id = id;
		this.nom = nom;
		this.level = level;
		this.def = def;
		this.att = att;
	}
	//-----------------------------------------------------------------------------------------------
	//Getters and Setters
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getDef() {
		return def;
	}

	public void setDef(double def) {
		this.def = def;
	}

	public double getAtt() {
		return att;
	}

	public void setAtt(double att) {
		this.att = att;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public CoutBatiment getCost() {
		return cost;
	}

	public void setCost(CoutBatiment cost) {
		this.cost = cost;
	}
	
	//------------------------------------------------------------------------------------------
	//Methods
	public String toStringWithCost() {		
		
		String outputText = String.format("Nom: "+ this.getNom() + "  Niveau: " + this.level+ "  Defense: " +this.def + "  Attaque: " +this.att + "\n");
		
		for(Ressource ressource :batRepo.findCoutByNomBatiment(this.nom)){
						
			int costRessource = ressource.getStock();
			
			if(costRessource>0){
				
				String nameRessource = ressource.toStringName();
				outputText += String.format(nameRessource +": "+ costRessource+"  ");
				
			}
		}
	}
	

}
