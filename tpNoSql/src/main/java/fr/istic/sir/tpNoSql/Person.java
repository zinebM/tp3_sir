package fr.istic.sir.tpNoSql;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

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
