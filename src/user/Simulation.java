package user;
import consocarbone.*;
import java.util.ArrayList;

/**
 * simulation de mesures politiques sur une population donnee 
 */

public class Simulation {
	
	/**
	 * Reduire les depenses en biens 
	 * @param tauxReduc taux de reduction a applique sur les depenses en biens de chaque utilisateur 
	 * @param population population a modifier 
	 * @return diminution en pourcentage de l'impact
	 */

	public static double reducTauxDepense(Population population, double tauxReduc) {
		double impactAvant = population.calculerEmpreinte();

		for (Utilisateur u : population.getListPopulation()) {
			BienConso b = u.getBienConso();
			double montantReduc = b.getMontant()*tauxReduc;
			b.setMontant(montantReduc);
		}
		double impactApres = population.calculerEmpreinte();
		System.out.println("Impact apres la simulation: "+impactApres+" TCO2/an\n");

		return ((impactAvant-impactApres)/impactAvant)*100;
	}

	/**
	 * Reduire la classe energetique des logements d'un niveau pour tous les logements des utilisateurs de la population 
	 * Si la classe energetique est deja A, aucune modification
	 * @param population population a modifier 
	 * @return diminution en pourcentage de l'impact 
	 */


	public static double reducCE(Population population) {
		double impactAvant = population.calculerEmpreinte();

		for (Utilisateur u : population.getListPopulation()) {
			ArrayList<Logement> listLog = u.getLogements();
			for (Logement l: listLog) {
				if (l.getCe() == CE.B) l.setCe(CE.A);
				if (l.getCe() == CE.C) l.setCe(CE.B);
				if (l.getCe() == CE.D) l.setCe(CE.C);
				if (l.getCe() == CE.E) l.setCe(CE.D);
				if (l.getCe() == CE.F) l.setCe(CE.E);
				if (l.getCe() == CE.G) l.setCe(CE.F);
			}
			u.setLogement();
			u.setListCons();
		}

		double impactApres = population.calculerEmpreinte();
		System.out.println("Impact apres la simulation: "+impactApres+" TCO2/an\n");
		return ((impactAvant-impactApres)/impactAvant)*100;
	}

	/**
	 * Reduire le nombre de mail stockes par chaque utilisateur 
	 * Si un utilisateur a moins de mail stocke que le nombre a supprimer, il n'aura aucun mail stockes.
	 * @param nbMailSupp nombre de mail a supprimer par utilisateur
	 * @param population population a modifier 
	 * @return diminution en pourcentage de l'impact
	 */

	public static double reducNbMail(Population population, int nbMailSupp) {
		double impactAvant = population.calculerEmpreinte();

		for (Utilisateur u : population.getListPopulation()) {
			Mail m = u.getMail();
			int nbmInit = m.getNbMailStock();
			if (nbmInit<nbMailSupp) {
				m.setNbMailStock(0);
			}
			else {
				m.setNbMailStock(nbmInit-nbMailSupp);
			}
		}

		double impactApres = population.calculerEmpreinte();
		System.out.println("Impact apres la simulation: "+impactApres+" TCO2/an\n");

		return ((impactAvant-impactApres)/impactAvant)*100;
	}

	/**
	 * Cette simulation permet de reduire le nombre de repas a base de boeuf dans notre population. 
	 * @param tauxBoeufReduc taux de reduction a applique sur le taux de repas a base de boeuf 
	 * @param population population a modifier 
	 * @return diminution en pourcentage de l'impact
	 */


	public static double reducTauxBoeuf(Population population, double tauxBoeufReduc) {
		double impactAvant = population.calculerEmpreinte();

		for (Utilisateur u : population.getListPopulation()) {
			Alimentation a = u.getAlimentation();
			double tx = a.gettxBoeuf()*tauxBoeufReduc;
			a.settxBoeuf(tx);
		}
		
		double impactApres = population.calculerEmpreinte();
		System.out.println("Impact apres la simulation: "+impactApres+" TCO2/an");

		return ((impactAvant-impactApres)/impactAvant)*100;
	}
	
	/**
	 * Reduire le nombre de personnes utilisant la voiture dans notre population. 
	 * @param population population a modifier 
	 * @param tauxPourc taux de personnes qui n'utiliseront plus de voiture
	 * @return diminution en pourcentage de l'impact 
	 */

	public static double reducVoit(Population population, double tauxPourc) {
		double impactAvant = population.calculerEmpreinte();
		double n = population.getNb()*tauxPourc;
		int i = 0;
		for (Utilisateur u : population.getListPopulation()) {
			if (i<n) {
				Transport t = u.getTransport();
				t.setpossede(false);
				u.setListCons();
				i++;
			}
			else break;
		} 
		double impactApres = population.calculerEmpreinte();
		System.out.println("Impact apres la simulation: "+impactApres+" TCO2/an\n");
		
		return ((impactAvant-impactApres)/impactAvant)*100;
	}

}
