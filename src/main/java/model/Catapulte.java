package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Catapulte extends Attaque {
	protected Bois b = new Bois(3);
	protected Pierre p = new Pierre(0);
	protected Minerais m = new Minerais(0);
	protected Charbon c = new Charbon(0);
	protected Gold g = new Gold(3);
	protected Fer f = new Fer(3);
	protected Cuivre cu = new Cuivre(0);
	
	protected double att;
	protected double def;
	
	public Catapulte() 
	
	{
		super();
		setNom("catapulte");
		cost.add(b);cost.add(p);cost.add(m);cost.add(c);cost.add(g);cost.add(f);cost.add(cu);
		setDef(25);
		setAtt(20);
	}

	public Catapulte(String nom, int level, double def){
		super(nom, level, def);
	}
	
	public Catapulte(int id,int idCompte, int idPartie,String nom, int level, double def, double att)
	{
		super(id,idCompte, idPartie,nom, level, def, att);
		cost.add(b);cost.add(p);cost.add(m);cost.add(c);cost.add(g);cost.add(f);cost.add(cu);
	}

	public Bois getB() {
		return b;
	}

	public void setB(Bois b) {
		this.b = b;
	}

	public Pierre getP() {
		return p;
	}

	public void setP(Pierre p) {
		this.p = p;
	}

	public Minerais getM() {
		return m;
	}

	public void setM(Minerais m) {
		this.m = m;
	}

	public Charbon getC() {
		return c;
	}

	public void setC(Charbon c) {
		this.c = c;
	}

	public Gold getG() {
		return g;
	}

	public void setG(Gold g) {
		this.g = g;
	}

	public Fer getF() {
		return f;
	}

	public void setF(Fer f) {
		this.f = f;
	}

	public Cuivre getCu() {
		return cu;
	}

	public void setCu(Cuivre cu) {
		this.cu = cu;
	}
	
	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	//-----------------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------------------
	public void upgrade() 
	{	
		List  <Ressource> tmpCost= new ArrayList<Ressource>();
		tmpCost = this.cost;
		for (Ressource r: tmpCost)
		{
			if (r.getStock()!=0) 
			{
				r.setStock(r.getStock()+3);
			}
		}
		this.setAtt(this.getAtt()*2.5);
		this.setDef(this.getDef()+20);
		this.setCost(tmpCost);
		this.setLevel(this.getLevel()+1);
		return;
	}
	
	@Override
	public String toStringName() {
		return "Catapulte";
	}
}