package user;
import consocarbone.*;
//import java.util.ArrayList;
//import java.util.List; 

public class Utilisateur  {
  Alimentation alimentation;
  BienConso bienConso;
  Logement logement;
  Transport transport;
  ServicesPublics services;
  
  public Utilisateur() {}
     /*List<ConsoCarbone> listCons = new ArrayList<ConsoCarbone>();
     listCons.add(new Alimentation(0.6,0.4));*/
     
  
  
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
	  System.out.println(alimentation.toString());
	  System.out.println(bienConso.toString());
	  System.out.println(logement.toString());
	  System.out.println(transport.toString());
	  System.out.println(services.toString());
  }
  
  public void ordonneEmpreinte( ) {}
  
}
