package pl.restaurant.model.order;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.restaurant.model.item.Item;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {


    List<Order> findAllByOrderStatus(OrderStatus status);

}
