package notreProjetBack.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import notreProjetBack.model.Batiment;

public interface BatimentRepository extends JpaRepository <Batiment, Integer> {

	@Query("from batiment where type_batiment =:type")
	List<Batiment> findTypeBatiment(@Param("type") String type);
	
	List<Batiment> findByAmeliorable(Boolean ameliorable);
}
