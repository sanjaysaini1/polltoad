package models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class PoliticalParty extends Model {

	@Id
	public Long politicalPartyId;

	@Required
	@Column(unique = true)
	public String name;

	public Date dateofformation;

	@OneToOne()
	@JoinColumn(name = "politicianId")
	public Politician partychief;

	public static Finder<Long, PoliticalParty> find = new Finder(Long.class,
			PoliticalParty.class);

	public static List<PoliticalParty> all() {
		return find.all();
	}

	public static void create(PoliticalParty politicalparty) {

		System.out.println(politicalparty.toString());
		// politician.person.save();
		politicalparty.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

	public static Map<String, String> allMap() {

		Map<String, String> map = new HashMap<String, String>();

		for (PoliticalParty politicalParty : PoliticalParty.all()) {
			map.put(politicalParty.politicalPartyId.toString(), politicalParty.name);
		}

		return map;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PoliticalParty [id=" + politicalPartyId + ", name=" + name
				+ ", dateofformation=" + dateofformation + ", partychief="
				+ partychief + "]";
	}
}
