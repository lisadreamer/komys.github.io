package komys;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import komys.domain.Material;
import komys.domain.MaterialRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MaterialRepositoryTest {

	@Autowired
	private MaterialRepository mrep;
	
	@Test
    public void createNewMaterial() {
		Material material = new Material("Bronze");
    	mrep.save(material);
    	assertThat(material.getMaterialId()).isNotNull();
    	assertThat(material.getName()).doesNotContain("=");
    }
	
	@Test
    public void findByNameShouldReturnMaterial() {
        List<Material> mat = mrep.findByName("Gold");
        
        assertThat(mat).hasSize(1);
        assertThat(mat.get(0).getName()).isEqualTo("Gold");
        assertThat(mat.get(0).getName()).isNotNull();
    }
	
	@Test
    public void deleteMaterial() {
		Material material = new Material("Titanium");
    	mrep.save(material);
    	assertThat(material.getMaterialId()).isNotNull();
    	
    	//test delete functionality for the category we just created
    	Long matid = material.getMaterialId();
    	mrep.delete(matid);
    	Material c = mrep.findOne(matid);
    	assertThat(c).isNull();
    } 
}
