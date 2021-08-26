package notreProjetBack.model;

import javax.persistence.Entity;

@Entity
public class Transformation  extends Batiment{

	public Transformation() {
		super();
		this.setAmeliorable(false);
	}
	
	public Transformation(int id, String nom, int level, double def,double att,boolean ameliorable)
	{
		super(id,nom,level,def,att,ameliorable);
	}
	
	public Transformation(String nom, int level, double def,double att,boolean ameliorable)
	{
		super(nom,level,def,att,ameliorable);
	}
}
