package life4food.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Element {

	private Integer id;
	private String name;
	private Type type = Type.NONE;
	private String description;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public Element setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Element setName(String name) {
		this.name = name;
		return this;
	}
	
	public Type getType() {
		return type;
	}

	public Element setType(Type type) {
		this.type = type;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Element setDescription(String description) {
		this.description = description;
		return this;
	}
}
