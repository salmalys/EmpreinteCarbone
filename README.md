# EmpreinteCarbone
Le but de ce projet est de réaliser un calculateur d’empreinte carbone. Ce type de programme quantifie les émissions de Gaz à Effet de Serre (GES) d’un.e individu.e en tonnes de CO2 équivalent (TCO2eq) en fonction de son mode de vie.

Pour pouvoir executer le programme, il faut recuperer le jar dans le dossier target, ainsi que les fichiers texte user puis lancer la commande: 
java -jar EmpreinteCarboneLahrachPicard.jar

version JavaSE-17 est nécessaire 
 
Nous avons développé notre projet sur l'IDE Eclipse et utilisé gitHub
lien du repository: https://github.com/salmalys/EmpreinteCarbone.git

Le format des fichiers user est imposé:

nomPoste;att1;att2
nomPoste;nb;p1att1;p1att2;p2att1;p2att2  pour les postes Logement et Transport 
pi: i-eme poste 

nomPoste = { Logement, Mail, Alimentation, Transport, BienConso}
L’ordre des attributs est également imposé
Logement;nb;CE;superficie
Alimentation;tauxBoeuf; tauxVege
BienConso;montant
Mail;nbMailEnvoyes;nbMailStockes
Transport;nb;Taille;km;Amortissement


