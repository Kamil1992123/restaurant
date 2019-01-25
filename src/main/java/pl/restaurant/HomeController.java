package pl.restaurant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.restaurant.item.Item;
import pl.restaurant.item.ItemRepository;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {



    @Autowired
    private ItemRepository itemRepository;



    @GetMapping("/")
    public String home(Model model){

        List <Item> itemsList = new ArrayList<>();
        Iterable <Item> itemIterable = itemRepository.findAll();

        for (Item item : itemIterable){
            itemsList.add(item);
        }

        model.addAttribute("food",itemsList);
        return "home";

    }
}
