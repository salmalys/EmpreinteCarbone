package user;
import java.util.ArrayList;

public class Population implements Cloneable {
	private ArrayList<Utilisateur> listPopulation;
	private int nb;

	public Population() {
		listPopulation = new ArrayList<Utilisateur>();
	}
	
	public Population(Utilisateur ... pop) {
		listPopulation = new ArrayList<Utilisateur>();
		for (Utilisateur u: pop) {
			listPopulation.add(u);
			this.nb++;
		};
	}
	
	public void setPopulation(ArrayList<Utilisateur> population) {this.listPopulation = population;}
	public ArrayList<Utilisateur> getListPopulation(){return this.listPopulation;}
	
	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}
	
	public void addUser(Utilisateur user) {
		listPopulation.add(user);
		this.nb++;
	}
	
	public double calculerEmpreinte() {
		double impactTotal = 0;
		for (Utilisateur u : listPopulation) {
			impactTotal += u.calculerEmpreinte();
		}
		return impactTotal;	
	}
	
	@Override
	public Object clone(){
		try {
			Population p = (Population) super.clone();
			p.listPopulation = new ArrayList<Utilisateur>(this.listPopulation);
			return p;
		}
		catch (CloneNotSupportedException e){
			throw new InternalError();
		}
	}
		
}
	
	

