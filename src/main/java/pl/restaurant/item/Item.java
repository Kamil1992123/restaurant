package pl.restaurant.item;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import pl.restaurant.order.Order;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
//@ToString(exclude = "id")
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String quickDescription;
    @Column(length = 1500)
    private String fullDescription;



    @Override
    public String toString() {
        return name +  "cena: " + price + " Opis: " + quickDescription + " - " + fullDescription ;
    }
}

