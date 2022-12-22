package consocarbone;
import tools.*;
import java.util.Scanner;
import user.*;
import java.util.ArrayList;

/**
 * Classe Main qui prend en compte les differents choix de l'utilisateur et qui donne le detail de l'empreinte carbone et des recommendations pour l'utilisateur 
 *
 */

public class Main {

	/**
	 * Methode main qui en fonction du choix de l'utilisateur, detaille l'empreinte carbone puis conseil l'utilisateur et propose de tester des simulations pour aider a reduire l'impact carbone
	 * @param args ligne de commande, soit rien, soit le noms des fichiers
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
				System.out.println("Voici le detail de votre empreinte carbone:");
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
	 * Methode permettant de donner le choix a l'utilisateur entre calculer l'empreintre carbone d'une population grace a des fichiers, ou grace a un questionnaire
	 * @param sc : Reponse de l'utilisateur en ligne de commande
	 * @return le choix de l'utilisateur entre calculer l'empreintre d'une population a partir d'un fichier ou d'un questionnaire
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
	 * Methode permettant d'afficher les choix de simulation a l'utilisateur, puis recupere le choix de l'utilisateur
	 * @param sc ecrit sur la console
	 * @return Le choix de la simulation a tester
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
	 * Methode permettant de lancer la simulation choisi par l'utilisateur et de savoir l'effet de celle ci sur l'impact 
	 * @param p la population sur laquelle on va appliquer la simulation
	 * @param optionSimul Le choix de la simulation par l'utilisateur
	 * @param sc ecrit sur la console
	 */

	public static void testSimul(Population p, int optionSimul, Scanner sc) {
		switch(optionSimul) {
		case 1:{
			System.out.println("\nEntrez la baisse du taux de depense souhaite");
			//double t = sc.nextDouble();
			//sc.nextLine();
			double t = Double.parseDouble(sc.nextLine());
			System.out.println("L'impact totale de la population a ete baisse de "+Simulation.reducTauxDepense(p,t)+"%\n");
			break;
		}
		case 2:{
			System.out.println("\nEntrez la baisse du taux de Boeuf souhaite");
			//double t = sc.nextDouble();
			//sc.nextLine();
			double t = Double.parseDouble(sc.nextLine());
			System.out.println("L'impact totale de la population a ete baisse de "+Simulation.reducTauxBoeuf(p,t)+"%\n");
			break;
		}
		case 3:{
			System.out.println("\nEntrez le nombre de mails stockes a supprimer");
			//double t = sc.nextDouble();
			//sc.nextLine();
			int t = Integer.parseInt(sc.nextLine());
			System.out.println("L'impact totale de la population a ete baisse de "+Simulation.reducNbMail(p,t)+"%\n");
			break;
		}
		case 4:{
			System.out.println("\nEntrez le taux de personnes qui n'utiliserons plus leur voiture.");
			//double t = sc.nextDouble();
			//sc.nextLine();
			double t = Double.parseDouble(sc.nextLine());
			System.out.println("L'impact totale de la population a ete baisse de "+Simulation.reducVoit(p,t)+"%\n");
			break;
		}
		case 5:{
			System.out.println("\nSimulation pour le logement:");
			System.out.println("L'impact totale de la population a ete baisse de "+Simulation.reducCE(p)+"%\n");
			break;
		}
		default:

		}
	}

}
