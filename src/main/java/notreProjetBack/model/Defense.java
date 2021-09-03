package notreProjetBack.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Defense extends Batiment {

	public Defense() {
	}

	public Defense(String nom, double pointsDefense, int level, boolean ameliorable) {
		super(nom, pointsDefense, level, ameliorable);
	}
	
}
