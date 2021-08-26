package notreProjetBack.model;

import java.util.List;

import javax.persistence.Entity;


@Entity
public class Attaque extends Batiment{
	
	public Attaque() {
		super();
		this.setAmeliorable(true);
	}
	
	public Attaque(Integer id, String nom, int level, double def,double att,boolean ameliorable)
	{
		super(id,nom,level,def,att,ameliorable);
	}
	
	public Attaque(String nom, int level, double def,double att,boolean ameliorable)
	{
		super(nom,level,def,att,ameliorable);
	}
	
	public Attaque(String nom, double def, double att, int level, boolean ameliorable, List<CoutBatiment> cost) {
		super(nom, def, att, level, ameliorable, cost);
	}
	
}
