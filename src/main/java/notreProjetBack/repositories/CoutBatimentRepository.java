package notreProjetBack.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import notreProjetBack.model.Batiment;
import notreProjetBack.model.Ressource;
import notreProjetBack.model.Session;

public interface CoutBatimentRepository extends JpaRepository <Session, Integer>{

	List<Ressource> findCoutByBatiment(Batiment batiment);
}
