package test;

import javax.persistence.EntityManager;

import model.Test_Nico;
import util.Context;

public class Test {

	public static void main(String[] args) {
						
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		
		Test_Nico t = new Test_Nico(10);
		
		em.getTransaction().begin();
		
		em.persist(t);
		
		em.getTransaction().commit();
		
		em.close();
				
		Context.getInstance().closeEmf();
		
	}

}
