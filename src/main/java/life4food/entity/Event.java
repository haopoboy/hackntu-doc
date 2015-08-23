package life4food.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Event {
	
	private Integer id;
	private String name;
	private Type type = Type.NONE; 
	private Product leftProduct;
	private Product rightProduct;
	private String description;
	private String notification;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public Event setId(Integer id) {
		this.id = id;
		return this;
	}

	public Type getType() {
		return type;
	}

	public Event setType(Type type) {
		this.type = type;
		return this;
	}
	
	@ManyToOne
	public Product getLeftProduct() {
		return leftProduct;
	}

	public Event setLeftProduct(Product leftProduct) {
		this.leftProduct = leftProduct;
		return this;
	}

	@ManyToOne
	public Product getRightProduct() {
		return rightProduct;
	}

	public Event setRightProduct(Product rightProduct) {
		this.rightProduct = rightProduct;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Event setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getName() {
		return name;
	}

	public Event setName(String name) {
		this.name = name;
		return this;
	}

	public String getNotification() {
		return notification;
	}

	public Event setNotification(String notification) {
		this.notification = notification;
		return this;
	}
}