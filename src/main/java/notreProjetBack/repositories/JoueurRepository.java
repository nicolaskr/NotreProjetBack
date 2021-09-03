package notreProjetBack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import notreProjetBack.model.Joueur;

public interface JoueurRepository extends JpaRepository <Joueur, Integer> {

}
