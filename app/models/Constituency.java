package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "name", "stateId","parliament" }))
public class Constituency extends Model {

	@Id
	public Long constituencyId;

	@Required
	public String name;

	public Long population;

	@ManyToMany()
	public List<District> districts;

	@ManyToOne()
	@JoinColumn(name = "stateId")
	public State state;

	public boolean parliament ;
	
	public static Finder<Long, Constituency> find = new Finder<Long, Constituency>(Long.class,
			Constituency.class);

	public static List<Constituency> all() {
		return find.all();
	}

	public static void create(Constituency constituency) {

		System.out.println(constituency.toString());
		// politician.person.save();
		constituency.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

	public static Map<String, String> allMap() {

		Map<String, String> map = new HashMap<String, String>();

		for (Constituency constituency : Constituency.all()) {
			map.put(constituency.constituencyId.toString(), constituency.name);
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
		return "Constituency [id=" + constituencyId + ", name=" + name
				+ ", population=" + population + ", state=" + state
				+ ", parliament=" + parliament + "]";
	}

}
