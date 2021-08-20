package test;

import javax.persistence.EntityManager;

import model.Bois;
import model.Catapulte;
import model.Fonderie;
import model.Four;
import model.Gold;
import model.Joueur;
import model.Merveille;
import model.Partie;
import model.Pierre;
import model.Scierie;
import model.Session;
import util.Context;

public class Test_Nico {

	public static void main(String[] args) {
				
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		
//		Joueur thib = new Joueur("login", "pass", "Thibault", "David", "1");
//		Joueur john = new Joueur("login", "pass", "Johan", "Loison", "2");
//		Joueur pier = new Joueur("login", "pass", "Pierre", "Lequay", "3");
//		Joueur nico = new Joueur("login", "pass", "Nicolas", "Kroupa", "4");

		Partie partie = new Partie(100, true);	
		
		Joueur thib = (Joueur) Context.getInstance().getDaoC().findBySurnom("1");
		Joueur john = (Joueur) Context.getInstance().getDaoC().findBySurnom("2");
		Joueur pier = (Joueur) Context.getInstance().getDaoC().findBySurnom("3");
		Joueur nico = (Joueur) Context.getInstance().getDaoC().findBySurnom("4");

//		Partie partie = Context.getInstance().getDaoP().findById(1);		
//		Context.getInstance().getDaoP().delete(partie);
		
		Context.getInstance().getDaoC().update(thib);
		Context.getInstance().getDaoC().update(john);
		Context.getInstance().getDaoC().update(pier);
		Context.getInstance().getDaoC().update(nico);
		partie = Context.getInstance().getDaoP().update(partie);
		
		em.close();
		
		partie.initPartie(2);
		
		Catapulte catapulte = new Catapulte();
		System.out.println(partie);
		System.out.println(partie.getSessions());
		

		Context.getInstance().closeEmf();

	}

}
