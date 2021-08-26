package notreProjetBack.model;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"partie_id", "compte_id"})}) 
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "a_joue_le_tours")
    private boolean aJoueLeTours;

    @Column(name = "tour_en_tours")
    private boolean tourEnCours;

    @Column(name = "a_commence")
    private boolean aCommence;

    private int def;

    private int att;

    @ManyToOne
    private Partie partie;

    @ManyToOne
    private Compte compte;

    @OneToMany (mappedBy = "session")
    private List<SessionBatiment> sessionBatiment;

    @OneToMany (mappedBy = "session")
    private List<SessionRessource> sessionRessource;

    public Session() {
    }

    public Session(Partie partie, Compte compte) {
        this.partie = partie;
        this.compte = compte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return id.equals(session.id);
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

    public boolean isaJoueLeTours() {
        return aJoueLeTours;
    }

    public void setaJoueLeTours(boolean aJoueLeTours) {
        this.aJoueLeTours = aJoueLeTours;
    }

    public boolean isTourEnCours() {
        return tourEnCours;
    }

    public void setTourEnCours(boolean tourEnCours) {
        this.tourEnCours = tourEnCours;
    }

    public boolean isaCommence() {
        return aCommence;
    }

    public void setaCommence(boolean aCommence) {
        this.aCommence = aCommence;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

	public List<SessionBatiment> getSessionBatiment() {
		return sessionBatiment;
	}

	public void setSessionBatiment(List<SessionBatiment> sessionBatiment) {
		this.sessionBatiment = sessionBatiment;
	}

	public List<SessionRessource> getSessionRessource() {
		return sessionRessource;
	}

	public void setSessionRessource(List<SessionRessource> sessionRessource) {
		this.sessionRessource = sessionRessource;
	}


}
