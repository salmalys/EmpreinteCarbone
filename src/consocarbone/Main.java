package consocarbone;
import tools.*;

import java.util.Scanner;

import user.*;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Choisissez une des options: (Entrez 1 ou 2)");
		
		System.out.println("Choix 1: Creer sa population a partir de fichiers");
		System.out.println("Choix 2: Repondre au questionnaire pour calculer sa popre empreinte");
		
		Scanner sc1 = new Scanner(System.in);
		int rep = Integer.parseInt(sc1.nextLine());
		sc1.close();
		
		
		do {
			if (rep == 1) {
				System.out.println("Entrez le nom des fichiers: ");
				String[] filenames = (sc1.nextLine()).split(" ");
				Population p = Traitement.recupPop(filenames);
				p.calculerEmpreinte();
			}
			else if(rep == 2) {
				ArrayList<ConsoCarbone> listPostes = Questionnaire.commencer();
				Utilisateur u = new Utilisateur(listPostes);
				u.detaillerEmpreinte();
			}
			else System.out.println("repondez par 1 ou 2");
			
		}while((rep!= 1)||(rep!= 2));
		System.out.println("tout va bien");
		
		
	}
	
}
