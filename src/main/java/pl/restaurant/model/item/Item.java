package pl.restaurant.model.item;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private String url;


    @Override
    public String toString() {
        return name +  "cena: " + price + " Opis: " + quickDescription + " - " + fullDescription ;
    }
}

