package user;
import consocarbone.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	  //logement.setCe(null);
	  //logement.setSuperficie(0);
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
		  impactTotal += c.getImpact();
	  }
	  return impactTotal;
  }
  
  public void detaillerEmpreinte() {
	  for (ConsoCarbone c: listCons) {
		  System.out.println(c.toString());
	  }
  }
  
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
