package notreProjetBack;

import notreProjetBack.model.Admin;
import notreProjetBack.model.Attaque;
import notreProjetBack.model.Compte;
import notreProjetBack.model.CoutBatiment;
import notreProjetBack.model.CoutBatimentKey;
import notreProjetBack.model.Defense;
import notreProjetBack.model.Joueur;
import notreProjetBack.model.Partie;
import notreProjetBack.model.Production;
import notreProjetBack.model.Ressource;
import notreProjetBack.model.Session;
import notreProjetBack.model.SessionBatiment;
import notreProjetBack.model.SessionKey;
import notreProjetBack.repositories.BatimentRepository;
import notreProjetBack.repositories.CompteRepository;
import notreProjetBack.repositories.CoutBatimentRepository;
import notreProjetBack.repositories.PartieRepository;
import notreProjetBack.repositories.RessourceRepository;
import notreProjetBack.repositories.SessionBatimentRepository;
import notreProjetBack.repositories.SessionRepository;
import notreProjetBack.repositories.SessionRessourceRepository;

import org.springframework.beans.factory.annotation.Autowired;




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
	
	@Autowired
	CoutBatimentRepository coutBatimentRepository;
	
	@Autowired
	RessourceRepository ressourceRepository;

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
		
		
		Ressource bois = new Ressource("bois");
		Ressource pierre = new Ressource("pierre");
		Ressource minerais = new Ressource("minerais");
		
		ressourceRepository.save(bois);
		ressourceRepository.save(pierre);
		ressourceRepository.save(minerais);
		
		
		Defense bastide = new Defense("Bastide", 5.0, 1, true);
		Defense mur = new Defense("Mur", 10.0, 1, true);
		Defense toit = new Defense("Toit", 30.0, 1, true);
		
		Attaque fusil = new Attaque("Fusil", 5.0, 50.0, 1, true);
		Attaque machette = new Attaque("Machette", 10.0, 100.0, 1, true);
		Attaque lanceRoquette = new Attaque("lanceRoquette", 30.0, 150.0, 1, true);
		
		Production mine = new Production("mine", 5.0, 1, true, 5);
		Production carriere = new Production("carriere", 10.0, 1, true, 5);
		Production usine = new Production("usine", 30.0, 1, true, 5);
				
		batimentRepository.save(bastide);
		batimentRepository.save(mur);
		batimentRepository.save(toit);
		batimentRepository.save(fusil);
		batimentRepository.save(machette);
		batimentRepository.save(lanceRoquette);
		batimentRepository.save(mine);
		batimentRepository.save(carriere);
		batimentRepository.save(usine);
		
		
		
		coutBatimentRepository.save(new CoutBatiment(new CoutBatimentKey(mur, bois), 5));
		coutBatimentRepository.save(new CoutBatiment(new CoutBatimentKey(mur, minerais), 2));
		coutBatimentRepository.save(new CoutBatiment(new CoutBatimentKey(mur, pierre), 7));
		
		coutBatimentRepository.save(new CoutBatiment(new CoutBatimentKey(fusil, minerais), 10));
		
		coutBatimentRepository.save(new CoutBatiment(new CoutBatimentKey(carriere, bois), 2));
		

				
		
		SessionBatiment sessionBatiment1 = new SessionBatiment(session1, bastide, bastide.getPointsDefense());
		sessionBatimentRepository.save(sessionBatiment1);
		
		SessionBatiment sessionBatiment2 = new SessionBatiment(session2, bastide, bastide.getPointsDefense());
		sessionBatimentRepository.save(sessionBatiment2);
		
		SessionBatiment sessionBatiment3 = new SessionBatiment(session1, lanceRoquette, lanceRoquette.getPointsDefense(), lanceRoquette.getPointsDAttaque());
		sessionBatimentRepository.save(sessionBatiment3);
		
		SessionBatiment sessionBatiment4 = new SessionBatiment(session2, machette, machette.getPointsDefense(), machette.getPointsDAttaque());
		sessionBatimentRepository.save(sessionBatiment4);
		
		SessionBatiment sessionBatiment5 = new SessionBatiment(session3, usine, usine.getPointsDefense());
		sessionBatimentRepository.save(sessionBatiment5);
		
		SessionBatiment sessionBatiment6 = new SessionBatiment(session4, carriere, carriere.getPointsDefense());
		sessionBatimentRepository.save(sessionBatiment6);
		
	}
}
