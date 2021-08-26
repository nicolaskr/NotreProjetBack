package notreProjetBack.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import notreProjetBack.model.Batiment;
import notreProjetBack.model.Ressource;
import notreProjetBack.model.Session;
import notreProjetBack.model.SessionRessource;

public interface SessionRessourceRepository  extends JpaRepository <SessionRessource, Integer>{

	List<Ressource> findBySession(Session session);
	
	List<Ressource> findBySessionAndRessource(Session session, Ressource ressource);
}
