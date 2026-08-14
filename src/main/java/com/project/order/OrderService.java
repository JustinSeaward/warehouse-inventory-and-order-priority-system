package com.project.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    private OrderBST priorityTree = new OrderBST();

    public List<Order> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        if (orders.isEmpty()){
            System.out.println("Service Error:  No orders in system to return");
        }
        System.out.println("Service: Orders found!");
        return orders;
    }

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    public Order addPriority(Order order) {
        priorityTree.insert(order);

        return order;
    }
}
