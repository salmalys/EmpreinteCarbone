package tools;

import java.util.*;
import consocarbone.*;
import java.util.ArrayList;

public class Questionnaire {
	
	static final String[] NOM_POSTE = {"Logement", "Alimentation", "BienConso","Mail","Transport"};
	
	static final String[] QST_LOGEMENT = {"Combien de logement avez vous ?","Quelle est la superficie de votre appartement en m^2?","Quelle est la classe energetique ?"};
	static final String[] QST_ALIMENTATION = {"Quel est votre taux de repas a base de boeuf ?", "Quel est votre taux de repas vegetariens ?"};
	static final String[] QST_BIENCONSO = {"Quel est le montant de vos depenses annuelles en euros ?"};
	static final String[] QST_MAIL = {"Combien avez vous de mail envoyes depuis un an?", "Combien avez vous de mails recus depuis un an?"};
	static final String[] QST_TRANSPORT = {"Combien de voiture avez vous ?","Quelle est la taille de votre voiture?","Quel est vos nombre de kilometre a l'annee ?","Quelle est la duree de conservation de votre vehicule ?"};
	
	static final String[][] QUESTION = {QST_LOGEMENT, QST_ALIMENTATION, QST_BIENCONSO,QST_MAIL, QST_TRANSPORT};
	static final int[] nbAtt = {2,2,1,2,3};
	
	
	public static ArrayList<ConsoCarbone> commencer() {
		ArrayList<ConsoCarbone> listPostes = new ArrayList<ConsoCarbone>();
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0 ; i< NOM_POSTE.length ; i++) {
        	System.out.println(NOM_POSTE[i]);
        	String[] line = questionPoste(sc,NOM_POSTE[i],QUESTION[i],nbAtt[i]);
        	System.out.println(Arrays.toString(line));
        	Traitement.traiterLigne(line,listPostes);
        }
        System.out.println("fin");
        
		sc.close();
		
		return listPostes;
	}
	
	public static String[] questionPoste(Scanner sc, String nomPoste, String[] qPoste, int nbAtt) {
		String[] line = null;
		if((nomPoste == "Logement")||(nomPoste == "Transport")){
			System.out.println("hello");
			System.out.println(qPoste[0]);
			String nbPosteVal = sc.nextLine();
			int nbPoste = Integer.parseInt(nbPosteVal);
			
			line = new String[2+nbPoste*nbAtt];
			
			line[0] = nomPoste;
			line[1] = nbPosteVal;
			
			int cpt = 2;
			for(int j = 0; j<nbPoste; j++) {
				for(int q = 1; q<qPoste.length; q++) {
					System.out.println(qPoste[q]);
					line[cpt] = sc.nextLine();
					cpt++;
				}
			}
			
		}
		else {
			//System.out.println("un poste apas log ni transport");
			line = new String[1+nbAtt];
			line[0] = nomPoste;
			int cpt = 1;
			for(int q = 0; q<qPoste.length; q++) {
				System.out.println(qPoste[q]);
				line[cpt] = sc.nextLine();
				cpt++;
			}
		}
		
		
		
		return line;
	}


}
