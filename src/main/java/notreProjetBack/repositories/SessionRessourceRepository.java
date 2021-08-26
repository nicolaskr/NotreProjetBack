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

	/*@Query("from SessionRessource sr join Ressource r on sr.ressource_id=r.id where sr.session =:session")
	List<Ressource> findBySession(@Param("session") Session session);
	
	@Query("from SessionRessource sr where sr.session =:session and sr.ressource =:ressource ")
	Optional<Integer> findQuantiteBySessionAndRessource(@Param("session") Session session, @Param("ressource") Ressource ressource);*/

}
