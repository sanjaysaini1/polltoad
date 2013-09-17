package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Family {

	@Id
	public Long id;
	
	public List<Person> family;
}
