package fr.istic.sir.tpNoSql;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;


@Entity
public class Article {
	
	@Id ObjectId id;
	String name;
	int stars;
	List<Person> listePersonnes;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public List<Person> getListePersonnes() {
		return listePersonnes;
	}
	public void setListePersonnes(List<Person> listePersonnes) {
		this.listePersonnes = listePersonnes;
	}
	
	
	
}
