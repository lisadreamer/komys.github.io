package komys.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MaterialRepository extends CrudRepository<Material, Long>{
	
	List<Material> findByName(String name);
}
