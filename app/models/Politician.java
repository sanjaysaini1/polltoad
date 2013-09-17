package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Politician extends Model {

	@Id
	public Long id;
	@Required
	@OneToOne
	public Person person;

	@ManyToMany
	public List<Constituency> constituency;
	
	@ManyToOne
	public Constituency currentconstituency;

	@ManyToMany
	public List<Election> electionsfaught;

	@ManyToMany
	public List<PoliticalParty> politicalparties;

	@ManyToOne
	public PoliticalParty currentpoliticalparty;

	@ManyToOne
	public Education education;

	@ManyToOne
	public Family family;

	@ManyToOne
	public Profession profession;
	
	@OneToOne
	public Media media;
	
	public static Finder<Long, Politician> find = new Finder(Long.class, Politician.class);

	public static List<Politician> all() {
		return find.all();
	}

	public static void create(Politician politician) {

		politician.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

}