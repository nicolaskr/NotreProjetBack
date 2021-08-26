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
import notreProjetBack.model.Production;
import notreProjetBack.repositories.ProductionRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TestProductionThibault {

	@Autowired
	private ProductionRepository pRep;
	
	
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
	public void insertTestProd() {
		Production prod = new Production("prodTest",1,70,70,true);
		pRep.save(prod);
		assertNotNull(prod);
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void findByTypeBatimentAtt() {
		Production prod = new Production("prodTest",1,70,70,true);
		pRep.save(prod);
		assertEquals(prod, pRep.findProductionBatiment().get(0));
	}
}
