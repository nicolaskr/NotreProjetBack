package notreProjetBack.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import notreProjetBack.model.Compte;

@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte{

	public Admin() {
	}
	
	public Admin(String login, String password) {
		super(login, password);
	}

	public Admin(Integer id,String login, String password) {
		super(id,login, password);
	}
		
	public Admin (Integer id, String login, String password, String prenom, String nom, String surnom)
	{
		super(id,login,password, prenom, nom, surnom);
	}	
	
	public Admin (String login, String password, String prenom, String nom, String surnom)
	{
		super(login,password, prenom, nom, surnom);
	}
}
