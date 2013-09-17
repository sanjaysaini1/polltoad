package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class PoliticalParty extends Model {

	@Id
	public Long id;
	
	@Required
	public String name;
	
	public Date dateofformation;

	public Politician partychief;
	
}
