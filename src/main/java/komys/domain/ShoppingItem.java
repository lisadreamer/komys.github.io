package komys.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;*/

public class ShoppingItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/*@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "id")*/
	private Item x;
	
	private int quantity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public Item getX() {
		return x;
	}
	public void setX(Item x) {
		this.x = x;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public ShoppingItem(Item x, int quantity) {
		super();
		this.x = x;
		this.quantity = quantity;
	}
	public ShoppingItem() {
		super();
	}
	
	
	
	
	
}
