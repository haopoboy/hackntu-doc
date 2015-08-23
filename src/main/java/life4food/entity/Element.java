package life4food.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Element {

	private Integer id;
	private String name;
	private Type type = Type.NONE;
	private String advDescription;
	private String disadvDescription;

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

	public String getAdvDescription() {
		return advDescription;
	}

	public Element setAdvDescription(String advDescription) {
		this.advDescription = advDescription;
		return this;
	}

	public String getDisadvDescription() {
		return disadvDescription;
	}

	public Element setDisadvDescription(String disadvDescription) {
		this.disadvDescription = disadvDescription;
		return this;
	}
}
