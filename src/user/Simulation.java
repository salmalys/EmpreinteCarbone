package user;
import consocarbone.*;

public class Simulation {
	//classe avec des methodes statiques pour les simulations
	
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
