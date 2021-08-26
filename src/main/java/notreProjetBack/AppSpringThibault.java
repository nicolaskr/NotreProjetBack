package notreProjetBack;

import org.springframework.beans.factory.annotation.Autowired;

import notreProjetBack.model.Joueur;
import notreProjetBack.repositories.CompteRepository;

public class AppSpringThibault {
	
	@Autowired
	private CompteRepository cRep;
	
	public void run(String[] args) {
		Joueur j1 = new Joueur("t","d","t","d","td");
		cRep.save(j1);
	}
}
