package tools;

import java.util.*;

public class Questionnaire {
	
	static final String[] NOM_POSTE = {"Logement", "Alimentation", "BienConso","Mail","Transport"};
	
	static final String QST_LOGEMENT1 = "Combien de logement avez vous ?";
	static final String[] QST_LOGEMENT2 ={"Quelle est la superficie de votre appartement en m^2?", "Quelle est la classe energetique ?"};
	static final String[] QST_ALIMENTATION = {"Quel est votre taux de repas a base de boeuf ?", "Quel est votre taux de repas vegetariens ?"};
	static final String[] QST_BIENCONSO = {"Quel est le montant de vos depenses annuelles en euros ?"};
	static final String[] QST_MAIL = {"Combien avez vous de mail envoyes depuis un an?", "Combien avez vous de mails recus depuis un an?"};
	static final String QST_TRANSPORT1 = "Combien de voiture avez vous ?";
	static final String[] QST_TRANSPORT2 = {"Quelle est la taille de votre voiture?", "Quel est vos nombre de kilometre a l'annee ?", "Quelle est la duree de conservation de votre vehicule ?"};
	
	static final String[][] QUESTION = {QST_LOGEMENT2, QST_ALIMENTATION, QST_BIENCONSO,QST_MAIL, QST_TRANSPORT2};
	
	
	public static ArrayList<String> commencer() {
		ArrayList<String> tab = new ArrayList<String>();
		
        Scanner sc = new Scanner(System.in);
		
        for (int i = 0 ; i< NOM_POSTE.length ; i++) {
        	System.out.println("\nPoste de consommation: " + NOM_POSTE[i]);
        	
        	//logement
        	if(i == 0) {
        		System.out.println(QST_LOGEMENT1);
        		String str = sc.nextLine();
        		tab.add(str);
        		int nbLogement = Integer.parseInt(str);
        		for(int j = 0; j<nbLogement; j++) {
        			for (String q: QST_LOGEMENT2) {
        				System.out.println(q);
        				tab.add(sc.nextLine());
        			}
        		}
        	}
        	
        	if((i == 1) ||(i == 2) || (i==3) ) {
        		for (int j = 0; j< QUESTION[i].length; j++) {
            		System.out.println(QUESTION[i][j]);
            		tab.add(sc.nextLine());
            	}
        	}
        	
        	if(i == 4) {
        		System.out.println(QST_TRANSPORT1);
        		String str = sc.nextLine();
        		tab.add(str);
        		int nbTransport = Integer.parseInt(str);
        		for(int j = 0; j<nbTransport; j++) {
            			for (String q: QST_TRANSPORT2) {
            				System.out.println(q);
            				tab.add(sc.nextLine());
            			}
        		}
     
        	}

        }
		sc.close();
		
		return tab;
	}


}
