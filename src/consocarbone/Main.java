package consocarbone;
import tools.*;
import user.*;

import java.io.*;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		if (args.length > 0) {
			Population pop = new Population();
			System.out.println(args[0]);
			for (int i = 0; i<args.length; i++) {
				//Utilisateur user = new Utilisateur(args[i]);
				ArrayList<String> tab = recupReponses(args[i]);
				if (Verif.testReponses(tab)){
					Utilisateur u = new Utilisateur(tab);
					pop.addUser(u);
				}
				else {
					System.out.println("Erreur fichier"); 
				}
				
			}
		}
		else {
			ArrayList<String> tab = Questionnaire.commencer();
			Verif.testReponses(tab);
			Utilisateur u = new Utilisateur(tab);
			u.detaillerEmpreinte();
		}
		
	}
	
	
	public static ArrayList<String> recupReponses(String filename){
	    try
	    {
	      File file = new File(filename);    
	      FileReader fr = new FileReader(file);  
     
	      BufferedReader br = new BufferedReader(fr);  
	      
	      ArrayList<String> contenu = new ArrayList<String>();
	      
	      String line;
	      while((line = br.readLine()) != null)
	      {
	        String[] tab = line.split(" ");
	        for (int i = 1; i<tab.length; i++) {
	        	contenu.add(tab[i]);
	        }
	       }   
	      
	      fr.close(); 
	      return contenu;
	    }
	    catch(IOException e)
	    {
	      e.printStackTrace();
	    }
	    return null;
	}

}
