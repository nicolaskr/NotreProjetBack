package notreProjetBack.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class CoutBatiment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	@ManyToOne
	Batiment batiment;
	
	@ManyToOne
	Ressource ressource;
	int cout;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoutBatiment other = (CoutBatiment) obj;
		return Objects.equals(id, other.id);
	}
	public CoutBatiment() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public CoutBatiment(Integer id, Batiment batiment, Ressource ressource, int cout) {
		super();
		this.id = id;
		this.batiment = batiment;
		this.ressource = ressource;
		this.cout = cout;
	}
	public CoutBatiment(Batiment batiment, Ressource ressource, int cout) {
		super();
		this.batiment = batiment;
		this.ressource = ressource;
		this.cout = cout;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Batiment getBatiment() {
		return batiment;
	}
	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}

	public Ressource getRessource() {
		return ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}
	public int getCout() {
		return cout;
	}
	public void setCout(int cout) {
		this.cout = cout;
	}
	
}
