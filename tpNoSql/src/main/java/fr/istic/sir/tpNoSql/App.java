package fr.istic.sir.tpNoSql;

import java.net.UnknownHostException;

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
//			 Person p = new Person();
//
//			 p.setName("Tintin");
//
//			 Address address = new Address();
//
//			 address.setStreet("123 Some street");
//
//			 address.setCity("Some city");
//
//			 address.setPostCode("123 456");
//
//			 address.setCountry("Some country");
//
//			 p.setAddress(address);
//			 
//			 //sauvegarde
//			 ds.save(p);

			 for (Person e : ds.find(Person.class)) 
				 System.err.println(e);
			 
			 
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


       

    }
}
