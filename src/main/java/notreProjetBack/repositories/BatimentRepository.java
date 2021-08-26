package notreProjetBack.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import notreProjetBack.model.Batiment;


public interface BatimentRepository extends JpaRepository <Batiment, Integer> {

	List<Batiment> findByType(String type);
	
	List<Batiment> findByAmeliorable(Boolean ameliorable);
}
