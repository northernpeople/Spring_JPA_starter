package init.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
	@NamedQuery(
			 name="fetchAllWithItems",
			 query="SELECT c FROM ShoppingCart c LEFT JOIN FETCH c.items" 
			),
	@NamedQuery(
			 name="fetchOneWithItems",
			 query="SELECT c FROM ShoppingCart c LEFT JOIN FETCH c.items WHERE c.id LIKE ?1 " 
			)
})

@Entity
public class ShoppingCart {
	
	@Id
	@GeneratedValue
	public Long id;
	
	@OneToMany(mappedBy="cart")
	private Set<Item> items = new HashSet<>();
	
	public String description;

	public ShoppingCart(String description) {
		this.description = description;
	}
	
	public ShoppingCart() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShoppingCart [id=").append(id).append(", items=").append(items).append(", description=")
				.append(description).append("]");
		return builder.toString();
	}

	

}
