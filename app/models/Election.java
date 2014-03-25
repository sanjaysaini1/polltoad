package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Election extends Model {

	@Id
	public Long electionId;

	@Required
	public Date dateofelection;

	@Required
	public Constituency constituency;

	@ManyToMany(cascade = CascadeType.ALL)
	public List<Politician> contestant;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "electionresultId")
	public ElectionResult electionresult;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Election [id=" + electionId + ", dateofelection="
				+ dateofelection + ", constituency=" + constituency
				+ ", contestant=" + contestant + ", electionresult="
				+ electionresult + "]";
	}

}
