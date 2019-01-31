package pl.restaurant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.restaurant.model.item.Item;
import pl.restaurant.model.item.ItemRepository;
import pl.restaurant.model.order.ClientOrder;
import pl.restaurant.model.order.Order;
import pl.restaurant.model.order.OrderRepository;
import pl.restaurant.model.order.OrderStatus;

import java.util.List;
import java.util.Optional;

@Controller
public class OrderPanelController {



    private OrderRepository orderRepository;

    @Autowired
    public OrderPanelController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/panel/order")
    public String getOrders(@RequestParam(required = false) OrderStatus status, Model model){

        List<Order> orderList;
        if (status == null){
            orderList = orderRepository.findAll();
        }
        else {
            orderList = orderRepository.findAllByOrderStatus(status);
        }
        model.addAttribute("orders", orderList);

        return "orderPanel";
    }


    @GetMapping("/panel/order/{id}")
    public String orderDetails(@PathVariable Long id, Model model){



        Optional<Order> order = orderRepository.findById(id);
        return order.map(obj -> singleOrderModel(obj , model)).orElse("redirect:/");


    }


    @PostMapping("/panel/order/{id}")
    public  String changeOrderStatus(@PathVariable Long id, Model model) {

        Optional<Order> order = orderRepository.findById(id);

        order.ifPresent(obj -> {
                obj.setOrderStatus(OrderStatus.nextStatus(obj.getOrderStatus()));
                orderRepository.save(obj);
                });
        return order.map(obj -> singleOrderModel(obj , model)).orElse("redirect:/");
    }



    private String singleOrderModel(Order order, Model model){

        model.addAttribute("order" , order);
        model.addAttribute("sum", order.getItemList().stream().mapToDouble(Item::getPrice).sum());

        return "orderDetails";
    }
}
