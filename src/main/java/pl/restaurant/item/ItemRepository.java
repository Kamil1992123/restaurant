package pl.restaurant.item;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item,Long> {



     Optional<Item> findByNameIgnoreCase(String name);

}
