package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class State extends Model {

	@Id
	public Long stateId;

	@Required
	@Column(unique = true)
	public String name;

	@Required
	public boolean ut = false;

	public static Finder<Long, State> find = new Finder(Long.class, State.class);

	public static List<State> all() {
		return find.all();
	}

	public static void create(State state) {

		System.out.println(state.toString());
		// politician.person.save();
		state.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

	public static Map<String, String> allMap() {

		Map<String, String> map = new HashMap<String, String>();

		for (State state : State.all()) {
			map.put(state.stateId.toString(), state.name);
		}

		return map;
	}

	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", name=" + name + ", ut=" + ut
				+ "]";
	}

}
