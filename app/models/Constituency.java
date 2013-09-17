package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;

@Entity
public class Constituency {

	@Id
	public Long id;
	
	@Required
	public String name;
	
	public long population;
	
	public String state;
	
	@Required
	public boolean parliament;
	
}
