package user;
import consocarbone.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utilisateur {
  private Alimentation alimentation;
  private BienConso bienConso;
  private Logement logement;
  private Transport transport;
  private ServicesPublics services;
  
  private ArrayList<Logement> logements;
  private ArrayList<Transport> transports;
  
  private ArrayList<ConsoCarbone> listCons;
  
  public Utilisateur() {}
  
  public Utilisateur(ConsoCarbone ... postes) {
	  logements = new ArrayList<Logement>();
	  transports = new ArrayList<Transport>();
	  for (int i = 0; i<postes.length; i++) {
		  if (postes[i] instanceof Alimentation) alimentation = (Alimentation) postes[i];
		  if (postes[i] instanceof ServicesPublics) services = (ServicesPublics) postes[i];
		  if (postes[i] instanceof BienConso) bienConso = (BienConso) postes[i];
		  if (postes[i] instanceof Logement) logements.add((Logement)postes[i]);
		  if (postes[i] instanceof Transport) transports.add((Transport)postes[i]);		  
	  }
	  setLogement();
	  setTransport();
  }
  
  public Alimentation getAlimentation() {return alimentation;}
  public void setAlimentation(Alimentation alimentation) {this.alimentation = alimentation;}
	
  public BienConso getBienConso() {return bienConso;}
  public void setBienConso(BienConso bienConso) {this.bienConso = bienConso;}
	
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
		listCons = null;
		listCons.add(this.alimentation);
		listCons.add(this.bienConso);
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
  
 //a modifier methode generique
  public void detaillerEmpreinte() {
	  for (ConsoCarbone c: listCons)
		  System.out.println(c.toString());
	  
	  /*System.out.println(alimentation.toString());
	  System.out.println(bienConso.toString());
	  System.out.println(logement.toString());
	  System.out.println(transport.toString());
	  System.out.println(services.toString());*/
  }
  
  public void conseilEmpreinte( ) {
	  //instancier un Utilisateur: utilisateur moyen 
	  
	  if (this.alimentation.getImpact() > 2.353 ) System.out.println("Nous vous conseillions de reduire votre impact alimentaire");
	  if (this.bienConso.getImpact() > 2.625) System.out.println("Nous vous conseillions de reduire votre impact de bien consommateur");
	  if (this.logement.getImpact() > 2.706) System.out.println("Nous vous conseillions de reduire votre impact de logement"); 
	  if (this.transport.getImpact() > 2.920) System.out.println("Nous vous conseillions de reduire votre impact de transport");
  }
  
}
