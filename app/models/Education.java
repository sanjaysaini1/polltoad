package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Education extends Model {

	@Id
	public Long educationId;

	@Required
	public String education;

	public String almamater;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Education [id=" + educationId + ", education=" + education
				+ ", almamater=" + almamater + "]";
	}
}
