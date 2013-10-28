package models;

import java.net.URL;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import play.data.format.Formats;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "name",
		"dateofbirth" }))
public class Person extends Model {

	@Id
	public Long personId;

	@Required
	@MaxLength(100)
	public String name;

	@Required
	public Date dateofbirth;

	@Required
	@MaxLength(100)
	public String placeofbirth;

	public URL picture;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [id=" + personId + ", name=" + name + ", dateofbirth="
				+ dateofbirth + ", placeofbirth=" + placeofbirth + ", picture="
				+ picture + "]";
	}

}
