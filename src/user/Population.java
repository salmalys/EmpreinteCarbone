package user;
import java.util.ArrayList;

/**
 * Classe Population. Elle permet de creer une liste de plusieurs utilisateur 
 */

public class Population implements Cloneable {
	private ArrayList<Utilisateur> listPopulation;
	private int nb;

	/**
	 * Constructeur de la classe Population par defaut qui instancie une ArrayList d'utilisateur 
	 */

	public Population() {listPopulation = new ArrayList<Utilisateur>();}

	/**
	 * Constructeur de la classe population qui a partir d'un tableau d'utilisateur creer une population
	 * @param pop tableau d'utilisateur de taille indefinie 
	 */

	public Population(Utilisateur ... pop) {
		listPopulation = new ArrayList<Utilisateur>();
		for (Utilisateur u: pop) {
			listPopulation.add(u);
			this.nb++;
		};
	}

	/**
	 *  Constructeur de la classe population qui a partir d'une liste d'utilisateur creer une population
	 * @param population liste d'utilisateur 
	 */

	public Population(ArrayList<Utilisateur> population) {
		listPopulation = new ArrayList<Utilisateur>();
		for (Utilisateur u: population) {
			listPopulation.add(u);
			this.nb++;
		};
	}

	/**
	 * Setter d'une population
	 * @param population liste d'utilisateur 
	 */

	public void setPopulation(ArrayList<Utilisateur> population) {this.listPopulation = population;}

	/**
	 * Getter de la population
	 * @return la liste d'utilisateur correspondant a la population 
	 */

	public ArrayList<Utilisateur> getListPopulation(){return this.listPopulation;}

	/**
	 * Setter du nombre d'utilisateur
	 * @param nb nombre d'utilisateur dans la population
	 */

	public void setNb(int nb) {this.nb = nb;}

	/**
	 * Getter du nombre d'utilisateur
	 * @return le nombre d'utilisateur dans la population
	 */

	public int getNb() {return nb;}

	/**
	 * Methode permettant d'ajouter un utilisateur dans la population, incremente nb qui represente le nombre d'utilisateur 
	 * @param user utilisateur a ajouter
	 */

	public void addUser(Utilisateur user) {
		listPopulation.add(user);
		this.nb++;
	}

	/**
	 * Methode calculant l'empreinte de toute la population en utilisant la methode faites dans utilisateur
	 * @see Utilisateur#calculerEmpreinte
	 * @return l'impact total de la population
	 */

	public double calculerEmpreinte() {
		double impactTotal = 0;
		for (Utilisateur u : listPopulation) {
			impactTotal += u.calculerEmpreinte();         
		}
		return impactTotal;       
	}

	/**
	 * Methode calculant l'empreinte alimentaire de toute la population
	 * @return l'impact alimentaire de la population
	 */

	public double calculerEmpreinteAlim() {
		double impactA = 0;
		for (Utilisateur u : listPopulation) {
			impactA += u.getAlimentation().getImpact();
		}
		return impactA;   
	}

	/**
	 * Methode calculant l'empreinte de tous les logements de toute la population
	 * @return l'impact des logements de la population
	 */

	public double calculerEmpreinteLog() {
		double impactL = 0;
		for (Utilisateur u : listPopulation) {
			impactL += u.getLogement().getImpact();
		}
		return impactL;    
	}

	/**
	 * Methode calculant l'empreinte bien consommateur de toute la population
	 * @return l'impact bien consommateur de la population
	 */

	public double calculerEmpreinteBienC() {
		double impactB = 0;
		for (Utilisateur u : listPopulation) {
			impactB += u.getBienConso().getImpact();
		}
		return impactB;    
	}

	/**
	 * Methode calculant l'empreinte des mails de toute la population
	 * @return l'impact des mails de la population
	 */

	public double calculerEmpreinteMail() {
		double impactM = 0;
		for (Utilisateur u : listPopulation) {
			impactM += u.getMail().getImpact();
		}
		return impactM;  
	}

	/**
	 * Methode calculant l'empreinte de tous les transports de toute la population
	 * @return l'impact transport de la population
	 */

	public double calculerEmpreinteTrans() {
		double impactT= 0;
		for (Utilisateur u : listPopulation) {
			impactT += u.getTransport().getImpact();
		}
		return impactT;    
	}

	/**
	 * Methode conseillant la population. Les constantes representent l'impact de chaque poste moyen d'un francais multiplie par le nombre d'utilisateur. Cela nous permet de trouver les valeurs moyenne pour une population du meme nombre de notre population. Si l'empreinte d'un poste de notre population est superieur a celui de la population moyenne alors on renvoit un conseil
	 */

	public void conseilEmpreintePop( ) {
		double cA = 2.353*this.nb;
		double cL = 2.706*this.nb;
		double cB = 2.625*this.nb;
		double cM = 2.5*this.nb;
		double cT = 2.920*this.nb;


		if (this.calculerEmpreinteAlim()> cA) System.out.println("Nous vous conseillions d'essayer la simulation qui reduit les taux de repas aux boeufs, pour reduire l'impact alimentaite");
		if (this.calculerEmpreinteBienC() > cB) System.out.println("Nous vous conseillions d'essayer la simulation qui diminue le montant des depenses de votre population");
		if(this.calculerEmpreinteMail() > cM) System.out.println("Nous vous conseillions d'essayer la simulation qui simule la suppression de mail");
		if (this.calculerEmpreinteLog()> cL) System.out.println("Nous vous conseillions d'essayer la simulation qui baisse d'une classe, la classe energetique pour chaque logement de vos utilisateur");
		if (this.calculerEmpreinteTrans() > cT) System.out.println("Nous vous conseillions d'essayer la simulation qui fait baisser le nombre de voiture de certain de vos utilisateur");
	}

	/**
	 * Reecriture de la methode clone de la classe Object pour cloner une population
	 */

	@Override
	public Object clone(){

		Population p = new Population();
		p.nb = this.nb;
		p.listPopulation = new ArrayList<Utilisateur>();
		for (Utilisateur u: listPopulation) {
			p.addUser((Utilisateur)u.clone());
		}
		return p;


	}
}

