package notreProjetBack.model;

import javax.persistence.Entity;

@Entity
public class Defense extends Batiment {

	public Defense() {
		super();
		this.setAmeliorable(true);
	}
		
	public Defense(int id, String nom, int level, double def,double att,boolean ameliorable)
	{
		super(id,nom,level,def,att,ameliorable);
	}
	
	public Defense(String nom, int level, double def,double att,boolean ameliorable)
	{
		super(nom,level,def,att,ameliorable);
	}
	
	
}
