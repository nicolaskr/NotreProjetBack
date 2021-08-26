package notreProjetBack.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import notreProjetBack.model.Ressource;

public interface RessourceRepository  extends JpaRepository <Ressource, Integer>{

	Optional<Ressource> findByNom(String nom);
}
