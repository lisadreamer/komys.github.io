package komys.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long>{
	
	List<Item> findByName(String name);
	List<Item> findByType(Type type);
}

