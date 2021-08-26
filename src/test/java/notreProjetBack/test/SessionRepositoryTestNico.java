package notreProjetBack.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import notreProjetBack.config.AppConfig;
import notreProjetBack.model.Admin;
import notreProjetBack.model.Joueur;
import notreProjetBack.model.Partie;
import notreProjetBack.model.Session;
import notreProjetBack.repositories.CompteRepository;
import notreProjetBack.repositories.PartieRepository;
import notreProjetBack.repositories.SessionRepository;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class SessionRepositoryTestNico {
	
	Admin admin1;
	Joueur joueur1;
	Joueur joueur2;
	Joueur joueur3;
	Joueur joueur4;
	Partie partie1;
	Session session1;
	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	SessionRepository sessionRepository;
	
	@Autowired
	PartieRepository partieRepository;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {		
		admin1 = (Admin) compteRepository.findById(1).get();
		joueur1 = (Joueur) compteRepository.findById(2).get();
		joueur2 = (Joueur) compteRepository.findById(3).get();
		joueur3 = (Joueur) compteRepository.findById(4).get();
		joueur4 = (Joueur) compteRepository.findById(5).get();
		
		partie1 = partieRepository.findById(1).get();
		
		session1 = sessionRepository.findById(1).get();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSessionRepositoryExist() {
		assertNotNull(sessionRepository);
	}

	@Test
	public void testSessionRepositorySave() {
		
		Joueur joueurLambda = new Joueur("login", "password", "prenom", "nom", generatedString());
		compteRepository.save(joueurLambda);
		
		Partie partieLambda = new Partie();
		partieRepository.save(partieLambda);
		
		Session sessionLambda = new Session(partieLambda, joueurLambda);
		sessionRepository.save(sessionLambda);
	}
	
	@Test
	public void testSessionFindByPartie() {
		List<Session> sessionList = sessionRepository.findByPartie(partie1);
		assertFalse(sessionList.isEmpty());
	}
	
	@Test
	public void testSessionFindByCompte() {
		List<Session> sessionList = sessionRepository.findByCompte(joueur1);
		assertFalse(sessionList.isEmpty());
	}
	
	public String generatedString() {
		byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String generatedString = new String(array);
	    return generatedString;
	}

}
