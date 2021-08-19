package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOBatiment;
import dao.DAOCompte;
import dao.DAOPartie;
import dao.DAORessource;

public class Context {

	private static Context _instance=null;
	private static DAOBatiment daoB;
	private static DAOCompte daoC;
	private static DAOPartie daoP;
	private static DAORessource daoR;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("NotreProjetBack");
		
	private Context() {}	
	
	public static Context getInstance() {
		if(_instance==null) {_instance=new Context();}
		return _instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public DAOBatiment getDaoB() {
		return daoB;
	}
	
	public DAOCompte getDaoC() {
		return daoC;
	}
	
	public DAOPartie getDaoP() {
		return daoP;
	}
	
	public DAORessource getDaoR() {
		return daoR;
	}
	
	public void closeEmf() {
		emf.close();
	}
		
}
