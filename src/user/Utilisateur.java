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
  private List<ConsoCarbone> listCons;
  
  public Utilisateur() {
    
  }
  
  
  //instancir un nv logement avec la somme des impacts de tous les logements 
  
  public List<ConsoCarbone> init(List<ConsoCarbone> listConso){
	  listCons = new ArrayList<ConsoCarbone>();
	  listCons.add(this.alimentation);
	  listCons.add(this.bienConso);
	  listCons.add(this.logement);
	  listCons.add(this.transport);
	  listCons.add(this.services);
	  return listCons;
  }
  
  public void ordonne(List<ConsoCarbone> listCons){
	  Collections.sort(listCons);
  }
  
  //essayer de faire d'une autre maniere
  
  public double calculerEmpreinte() {
	  /*
	  
	  int impactTotal = 0;
	  for(pc: lisCons) {
		  impactTotal += pc.getImpact();
	  }*/
	  double impactTotal = alimentation.getImpact() + bienConso.getImpact() + logement.getImpact() + transport.getImpact() + services.getImpact();
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
