package notreProjetBack.model;

import javax.persistence.Entity;

@Entity
public class Defense extends Batiment {

	public Defense() {
		super();
		this.setAmeliorable(true);
	}
	
	
}
