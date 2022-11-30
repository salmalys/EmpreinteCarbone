package user;
import consocarbone.*;
//import java.util.ArrayList;
 
public class Utilisateur  {
  Alimentation alimentation;
  BienConso bienConso;
  Logement logement;
  Transport transport;
  ServicesPublics services;
  
  public Utilisateur() {}
  
  //essayer de faire d'une autre maniere
  
  public double calculerEmpreinte() {
	  /*List<ConsoCarbone> lisCons;
	  
	  
	  int impactTotal = 0;
	  for(pc: lisCons) {
		  impactTotal += pc.getImpact();
	  }*/
	  double impactTotal = alimentation.getImpact() + bienConso.getImpact() + logement.getImpact() + transport.getImpact() + services.getImpact();
	  return impactTotal;
  }
  
 //a modifier methode generique
  
  public void detaillerEmpreinte() {
	  System.out.println(alimentation.toString());
	  System.out.println(bienConso.toString());
	  System.out.println(logement.toString());
	  System.out.println(transport.toString());
	  System.out.println(services.toString());
  }
  
}
