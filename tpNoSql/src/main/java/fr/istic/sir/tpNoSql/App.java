package fr.istic.sir.tpNoSql;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;



/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) 
	{
		Morphia morphia = new Morphia();   

		//  Mongo mongo = new Mongo();

		morphia.map(Person.class).map(Address.class);

		Datastore ds;
		try {
			ds = morphia.createDatastore( new Mongo(), "my_database");
			
			//creation des articles
			Article art = new Article();
			art.setName("Apprendre NoSQL");

			Article art2 = new Article();
			art2.setName("Apprendre JPA");

			
			//creation des personnes
			Person p = new Person();
			p.setName("Fidy R");

			Person p2 = new Person();
			p2.setName("Zineb M");

			//creation des adresses
			Address address1 = new Address();
			address1.setStreet("RUE - 11");
			address1.setCity("Avenue- 11");
			address1.setPostCode("456 - 11");
			address1.setCountry("Madaga - 11");

			Address address2 = new Address();
			address2.setStreet("Some street - 12");
			address2.setCity("Some city - 12");
			address2.setPostCode("123 456 - 12");
			address2.setCountry("Some country - 12");

			Address address3 = new Address();
			address3.setStreet("Some street - 21");
			address3.setCity("Some city - 21");
			address3.setPostCode("123 456 - 21");
			address3.setCountry("Some country - 21");


			//ajout adresses dans liste
			List<Address> listadresses=new ArrayList<Address>();
			listadresses.add(address1);
			listadresses.add(address2);

			List<Address> listadresses2=new ArrayList<Address>();
			listadresses2.add(address3);


			//rattacher les listes d'adresse aux personnes correspondantes
			p.setListaddress(listadresses);
			p2.setListaddress(listadresses2);

			//ajout peronnes dans liste
			List<Person> listpersonnes=new ArrayList<Person>();
			listpersonnes.add(p);

			List<Person> listpersonnes2=new ArrayList<Person>();
			listpersonnes2.add(p2);

			//rattacher les listes de personnes aux articles correspondants
			art.setListePersonnes(listpersonnes);
			art2.setListePersonnes(listpersonnes2);

			//sauvegare dans la base
			ds.save(address3);
			ds.save(address2);
			ds.save(address1);
			ds.save(p);
			ds.save(p2);
			ds.save(listadresses2);
			ds.save(listadresses);
			ds.save(art2);
			ds.save(art);
			ds.save(listpersonnes);
			ds.save(listpersonnes2);

			//affichage
			afficheByArticleName(ds,"Apprendre NoSQL");
			afficheByArticleName(ds,"Apprendre JPA");


		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public static void afficheByArticleName(Datastore ds,String name){
		Article article = ds.find(Article.class).field("name").equal(name).get();

		for(Person pers : article.getListePersonnes()){ 

			System.err.println(" L'article: " +article.getName() + " a été acheté par:" );
			System.err.println(pers.getName() + " qui a comme adresse(s) ");

			for(Address a:pers.getListaddress()){
				System.err.println(a.getCity());
				System.err.println(a.getStreet());
			}


		}
	}
}
