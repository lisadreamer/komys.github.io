package komys.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Material {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long materialId;

	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "material")
	private List<Item> items;

	public Material(){}
	
	public Material(String name){
		super();
		this.name = name;
	}
	
	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "";
	}
}
