package consocarbone;
import tools.*;
import java.util.Scanner;
import user.*;
import java.util.ArrayList;

public class Main {

	/**
	 * Methode main qui en fonction de l'option choisie, 
	 * Cree une population a partir de fichiers textes, affiche l'impact totale et propose des simulations
	 * ou
	 * Cree un Utilisateur a partir des reponses au questionnaire, affiche l'empreinte carbonne pour chaque poste et fais des recommendations
	 * @param args
	 */

	public static void main(String[] args) {
		int option;
		Scanner sc = new Scanner(System.in);
		do {
			option = showMenu(sc);
			switch(option) {
			case 1:{
				System.out.println("\nChaque fichier doit contenir les informations d'un utilisateur");
				System.out.println("Format Chaque ligne doit correspondre a un poste de consommation\nexemple: NomPoste;nbPoste;att1;att2\\n");
				System.out.println("Entrez la liste des fichiers (separees par des espaces):");
				String f = sc.nextLine();
				String[] filenames = f.split(" ");
				Population p = Traitement.readPop(filenames);
				System.out.println("\nEmpreinte carbonne totale de la population: "+p.calculerEmpreinte()+"TCO2/an\n");
				p.conseilEmpreintePop();
				testSimul(p,showMenuSimulation(sc),sc);
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
		System.out.println("Choisissez une des options: (Entrez 1 ou 2)");
		System.out.println("Choix 1: Calculer l'empreinte carbonne d'une population");
		System.out.println("Choix 2: Repondre a un questionnaire pour calculer sa propre empreinte");
		System.out.println("Choix 3: Quitter");

		int option = sc.nextInt();
		sc.nextLine();	

		return option;

	}

	/**
	 * Affiche le menu pour la simulation sur la console 
	 * @param Scanner 
	 * @return option de simulation choisi
	 */

	public static int showMenuSimulation(Scanner sc) {
		System.out.println("\nChoisissez une des options: (Entrez un nombre entre 1 et 6)");
		System.out.println("Choix 1: Simuler une baisse du taux de bien conso.");
		System.out.println("Choix 2: Simuler une baisse du taux de boeufs pour chaque utilisateur de la population.");
		System.out.println("Choix 3: Simuler une baisse du nombre de mails stockes chaque utilisateur de la population.");
		System.out.println("Choix 4: Simuler une baisse du taux de personnes se deplacant en voiture.");
		System.out.println("Choix 5: Simuler une baisse de la classe energetique pour chaque utilisateur de la population.");
		System.out.println("Choix 6: Quitter");

		int option = sc.nextInt();
		sc.nextLine();
		return option;
	}

	/**
	 * Effectue la simulation choisi par l'utilisateur affiche le resultat (baisse de l'impact) 
	 * @param p population sur laquelle on applique la simulation
	 * @param optionSimul choix de la simulation 
	 * @param sc
	 */

	public static void testSimul(Population population, int optionSimul, Scanner sc) {
		Population p = (Population)population.clone();
		switch(optionSimul) {
		case 1:{
			System.out.println("\nEntrez la baisse du taux de depense souhaite");
			double t = Double.parseDouble(sc.nextLine());
			System.out.println("L'impact totale de la population a ete baisse de "+Simulation.reducTauxDepense(p,t)+"%\n");
			break;
		}
		case 2:{
			System.out.println("\nEntrez la baisse du taux de Boeuf souhaite");
			double t = Double.parseDouble(sc.nextLine());
			System.out.println("L'impact totale de la population a ete baisse de "+Simulation.reducTauxBoeuf(p,t)+"%\n");
			break;
		}
		case 3:{
			System.out.println("\nEntrez le nombre de mails stockes a supprimer");
			int t = Integer.parseInt(sc.nextLine());
			System.out.println("L'impact totale de la population a ete baisse de "+Simulation.reducNbMail(p,t)+"%\n");
			break;
		}
		case 4:{
			System.out.println("\nEntrez le taux de personnes qui n'utiliserons plus leur voiture.");
			double t = Double.parseDouble(sc.nextLine());
			System.out.println("L'impact totale de la population a ete baisse de "+Simulation.reducVoit(p,t)+"%\n");
			break;
		}
		case 5:{
			System.out.println("\nSimulation pour le logement:");
			System.out.println("L'impact totale de la population a ete baisse de "+Simulation.reducCE(p)+"%\n");
			break;
		}
		case 6:
			System.out.println("Fin");
			System.exit(0);
			break;
		default: System.out.println("La valeur entree n'est pas valide");
		}
	}

}
