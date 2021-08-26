package notreProjetBack.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import notreProjetBack.model.Batiment;
import notreProjetBack.model.Session;
import notreProjetBack.model.SessionBatiment;

public interface SessionBatimentRepository extends JpaRepository <SessionBatiment, Integer> {

	List<Batiment> findBySession(Session session);
	
	List<Batiment> findBySessionAndBatiment(Session session, Batiment batiment);
	
	/*@Query("from SessionBatiment sb where sb.session =:session and TYPE(sb.batiment)=:type")
	List<Batiment> findBySessionAndTypeBatiment(@Param("session") Session session, @Param("type") String type);*/
	
	/*@Query("from SessionBatiment sb left join fetch Batiment b on sb.batiment_id=b.id left join fetch Session s on sb.session_id=s.id where sb.session =:session and b.type_batiment=:type")
	List<Batiment> findBySessionAndTypeBatiment(@Param("session") Session session, @Param("type") String type);*/
	
}
