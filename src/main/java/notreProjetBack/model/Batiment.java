package notreProjetBack.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import notreProjetBack.repositories.CoutBatimentRepository;
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
	protected String type_batiment;
	protected boolean ameliorable;
	


	@ManyToOne
	protected CoutBatiment cost;
	
	@Autowired
	protected transient CoutBatimentRepository cBatRepo;
	
	@Autowired
	protected transient RessourceRepository ressourceRepo;
<<<<<<< refs/remotes/origin/master

=======
	
>>>>>>> debugage
	
	
	

	public String getType_batiment() {
		return type_batiment;
	}

	public void setType_batiment(String type_batiment) {
		this.type_batiment = type_batiment;
	}

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
	
	public boolean isAmeliorable() {
		return ameliorable;
	}

	public void setAmeliorable(boolean ameliorable) {
		this.ameliorable = ameliorable;
	}

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
		

		for(Ressource ressource :coutBatRepo.findCoutByBatiment((this))){


						
			Integer costRessource = coutBatRepo.findCoutByBatimentByRessource(this, ressource).get();
			
			if(costRessource>0){
				
				String nameRessource = ressource.getNom();
				outputText += String.format(nameRessource +": "+ costRessource+"  ");
				
			}
		}
		return outputText;
	}
	

}
