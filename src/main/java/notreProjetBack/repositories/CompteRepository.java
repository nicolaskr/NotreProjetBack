package notreProjetBack.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import notreProjetBack.model.Compte;

public interface CompteRepository extends JpaRepository <Compte, Integer> {

	Optional<Compte> findBySurnom(String surnom);
<<<<<<< refs/remotes/origin/master
	
	Optional<Compte> findByLoginAndPassword(String login, String password);
=======
    Optional<Compte> findByLoginAndPassword(String login, String password);
    
>>>>>>> classe joueur + testCompte
}
