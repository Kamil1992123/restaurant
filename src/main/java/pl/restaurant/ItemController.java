package pl.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.restaurant.item.Item;
import pl.restaurant.item.ItemRepository;

import java.util.Optional;

@Controller
public class ItemController {


    private ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }



    @GetMapping("/food/{name}")
    public String foodDetails(@PathVariable String name, Model model){

        Optional <Item> itemOptional = itemRepository.findByNameIgnoreCase(name.replaceAll("-"," "));
        itemOptional.ifPresent(item -> model.addAttribute("dinner",item));


        return itemOptional.map(item -> "foodDetails").orElse("redirect:/");
    }




}
