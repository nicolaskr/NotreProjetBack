package notreProjetBack.test;

import static org.junit.Assert.*;

import notreProjetBack.config.AppConfig;
import notreProjetBack.model.Admin;
import notreProjetBack.model.Joueur;
import notreProjetBack.model.Partie;
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
public class PartieRepositoryTestNico {
	
	@Autowired
	CompteRepository compteRepository;
	
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
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPartieRepositoryExist() {
		assertNotNull(partieRepository);
	}

	@Test
	public void testPartieRepositorySetSessions() {
		Partie p = new Partie();
		partieRepository.save(p);
	}

}
