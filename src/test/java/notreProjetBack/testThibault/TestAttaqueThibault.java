package notreProjetBack.testThibault;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TestAttaqueThibault {

	@Autowired
	private AttaqueRepository aRep;
	
	
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
		aRep.save(att);
		assertNotNull(att);
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void findBatimentAtt() {
		Attaque att = new Attaque("attTest",1,50,50,true);
		aRep.save(att);
		assertEquals(att, aRep.findAttaqueBatiment().get(0));
	}
	
}
