package notreProjetBack.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import notreProjetBack.model.Attaque;
import notreProjetBack.model.Batiment;
import notreProjetBack.model.Defense;

public interface AttaqueRepository extends JpaRepository <Attaque, Integer> {

	@Query("from Attaque")
	List<Attaque> findAttaqueBatiment();
}
