package pl.restaurant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.restaurant.common.Message;
import pl.restaurant.model.item.Item;
import pl.restaurant.model.item.ItemRepository;
import pl.restaurant.model.order.ClientOrder;
import pl.restaurant.model.order.Order;
import pl.restaurant.model.order.OrderRepository;

import java.util.Optional;

@Controller
public class OrderController {



    private ClientOrder clientOrder;
    private ItemRepository itemRepository;
    private OrderRepository orderRepository;

    @Autowired
    public OrderController(ClientOrder clientOrder, ItemRepository itemRepository, OrderRepository orderRepository) {
        this.clientOrder = clientOrder;
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/order/add")
    public String addOrder(@RequestParam Long id, Model model){

        Optional <Item> itemOptional = itemRepository.findById(id);
        itemOptional.ifPresent(clientOrder::add);
        if (itemOptional.isPresent()){
            model.addAttribute("message",new Message("Dodano", "Do zamówienia dodano:" +itemOptional.get().getName()));
        }
        else {
            model.addAttribute("message", new Message("Nie dodano", "Podano błędne id" + id));
        }

        return "message";
    }

    @GetMapping("/order")
    public String getOrder(Model model){



        model.addAttribute("order", clientOrder.getOrder());
        model.addAttribute("sum", clientOrder.getOrder().getItemList()
                .stream()
                .mapToDouble(Item::getPrice)
                .sum());

        return "order";
    }


    @PostMapping("/order/info/")
    public String proceedOrder(@RequestParam String address, @RequestParam String telephone, Model model){

        Order order = clientOrder.getOrder();
        order.setAddress(address);
        order.setTelephoneNumber(telephone);
        orderRepository.save(order);
        clientOrder.clear();
        model.addAttribute("message", new Message("Dziękujemy", "Zamówienie przyjęte do realizacji"));
        return "message";

    }
}
