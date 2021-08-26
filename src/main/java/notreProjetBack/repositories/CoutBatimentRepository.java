package notreProjetBack.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import notreProjetBack.model.Batiment;
import notreProjetBack.model.Ressource;
import notreProjetBack.model.Session;

public interface CoutBatimentRepository extends JpaRepository <Session, Integer>{

	List<Ressource> findCoutByBatiment(Batiment batiment);
	

	@Query("select cb.cout from CoutBatiment cb where cb.batiment =:batiment and cb.ressource =:ressource")
	Optional<Integer> findCoutByBatimentByRessource(@Param("batiment") Batiment batiment, @Param("ressource") Ressource ressource);

}
