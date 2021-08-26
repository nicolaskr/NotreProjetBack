package notreProjetBack.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import notreProjetBack.model.Batiment;
import notreProjetBack.model.Transformation;

public interface TransformationRepository extends JpaRepository <Transformation, Integer> {

	@Query("from Transformation")
	List<Transformation> findTransformationBatiment();
	
}
