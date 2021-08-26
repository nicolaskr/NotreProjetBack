package notreProjetBack.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import notreProjetBack.model.Compte;

@Entity
@DiscriminatorValue("joueur")
public class Joueur extends Compte{

	public Joueur() {
	}
	
	public Joueur (String login, String password){
		super(login, password);
	}
	
	public Joueur (int id, String login, String password){
		super(id, login, password);
	}
	
	public Joueur (String login, String password, String prenom, String nom, String surnom){
		super(login,password, prenom, nom, surnom);
	}
	
	public Joueur (int id, String login, String password, String prenom, String nom, String surnom){
		super(id,login,password,prenom, nom, surnom);
	}
}
