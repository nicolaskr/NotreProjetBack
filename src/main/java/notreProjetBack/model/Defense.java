package notreProjetBack.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Defense extends Batiment {

	protected String type="Defense";
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Defense() {
		super();
		this.setAmeliorable(true);
	}
		
	public Defense(Integer id, String nom, int level, double def,double att,boolean ameliorable)
	{
		super(id,nom,level,def,att,ameliorable);
	}
	
	public Defense(String nom, int level, double def,double att,boolean ameliorable)
	{
		super(nom,level,def,att,ameliorable);
	}
	
	public Defense(String nom, int level, double def) {
		super(nom, level, def);
	}
	




	public Defense(String nom, double def, double att, int level, boolean ameliorable, List<CoutBatiment> cost) {
		super(nom, def, att, level, ameliorable, cost);
	}

	@Override
	public String toString() {
		return "Defense" + nom;
	}
	
	
	
}
