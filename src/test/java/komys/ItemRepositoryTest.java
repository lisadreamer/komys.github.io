package komys;

import java.util.List;

import komys.domain.Item;
import komys.domain.ItemRepository;
import komys.domain.MaterialRepository;
import komys.domain.TypeRepository;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository irep;
	@Autowired
	private TypeRepository trep;
	@Autowired
	private MaterialRepository mrep;
	
	@Test
    public void createNewItem() {
		Item item = new Item("Northen Star", "images/northenstar.jpg", trep.findByName("Earrings").get(0),  mrep.findByName("Silver").get(0), 9.99,  "-", 99);
		irep.save(item);
		assertThat(item.getId()).isNotNull();
	}
	
	@Test
    public void findByIsbnShouldReturnItem() {
        List<Item> items = irep.findByName("silver earring 01");
        
        assertThat(items).hasSize(1);
        assertThat(items.get(0).getImg()).containsIgnoringCase("images/");
        assertThat(items.get(0).getWeight()).isGreaterThan(0);
        assertThat(items.get(0).getPrice()).isGreaterThan(0);
        assertThat(items.get(0).getName()).doesNotContain("'");
    }
	
	@Test
    public void deleteItem() {
		Item item = new Item("Northen Star", "images/northenstar.jpg", trep.findByName("Earrings").get(0),  mrep.findByName("Silver").get(0), 9.99,  "-", 99);
    	irep.save(item);    	
    	assertThat(item.getId()).isNotNull();
    	
    	//test delete functionality for the book we just created
    	Long itemid = item.getId();
    	irep.delete(itemid);
    	Item b = irep.findOne(itemid);
    	assertThat(b).isNull();
    } 
}
