package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

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
import notreProjetBack.model.Ressource;
import notreProjetBack.model.SessionRessource;
import notreProjetBack.repositories.RessourceRepository;
import notreProjetBack.repositories.SessionRepository;
import notreProjetBack.repositories.SessionRessourceRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TestSessionRessourceThibault {

	@Autowired
	private SessionRessourceRepository srRep;
	
	@Autowired
	private SessionRepository sRep;
	
	@Autowired
	private RessourceRepository rRep;
	
	
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
		SessionRessource sr = new SessionRessource(sRep.findById(1).get(),rRep.findById(2).get(),12);
		srRep.save(sr);
		assertNotNull(sr);
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void findBySession() {
		assertEquals(4,srRep.findBySession(sRep.getById(1)).size());
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void findBySessionAndRessource() {
		
		assertEquals(srRep.findById(1).get(),srRep.findBySessionAndRessource(sRep.findById(1).get(),rRep.findById(7).get()).get());
	}
}
