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
import notreProjetBack.model.Attaque;
import notreProjetBack.model.Defense;
import notreProjetBack.model.Production;
import notreProjetBack.model.Transformation;
import notreProjetBack.repositories.AttaqueRepository;
import notreProjetBack.repositories.BatimentRepository;
import notreProjetBack.repositories.DefenseRepository;
import notreProjetBack.repositories.ProductionRepository;
import notreProjetBack.repositories.TransformationRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TestBatimentThibault {

	@Autowired
	private BatimentRepository bRep;
	
	@Autowired
	private AttaqueRepository aRep;
	
	@Autowired
	private DefenseRepository dRep;
	
	@Autowired
	private ProductionRepository pRep;
	
	@Autowired
	private TransformationRepository tRep;
	
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
	public void insertTestAtt() {
		Attaque att = new Attaque("attTest",1,50,50,true);
		bRep.save(att);
		assertNotNull(att);
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void insertTestDef() {
		Defense def = new Defense("defTest",1,70,70,true);
		bRep.save(def);
		assertNotNull(def);
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void insertTestProd() {
		Production prod = new Production("prodTest",1,70,70,true);
		bRep.save(prod);
		assertNotNull(prod);
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void insertTestTransf() {
		Transformation transf = new Transformation("transfTest",1,70,70,false);
		bRep.save(transf);
		assertNotNull(transf);
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void findByAmeliorable() {
		Attaque att = new Attaque("attTest",1,50,50,true);
		bRep.save(att);
		Defense def = new Defense("defTest",1,70,70,true);
		bRep.save(def);
		Production prod = new Production("prodTest",1,70,70,true);
		bRep.save(prod);
		Transformation transf = new Transformation("transfTest",1,70,70,false);
		bRep.save(transf);
		assertEquals(att, bRep.findByAmeliorable(true).get(0));
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void findBatAtt() {
		Attaque att = new Attaque("attTest",1,50,50,true);
		bRep.save(att);
		Defense def = new Defense("defTest",1,70,70,true);
		bRep.save(def);
		Production prod = new Production("prodTest",1,70,70,true);
		bRep.save(prod);
		Transformation transf = new Transformation("transfTest",1,70,70,false);
		bRep.save(transf);
		assertEquals(att, aRep.findAttaqueBatiment().get(0));
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void findBatDef() {
		Attaque att = new Attaque("attTest",1,50,50,true);
		bRep.save(att);
		Defense def = new Defense("defTest",1,70,70,true);
		bRep.save(def);
		Production prod = new Production("prodTest",1,70,70,true);
		bRep.save(prod);
		Transformation transf = new Transformation("transfTest",1,70,70,false);
		bRep.save(transf);
		assertEquals(def, dRep.findDefenseBatiment().get(0));
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void findBatProd() {
		Attaque att = new Attaque("attTest",1,50,50,true);
		bRep.save(att);
		Defense def = new Defense("defTest",1,70,70,true);
		bRep.save(def);
		Production prod = new Production("prodTest",1,70,70,true);
		bRep.save(prod);
		Transformation transf = new Transformation("transfTest",1,70,70,false);
		bRep.save(transf);
		assertEquals(prod, pRep.findProductionBatiment().get(0));
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void findBatTransf() {
		Attaque att = new Attaque("attTest",1,50,50,true);
		bRep.save(att);
		Defense def = new Defense("defTest",1,70,70,true);
		bRep.save(def);
		Production prod = new Production("prodTest",1,70,70,true);
		bRep.save(prod);
		Transformation transf = new Transformation("transfTest",1,70,70,false);
		bRep.save(transf);
		assertEquals(transf, tRep.findTransformationBatiment().get(0));
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void findBatAttaques() {
		Attaque att = new Attaque("attTest",1,50,50,true);
		bRep.save(att);
		Attaque att2 = new Attaque("attTest2",1,50,50,true);
		bRep.save(att2);
		Attaque att3 = new Attaque("attTest3",1,50,50,true);
		bRep.save(att3);
		Defense def = new Defense("defTest",1,70,70,true);
		bRep.save(def);
		Production prod = new Production("prodTest",1,70,70,true);
		bRep.save(prod);
		Transformation transf = new Transformation("transfTest",1,70,70,false);
		bRep.save(transf);
		assertEquals(3, aRep.findAttaqueBatiment().size());
	}

}
