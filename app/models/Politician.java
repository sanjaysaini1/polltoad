package models;

import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.data.format.Formatters;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Politician extends Model {

	@Id
	public Long politicianId;

	@Required
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "personId")
	public Person person;

	@ManyToMany(cascade = CascadeType.ALL)
	public List<Constituency> constituency;

	@ManyToOne
	public Constituency currentconstituency;

	@ManyToMany(cascade = CascadeType.ALL)
	public List<Election> electionsfaught;

	@ManyToMany(cascade = CascadeType.ALL)
	public List<PoliticalParty> politicalparties;

	@ManyToOne
	public  PoliticalParty currentpoliticalparty;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "educationId")
	public Education education;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "familyId")
	public Family family;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "professionId")
	public Profession profession;


	public static Finder<Long, Politician> find = new Finder(Long.class,
			Politician.class);

	public static List<Politician> all() {
		return find.all();
	}

	public static void create(Politician politician) {

		System.out.println(politician.toString());
		// politician.person.save();
		politician.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Politician [id=" + politicianId + ", person=" + person
				+ ", constituency=" + constituency + ", currentconstituency="
				+ currentconstituency + ", electionsfaught=" + electionsfaught
				+ ", politicalparties=" + politicalparties
				+ ", currentpoliticalparty=" + currentpoliticalparty
				+ ", education=" + education + ", family=" + family
				+ ", profession=" + profession + "]";
	}

}