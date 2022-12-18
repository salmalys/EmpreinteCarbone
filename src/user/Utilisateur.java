package user;
import consocarbone.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utilisateur {
  private Alimentation alimentation;
  private BienConso bienConso;
  private Logement logement;
  private Mail mail;
  private Transport transport;
  private ServicesPublics services;
  
  private ArrayList<Logement> logements;
  private ArrayList<Transport> transports;
  
  private ArrayList<ConsoCarbone> listCons;
  
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
  
  public Alimentation getAlimentation() {return alimentation;}
  public void setAlimentation(Alimentation alimentation) {this.alimentation = alimentation;}
	
  public BienConso getBienConso() {return bienConso;}
  public void setBienConso(BienConso bienConso) {this.bienConso = bienConso;}
	
  public Mail getMail() {return mail;}
  public void setMail(Mail mails) {this.mail= mails;}
	
  public ArrayList<Logement> getLogements() {return logements;}
  public void setLogements(ArrayList<Logement> logements) {this.logements = logements;}
	
  public ArrayList<Transport> getTransports() {return transports;}
  public void setTransport(ArrayList<Transport> transports) {this.transports = transports;}
	
  public ServicesPublics getServices() {return services;}
  public void setServices(ServicesPublics services) {this.services = services;}
	
	
  public Logement getLogement() {return logement;}
  
  public void setLogement() {
	  logement = new Logement();
	  double impactLog = 0;
	  for (Logement l : this.logements) {
			 impactLog += l.getImpact();
		 }
	  logement.setCe(null);
	  logement.setSuperficie(0);
	  logement.setImpact(impactLog);
	}
	 
	 
	public Transport getTransport() {return transport;}
	
	public void setTransport() {
		 transport = new Transport();
		 double impactTransport = 0;
		 for (Transport t : this.transports) {
			 impactTransport += t.getImpact();
		 }
		 transport.setImpact(impactTransport);
	}
	 
	 
	public List<ConsoCarbone> getListCons() {return listCons;}
	
	public void setListCons() {
		listCons = new ArrayList<ConsoCarbone>();
		listCons.add(this.alimentation);
		listCons.add(this.bienConso);
		listCons.add(this.mail);
		listCons.add(this.services);
		listCons.add(this.logement);
		listCons.add(this.transport);
	}
  
  public ArrayList<ConsoCarbone> ordonne(){
	  Collections.sort(listCons);
	  
	  for (ConsoCarbone c: listCons) {
		  c.toString();
	  }
	  return listCons;
  }
  
  public double calculerEmpreinte() {
	  int impactTotal = 0;
	  for(ConsoCarbone c: listCons) {
		  impactTotal += c.calculEmpreinte();
	  }
	  return impactTotal;
  }
  
 //a modifier methode generique
  public void detaillerEmpreinte() {
	  for (ConsoCarbone c: listCons) {
		  System.out.println(c.toString());
	  }
	  /*System.out.println(alimentation.toString());
	  System.out.println(bienConso.toString());
	  System.out.println(logement.toString());
	  System.out.println(transport.toString());
	  System.out.println(services.toString());*/
  }
  
  public void conseilEmpreinte( ) {
	  //instancier un Utilisateur: utilisateur moyen 
	  
	  if (this.alimentation.getImpact() > 2.353 ) System.out.println("Nous vous conseillions de reduire votre impact alimentaire, vous pouvez par exemple reduire vos repas a base de boeuf");
	  if (this.bienConso.getImpact() > 2.625) System.out.println("Nous vous conseillions de reduire votre impact de bien consommateur, par exemple en essayant de moins depenser dans la consomation rapide");
	  if(this.mail.getImpact() > 2.5) System.out.println("Nous vous conseillions de supprimer vos mails et d'envoyer seulement les mails necessaire");
	  if (this.logement.getImpact() > 2.706) System.out.println("Nous vous conseillions de reduire votre impact de logement, par exemple en essaynt de faire baisser la classe ernegetique de votre logement"); 
	  if (this.transport.getImpact() > 2.920) System.out.println("Nous vous conseillions de reduire votre impact de transport, par exemple en achetant une voiture electrique, ou plus recente, ou seulement diminuer vos deplacements quotidients en voiture");
  }
  
  @Override
  public Object clone() {
		try {
			Utilisateur u = (Utilisateur) super.clone();
			u.listCons = new ArrayList<ConsoCarbone>(this.listCons);
			return u;
		}
		catch (CloneNotSupportedException e){
			throw new InternalError();
		}
  }
  
}
