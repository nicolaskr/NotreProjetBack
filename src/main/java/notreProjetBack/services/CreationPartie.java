package notreProjetBack.services;

import notreProjetBack.model.Compte;
import notreProjetBack.model.Joueur;
import notreProjetBack.model.Partie;
import notreProjetBack.model.Session;
import notreProjetBack.repositories.PartieRepository;
import notreProjetBack.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CreationPartie {

    @Autowired
    PartieRepository partieRepository;

    @Autowired
    SessionRepository sessionRepository;

    /*
     * Créer une partie vide
     * */
    public Partie saveNewPartie(){

        Partie partie = new Partie();
        partieRepository.save(partie);

        return partie;
    }

    /*
     * Ajouter un joueur à une partie & initialise la session
     * */
    public void saveJoueurInAPartie(Joueur joueur, Partie partie){

        Session session = new Session(partie, joueur);
        sessionRepository.save(session);

    }

    /*
    * Créer une partie avec des comptes deja existant & initialise les sessions
    * */
    public void saveNewPartieWithJoueurs(List<Joueur> joueurList){

        Partie partie = saveNewPartie();

        List<Session> sessionList = new ArrayList<Session>();

        for (Joueur joueur:joueurList) {
            Session session = new Session(partie, joueur);
            sessionList.add(session);
        }

        sessionRepository.saveAll(sessionList);

    }

}


