package user;
import consocarbone.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * La classe utilisateur permet de creer un nouvel utilisateur avec ses impacts pour chaque poste.
 */

public class Utilisateur implements Cloneable{
	private Alimentation alimentation;
	private BienConso bienConso;
	private Logement logement;
	private Mail mail;
	private Transport transport;
	private ServicesPublics services;

	private ArrayList<Logement> logements;
	private ArrayList<Transport> transports;

	private ArrayList<ConsoCarbone> listCons;

	/**
	 * Constructeur par defaut, il met a null chaque attribut de la classe
	 */

	public Utilisateur() {
		this.alimentation = null;
		this.bienConso = null;
		this.transport = null;
		this.logement = null;
		this.mail = null;
		this.services = null;

		this.logements = null;
		this.transports = null;

		this.listCons = null;

	}

	/**
	 * Constructeur de la classe Utilisateur qui instancie chaque poste 
	 * @param postes : liste des postes de l'utilisateur que l'on veut instancier
	 */


	public Utilisateur(ArrayList<ConsoCarbone> postes) {
		logements = new ArrayList<Logement>();
		transports = new ArrayList<Transport>();

		for (ConsoCarbone c: postes) {
			if (c instanceof Alimentation) alimentation = (Alimentation) c;
			if (c instanceof BienConso) bienConso = (BienConso) c;
			if (c instanceof Mail) mail = (Mail) c;
			if (c instanceof Logement) logements.add((Logement)c);
			if (c instanceof Transport) transports.add((Transport)c);		  
		}

		services = ServicesPublics.getInstance();
		setLogement();
		setTransport();
		setListCons();
	}

	/**
	 * Getter de l'alimentation
	 * @return l'alimentation de cet utilisateur
	 */

	public Alimentation getAlimentation() {return alimentation;}

	/**
	 * Setter de l'objet alimentation
	 * @param alimentation
	 */

	public void setAlimentation(Alimentation alimentation) {this.alimentation = alimentation;}

	/**
	 * Getter du bien consomatteur 
	 * @return le bien consomatteur de cet utilisateur
	 */

	public BienConso getBienConso() {return bienConso;}

	/**
	 * Setter du bien consommateur
	 * @param bienConso
	 */

	public void setBienConso(BienConso bienConso) {this.bienConso = bienConso;}

	/**
	 * Getter des mails de cet utilisateur
	 * @return l'objet mail 
	 */

	public Mail getMail() {return mail;}

	/**
	 * Setter de l'objet mail de cet utilisateur
	 * @param mails
	 */

	public void setMail(Mail mails) {this.mail= mails;}

	/**
	 * Getter de la liste de logement de cet utilisateur
	 * @return logement
	 */

	public ArrayList<Logement> getLogements() {return logements;}

	/**
	 * Setter de la liste des logements de l'utilisateur
	 * @param logements
	 */

	public void setLogements(ArrayList<Logement> logements) {this.logements = logements;}

	/**
	 * Getter de la liste de transport
	 * @return transport
	 */

	public ArrayList<Transport> getTransports() {return transports;}

	/**
	 * Setter de la liste des transports de l'utilisateur
	 * @param transports
	 */

	public void setTransport(ArrayList<Transport> transports) {this.transports = transports;}

	/**
	 * Getter des services publics
	 * @return l'objet des services publics
	 */

	public ServicesPublics getServices() {return services;}

	/**
	 * Setter des services publics
	 * @param services
	 */

	public void setServices(ServicesPublics services) {this.services = services;}

	/**
	 * Getter de l'objet logement
	 * @return le logement
	 */

	public Logement getLogement() {return logement;}

	/**
	 * Setter de l'objet logement qui somme les impacts de tous les logements de cet utilisateur.
	 */
	public void setLogement() {
		logement = new Logement();
		double impactLog = 0;
		for (Logement l : this.logements) {
			impactLog += l.getImpact();
		}
		//logement.setCe(null);
		//logement.setSuperficie(0);
		logement.setImpact(impactLog);
	}

	/**
	 * Getter de l'objet transport
	 * @return
	 */

	public Transport getTransport() {return transport;}

