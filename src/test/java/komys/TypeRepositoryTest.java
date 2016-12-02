package komys;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import komys.domain.Type;
import komys.domain.TypeRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TypeRepositoryTest {
	
	@Autowired
	private TypeRepository trep;
	
	@Test
    public void createNewType() {
		Type type = new Type("Chains");
    	trep.save(type);
    	assertThat(type.getTypeId()).isNotNull();
    	assertThat(type.getName()).doesNotContain("=");
    }
	
	@Test
    public void findByNameShouldReturnMaterial() {
        List<Type> types = trep.findByName("Rings");
        
        assertThat(types).hasSize(1);
        assertThat(types.get(0).getName()).isEqualToIgnoringCase("rings");
        assertThat(types.get(0).getName()).isNotNull();
    }
	
	@Test
    public void deleteMaterial() {
		Type type = new Type("Chains");
    	trep.save(type);
    	assertThat(type.getTypeId()).isNotNull();
    	
    	//test delete functionality for the category we just created
    	Long typid = type.getTypeId();
    	trep.delete(typid);
    	Type c = trep.findOne(typid);
    	assertThat(c).isNull();
    } 
}
