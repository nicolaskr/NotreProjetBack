package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import notreProjetBack.config.AppConfig;
import notreProjetBack.model.Compte;
import notreProjetBack.model.Joueur;
import notreProjetBack.repositories.CompteRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class testCompte {

	@Autowired
	private CompteRepository cptRepo;
	
	
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
	@Rollback(true)
	@Transactional
	public void insertTest() {
		Joueur j = new Joueur("A","A","A","A","A");
		cptRepo.save(j);
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void findBySurnom() {
		assertEquals("A", cptRepo.findBySurnom("A").get().getSurnom());
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void findByLoginAndPassword() {
		Joueur j = new Joueur("J","J","J","J","J");
		cptRepo.save(j);
		assertEquals(j, cptRepo.findByLoginAndPassword(j.getLogin(),j.getPassword()).get());
	}

}
