package test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import notreProjetBack.config.AppConfig;
import notreProjetBack.model.Batiment;
import notreProjetBack.model.CoutBatiment;
import notreProjetBack.model.Defense;
import notreProjetBack.model.Joueur;
import notreProjetBack.model.Session;
import notreProjetBack.model.SessionBatiment;
import notreProjetBack.repositories.BatimentRepository;
import notreProjetBack.repositories.SessionBatimentRepository;
import notreProjetBack.repositories.SessionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TestSessionBatimentRepo {
	
	@Autowired
	SessionBatimentRepository sessionBatimentRepository;
	
	@Autowired
	SessionRepository sessionRepository;
	
	@Autowired
	BatimentRepository batimentRepository;

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
	
//	@Test
//	public void findBatimentBySession() {
//		Optional<Session> opt= sr.findById(2);
//		System.out.println();
//		List<SessionBatiment> ses = sbr.findBySession(opt.get());
//		System.out.println(ses);
//	}
	
	@Test
	public void testFindByIdWithCoutBatiment() {

		Defense mur = (Defense) batimentRepository.findByNom("mur").get();
		
		System.out.println(mur.getNom());
		System.out.println(mur);
		
		mur = (Defense) batimentRepository.findByIdWithCoutBatiment(mur.getId()).get();
			
		
		System.out.println(mur.getNom());
		
		for (CoutBatiment coutBatiment : mur.getCoutBatiment()) {
			System.out.println(coutBatiment.getId().getRessource().getNom());
			System.out.println(coutBatiment.getCout());
		}
		
	}

}
