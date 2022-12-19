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
	
	public double calculerEmpreinteAlim() {
		double impactA = 0;
		for (Utilisateur u : listPopulation) {
			impactA += u.getAlimentation().getImpact();
		}
		return impactA;	
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
	
	public void conseilEmpreintePop( ) {
		  //a verifier 
		  
		  if (this.calculerEmpreinteAlim()> 2.353*this.nb) System.out.println("Nous vous conseillions de reduire votre impact alimentaire, vous pouvez par exemple reduire vos repas a base de boeuf");
		  //if (this.calculerEmpreinteLog() > 2.625) System.out.println("Nous vous conseillions de reduire votre impact de bien consommateur, par exemple en essayant de moins depenser dans la consomation rapide");
		  //if(this.calculerEmpreinteBien() > 2.5) System.out.println("Nous vous conseillions de supprimer vos mails et d'envoyer seulement les mails necessaire");
		  if (this.calculerEmpreinteAlim()> 2.706) System.out.println("Nous vous conseillions de reduire votre impact de logement, par exemple en essaynt de faire baisser la classe ernegetique de votre logement"); 
		  if (this.calculerEmpreinteAlim() > 2.920) System.out.println("Nous vous conseillions de reduire votre impact de transport, par exemple en achetant une voiture electrique, ou plus recente, ou seulement diminuer vos deplacements quotidients en voiture");
	  }
		
}
	
	

