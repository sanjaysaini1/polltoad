package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;

@Entity
public class Profession {

	@Id
	public Long id;
	
	@Required
	public String profession;
}
