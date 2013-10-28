package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Media extends Model {

	@Id
	public Long mediaId;

	@Column(unique = true)
	public String name;

	public Long impact;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Media [id=" + mediaId + ", name=" + name + ", impact=" + impact
				+ "]";
	}
}
