package notreProjetBack.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import notreProjetBack.model.Batiment;
import notreProjetBack.model.Session;
import notreProjetBack.model.SessionBatiment;

public interface SessionBatimentRepository extends JpaRepository <SessionBatiment, Integer> {


	List<SessionBatiment> findBySession(Session session);
		

}
