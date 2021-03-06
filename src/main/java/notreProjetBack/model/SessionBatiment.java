package notreProjetBack.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "session_batiment")
public class SessionBatiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Session session;

    @ManyToOne
    @JoinColumn(name = "batiment_id", foreignKey = @ForeignKey(name = "session_batiment_id_pk"))
    private Batiment batiment;
    
    private double pointsDeVie;
    
    private double pointsDAttaque;
    
    public SessionBatiment() {
    }

    public SessionBatiment(Session session, Batiment batiment, double pointsDeVie, double pointsDAttaque) {
		this.session = session;
		this.batiment = batiment;
		this.pointsDeVie = pointsDeVie;
		this.pointsDAttaque = pointsDAttaque;
	}
    
    public SessionBatiment(Session session, Batiment batiment, double pointsDeVie) {
		this.session = session;
		this.batiment = batiment;
		this.pointsDeVie = pointsDeVie;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionBatiment that = (SessionBatiment) o;
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

	public Batiment getBatiment() {
		return batiment;
	}

	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}

	public double getPointsDeVie() {
		return pointsDeVie;
	}

	public void setPointsDeVie(double pointsDeVie) {
		this.pointsDeVie = pointsDeVie;
	}

	public double getPointsDAttaque() {
		return pointsDAttaque;
	}

	public void setPointsDAttaque(double pointsDAttaque) {
		this.pointsDAttaque = pointsDAttaque;
	}
	
}
