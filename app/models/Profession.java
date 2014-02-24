package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Profession extends Model {

	@Id
	public Long professionId;

	@Required
	public String profession;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Profession [id=" + professionId + ", profession=" + profession
				+ "]";
	}
}
