package user;
import consocarbone.*;

public class Simulation {
	//classe avec des methodes statiques pour les simulations
	
	/*
	 * public static double reducVoit(Population population, double tauxPourc) {
	 * Population popuSimule = (Population)population.clone(); double impactAvant =
	 * popuSimule.calculerEmpreinte();
	 * 
	 * int n = (popuSimule.getNb()*tauxPourc).intValue();
	 * 
	 * for (Utilisateur u : popuSimule.getListPopulation()) { Alimentation a =
	 * u.getAlimentation(); double tx = a.gettxBoeuf()*tauxBoeufReduc;
	 * a.settxBoeuf(tx); } }
	 */
	
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
