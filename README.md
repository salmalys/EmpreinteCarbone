# EmpreinteCarbone
Le but de ce projet est de réaliser un calculateur d’empreinte carbone. Ce type de programme quantifie les émissions de Gaz à Effet de Serre (GES) d’un.e individu.e en tonnes de CO2 équivalent (TCO2eq) n fonction de son mode de vie.

Pour pouvoir executer le programme, il faut récuperer le fichier jar dans le dossier target, puis lancer la commande java -jar EmpreinteCraboneJalon1.jar.
Attention, la version JavaSE-17 est nécessaire. 

Documentation: 
- Nous avons développé notre projet sur l'IDE Eclipse et utilisé gitHub pour faciliter le travail d'équipe.  
lien du repository: https://github.com/salmalys/EmpreinteCarbone.git

Vous trouverez dans l’archive 2 packages : consocarbone et tools. 

Le package consocarbone contient :
-	4 classes pour 4 postes de consommation  :  Logement, Alimentation, BienConso et Transport. 
-	Toutes héritent de la classe abstraite ConsoCarbone. 
-	2 énumérations Taille et CE
-	La classe principale Main  

Pour pouvoir tester l
Pour simplifier la fonction main, nous avons décidé d’implémenter deux classes utilitaires Questionnaire et Verif. 

La classe Questionnaire contient toutes les questions à poser pour chaque poste de consommation (stockées dans un tableau de String) et une méthode commencer qui effectue la saisie des données. 

Les réponses sont stockées dans une matrice reponses:
- reponses[0] correspond aux réponses du poste de consommation Logement
- reponses[1] correspond aux réponses du poste de consommation Alimentation
- reponses[2] correspond aux réponses du poste de consommation Bienconso

La taille de cette matrice a été fixée à 3x3 puisque le questionnaire concerne trois postes de consommation avec un maximum de 2 questions par poste. Evidemment, cette taille sera fixée autrement apres enrichissement du quetstionnaire.  

Verif recupere la matrice et retourne une erreur si les conditions sur les saisies ne sont pas correctes (si la valeur de la superficie n’est pas un entier positif, si le taux n’est pas compris entre 0 et 1..).

Dans les méthodes testNumericPositif et testTaux, nous avons utilisé un try/catch qui est une méthode trouvée sur un forum stackflow.

Pour tester le polymorphisme, nous avons pour l’instant instancié dans la fonction main uniquement trois postes consommations : Logement l , Alimentation a et BienConso b. Puis pour chacun de ces objets, les methodes toString et empCarbMoy sont appelées. Par exemple, pour l'objet a, la méthode renvoie bien l'affichage de la méthode toString de la classe Alimentation. 

Remarques: 
- Nous n'avons pas encore traité les questions de la classe Transport dans le questionnaire. Pour tester le polymorphisme de nos méthodes, les 3 postes de consommation présentés suffisent. 
- La manière dont est traité l'échange avec l'utilisateur est encore provisoire. 
- Nous avons pensé à utiliser des listes plutôt que des tableaux pour les questions (par souci d'espace mémoire). 
- La vérification des saisies est éffectuée une fois le questionnaire terminé. Par la suite, il serait préférable de traiter et tester les données immédiatement plutôt que de continuer à poser les questions après une erreur de saisie. 

