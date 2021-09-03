package notreProjetBack;

import notreProjetBack.model.Admin;
import notreProjetBack.model.Attaque;
import notreProjetBack.model.Compte;
import notreProjetBack.model.Defense;
import notreProjetBack.model.Joueur;
import notreProjetBack.model.Partie;
import notreProjetBack.model.Production;
import notreProjetBack.model.Session;
import notreProjetBack.model.SessionBatiment;
import notreProjetBack.model.SessionKey;
import notreProjetBack.repositories.BatimentRepository;
import notreProjetBack.repositories.CompteRepository;
import notreProjetBack.repositories.PartieRepository;
import notreProjetBack.repositories.SessionBatimentRepository;
import notreProjetBack.repositories.SessionRepository;
import notreProjetBack.repositories.SessionRessourceRepository;

import org.springframework.beans.factory.annotation.Autowired;

import model.Bastide;



public class AppSpringNico {

	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	SessionRessourceRepository sessionRessourceRepo;
	
	@Autowired
	PartieRepository partieRepository;
	
	@Autowired
	SessionRepository sessionRepository;
	
	@Autowired
	SessionBatimentRepository sessionBatimentRepository;
	
	@Autowired
	BatimentRepository batimentRepository;

	public  void run(String[] args) {

		Admin admin1 = new Admin("login", "password", "prenom",  "nom", "admin1");
		Joueur joueur1 = new Joueur("login", "password", "prenom", "nom", "joueur1");
		Joueur joueur2 = new Joueur("login", "password", "prenom", "nom", "joueur2");
		Joueur joueur3 = new Joueur("login", "password", "prenom", "nom", "joueur3");
		Joueur joueur4 = new Joueur("login", "password", "prenom", "nom", "joueur4");

		compteRepository.save(admin1);
		compteRepository.save(joueur1);
		compteRepository.save(joueur2);
		compteRepository.save(joueur3);
		compteRepository.save(joueur4);
		
		Partie partie = new Partie();
		partieRepository.save(partie);
		
		Session session1 = new Session(new SessionKey(partie, joueur1));
		Session session2 = new Session(new SessionKey(partie, joueur2));
		Session session3 = new Session(new SessionKey(partie, joueur3));
		Session session4 = new Session(new SessionKey(partie, joueur4));
		
		sessionRepository.save(session1);
		sessionRepository.save(session2);
		sessionRepository.save(session3);
		sessionRepository.save(session4);
		
		Defense bastide = new Defense("Bastide", 1, 5.0, 0, true);
		Defense mur = new Defense("Mur", 1, 10.0, 0, true);
		Defense toit = new Defense("Toit", 1, 30.0, 0, true);
		
		Attaque fusil = new Attaque("Fusil", 1, 5.0, 50.0, true);
		Attaque machette = new Attaque("Machette", 1, 10.0, 100.0, true);
		Attaque lanceRoquette = new Attaque("lanceRoquette", 1, 30.0, 150.0, true);
		
		Production mine = new Production("mine", 1, 5.0, 0, true);
		Production carriere = new Production("carriere", 1, 10.0, 0, true);
		Production usine = new Production("usine", 1, 30.0, 0, true);
				
		batimentRepository.save(bastide);
		batimentRepository.save(mur);
		batimentRepository.save(toit);
		batimentRepository.save(fusil);
		batimentRepository.save(machette);
		batimentRepository.save(lanceRoquette);
		batimentRepository.save(mine);
		batimentRepository.save(carriere);
		batimentRepository.save(usine);
		
		
		SessionBatiment sessionBatiment1 = new SessionBatiment(session1, bastide, bastide.getDef(), bastide.getAtt());
		sessionBatimentRepository.save(sessionBatiment1);
		
		SessionBatiment sessionBatiment2 = new SessionBatiment(session2, bastide, bastide.getDef(), bastide.getAtt());
		sessionBatimentRepository.save(sessionBatiment2);
		
		SessionBatiment sessionBatiment3 = new SessionBatiment(session1, lanceRoquette, lanceRoquette.getDef(), lanceRoquette.getAtt());
		sessionBatimentRepository.save(sessionBatiment3);
		
		SessionBatiment sessionBatiment4 = new SessionBatiment(session2, machette, machette.getDef(), machette.getAtt());
		sessionBatimentRepository.save(sessionBatiment4);
		
		SessionBatiment sessionBatiment5 = new SessionBatiment(session3, usine, usine.getDef(), usine.getAtt());
		sessionBatimentRepository.save(sessionBatiment5);
		
		SessionBatiment sessionBatiment6 = new SessionBatiment(session4, carriere, carriere.getDef(), carriere.getAtt());
		sessionBatimentRepository.save(sessionBatiment6);
		
	}
}
