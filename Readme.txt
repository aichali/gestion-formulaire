1. Build du projer 
	mvn clean install
	
2. Deploy du projet 
	java -jar gestion-formulaire-1.0.0-SNAPSHOT.jar
	
	
	########  OUTIL MAVEN

MAVEN : outil permettant :
  - de bien organiser les projets,
  - automatiser les builds en ligne de commanfes,
  - automatiser les tests unitaires des fonctionnalités,
  - automatiser les livraisons,
  - versionner les livraisons,
  - automatiser la récupération des bibliothèques (dépendances) en utilisant le POM,

####### SPRING BOOT

######### COUCHE DOMAINES

La couche domaine consiste à modéliser le modèle relationnel en objets.
Pour cela des outils appelés ORM (OBJECT RELATIONNEL MAPPING) sont utilisés tels que JPA, HIBERNATE, TOPLINK, etc.

L'implantation de cette couche s'effectue selon les étapes suivante :
  - le mapping de chaque table du modèle relationnel en classe JAVA, annotée par @Entity,
  - le mapping des champs des différentes tables en indiquant leurs noms, leurs types, leurs tailles, etc
- Le mapping des identifiants des différentes tables et les séquences de leurs générations si nécessaires,
  - le mapping des relations entre les tables : tu peux parler brièvement de ce point en mettant par exemple ton cas,
  - la création de la connexion à la BD : ajouter la dépendance du driver dans le POM et les informations d'accès à la BD, 
  dans le fichier "application.properties"

###### COUCHE SERVICES OU REPOSITIRY

- cette couche contient les différents services d'accès aux données,

- chaque service implémente une requête d'accès aux données,

- pour écrire les requêtes, il est possible d'utiliser le langage SQL basique, ou le langage proposé par l'ORM utilisé : 
JPQL pour JPA, HQL pour hibernate, etc,

- il faut créer une classe JAVA pour chaque table. La classe est annotée par :
    1. @Service ou @Componenent s'il s'agit d'une classe service,
   2. Ou @@repository s'il s'agit d'une classe Repository.

Les @Repository sont spécifiques à Spring Data JPA. pour cela, il faut que cette dépendance soit présente dans le POM du projet.

Pour éviter de développer les services de base d'accès aux données  (recherche par identifiants, la récupération de toutes les lignes d'une table, l'insertion d'une nouvelle ligne, la suppression d'une ligne, la modification d'une ligne, etc ), faut hériter les classes Repository de la classe mère "CrudRepositpry".

La classe CeudRepository" est générique.
Pour l'heriter, il faut indiquer l'entité concernée et le type de sa clé primaire


######### LA COUCHE WEB
- L'objectif de ce projet est la création d'une API REST d'accès aux données.
Cet accès ne se fait en langage SQL, mais en requête HTTP : la recherche (GET), la création (POST), la suppression (DELETE), la mise à jour (PUT).

  - parler des concepts de base des services REST et du protocole HTTP : Ressource REST, Url d'appel d'une ressource, les méthodes d'appel HTTP, etc.

  - les services créés dans les Repository ne sont pas accessibles en HTTP. Pour cela, il faut créer des services pour les appeler dans la couche Web. Les classes créées dans cette couche sont appelées des contrôleurs.

Pour développer les contrôleurs, nous avons utilisés SPRING MVC.

- il faut créer une classe annotée par @RestController ou @Controller au-dessus de chaque classe @Repository.

Puis injecter la classe @Repository dans la classe @RestController pour qu'elle soit utilisée.

- il faut créer une méthode HTTPM, pour chaque service implémente dans les Repository.


######## DTO : Data Transfer Object
Les objets JAVA utilisés dans les couches "Domain" et "Service" sont appelés des JavaBean.

Dans la couche Web (les contrôleurs), un autre type d'objets doit utilisé. Ils servent à transférer les données entre le Front-End (ou les services externes) et l'API REST développée (Back-End).
Pour cette raison, ils sont appelés DTO (Data Transfer Objet)

############ TESTS DE L'API
Pour tester les différents services implémentés dans les contrôleurs, il est possible d'utiliser l'outil POSTMAN pour exécuter les différentes requêtes HTTP

##### MAPPING DES REQUETES HTTP AVEC LES CONTROLEURS

Les services présents dans les classes contrôleurs sont appelés en HTTP :
1. La méthode d'appel dépend de l'annotation de mapping :
     - GetMapping --> GET
     - PostMapping --> POST
     - PatchMaping --> PATCH
     - DeleteMaping --> DELETE

2. Si la requête HTTP envoi des données dans le corps, il faut mettre leur type dans la signature du service annoté par @RequestBody. Cette règle s'applique sur les méthodes POST et PATCH

3. Dans le cas de GET, les paramètres de la recherche peuvent :
    - faire partie de l'url du service. Dans ce cas, ils doivent être récupérés par @PathVariable
    - être passés en partes après l'url du services. Dans ce cas, elles doivent être récupérés par @Parameter


4 les url d'appel d'un service sont constitués de différents éléments :
   - l'IP de la machine de déploiement du service (localhost en local)
  - le port d'écoute du service, configuré dans le fichier [application.properties]
  - Le contexte  de déploiement du service, configuré dans le fichier [application.properties]
  - la valeur associée à l'annotation @RequestMapping qui se trouve au début de la classe du contrôleur,
   - la  valeur de l'attribut $path$, associé au mapping du service (@GetMapping,il
@PostMaping, etc)

5. Les réponses des requêtes HTTP doivent obligatoirement contenir un statut de traitement et un corps pour certaines méthodes. Pour constituer ces réponses, il faut utiliser ResponseEntity
 