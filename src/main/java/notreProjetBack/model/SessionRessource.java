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

    @OneToOne
    private Session session;

    @OneToOne
    private Ressource ressource;
    
    private int quantite;

    public SessionRessource() {
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

    public List<Ressource> getRessourceList() {
        return ressourceList;
    }

    public void setRessourceList(List<Ressource> ressourceList) {
        this.ressourceList = ressourceList;
    }
}
