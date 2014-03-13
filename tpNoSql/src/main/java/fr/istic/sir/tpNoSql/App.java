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
			
			 
			 
			 Person personZineb = ds.find(Person.class).field("name").equal("Zineb M").get();
			 
//			 for(Address a:personZineb.getListaddress()){
//				 System.err.println(a.getCity());
//				 System.err.println(a.getStreet());
//			 }
			 
			 Article art = new Article();
			 art.setName("Apprendre NoSQL");
			 
			 List<Person> listpersonnes=new ArrayList<Person>();
			 listpersonnes.add(personZineb);
			 
			 art.setListePersonnes(listpersonnes);
			 
			 ds.save(listpersonnes);
			 ds.save(art);
			 
			 for(Article ar : ds.find(Article.class)){ 
				 	System.err.println(ar.getName());
				 	for(Person pers : ar.getListePersonnes()){ 
				 		System.err.println(pers.getName());
//				 		for(Address a:pers.getListaddress()){
//							 System.err.println(a.getCity());
//							 System.err.println(a.getStreet());
//						 }
				 		
				 	}
			 }
			 
//			 Person p = new Person();
//			 p.setName("Zineb M");
//
//			 Address address1 = new Address();
//			 address1.setStreet("Some street - 1");
//			 address1.setCity("Some city - 1");
//			 address1.setPostCode("123 456 - 1");
//			 address1.setCountry("Some country - 1");
//			  
//			 Address address2 = new Address();
//			 address2.setStreet("Some street - 2");
//			 address2.setCity("Some city - 2");
//			 address2.setPostCode("123 456 - 2");
//			 address2.setCountry("Some country - 2");
//			 
//			 
//			 List<Address> listadresses=new ArrayList<Address>();
//			 listadresses.add(address1);
//			 listadresses.add(address2);
//			 
//			 p.setListaddress(listadresses);
////			 
////			 //sauvegarde
//			 ds.save(listadresses);
//			 ds.save(p);

//			 for (Person e : ds.find(Person.class)) {
////				 System.err.println(e.getAddress().getCity());
//		 		System.err.println(e.getName());
//				 
//				 for(Address a:p.getListaddress()){
//					 System.err.println(a.getCity());
//					 System.err.println(a.getStreet());
//				 }
//				
//			 }
//			 
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


       

    }
}
