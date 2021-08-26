package notreProjetBack.test;

import static org.junit.Assert.*;

import java.util.Random;

import notreProjetBack.config.AppConfig;
import notreProjetBack.model.Admin;
import notreProjetBack.model.Joueur;
import notreProjetBack.repositories.CompteRepository;
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
public class CompteRepositoryTestNico {

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
	public void testCompteRepositoryExist() {
		assertNotNull(compteRepository);
	}

	@Test
	public void testCompteRepositorySave() {			    
		Admin admin1 = new Admin("login", "password", "prenom", "nom", generatedString());
		Joueur joueur1 = new Joueur("login", "password", "prenom", "nom", generatedString());

		compteRepository.save(admin1);
		compteRepository.save(joueur1);
	}
	
	public String generatedString() {
		byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String generatedString = new String(array);
	    return generatedString;
	}

}
