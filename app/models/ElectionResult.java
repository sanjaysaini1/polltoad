package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

//List of politician top to bottom votewise
@Entity
public class ElectionResult extends Model {

	@Id
	public Long electionResultId;

	@ManyToMany(cascade = CascadeType.ALL)
	public List<Politician> politicianList;

	public List<Long> votecount;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElectionResult [id=" + electionResultId + ", politicianList="
				+ politicianList + ", votecount=" + votecount + "]";
	}

}
