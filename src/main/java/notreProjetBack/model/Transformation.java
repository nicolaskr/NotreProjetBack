package notreProjetBack.model;

import javax.persistence.Entity;

@Entity
public class Transformation  extends Batiment{
	protected String type_batiment = this.getClass().getName();

}
