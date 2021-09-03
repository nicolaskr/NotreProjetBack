package notreProjetBack.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import notreProjetBack.model.Ressource;
import notreProjetBack.model.Session;
import notreProjetBack.model.SessionRessource;
import notreProjetBack.model.SessionRessourceKey;

public interface SessionRessourceRepository  extends JpaRepository <SessionRessource, SessionRessourceKey>{
	
	@Query("select distinct s from SessionRessource s where s.id.session=:session")	
	List<SessionRessource> findBySession(@Param(value = "session") Session session);
	
//	Optional<SessionRessource> findBySessionAndRessource(Session session, Ressource ressource);
//  n'est plus nécessaire car findById fait la même chose 
//	exemple : 
//	SessionRessourceKey sessionRessourceKey = new SessionRessourceKey(session, ressource);
//	findById(sessionRessourceKey);
}
