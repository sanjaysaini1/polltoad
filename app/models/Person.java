package models;

import java.net.URL;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Person extends Model{

	@Id
	public Long id;

	@Required
	public String name;

	@Required
	public Date dateofbirth;

	@Required
	public String placeofbirth;

	@Required
	public URL picture;

}
