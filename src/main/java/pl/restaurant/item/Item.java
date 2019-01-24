package pl.restaurant.item;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.restaurant.order.Order;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String quickDescription;
    private String fullDescription;


}
