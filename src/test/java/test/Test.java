package test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.*;
import util.Context;

public class Test {

	public static void main(String[] args) {
						

		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		
		Joueur j = new Joueur("login","pass");
		Partie pa = new Partie(100, true);
		Session s = new Session(false, pa, j);
		
		Catapulte c = new Catapulte();
		Merveille m = new Merveille();
		Scierie sc = new Scierie();
		Four f = new Four();
		Fonderie fo = new Fonderie();

		s.getConstructions().add(c);
		s.getConstructions().add(m);
		s.getConstructions().add(f);
		s.getConstructions().add(sc);
		s.getConstructions().add(fo);
		
		Bois b = new Bois(2);
		Pierre p = new Pierre(3);
		Gold g = new Gold (5);
		
		s.getRessources().add(g);
		s.getRessources().add(p);
		s.getRessources().add(b);
		

		em.getTransaction().begin();

//		Context.getInstance().getDaoC().insert(j);
//		Context.getInstance().getDaoP().insert(pa);
//
//
//		Context.getInstance().getDaoB().insert(m);
//		Context.getInstance().getDaoB().insert(f);
//		Context.getInstance().getDaoB().insert(sc);
//		Context.getInstance().getDaoB().insert(c);
//		Context.getInstance().getDaoB().insert(fo);

		Context.getInstance().getDaoS().update(s);

		em.getTransaction().commit();
		
		em.close();
		
		
		
		Context.getInstance().closeEmf();
	}

}
