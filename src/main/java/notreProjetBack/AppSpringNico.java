package notreProjetBack;

import notreProjetBack.model.Admin;
import notreProjetBack.model.Compte;
import notreProjetBack.model.Joueur;
import notreProjetBack.repositories.CompteRepository;
import notreProjetBack.repositories.SessionRessourceRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class AppSpringNico {

//	@Autowired
//	CompteRepository compteRepository;
	
	@Autowired
	SessionRessourceRepository sessionRessourceRepo;

	public  void run(String[] args) {

//		Admin admin1 = new Admin("login", "password", "prenom",  "nom", "admin1");
//		Joueur joueur1 = new Joueur("login", "password", "prenom", "nom", "joueur1");
//
//		compteRepository.save(admin1);
//		compteRepository.save(joueur1);
		
		

	}
}
