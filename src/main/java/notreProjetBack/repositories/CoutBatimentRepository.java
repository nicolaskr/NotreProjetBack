package notreProjetBack.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import notreProjetBack.model.Batiment;
import notreProjetBack.model.CoutBatiment;
import notreProjetBack.model.Ressource;
import notreProjetBack.model.Session;
import notreProjetBack.model.SessionBatiment;

public interface CoutBatimentRepository extends JpaRepository <CoutBatiment, Integer>{

	List<CoutBatiment> findByBatiment(Batiment batiment);
	
	Optional<CoutBatiment> findByBatimentAndRessource(Batiment batiment, Ressource ressource);

}
