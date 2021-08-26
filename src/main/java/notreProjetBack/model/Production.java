package notreProjetBack.model;

import javax.persistence.Entity;

@Entity
public class Production extends Batiment{

	public Production() {
		super();
		this.setAmeliorable(true);
	}
	
	public Production(int id, String nom, int level, double def,double att,boolean ameliorable)
	{
		super(id,nom,level,def,att,ameliorable);
	}
	
	public Production(String nom, int level, double def,double att,boolean ameliorable)
	{
		super(nom,level,def,att,ameliorable);
	}
}
