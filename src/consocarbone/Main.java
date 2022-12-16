package consocarbone;
import tools.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("hello");
		if (args.length > 0) {
			System.out.println(args[0]);
			//for (int i = 0; i<args.length; i++) {
			//	recupReponses(args[i]);
			//}
		}
		// Lancement du questionnaire et recuperation des saisies de l'utilisateur dans la matrice reponses 
		String[][] reponses = Questionnaire.commencer();
		
		//verification des donnees saisies, en cas d'echec fin du programme
		if (!(Verif.testReponses(reponses))) System.exit(1);
		
		//Cast des reponses entrees par l'utilisateur 
		int superficie = Integer.parseInt(reponses[0][0]); 
		CE ce = CE.valueOf(reponses[0][1]);
		double tBoeuf = Double.parseDouble(reponses[1][0]);
		double tVege = Double.parseDouble(reponses[1][1]);
		int montant = Integer.parseInt(reponses[2][0]);

		//Instanciation des postes de consommation, puis affichage des informations relatives aux postes
		Logement l = new Logement(superficie,ce);
		System.out.println(l.toString());
		Logement.empCarbMoy();
		
		Alimentation a = new Alimentation(tBoeuf,tVege);
		System.out.println(a.toString());
		Alimentation.empCarbMoy();
		
		BienConso b = new BienConso(montant);
		System.out.println(b.toString());
		BienConso.empCarbMoy();
		
		System.out.println(b.compareTo(a));
		
	}
	
	
	public static void recupReponses(String filename){
	    try
	    {
	      File file = new File(filename);    
	      FileReader fr = new FileReader(file);  
     
	      BufferedReader br = new BufferedReader(fr);  
	      StringBuffer sb = new StringBuffer();  
	      
	      String line;
	      while((line = br.readLine()) != null)
	      {
	        sb.append(line);      
	        sb.append("\n");     
	      }
	      System.out.println(sb);
	      fr.close();    
	    }
	    catch(IOException e)
	    {
	      e.printStackTrace();
	    }
	}

}
