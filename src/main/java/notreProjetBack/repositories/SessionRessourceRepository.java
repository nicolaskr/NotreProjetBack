package notreProjetBack.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import notreProjetBack.model.Ressource;
import notreProjetBack.model.Session;
import notreProjetBack.model.SessionRessource;

public interface SessionRessourceRepository  extends JpaRepository <SessionRessource, Integer>{

	List<SessionRessource> findBySession(Session session);
	
	Optional<SessionRessource> findBySessionAndRessource(Session session, Ressource ressource);
}
