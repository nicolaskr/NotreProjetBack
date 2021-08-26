package notreProjetBack;

import org.springframework.beans.factory.annotation.Autowired;

import notreProjetBack.model.Attaque;
import notreProjetBack.repositories.BatimentRepository;
import notreProjetBack.repositories.CompteRepository;

public class AppSpringThibault {
	
	@Autowired
	private CompteRepository cRep;
	
	@Autowired
	private BatimentRepository bRep;
	
	public void run(String[] args) {
		/*Joueur j1 = new Joueur("t","d","t","d","td");
		Admin a1 = new Admin("a","a","a","a","admin");
		cRep.save(j1);
		cRep.save(a1);*/
		
	}
}
