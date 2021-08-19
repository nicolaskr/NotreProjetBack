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
	
				
		em.getTransaction().begin();

		Context.getInstance().getDaoC().insert(j);
		Context.getInstance().getDaoP().insert(pa);
		Context.getInstance().getDaoS().update(s);

		em.getTransaction().commit();
		
		em.close();
		
		
		
		Context.getInstance().closeEmf();
	}

}
