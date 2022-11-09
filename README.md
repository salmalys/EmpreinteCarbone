# EmpreinteCarbone
Le but de ce projet est de réaliser un calculateur d’empreinte carbone. Ce type de programme quantifie les émissions de Gaz à Effet de Serre (GES) d’un.e individu.e en tonnes de CO2 équivalent (TCO2eq) n fonction de son mode de vie.

--Version JavaSE-17
cmd : java -jar EmpreinteCraboneJalon1.jar 
Java Doc :
Vous trouverez dans l’archive 2 packages : consocarbone et tools. 
Le package consocarbone contient :
-	4 classes :  Logement, Alimentation, BienConso et Transport. 
-	Toutes héritent de la classe abstraite ConsoCarbone. 
-	2 énumérations Taille et CE
-	La classe principale Main  
Pour la clarté du main, nous avons décidé d’implémenter deux classes utilitaires Questionnaire et Verif. 
La classe Questionnaire contient toutes les questions à poser pour chaque poste de consommation (stockées dans un tableau de String) et une méthode commencer qui effectue la saisie des données. 
Les réponses sont stockées dans une matrice reponses.
reponses[0] correspond aux réponses du poste de consommation Logement
reponses[1] correspond aux réponses du poste de consommation Alimentation.
reponses[2] correspond aux réponses du poste de consommation Bienconso.
La taille de cette matrice a été fixée à 3x3 puisque le questionnaire concerne trois postes de consommation avec un maximum de 2 questions par poste. Evidemment, cette taille 
Verif recupere la matrice et retourne une erreur si les conditions sur les arguments ne sont pas correctes (si la valeur de la superficie n’est pas un entier, si le taux n’est pas compris entre 0 et 1..)
Dans les méthodes testNumericPositif et testTaux, nous avons utilisé un try/catch qui est une méthode trouvée sur un forum stackflow.
Pour tester le polymorphisme des méthodes, nous avons pour l’instant instancié uniquement trois postes consommations : Logement , Alimentation et BienConso. 
