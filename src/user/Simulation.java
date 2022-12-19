package user;
import consocarbone.*;

public class Simulation {
	//classe avec des methodes statiques pour les simulations
	
	
	  public static double reducVoit(Population population, double tauxPourc) {
	  Population popuSimule = (Population)population.clone(); double impactAvant =
	  popuSimule.calculerEmpreinte();
	  
	  double n = popuSimule.getNb()*tauxPourc;
	  int i = 0;
	  for (Utilisateur u : popuSimule.getListPopulation()) {
		  if (i<n) {
			  Transport t = u.getTransport();
			  t.setpossede(false);
		  }
		  else {
			  break;
		  } 
		 } 
	  double impactApres = popuSimule.calculerEmpreinte();
		
	  return ((impactApres-impactAvant)/impactAvant)*100;
	  }
	 
	
	public static double reducNbMail(Population population, int nbMailSupp) {
		Population popuSimule = (Population)population.clone();
		double impactAvant = popuSimule.calculerEmpreinte();
		
		for (Utilisateur u : popuSimule.getListPopulation()) {
			Mail m = u.getMail();
			int nbmInit = m.getNbMailStock();
			if (nbmInit<nbMailSupp) {
				m.setNbMailStock(0);
			}
			else {
				m.setNbMailStock(nbmInit-nbMailSupp);
			}
		}
		double impactApres = popuSimule.calculerEmpreinte();
		
		return ((impactApres-impactAvant)/impactAvant)*100;
	}
	
	public static double reducTauxBoeuf(Population population, double tauxBoeufReduc) {
		Population popuSimule = (Population)population.clone();
		double impactAvant = popuSimule.calculerEmpreinte();
		
		for (Utilisateur u : popuSimule.getListPopulation()) {
			Alimentation a = u.getAlimentation();
			double tx = a.gettxBoeuf()*tauxBoeufReduc;
			a.settxBoeuf(tx);
		}
		double impactApres = popuSimule.calculerEmpreinte();
		
		return ((impactApres-impactAvant)/impactAvant)*100;
	}
	
	
	public static double reducTauxDepense(Population population, double tauxReduc) {
		Population popuSimule = (Population)population.clone();
		double impactAvant = popuSimule.calculerEmpreinte();
		
		for (Utilisateur u : popuSimule.getListPopulation()) {
			BienConso b = u.getBienConso();
			double montantReduc = b.getMontant()*tauxReduc;
			b.setMontant(montantReduc);
		}
		double impactApres = popuSimule.calculerEmpreinte();
		
		return ((impactApres-impactAvant)/impactAvant)*100;
	}
	
}
