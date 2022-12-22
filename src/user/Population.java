package user;
import java.util.ArrayList;

/**
 * Ensemble d'utilisateurs 
 */

public class Population implements Cloneable {
	private ArrayList<Utilisateur> listPopulation;
	private int nb;

	/**
	 * Constructeur de la classe Population instancie une liste d'utilisateur vide
	 */
	public Population() {listPopulation = new ArrayList<Utilisateur>();}

	/**
	 *  Constructeur de la classe population a partir d'une liste d'utilisateur creer une population
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
	 * Constructeur de la classe population a partir d'utilisateurs donnes
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
	 * Getter du nombre d'utilisateur
	 * @return le nombre d'utilisateur dans la population
	 */
	public int getNb() {return nb;}

	/**
	 * Methode permettant d'ajouter un utilisateur dans la population et incremente le nombre d'utilisateurs dans la population
	 * @param user utilisateur a ajouter
	 */
	public void addUser(Utilisateur user) {
		listPopulation.add(user);
		this.nb++;
	}

	/**
	 * Calcul l'empreinte totale de toute la population 
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
	 * Affiche des suggestions de simulation en comparant l'impact pour chaque poste a celui d'une population moyenne
	 */
	public void conseilEmpreintePop( ) {
		double cA = 2.353*this.nb;
		double cL = 2.706*this.nb;
		double cB = 2.625*this.nb;
		double cM = 2.5*this.nb;
		double cT = 2.920*this.nb;


		if (this.calculerEmpreinteAlim()> cA) System.out.println("Poste Alimentation:\nNous vous conseillions d'essayer la simulation qui reduit les taux de repas aux boeufs, pour reduire l'impact alimentaite");
		if (this.calculerEmpreinteBienC() > cB) System.out.println("Poste BienConso:\nNous vous conseillions d'essayer la simulation qui diminue le montant des depenses de votre population");
		if(this.calculerEmpreinteMail() > cM) System.out.println("Poste Mail:\nEssayez la simulation qui supprime un nombre de mails pour chacun de vos utilisateurs");
		if (this.calculerEmpreinteLog()> cL) System.out.println("Poste Logement:\nEssayez la simulation qui baisse d'un niveau la classe energetique pour tous les logements de la population");
		if (this.calculerEmpreinteTrans() > cT) System.out.println("Poste Transport:\nEssayez la simulation qui diminue le nombre de personnes utilisant la voiture.");
	}

	/**
	 * Reecriture de la methode clone de la classe Object pour cloner une population
	 */
	@Override
	public Object clone(){
		Population p = new Population();
		p.nb = this.nb;
		p.listPopulation = new ArrayList<Utilisateur>();
		
		for (Utilisateur u: listPopulation) 
			p.addUser((Utilisateur)u.clone());
		return p;
	}
}

