package consocarbone;
import tools.*;

import java.util.Scanner;

import user.*;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		int option;
		Scanner sc = new Scanner(System.in);
		do {
			option = showMenu(sc);
			switch(option) {
			case 1:{
				System.out.println("Chaque fichier doit contenir les informations d'un utilisateur");
				System.out.println("Format: Chaque ligne doit correspondre a un poste de consommation ");
				System.out.println("NomPoste;lalj,");
				System.out.println("Entrez la liste des fichiers: (separees par des espaces ");
				String f = sc.nextLine();
				String[] filenames = f.split(" ");
				Population p = Traitement.recupPop(filenames);
				System.out.println("Empreinte de la population"+p.calculerEmpreinte());
				testSimul(p,showMenuSimulation(sc),sc);
				break;
				}
			case 2:{
				ArrayList<ConsoCarbone> listPostes = Questionnaire.commencer(sc);
				Utilisateur u = new Utilisateur(listPostes);
				u.detaillerEmpreinte();
				break;
				}
			case 3:
				System.exit(0);
			default:
				option = -1;
				System.out.println("Entrez une valeur valide");
			}
		}while(option == -1);
		System.out.println("Fin menu");
		
		sc.close();
	}
	
	public static int showMenu(Scanner sc) {
		System.out.println("Choisissez une des options: (Entrez 1 ou 2)");
		System.out.println("Choix 1: Calculer l'empreinte carbonne d'une population");
		System.out.println("Choix 2: Repondre a un questionnaire pour calculer sa propre empreinte");
		System.out.println("Choix 3: Quitter");

		int option = sc.nextInt();
		sc.nextLine();
		return option;
		
	}
	
	public static int showMenuSimulation(Scanner sc) {
		System.out.println("Choisissez une des options: (Entrez 1 ou 2)");
		System.out.println("Choix 1: Simuler une baisse du taux de biens de consommation pour chaque utilisateur de la population");
		System.out.println("Choix 2: Simulation2");
		System.out.println("Choix 3: Quitter");

		int option = sc.nextInt();
		sc.nextLine();
		return option;
		
	}
	
	public static void testSimul(Population p, int optionSimul, Scanner sc) {
		switch(optionSimul) {
		case 1:{
			System.out.println("Entrez la baisse du taux de depense souhaite");
			double t = sc.nextDouble();
			System.out.println("L'impact totale de la population a été baissé de "+Simulation.reducTauxDepense(p,t));
			break;
		}
		case 2:{
			System.out.println("Entrez la baisse du taux de Boeuf souhaite");
			double t = sc.nextDouble();
			System.out.println("L'impact totale de la population a été baissé de "+Simulation.reducTauxDepense(p,t));
			break;
		}
		default:
			
		}
	}
	
}
