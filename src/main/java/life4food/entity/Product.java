package life4food.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.google.common.collect.Lists;

@Entity
public class Product {

	private Integer id;
	private String name;
	
	private List<String> misunderstandings = Lists.newArrayList();
	private List<Element> elements = Lists.newArrayList();

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public Product setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Product setName(String name) {
		this.name = name;
		return this;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Element> getElements() {
		return elements;
	}

	public Product setElements(List<Element> elements) {
		this.elements = elements;
		return this;
	}
	
	public Product addElement(Element element) {
		this.elements.add(element);
		return this;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + "]";
	}
}
