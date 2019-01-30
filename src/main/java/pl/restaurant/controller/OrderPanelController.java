package pl.restaurant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
}
