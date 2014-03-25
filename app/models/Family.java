package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.db.ebean.Model;

@Entity
public class Family extends Model {

	@Id
	public Long familyId;

	@ManyToMany(cascade = CascadeType.ALL)
	public List<Person> member;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Family [id=" + familyId + ", family=" + member + "]";
	}
}
