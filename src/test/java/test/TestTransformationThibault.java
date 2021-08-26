package test;

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
import notreProjetBack.model.Transformation;
import notreProjetBack.repositories.TransformationRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TestTransformationThibault {

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
	public void insertTestTransf() {
		Transformation transf = new Transformation("transfTest",1,70,70,false);
		tRep.save(transf);
		assertNotNull(transf);
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void findByTypeBatimentAtt() {
		Transformation transf = new Transformation("transfTest",1,70,70,false);
		tRep.save(transf);
		assertEquals(transf, tRep.findTransformationBatiment().get(0));
	}
	
}
