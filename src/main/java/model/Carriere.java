package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Carriere extends Production {
	protected transient Bois b = new Bois(8);
	protected transient Pierre p = new Pierre(0);
	protected transient Minerais m = new Minerais(8);
	protected transient Charbon c = new Charbon(0);
	protected transient Gold g = new Gold(0);
	protected transient Fer f = new Fer(0);
	protected transient Cuivre cu = new Cuivre(0);
	
	public Carriere() 
	
	{
		setNom("carriere");
		cost.add(b);cost.add(p);cost.add(m);cost.add(c);cost.add(g);cost.add(f);cost.add(cu);
		setDef(25);
	}

	public Carriere(String nom, int level, double def){
		super(nom, level, def);
	}
	
	public Carriere(int id, String nom, int level, double def)
	{
		super(id, nom, level, def);
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
	//---------------------------------------------------------------------
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
		this.setAtt(this.getAtt()+0);
		this.setDef(this.getDef()+20);
		this.setCost(tmpCost);
		this.setLevel(this.getLevel()+1);
		return;
	}
	
	@Override
	public String toStringName() {
		return "Carriere";
	}
	
}
