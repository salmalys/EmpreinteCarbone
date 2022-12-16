package user;
import consocarbone.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
  
  public Utilisateur() {}
  
  public Utilisateur(ArrayList<String> tab) {
	  alimentation = new Alimentation();
	  bienConso = new BienConso();
	  mails = new Mail();
	  services = ServicesPublics.getInstance();
	  logements = new ArrayList<Logement>();
	  transports = new ArrayList<Transport>();
	  
	    int i = 0;
		int nbLogement = 0;
		int nbTransport = 0;
		
		Iterator<String> l =  tab.iterator();
		while(l.hasNext()){
			//logement
			if (i == 0) {
				nbLogement = Integer.parseInt(l.next());
				for (int j = 0; j<nbLogement; j++) {
					Logement log = new Logement();
					log.setSuperficie(Integer.parseInt(l.next()));
					log.setCe(CE.valueOf(l.next()));
					i += 2;
					logements.add(log);
				}
			}
			//alimentation
			if(i == nbLogement*2 +1) {
				alimentation.settxBoeuf(Double.parseDouble(l.next()));
				alimentation.settxVege(Double.parseDouble(l.next()));
				i += 2;
			}
			if(i == nbLogement*2 +3) {
				bienConso.setMontant(Integer.parseInt(l.next()));
				i++;
			}
			
			if (i == nbLogement*2 +4){
				mails.setNbMailEnv(Integer.parseInt(l.next()));
				mails.setNbMailStock(Integer.parseInt(l.next()));
				i+=2;
			}
			
			if(i == nbLogement*2 +6) {
				nbTransport = Integer.parseInt(l.next());
				for (int j = 0; j<nbTransport; j++) {
					Transport t = new Transport();
					t.setTaille(Taille.valueOf(l.next()));
					t.setAmortissement(Integer.parseInt(l.next()));
					t.setKm(Integer.parseInt(l.next()));
					i += 2;
					transports.add(t);
				}
			}
		}
		setLogement();
		setTransport();
  }
  
  public Utilisateur(ConsoCarbone ... postes) {
	  logements = new ArrayList<Logement>();
	  transports = new ArrayList<Transport>();
	  for (int i = 0; i<postes.length; i++) {
		  if (postes[i] instanceof Alimentation) alimentation = (Alimentation) postes[i];
		  if (postes[i] instanceof ServicesPublics) services = (ServicesPublics) postes[i];
		  if (postes[i] instanceof BienConso) bienConso = (BienConso) postes[i];
		  if (postes[i] instanceof Mail) mails = (Mails) postes[i];
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
	
  public Mail getMail() {return mails;}
  public void setMail(Mail mails) {this.mails= mails;}
	
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
		listCons.add(this.mails);
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
	  
	  if (this.alimentation.getImpact() > 2.353 ) System.out.println("Nous vous conseillions de reduire votre impact alimentaire, vous pouvez par exemple reduire vos repas a base de boeuf");
	  if (this.bienConso.getImpact() > 2.625) System.out.println("Nous vous conseillions de reduire votre impact de bien consommateur, par exemple en essayant de moins depenser dans la consomation rapide");
	  if(this.mails.getImpact() > 2.5) System.out.println("Nous vous conseillions de supprimer vos mails et d'envoyer seulement les mails necessaire");
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
