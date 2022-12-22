package user;
import consocarbone.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * un utilisateur est defini par ses postes de consommation
 */

public class Utilisateur implements Cloneable{
	private Alimentation alimentation;
	private BienConso bienConso;
	private Mail mail;
	private ServicesPublics services;
	
	/**
	 * poste logement construit a partir d'une liste
	 */
	private Logement logement;
	
	/**
	 * poste Transport construit a partir d'une liste
	 */
	private Transport transport;
	
	/**
	 * liste de logements 
	 */
	private ArrayList<Logement> logements;
	
	/**
	 * liste de transports
	 */
	private ArrayList<Transport> transports;

	/**
	 * liste contenant tous chacun des 6 postes 
	 */
	private ArrayList<ConsoCarbone> listCons;

	/**
	 * Constructeur par defaut
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
	 * Constructeur de la classe Utilisateur a partir d'une liste de postes 
	 * @param postes liste des postes 
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
	 * @param alimentation objet alimentation
	 */

	public void setAlimentation(Alimentation alimentation) {this.alimentation = alimentation;}

	/**
	 * Getter du bien consomatteur 
	 * @return le bien consomatteur de cet utilisateur
	 */

	public BienConso getBienConso() {return bienConso;}

	/**
	 * Setter du bien consommateur
	 * @param bienConso objet bien conso
	 */

	public void setBienConso(BienConso bienConso) {this.bienConso = bienConso;}

	/**
	 * Getter des mails de cet utilisateur
	 * @return l'objet mail 
	 */

	public Mail getMail() {return mail;}

	/**
	 * Setter de l'objet mail de cet utilisateur
	 * @param mails objet mail
	 */

	public void setMail(Mail mails) {this.mail= mails;}

	/**
	 * Getter de la liste de logement de cet utilisateur
	 * @return logement objet logement
	 */

	public ArrayList<Logement> getLogements() {return logements;}

	/**
	 * Setter de la liste des logements de l'utilisateur
	 * @param logements nouveau logement initialise
	 */

	public void setLogements(ArrayList<Logement> logements) {this.logements = logements;}

	/**
	 * Getter de la liste de transport
	 * @return transport 
	 */

	public ArrayList<Transport> getTransports() {return transports;}

	/**
	 * Setter de la liste des transports de l'utilisateur
	 * @param transports objet transport
	 */

	public void setTransport(ArrayList<Transport> transports) {this.transports = transports;}

	/**
	 * Getter des services publics
	 * @return l'objet des services publics
	 */

	public ServicesPublics getServices() {return services;}

	/**
	 * Setter des services publics
	 * @param services objet services
	 */

	public void setServices(ServicesPublics services) {this.services = services;}

	/**
	 * Getter de l'objet logement
	 * @return le logement
	 */

	public Logement getLogement() {return logement;}

	/**
	 * Setter de l'objet logement impact sette en sommant les impacts de tous les logements dans la liste logements
	 */
	
	public void setLogement() {
		logement = new Logement();
		double impactLog = 0;
		for (Logement l : this.logements) {
			impactLog += l.getImpact();
		}
		logement.setImpact(impactLog);
	}

	/**
	 * Getter de l'objet transport
	 * @return l'objet transport
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
	 * Getter de l'objet listCons
	 * @return la liste des 6 postes de consommation
	 */
	public List<ConsoCarbone> getListCons() {return listCons;}

	/**
	 * alimente la liste des postes a partir des postes de l'utilisateur
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
	 * Trie dans l'odre croissant la liste des postes selon leur impacts
	 */
	public void ordonne(){Collections.sort(listCons);}

	
	/**
	 * Calcule l'impact totale de l'utilisateur en sommant les impacts de tous ses postes
	 * @return l'empreinte carbonne totale
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
	 * Afficher a l'ecran nos conseils pour les postes pour lesquels l'impact est superieur a la moyenne.
	 */
	public void conseilEmpreinte( ) {
		double cA = 2.353;
		double cL = 2.706;
		double cB = 2.625;
		double cM = 2.5;
		double cT = 2.920;
		System.out.println("\nNous avons compare votre empreinte carbonne a celle d'un francais moyen");
		System.out.println("Voici quelques recommendations pour les postes  de consommation pour lesquels votre empreinte est superieur a la moyennne\n");

		if (this.alimentation.getImpact()>cA) System.out.println("Poste Alimentation:\nReduisez votre impact alimentaire, vous pouvez par exemple diminuer vos repas a base de boeuf\n");
		if (this.bienConso.getImpact()>cB) System.out.println("Poste BienConso:\nReduisez votre impact des biens depenses, par exemple en essayant de moins depenser dans la consommation rapide\n");
		if(this.mail.getImpact()>cM) System.out.println("Poste Mail:\nReduisez l'impact de vos mails, nous vous conseillions de supprimer vos mails stockes inutiles\n");
		if (this.logement.getImpact()>cL) System.out.println("Poste Logement:\nReduisez l'impact de vos logements, par exemple investissez en isolation pour baisser la classe ernegetique de votre(vos) logement(s)\n"); 
		if (this.transport.getImpact()>cT) System.out.println("Poste Transport:\nReduisez l'impact de vos vehicules, par exemple en utilisant d'autres moyens de transport comme le velo\n");
	}

	/**
	 * Reecriture de la methode clone de la classe Object. 
	 * chaque poste de consommation est clonees (sauf services)
	 */
	@Override
	public Object clone() {
		try {
			Utilisateur u = (Utilisateur)super.clone();
			u.alimentation = (Alimentation) this.alimentation.clone();
			u.bienConso = (BienConso) this.bienConso.clone();
			u.mail = (Mail) this.mail.clone();
			u.services = ServicesPublics.getInstance();
			
			u.logements = new ArrayList<Logement>();
			for (Logement l: this.logements) {
				u.logements.add((Logement)l.clone());
			}
			
			u.transports = new ArrayList<Transport>();
			for (Transport t: this.transports) {
				u.transports.add((Transport)t.clone());
			}
			
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
