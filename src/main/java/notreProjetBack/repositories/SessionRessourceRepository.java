package notreProjetBack.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import notreProjetBack.model.Batiment;
import notreProjetBack.model.Ressource;
import notreProjetBack.model.Session;

public interface SessionRessourceRepository  extends JpaRepository <Ressource, Integer>{

	List<Ressource> findBySession(Session session);
	
	List<Ressource> findBySessionAndRessourceList(Session session, Ressource ressourceList);
}
