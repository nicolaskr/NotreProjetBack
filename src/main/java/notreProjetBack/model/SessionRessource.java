package notreProjetBack.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class SessionRessource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Session session;

    @ManyToOne
    private Ressource ressource;
    
    private int quantite;

    public SessionRessource() {
    }
    
    public SessionRessource(Session session, Ressource ressource, int quantite) {
    	this.session=session;
    	this.ressource=ressource;
    	this.quantite=quantite;
    }
    
    public SessionRessource(Integer id,Session session, Ressource ressource, int quantite) {
    	this.session=session;
    	this.ressource=ressource;
    	this.quantite=quantite;
    	this.id=id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionRessource that = (SessionRessource) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }


	public Ressource getRessource() {
		return ressource;
	}


	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}


	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


}
