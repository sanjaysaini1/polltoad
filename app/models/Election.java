package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;

@Entity
public class Election {

	@Id
	public Long id;
	
	@Required
	public Date dateofelection;
	
	@Required
	public Constituency constituency;
	
	
	@ManyToMany
	public List<Politician> contestant;
	
	@OneToOne
	public ElectionResult electionresult;
	
}
