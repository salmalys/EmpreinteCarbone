package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

/**
 * lit des donnees des fichiers et instancie les postes, les utilisateurs ainsi que la population a partir de celles ci
 */

public class Traitement {

	/**
	 * Ajout des utilisateurs pour creer la population a partir de la lecture de fichiers
	 * @param filenames tableau contenant le nom des fichiers
	 * @return population contenant des utilisateurs crees pour chaque fichier 
	 */

	public static Population readPop(String... filenames) {
		Population p = new Population();
		for (String f: filenames) {
			Utilisateur u = readUser(f);
			p.addUser(u);
		}
		return p;
	}

	/**
	 * Lit le fichier donne et ajoute un poste a la liste des postes pour chaque ligne 
	 * @param filename nom du fichier a lire
	 * @return utilisateur cree a partir de la liste des postes alimentee par le fichier 
	 */

	public static Utilisateur readUser(String filename){
		try
		{
			File file = new File(filename);    
			FileReader fr = new FileReader(file);  
			BufferedReader br = new BufferedReader(fr);  

			ArrayList<ConsoCarbone> listPostes = new ArrayList<>();

			String line;
			while((line = br.readLine()) != null)
			{
				try {
					readConso(line.split(";"), listPostes);
				}
				catch (IllegalArgumentException e) {
					e.printStackTrace();
					System.exit(1);
				}
			}   
			fr.close(); 
			Utilisateur u = new Utilisateur(listPostes);

			return u;
		}

		catch(FileNotFoundException e){
			System.out.println("Le fichier "+filename+" est introuvable\n");
			//e.printStackTrace();
			System.exit(1);
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}

		return null;
	}

	/**
	 * Traite une ligne et instancie le poste associe a cette ligne
	 * @throws IllegalArgumentException leve une exception car si une donnee n'est pas correcte ou si le nom de poste n'est pas reconnu
	 * @param line ligne a traiter  
	 * @param listPostes liste a laquelle on ajoute le poste 
	 */

	public static void readConso(String[] line, ArrayList<ConsoCarbone> listPostes) throws IllegalArgumentException {
		switch(line[0]) {
		case "Alimentation": {
			if (Verif.testTaux(line[1])&&Verif.testTaux(line[2])){
				Alimentation a = new Alimentation(Double.parseDouble(line[1]),Double.parseDouble(line[2]));
				listPostes.add(a);
				return;
			}
			break;
		}
		case "Logement":{
			int nbLogement = Integer.parseInt(line[1]);
			for (int j = 0; j<nbLogement; j++) {
				String superficie = line[2*j+2];
				String ce = line[2*j+3];
				if (Verif.testNumericPositif(superficie)&&(Verif.testCe(ce))) {
					Logement l = new Logement(Integer.parseInt(superficie),CE.valueOf(ce));
					listPostes.add(l);
				}
				else throw new IllegalArgumentException("Erreur au poste Logement");
			}
			return;
		}
		case "Transport":{
			int nbTransport = Integer.parseInt(line[1]);
			for (int j = 0; j<nbTransport; j++) {
				String taille = line[3*j+2];
				String kilomAnnee = line[3*j+3];
				String Ammortissement = line[3*j+4];
				if (Verif.testTaille(taille)&&Verif.testNumericPositif(kilomAnnee)&&Verif.testNumericPositif(Ammortissement)) {
					Transport t = new Transport(true,Taille.valueOf(taille),Integer.parseInt(kilomAnnee), Integer.parseInt(Ammortissement));
					listPostes.add(t);
				}
				else throw new IllegalArgumentException("Erreur au poste Transport");
			}
			if (nbTransport == 0) {
				listPostes.add(new Transport(false));
			}
			return;
		}
		case "BienConso": {
			if (Verif.testNumericPositif(line[1])){
				BienConso b = new BienConso(Integer.parseInt(line[1]));
				listPostes.add(b);
				return;
			}
			break;
		}
		case "Mail":{
			if (Verif.testNumericPositif(line[1])&&Verif.testNumericPositif(line[2])){
				Mail m = new Mail(Integer.parseInt(line[1]),Integer.parseInt(line[2]));
				listPostes.add(m);
				return;
			}
			break;
		}
		default: throw new IllegalArgumentException("Erreur de nom de poste");
		}

		throw new IllegalArgumentException("Erreur au poste "+ line[0]);
	}
}
