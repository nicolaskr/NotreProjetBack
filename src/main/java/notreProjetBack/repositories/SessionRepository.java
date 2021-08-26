package notreProjetBack.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import notreProjetBack.model.Partie;
import notreProjetBack.model.Session;
import notreProjetBack.model.Compte;

public interface SessionRepository extends JpaRepository <Session, Integer>{

	/*@Query("select distinct s from Session s left join fetch s.sessionBatiment.batiment left join fetch s.sessionRessource.ressource where s.id =:id")
	Optional<Session> findByIdWithRessourcesAndBatiments(@Param("id") Integer id);*/
	
	List<Session> findByPartie(Partie partie);
	
	List<Session> findByCompte(Compte compte);
	
}
