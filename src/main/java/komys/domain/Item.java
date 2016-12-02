package komys.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import komys.domain.Type;

@Entity
public class Item {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String description;
	private String name;

	private String img;
	private double weight;
	private double price;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "typeId")
    private Type type;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "materialId")
    private Material material;
	
	public Item() {}
	
	public Item(String name, String img, Type type, Material material, double weight, String description, double price) {
		super();
		this.setName(name);
		this.setImg(img);
		this.setType(type);
		this.setMaterial(material);
		this.setWeight(weight);
		this.setDescription(description);
		this.setPrice(price);
	}
	
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	@Override
	public String toString() {
		return type + ": " + material + " " + price ;
	}
}
