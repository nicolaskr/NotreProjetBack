package notreProjetBack.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import notreProjetBack.model.Batiment;
import notreProjetBack.model.Production;

public interface ProductionRepository extends JpaRepository <Production, Integer> {

	@Query("from Production")
	List<Production> findProductionBatiment();

}
