package test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.*;
import util.Context;

public class Test {

	public static void main(String[] args) {
						

		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		
		Bois b = new Bois(2);
		Pierre p = new Pierre(3);
		Gold g = new Gold (5);
		
		List <Ressource> stock= new ArrayList();
		
		stock.add(g);
		stock.add(p);
		stock.add(b);
		
		em.getTransaction().begin();
		
		em.persist(stock);


		em.getTransaction().commit();
		em.close();
		Context.getInstance().closeEmf();
	}

}
