package user;
import java.util.ArrayList;

public class Population implements Cloneable {
	private ArrayList<Utilisateur> listPopulation;

	public Population() {}
	
	public Population(ArrayList<Utilisateur> pop) {
		listPopulation = pop;
	}
	
	public void setPopulation(ArrayList<Utilisateur> population) {this.listPopulation = population;}
	public ArrayList<Utilisateur> getListPopulation(){return this.listPopulation;}
	
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
			p.listPopulation = (ArrayList<Utilisateur>) this.listPopulation.clone();
			return p;
		}
		catch (CloneNotSupportedException e){
			throw new InternalError();
		}
	}
		
}
	
	

