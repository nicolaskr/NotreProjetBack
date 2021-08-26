package notreProjetBack.model;

import javax.persistence.Entity;


@Entity
public class Attaque extends Batiment{
	
	public Attaque() {
		super();
		this.setAmeliorable(true);
	}
	
	public Attaque(int id, String nom, int level, double def,double att,boolean ameliorable)
	{
		super(id,nom,level,def,att,ameliorable);
	}
	
	public Attaque(String nom, int level, double def,double att,boolean ameliorable)
	{
		super(nom,level,def,att,ameliorable);
	}
	
}
