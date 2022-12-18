package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import consocarbone.Alimentation;
import consocarbone.BienConso;
import consocarbone.CE;
import consocarbone.ConsoCarbone;
import consocarbone.Logement;
import consocarbone.Mail;
import consocarbone.Taille;
import consocarbone.Transport;
import user.Population;
import user.Utilisateur;

public class Traitement {

	public static Utilisateur recupUser(String filename){
	    try
	    {
	      File file = new File(filename);    
	      FileReader fr = new FileReader(file);  
	      BufferedReader br = new BufferedReader(fr);  
	     
	      ArrayList<ConsoCarbone> listPostes = new ArrayList<>();
	      
	      String line;
	      while((line = br.readLine()) != null)
	      {
	    	String val = traiterLigne(line.split(";"), listPostes);
	    	gestionErreur(val);
	    	
	      }   
	      
	   
	      
	      fr.close(); 
	      Utilisateur u = new Utilisateur(listPostes);
	     return u;
	    }
	    
	    catch(FileNotFoundException e){
	    	System.out.println("fichier non trouve");
	    	e.printStackTrace();
	    	System.exit(1);
	    	}
	    catch(IOException e){e.printStackTrace();System.exit(1);}
	    
	    return null;
	}
	
	public static String traiterLigne(String[] line, ArrayList<ConsoCarbone> listPostes) {
		System.out.println(Arrays.toString(line));
		switch(line[0]) {
			case "Alimentation": {
				if (Verif.testTaux(line[1])&&Verif.testTaux(line[2])){
					System.out.println(line[1]+line[2]);
					Alimentation a = new Alimentation(Double.parseDouble(line[1]),Double.parseDouble(line[2]));
					listPostes.add(a);
					break;
				}
				else return line[0];
			}
			case "Logement":{
				int nbLogement = Integer.parseInt(line[1]);
				System.out.println("nbLogement "+nbLogement);
				for (int j = 0; j<nbLogement; j++) {
					String superficie = line[2*j+2];
					String ce = line[2*j+3];
					System.out.println("j= "+j+"sup = "+superficie+"ce = "+ce);
					if (Verif.testNumericPositif(superficie)&&(Verif.testCe(ce))) {
						Logement l = new Logement(Integer.parseInt(superficie),CE.valueOf(ce));
						listPostes.add(l);
						
					}
					
					else {
						System.out.println("valala");
						return line[0];
					}
				}
				break;
			}
			case "Transport":{
				System.out.println("lineee trans:"+line[0]);
				int nbTransport = Integer.parseInt(line[1]);
				System.out.println("nbTransport "+nbTransport);
				for (int j = 0; j<nbTransport; j++) {
					String taille = line[3*j+2];
					String kilomAnnee = line[3*j+3];
					String Ammortissement = line[3*j+4];
					if (Verif.testTaille(taille)&&Verif.testNumericPositif(kilomAnnee)&&Verif.testNumericPositif(Ammortissement)) {
						Transport t = new Transport(true,Taille.valueOf(taille),Integer.parseInt(kilomAnnee), Integer.parseInt(Ammortissement));
						listPostes.add(t);
						//System.out.println(t.toString());
						//break;
					}
					else {
						System.out.println("valalaTRans");
						return line[0];
					}
				}
				if (nbTransport == 0) {
					listPostes.add(new Transport(false));
				}
				break;
			}
			case "BienConso": {
				if (Verif.testNumericPositif(line[1])){
					BienConso b = new BienConso(Integer.parseInt(line[1]));
					listPostes.add(b);
					System.out.println(b.toString());
					break;
				}
				else {
					System.out.println("valalaBien");
					return line[0];
				}
			}
			case "Mail":{
				if (Verif.testNumericPositif(line[1])&&Verif.testNumericPositif(line[2])){
					Mail m = new Mail(Integer.parseInt(line[1]),Integer.parseInt(line[2]));
					listPostes.add(m);
					//System.out.println(m.toString());
					break;
				}
				else {
					System.out.println("valalaMail");
					return line[0];
				}
			}
			default:return "Erreur de nom poste";
	}
	return "OK";

	}
	
	public static void gestionErreur(String val) throws IllegalArgumentException{
		if(val != "OK") {
			if(val == "Erreur de nom poste") throw new IllegalArgumentException("Erreur");
			else throw new IllegalArgumentException("Erreur au poste "+val);
		}
	}
	
	public static Population recupPop(String[] filenames) {
		Population pop = new Population();
		for (int i = 0; i<filenames.length; i++) {
			Utilisateur u = recupUser(filenames[i]);
			pop.addUser(u);
			//System.out.println("Calculer empreinte: "+u.calculerEmpreinte());
			
		}
		//System.out.println(pop.calculerEmpreinte());
			
		return pop;
	}
}
