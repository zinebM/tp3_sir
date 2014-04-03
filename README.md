tp3_sir
=======

Pour ce Tp 3, nous avons crée deux repos differents,celui là pour NoSQL et un autre qui s'appelle REDIS, pour REDIS.

Dans cette première partie le but était dz créer un projet Maven, puis utiliser la librairie Morphia afin de se connecter à la base de données MongoDB

En suivant le modèle de données donné, nous avons crée plusieurs objets, afin de les stocker dans la base de données.
 Voici un exemple de code:
 
```java
 

@Entity
public class Person {


@Id ObjectId id;
String name;

List<Address> listaddress;

public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}


public List<Address> getListaddress() {
return listaddress;
}
public void setListaddress(List<Address> listaddress) {
this.listaddress = listaddress;
}


}
```

2
Les limites d'une base de données orientée objet est qu'elle ne  permet pas la même flexibilité dans les requêtes et les chargements de données que les bases de données relationnelles.
