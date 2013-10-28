package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "name", "stateId" }))
public class District extends Model {

	@Id
	public long districtId;

	@Required
	public String name;

	@Required
	@OneToOne()
	@JoinColumn(name = "stateId")
	public State state;

	public static Finder<Long, District> find = new Finder(Long.class,
			District.class);

	public static List<District> all() {
		return find.all();
	}

	public static void create(District district) {

		System.out.println(district.toString());
		// politician.person.save();
		district.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

	@Override
	public String toString() {
		return "District [districtId=" + districtId + ", name=" + name
				+ ", state=" + state + "]";
	}

}
