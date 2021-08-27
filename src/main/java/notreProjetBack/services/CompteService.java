package notreProjetBack.services;

import model.Admin;
import model.Joueur;
import util.Context;

public class CompteService {

	
/////MAIN//////
	
//	public static void seConnecter() {
//		String compteCree = Context.saisieString("\nAvez-vous deja cree un compte ? (y/n)");
//
//		if(compteCree.equalsIgnoreCase("y"))
//		{
//			String login = Context.saisieString("\nSaisir login");
//			String password = Context.saisieString("Saisir password");
//			connected = Context.getInstance().getDaoC().seConnecter(login, password);
//
//			if(connected instanceof Admin) 
//			{
//				menuAdmin();
//			}
//			else if(connected instanceof Joueur) 
//			{
//				menuJoueur();
//			}
//			else 
//			{
//				System.out.println("Identifiants invalides !");
//			}
//		}
//		else
//		{
//			String login = Context.saisieString("\nSaisissez votre login : ");
//			String password = Context.saisieString("\nSaisissez votre mot de passe : ");
//			String prenom = Context.saisieString("\nVeuillez indiquez votre prenom : ");
//			String nom = Context.saisieString("\nVeuillez indiquez votre nom : ");
//			String surnom = Context.saisieString("\nChoisissez le nom sous lequel vous souhaitez �tre reconnu durant la partie : ");
//			Joueur j = new Joueur(login, password, prenom, nom, surnom);
//			Context.getInstance().getDaoC().insert(j);
//
//			connected = Context.getInstance().getDaoC().seConnecter(login,password);
//
//			if(connected instanceof Admin) 
//			{
//				menuAdmin();
//			}
//			else if(connected instanceof Joueur) 
//			{
//				menuJoueur();
//			}
//			else 
//			{
//				System.out.println("Identifiants invalides !");
//			}
//		}
//	}
	
	

//	public static void menuAdmin() {
//		System.out.println("\nMenu Admin");
//		System.out.println("1- ");
//		System.out.println("2- ");
//		System.out.println("3- Se deconnecter");
//
//		int choix = Context.saisieInt("Choisir un menu");
//
//		switch(choix) 
//		{
//		case 1 : ;break;
//		case 2 : ;break;
//		case 3 : connected=null;menuPrincipal();break;
//		}
//		menuAdmin();
//	}
	
	
//	public static void menuJoueur() {
//		System.out.println("\nMenu Joueur");
//		System.out.println("1- Demarrer une nouvelle partie");
//		System.out.println("2- Reprendre une partie existante");
//		System.out.println("3- Se deconnecter");
//		int choix = Context.saisieInt("Choisir un menu");
//
//		switch(choix) 
//		{
//		case 1 : nouvPartie();break;
//		case 2 : loadPartie();break;
//		case 3 : connected=null;menuPrincipal();break;
//		}
//		menuJoueur();
//	}
	
	
	
}
