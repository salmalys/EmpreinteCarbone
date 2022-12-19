package user;
import consocarbone.*;
import java.util.ArrayList;

public class Simulation {
	//classe avec des methodes statiques pour les simulations
	
	
	  public static double reducVoit(Population population, double tauxPourc) {
	  Population popuSimule = (Population)population.clone(); 
	  double impactAvant = popuSimule.calculerEmpreinte();
	  
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
		
	  return ((impactAvant-impactApres)/impactAvant)*100;
	  }
	  
	  public static double reducCE(Population population) {
			Population popuSimule = (Population)population.clone();
			double impactAvant = popuSimule.calculerEmpreinte();
			
			for (Utilisateur u : popuSimule.getListPopulation()) {
				ArrayList<Logement> listLog = u.getLogements();
				for (Logement l: listLog) {
					if (l.getCe() == CE.B) l.setCe(CE.A);
					if (l.getCe() == CE.C) l.setCe(CE.B);
					if (l.getCe() == CE.D) l.setCe(CE.C);
					if (l.getCe() == CE.E) l.setCe(CE.D);
					if (l.getCe() == CE.F) l.setCe(CE.E);
					if (l.getCe() == CE.G) l.setCe(CE.F);
				}
				//Logement A faire
				//setLogement();
			}
			double impactApres = popuSimule.calculerEmpreinte();
			
			return ((impactAvant-impactApres)/impactAvant)*100;
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
		
		return ((impactAvant-impactApres)/impactAvant)*100;
	}
	
	public static double reducTauxBoeuf(Population population, double tauxBoeufReduc) {
		Population popuSimule = (Population)population.clone();
		double impactAvant = popuSimule.calculerEmpreinte();
		
		System.out.println("impact avant de pop simule"+impactAvant);
		
		for (Utilisateur u : popuSimule.getListPopulation()) {
			Alimentation a = u.getAlimentation();
			System.out.println(a.gettxBoeuf());
			double tx = a.gettxBoeuf()*tauxBoeufReduc;
			a.settxBoeuf(tx);
			System.out.println(a.gettxBoeuf());
			
		}
		System.out.println("impact de pop de base"+population.calculerEmpreinte());
		double impactApres = popuSimule.calculerEmpreinte();
		System.out.println("impact apres de pop simule"+impactApres);
		
		return ((impactAvant-impactApres)/impactAvant)*100;
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
