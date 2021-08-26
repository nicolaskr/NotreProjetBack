package notreProjetBack.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import notreProjetBack.model.Batiment;
import notreProjetBack.model.Session;

public interface SessionBatimentRepository extends JpaRepository <Batiment, Integer> {

	List<Batiment> findBySession(Session session);
	
	List<Batiment> findBySessionAndBatimentList(Session session, Batiment batimentList);
	
	@Query("from SessionBatiment sb where sb.session =:session and sb.batiment.type_batiment=:type")
	List<Batiment> findBySessionAndTypeBatiment(@Param("session") Session session, @Param("type") String type);
}
