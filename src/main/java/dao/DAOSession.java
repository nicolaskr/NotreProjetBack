package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Batiment;
import model.Session;
import model.SessionId;
import util.Context;

public class DAOSession implements IDAOSession{

	@Override
	public Session findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Session> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Session insert(Session s) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
		return s;
	}
	public Session update(Session s) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		s = em.merge(s);
		em.getTransaction().commit();
		em.close();
		return s;
	}
	
	public void delete(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Session s = em.find(Session.class,id);
		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(Session s) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		s=em.merge(s);
		em.remove(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Session> findSessionsByPartieId(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("from Session where partie_id = :idp",Session.class);
		query.setParameter("idp", id);
		List<Session> listSessions = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return listSessions;
	}	
	
	public List<Batiment> findConstructionsById(SessionId id) {
		int idCompte = id.getIdCompte();
		int idPartie = id.getIdPartie();
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNativeQuery("Select * from Batiment join liste_batiments on batiment.id=liste_batiments.batiments where Session_compte_id = :idc and Session_partie_id = :idp",Batiment.class);
		query.setParameter("idc", idCompte);
		query.setParameter("idp", idPartie);
		List<Batiment> constructions = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return constructions;
	}	

}
