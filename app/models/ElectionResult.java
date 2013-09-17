package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.db.ebean.Model;
//List of politician top to bottom votewise
@Entity
public class ElectionResult extends Model{
	
	@Id
	public Long id;
	
	@ManyToMany
	public List<Politician> politicianList;
	 
	public List<Long> votecount;

}
