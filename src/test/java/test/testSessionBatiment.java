package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import notreProjetBack.config.AppConfig;
import notreProjetBack.model.Compte;
import notreProjetBack.model.Defense;
import notreProjetBack.model.Partie;
import notreProjetBack.model.Production;
import notreProjetBack.model.Session;
import notreProjetBack.model.SessionBatiment;
import notreProjetBack.model.SessionKey;
import notreProjetBack.repositories.CompteRepository;
import notreProjetBack.repositories.PartieRepository;
import notreProjetBack.repositories.SessionBatimentRepository;
import notreProjetBack.repositories.SessionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class testSessionBatiment {

	@Autowired
	SessionBatimentRepository sessionBatimentRepository;
	
	@Autowired
	SessionRepository sessionRepository;
	
	@Autowired
	PartieRepository partieRepository;
	
	@Autowired
	CompteRepository compteRepository;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindBySessionAndBatimentProduction() {
//		Partie partie = partieRepository.findById(1).get();
//		Compte compte = compteRepository.findById(1).get();
//		Session session = sessionRepository.findById(new SessionKey(partie,compte)).get();
		
		List<Session> sessions = sessionRepository.findAll();
		System.out.println(sessions);
		
		Session session = sessions.get(3);
		
		List<SessionBatiment> listDef = sessionBatimentRepository.findBySessionAndBatimentProduction(session);
		
		for (SessionBatiment sessionBatiment : listDef) {
			System.out.println(sessionBatiment.getBatiment().getNom());
		}
	}
	


}
