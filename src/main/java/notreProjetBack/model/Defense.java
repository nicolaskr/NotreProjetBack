package notreProjetBack.model;

import javax.persistence.Entity;

@Entity
public class Defense extends Batiment {
	protected String type_batiment = this.getClass().getName();

	public Defense() {
		super();
		this.setAmeliorable(true);
	}
	
	
}
