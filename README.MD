<h1>Compte rendu de l'activité Spring MVC Thymeleaf (Patients)</h1>
<h3>Description du projet</h3>
<p>Dans ce projet j'ai créé trois packages:</p>
<ul>
<li>entities: ce package contient la classe patient qui me servira de table</li>
<li>repository: ce package contient l'inteface JPA qui va me permettre 
de manipuler la table Patient</li>
<li>web : ce package contient mon controlleur qui contient trois actions, index, home et delete</li>

</ul>
<p>puis j'ai créé une vue "patients.html" qui va me permettre d'afficher la liste des patients, de faire la pagination et la recharche
. j'ai utilisé le moteur de template " Thymeleaf" et j'ai intégré Bootstrap</p>


<p>En ce qui concerne la base de données j'ai lié le projet avec MySQL
</p>

<h3>Table Patients</h3>
<img src="./Captures/img.png"/>

<h3>la page web /index</h3>
<img src="./Captures/img_1.png"/>
<p>la page affiche la liste des patients avec une fonctionnalité de recherche 
et une fonctionnalité de suppression et la pagination pour organiser la vue</p>

<h3>Fonctionnalité de recherche</h3>
<img src="./Captures/img_2.png"/>
<p>Tous les nom qui contiennent le keyword "Dou" s'affichent avec la pagination.</p>

<h3>Fonctionnalité de suppression</h3>
<img src="./Captures/img_3.png"/>
<p>Quand on souhaite supprimer un patient une alerte s'affiche 
contenant un message en cliquant sur ok on valide la suppression sinon on annule.</p>