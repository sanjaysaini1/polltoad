package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;

@Entity
public class PoliticalParty {

	@Id
	public Long id;
	
	@Required
	public String name;
	
	public Date dateofformation;

	public Politician partychief;
	
}
