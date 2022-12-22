package consocarbone;
import tools.*;
import java.util.Scanner;
import user.*;
import java.util.ArrayList;

/**
 * Classe principale : Menu interactif et appels des methodes sur la Population ou l'Utilisateur 
 */
public class Main {

	/**
	 * Methode main qui en fonction de l'option choisie, 
	 * Cree une population a partir de fichiers textes, affiche l'impact totale et propose des simulations
	 * ou
	 * Cree un Utilisateur a partir des reponses au questionnaire, affiche l'empreinte carbonne pour chaque poste et fais des recommendations
	 * @param args arguments en ligne de commande
	 */

	public static void main(String[] args) {
		int option;
		Scanner sc = new Scanner(System.in);
		do {
			option = showMenu(sc);
			switch(option) {
			case 1:{
				System.out.println("\nChaque fichier doit contenir les informations d'un utilisateur");
				System.out.println("Format Chaque ligne doit correspondre a un poste de consommation\nexemple: NomPoste;nbPoste;att1;att2\n");
				System.out.println("Entrez la liste des fichiers (separees par des espaces):");
				String f = sc.nextLine();
				String[] filenames = f.split(" ");
				Population p = Traitement.readPop(filenames);
				System.out.println("\nEmpreinte carbonne totale de la population: "+p.calculerEmpreinte()+" TCO2/an\n");
				p.conseilEmpreintePop();
				String rep;
				do {
					testSimul(p,sc);
					System.out.println("Voulez-vous tester une autre simulation ?(y/n)");
					rep = sc.nextLine();
				}while(rep.equals("y"));
				
				break;
			}
			case 2:{
				ArrayList<ConsoCarbone> listPostes = Questionnaire.commencer(sc);
				Utilisateur u = new Utilisateur(listPostes);
				System.out.println("Voici le detail de votre empreinte carbone dans l'ordre croissant:");
				u.ordonne();
				u.detaillerEmpreinte();
				u.conseilEmpreinte();
				break;
			}
			case 3:
				System.out.println("Fin");
				System.exit(0);
				break;
			default:
				option = -1;
				System.out.println("Entrez une valeur valide");
			}
		}while(option == -1);
		System.out.println("Fin Menu");

		sc.close();
	}

	/**
	 * Affiche le menu principale sur la console 
	 * @param sc Scanner
	 * @return option choisi
	 */

	public static int showMenu(Scanner sc) {
		System.out.println("Choisissez une des options: (Entrez un nombre entre 1 et 3)");
		System.out.println("Choix 1: Calculer l'empreinte carbonne d'une population");
		System.out.println("Choix 2: Repondre a un questionnaire pour calculer sa propre empreinte");
		System.out.println("Choix 3: Quitter");

		int option = sc.nextInt();
		sc.nextLine();	

		return option;

	}

	/**
	 * Affiche le menu pour la simulation sur la console 
	 * @param sc Scanner 
	 * @return option de simulation choisi
	 */

	public static int showMenuSimulation(Scanner sc) {
		System.out.println("\nChoisissez une des options: (Entrez un nombre entre 1 et 6)");
		System.out.println("Choix 1: Simuler une baisse de depenses en biens de chaque utilisateur");
		System.out.println("Choix 2: Simuler une baisse du taux de repas a base de boeuf de chaque utilisateur");
		System.out.println("Choix 3: Simuler une baisse du nombre de mails stockes par utilisateur");
		System.out.println("Choix 4: Simuler une baisse du nombre de personnes se deplacant en voiture");
		System.out.println("Choix 5: Simuler une baisse d'un niveau de la classe energetique pour tous les logements");
		System.out.println("Choix 6: Quitter");

		int option = sc.nextInt();
		sc.nextLine();
		return option;
	}

	/**
	 * Effectue la simulation choisi par l'utilisateur affiche le resultat (baisse de l'impact) 
	 * @param population population sur laquelle on applique la simulation
	 * @param sc Scanner
	 */

	public static void testSimul(Population population, Scanner sc) {
		int optionSimul;
		Population p = (Population)population.clone();
		do {
			optionSimul = showMenuSimulation(sc);
			switch(optionSimul) {
			case 1:{
				System.out.println("\nEntrez le taux de baisse des depenses en bien a simule (valeur entre 0 et 1)");
				double t = Double.parseDouble(sc.nextLine());
				System.out.println("L'impact total de la population a ete baisse de "+Simulation.reducTauxDepense(p,t)+"%\n");
				break;
			}
			case 2:{
				System.out.println("\nEntrez le taux de baisse des repas a base de boeuf a simule (valeur entre 0 et 1)");
				double t = Double.parseDouble(sc.nextLine());
				System.out.println("L'impact total de la population a ete baisse de "+Simulation.reducTauxBoeuf(p,t)+"%\n");
				break;
			}
			case 3:{
				System.out.println("\nEntrez le nombre de mails stockes a supprimer pour chaque utilisateur");
				int t = Integer.parseInt(sc.nextLine());
				System.out.println("L'impact total de la population a ete baisse de "+Simulation.reducNbMail(p,t)+"%\n");
				break;
			}
			case 4:{
				System.out.println("\nEntrez le taux de personnes qui n'utiliserons plus leur voiture (valeur entre 0 et 1)");
				double t = Double.parseDouble(sc.nextLine());
				System.out.println("L'impact total de la population a ete baisse de "+Simulation.reducVoit(p,t)+"%\n");
				break;
			}
			case 5:{
				System.out.println("\nLa classe energetique de tous les logements a diminue d'un niveau");
				System.out.println("L'impact total de la population a ete baisse de "+Simulation.reducCE(p)+"%\n");
				break;
			}
			case 6:
				System.out.println("Fin");
				System.exit(0);
				break;
			default:
				optionSimul = -1;
				System.out.println("Entrez une valeur valide");
			}
		}while(optionSimul == -1);
		
	}

}
