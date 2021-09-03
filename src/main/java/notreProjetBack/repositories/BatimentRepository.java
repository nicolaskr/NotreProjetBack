package notreProjetBack.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import notreProjetBack.model.Batiment;
import notreProjetBack.model.Partie;
import notreProjetBack.model.Session;


public interface BatimentRepository extends JpaRepository <Batiment, Integer> {
		
	List<Batiment> findByAmeliorable(Boolean ameliorable);
	
	Optional<Batiment> findByNom(String nom);
	
	@Query("select b from Batiment b left join fetch b.coutBatiment where b.id=:id")
	Optional<Batiment> findByIdWithCoutBatiment(@Param(value = "id") Integer id);

}
