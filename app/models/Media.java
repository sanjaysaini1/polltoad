package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Media {

	@Id
	public Long id;
	
	public String name;
}
