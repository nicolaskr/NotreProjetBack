package notreProjetBack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.RepositoryComposition;
import org.springframework.stereotype.Service;

import notreProjetBack.model.Admin;
import notreProjetBack.model.Compte;
import notreProjetBack.model.Joueur;
import notreProjetBack.repositories.AdminRepository;
import notreProjetBack.repositories.CompteRepository;
import notreProjetBack.repositories.JoueurRepository;
import util.Context;

@Service
public class CompteService {

	@Autowired
	private static CompteRepository compteRepo;
	
	@Autowired
	private static JoueurRepository joueurRepo;
	
	@Autowired
	private static AdminRepository adminRepo;
	
	public static Joueur saveNewJoueur(Joueur joueur){
		joueurRepo.save(joueur);
		return joueur;
	}
	
	public static Admin saveNewAdmin(Admin admin){
		adminRepo.save(admin);
		return admin;
	}
	
	public static Compte checkConnexion(String login, String password) {
		Compte compte = null;
		if(compteRepo.findByLoginAndPassword(login, password).isPresent()) {
			compte = compteRepo.findByLoginAndPassword(login, password).get();
		}
		return compte;
		//gerer joueur et admin
	}	
}
