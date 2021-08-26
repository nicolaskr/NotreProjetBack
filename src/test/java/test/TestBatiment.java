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
import notreProjetBack.model.Batiment;
import notreProjetBack.model.Compte;
import notreProjetBack.model.Defense;
import notreProjetBack.model.Joueur;
import notreProjetBack.repositories.BatimentRepository;
import notreProjetBack.repositories.CompteRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TestBatiment {

	@Autowired
	private BatimentRepository batRepo;
	
	
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
		Defense b = (Defense) new Batiment("Test", 1, 10);
		batRepo.save(b);
	}
	
	
	@Test
	public void findTypeBatiment() {
		assertEquals("Defense", batRepo.findTypeBatiment("Defense").get(0).getType_batiment());
	}
	
	@Test
	public void findByAmeliorable() {
		assertEquals("Defense", batRepo.findByAmeliorable(true).get(0).getType_batiment());
	}

}
