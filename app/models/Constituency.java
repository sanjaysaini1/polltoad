package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Constituency extends Model{

	@Id
	public Long id;
	
	@Required
	public String name;
	
	public long population;
	
	public String state;
	
	@Required
	public boolean parliament;
	
}
