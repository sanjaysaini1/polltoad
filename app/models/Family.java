package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Family extends Model {

	@Id
	public Long id;
	
	public List<Person> family;
}
