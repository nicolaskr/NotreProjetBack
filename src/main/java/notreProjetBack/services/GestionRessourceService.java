package notreProjetBack.services;

import org.springframework.beans.factory.annotation.Autowired;

import model.Batiment;
import model.Bois;
import model.Bucheron;
import model.Carrier;
import model.Carriere;
import model.Mine;
import model.Minerais;
import model.Mineur;
import model.Pierre;
import model.Ressource;
import model.Scierie;
import notreProjetBack.model.Session;
import notreProjetBack.model.SessionBatiment;
import notreProjetBack.repositories.RessourceRepository;
import notreProjetBack.repositories.SessionBatimentRepository;
import notreProjetBack.repositories.SessionRessourceRepository;

public class GestionRessourceService {

	@Autowired
	SessionRessourceRepository sessionRessourceRepository;
	
	@Autowired
	RessourceRepository ressourceRepository;
	
	@Autowired
	SessionBatimentRepository sessionBatimentRepository;
	 
	/*
	    * Piocher ressources
	    * */
	public String piocherRessource(Session session) {
		
		int bois = 0;
		int pierre = 0;
		int minerais = 0;
		
		for(int i=0; i<10; i++)
		{
			int d = (int)Math.round(Math.random()*2);
			switch(d)
			{
				case 0 : bois++; break;
				case 1 : pierre++;  break;
				case 2 : minerais++;  break;
			}
		}
		
		sessionRessourceRepository.findBySessionAndRessource(session, ressourceRepository.findByNom("bois").get()).get().setQuantite(sessionRessourceRepository.findBySessionAndRessource(session, ressourceRepository.findByNom("bois").get()).get().getQuantite()+bois);
		sessionRessourceRepository.findBySessionAndRessource(session, ressourceRepository.findByNom("pierre").get()).get().setQuantite(sessionRessourceRepository.findBySessionAndRessource(session, ressourceRepository.findByNom("pierre").get()).get().getQuantite()+pierre);
		sessionRessourceRepository.findBySessionAndRessource(session, ressourceRepository.findByNom("minerais").get()).get().setQuantite(sessionRessourceRepository.findBySessionAndRessource(session, ressourceRepository.findByNom("minerais").get()).get().getQuantite()+minerais);
		
		return "\nVous avez pioché " + bois + " bois, " + pierre + " pierre(s), " + minerais + " minerais !";
	}
	
	/*
	    * Gain ressources batiment de production
	    * */
	public String productionRessource(Session session) {
		
		if(sessionBatimentRepository.findBySession(session).isEmpty()) {
			return "Vous ne produisez pas de ressource";
		}
		
		for(SessionBatiment sessionBatiment: sessionBatimentRepository.findBySession(session) ) {
			// si batiment de la session batiment est dans la liste des batiment production alors...
		}
		return "message";
	}
	
//	for (Batiment b : this.constructions)
//	{
//		if(b instanceof Carriere)
//		{
//			pierre+=5;
//			System.out.println("\nVotre carriere vous a rapporte 5 pierres supplementaires ("+pierre+" pierre(s) au total !)\n");	
//		}
//		else if(b instanceof Carrier)
//		{
//			pierre+=2;
//			System.out.println("\nVotre carrier vous a rapporte 2 pierres supplementaires ("+pierre+" pierre(s) au total !)\n");	
//		}
//		else if (b instanceof Mine)
//		{
//			minerais+=5;
//			System.out.println("\nVotre mine vous a rapporte 5 minerais supplementaires ("+minerais+" minerais au total !)\n");	
//		}
//		else if (b instanceof Mineur)
//		{
//			minerais+=2;
//			System.out.println("\nVotre mineur vous a rapporte 2 minerais supplementaires ("+minerais+" minerais au total !)\n");	
//		}
//		else if (b instanceof Scierie)
//		{
//			bois+=5;
//			System.out.println("\nVotre scierie vous a rapporte 5 bois supplementaires ("+bois+" bois au total !)\n");	
//		}
//		else if (b instanceof Bucheron)
//		{
//			bois+=2;
//			System.out.println("\nVotre bucheron vous a rapporte 2 minerais supplementaires ("+minerais+" minerais au total !)\n");	
//		}
//	}
//	
//	for (Ressource r : this.ressources)	//modification du stock de ressources du joueur en fonction du cout (cf. methode actuAchat de la classe ressources)
//	{
//		if(r instanceof Bois)
//		{
//			r.actuGain(bois);
//		}
//		else if(r instanceof Pierre) {
//			r.actuGain(pierre);
//		}
//		else if(r instanceof Minerais) {
//			r.actuGain(minerais);
//		}
//
//	}
	
	
	/*
	    * Transformer ressources
	    * */
	
	
}
