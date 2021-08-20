package model;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import model.*;
import util.Context;

@Entity
public class Partie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="nbrDeTour")
	private int nbrDeTour;
	@Column(name="partieEnCours")
	private boolean partieEnCours;
	@Column(name="tourEnCours")
	static int cptPartie=0;
		
	private transient List<Session> sessions= new ArrayList<Session>();
		
	//Constructeurs
	public Partie() {}	
	
	public Partie(int nbrDeTour) {
		this.nbrDeTour = nbrDeTour;
	}

	public Partie(int nbrDeTour, boolean partieEnCours) {
		super();
		this.nbrDeTour = nbrDeTour;
		this.partieEnCours = partieEnCours;
	}

	public Partie(int id, int nbrDeTour, boolean partieEnCours) {
		super();
		this.id = id;
		this.nbrDeTour = nbrDeTour;
		this.partieEnCours = partieEnCours;
	}
	
	//Getters & Setters

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}	
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getnbrDeTour() {
		return nbrDeTour;
	}

	public void setnbrDeTour(int nbrDeTour) {
		this.nbrDeTour = nbrDeTour;
	}

	public boolean ispartieEnCours() {
		return partieEnCours;
	}

	public void setpartieEnCours(boolean partieEnCours) {
		this.partieEnCours = partieEnCours;
	}

	@Override
	public String toString() {
		return "Partie [id=" + id + ", nbrDeTour=" + nbrDeTour + ", partieEnCours=" + partieEnCours + "]";
	}
	
	//Fonctions maison
	
	public int initPartie(int nbJoueur)
	{		
		for(int i = 0;i<nbJoueur;i++)
		{		
			System.out.println("\nJoueur "+(i+1)+" : ");
			String compteCree = Context.saisieString("Ce joueur a-t-il deja un compte ? (y/n)");
			
			if(compteCree.equalsIgnoreCase("y"))
			{
				String surnomJ = Context.saisieString("Veuillez indiquer le surnom du joueur :");
				Compte c = Context.getInstance().getDaoC().findBySurnom(surnomJ);
				Session sessionX = new Session(false, this, c);
								
				System.out.println("\nBienvenue "+c.getPrenom()+" "+c.getNom()+", vous etes le Joueur "+(i+1)+" ! ");
				System.out.println("\nDans cette partie vous serez "+c.getSurnom());
				
				Bois b = new Bois(0);
				Pierre pi = new Pierre(0);
				Minerais m = new Minerais(0);
				Charbon ch = new Charbon(0);
				Gold g = new Gold(0);
				Fer f = new Fer(0);
				Cuivre cu = new Cuivre(0);
				List <Ressource> stock = new ArrayList();
				stock.add(b);stock.add(pi);stock.add(m);stock.add(ch);stock.add(g);stock.add(f);stock.add(cu);
				sessionX.setRessources(stock);
				sessionX = Context.getInstance().getDaoS().update(sessionX);
				
				sessions.add(sessionX);				
			}
			else
			{
				String login = Context.saisieString("\nSaisissez votre login : ");
				String password = Context.saisieString("\nSaisissez votre mot de passe : ");
				String prenom = Context.saisieString("\nVeuillez indiquez votre prenom : ");
				String nom = Context.saisieString("\nVeuillez indiquez votre nom : ");
				String surnom = Context.saisieString("\nChoisissez le nom sous lequel vous souhaitez etre reconnu durant la partie : ");
				Compte c = new Joueur (login, password, prenom, nom, surnom);
				
				c = Context.getInstance().getDaoC().insert(c);
				Session sessionX = new Session (false, this, c);
				
										
				System.out.println("\nBienvenue "+c.getPrenom()+" "+c.getNom()+", vous etes le Joueur "+(i+1)+" ! ");
				System.out.println("\nDans cette partie vous serez "+c.getSurnom());
				
				Bois b = new Bois(0);
				Pierre pi = new Pierre(0);
				Minerais m = new Minerais(0);
				Charbon ch = new Charbon(0);
				Gold g = new Gold(0);
				Fer f = new Fer(0);
				Cuivre cu = new Cuivre(0);
				List <Ressource> stock = new ArrayList();
				stock.add(b);stock.add(pi);stock.add(m);stock.add(ch);stock.add(g);stock.add(f);stock.add(cu);
				sessionX.setRessources(stock);
				sessionX=Context.getInstance().getDaoS().update(sessionX);
				
				sessions.add(sessionX);
			}
			
		}			
			
		return cptPartie++;
	}
	


	public void startPartie(){

		this.partieEnCours = true;
		Session vainqueur = null;

		while(this.partieEnCours){
			for(int i = 1;i<=nbrDeTour;i++)
			{
				if(i==1)
				{
					for(Session init : sessions)
					{
						init.construitBastide(); // Sans arguments car Session contient id_Compte + id_Partie
					}
				}
				for(int j=0;j<sessions.size();j++)
				{
					Compte c = sessions.get(j).getCompte();
					Session j1 = sessions.get(j);
					System.out.println("\nTour "+(i)+" - " + c.getPrenom() + " " + c.getNom() + " " + c.getSurnom() + "\n");
					j1.setTourEnCours(true);
					j1.piocherRessources();
					while(j1.isTourEnCours()==true)
					{
						j1.joueTour();
					}
					finDePartie();/*savePartie(p);*/

					if(this.partieEnCours==false)
					{
						vainqueur = finDePartie();
						break;

					}
				}
				if(this.partieEnCours==false)
				{
					break;
				}
			}
			if(this.partieEnCours==false)
			{
				break;
			}
		}
		
		if(this.partieEnCours==false)
		{
			menuFinDePartie(vainqueur);
		}
	}
	
	public Session finDePartie()
	{
		Session vainqueur = null;
		for(Session joueur : sessions)
		{
			int somme = 0;

			for(int i=0;i<sessions.size();i++)
			{
				somme+=(sessions.get(i)).getDef();
			}

			if(somme-joueur.getDef()==0)
			{
				this.partieEnCours = false;
				vainqueur = joueur;
			}

			else 
			{
				for(Batiment b : joueur.getConstructions())
				{
					if(b.toStringName().equals("Merveille"))
					{
						if(b.getLevel()==5)
						{
							this.partieEnCours = false;
							vainqueur = joueur;
						}
					}
				}
			}
		}
		return vainqueur;
	}
	
	
	public void menuFinDePartie(Session vainqueur)
	{
		Compte c = vainqueur.getCompte();
		System.out.println("\n\nEt nous avons notre grand vainqueur : "+c.getSurnom()+" ("+c.getPrenom()+" "+c.getNom()+") !!!\n");
		
		int width = 100;
        int height = 30;

        //BufferedImage image = ImageIO.read(new File("/Users/mkyong/Desktop/logo.jpg"));
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("SansSerif", Font.BOLD, 20));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("Victoire", 10, 20);

        //save this image
        //ImageIO.write(image, "png", new File("/users/mkyong/ascii-art.png"));

        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {

                sb.append(image.getRGB(x, y) == -16777216 ? " " : "0");

            }

            if (sb.toString().trim().isEmpty()) {
                continue;
            }

            System.out.println(sb);
        }
	}
	
	
	
	
	
}
