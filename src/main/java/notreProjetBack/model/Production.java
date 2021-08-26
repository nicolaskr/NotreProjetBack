package notreProjetBack.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Production extends Batiment{

	public Production() {
		super();
		this.setAmeliorable(true);
	}
	
	public Production(Integer id, String nom, int level, double def,double att,boolean ameliorable)
	{
		super(id,nom,level,def,att,ameliorable);
	}
	
	public Production(String nom, int level, double def,double att,boolean ameliorable)
	{
		super(nom,level,def,att,ameliorable);
	}
	
	public Production(String nom, double def, double att, int level, boolean ameliorable, List<CoutBatiment> cost) {
		super(nom, def, att, level, ameliorable, cost);
	}
}