	/**
	 * Setter de l'objet transport qui somme l'impact de chaque transport de l'utilisateur
	 */

	public void setTransport() {
		transport = new Transport();
		double impactTransport = 0;
		for (Transport t : this.transports) {
			impactTransport += t.getImpact();
		}
		transport.setImpact(impactTransport);
	}

	/**
	 * Methode retournant la liste des postes de l'utilisateur 
	 * @return
	 */
	public List<ConsoCarbone> getListCons() {return listCons;}

	/**
	 * Setter de la liste des poste qui les ajoute tous a la liste de consoCarbone
	 */

	public void setListCons() {
		listCons = new ArrayList<ConsoCarbone>();
		listCons.add(this.alimentation);
		listCons.add(this.bienConso);
		listCons.add(this.mail);
		listCons.add(this.services);
		listCons.add(this.logement);
		listCons.add(this.transport);
	}

	/**
	 * La methode ordonne trie tous les impacts de l'utilisateur par ordre croissant 
	 * @return
	 */

	public ArrayList<ConsoCarbone> ordonne(){
		Collections.sort(listCons);

		for (ConsoCarbone c: listCons) {
			c.toString();
		}
		return listCons;
	}

	/**
	 * Calcule l'empreinte de l'utilisateur en fonction des impact de tous ses postes
	 * @return l'impact total
	 */

	public double calculerEmpreinte() {
		int impactTotal = 0;
		for(ConsoCarbone c: listCons) {
			impactTotal += c.getImpact();
		}
		return impactTotal;
	}

	/**
	 * Affiche sur la console l'empreinte de l'utilisateur en detaillant l'impact de chaque poste
	 */

	public void detaillerEmpreinte() {
		for (ConsoCarbone c: listCons) {
			System.out.println(c.toString());
		}
	}

	/**
	 * Conseille l'utilisateur en fonction de son impact par poste compare a l'impact d'un francais moyen.
	 * Afficher a l'ecran nos conseils pour les postes pour lesquels il a un impact superieur a un francais moyen.
	 */

	public void conseilEmpreinte( ) {
		double cA = 2.353;
		double cL = 2.706;
		double cB = 2.625;
		double cM = 2.5;
		double cT = 2.920;
		System.out.println("\nNous avons compare votre empreinte carbonne a celle d'un francais moyen");
		System.out.println("Voici quelques recommendations pour chaque poste de consommation.\n");

		if (this.alimentation.getImpact()>cA) System.out.println("Poste Alimentation:\nNous vous conseillions de reduire votre impact alimentaire, vous pouvez par exemple reduire vos repas a base de boeuf\n");
		if (this.bienConso.getImpact()>cB) System.out.println("Poste BienConso:\nNous vous conseillions de reduire votre impact de bien consommateur, par exemple en essayant de moins depenser dans la consommation rapide\n");
		if(this.mail.getImpact()>cM) System.out.println("Poste Mail:\nNous vous conseillions de supprimer vos mails\n");
		if (this.logement.getImpact()>cL) System.out.println("Poste Logement:\nNous vous conseillions de reduire votre impact de logement, par exemple en essaynt de faire baisser la classe ernegetique de votre logement\n"); 
		if (this.transport.getImpact()>cT) System.out.println("Poste Transport:\nNous vous conseillions de reduire votre impact de transport, par exemple en utilisant un velo\n");
	}

	/**
	 * Reecriture de la methode clone de la classe Object. 
	 * On veut clone un utilisateur, on clone donc chaque poste de consommation, en appellant les methodes clone de chaque poste
	 * @throws InternnalError()
	 */

	@Override
	public Object clone() {
		try {
			Utilisateur u = (Utilisateur)super.clone();
			u.alimentation = (Alimentation) alimentation.clone();
			u.logement = (Logement) logement.clone();
			u.bienConso = (BienConso) bienConso.clone();
			u.mail = (Mail) mail.clone();
			u.transport = (Transport) transport.clone();

			u.services = ServicesPublics.getInstance();
			u.setLogement();
			u.setTransport();
			u.setListCons();
			return u; 
		}
		catch (CloneNotSupportedException e){
			throw new InternalError();
		}



	}

}
