package com.project.order;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    private OrderBST priorityTree = new OrderBST();

    @PostConstruct
    public void initTree(){
        List<Order> orders = orderRepository.findAll();
        for(int i = 0; i < orders.size(); i++){
            priorityTree.insert(orders.get(i));
        }
    }

    public List<Order> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        if (orders.isEmpty()){
            System.out.println("Service Error:  No orders in system to return");
        }
        System.out.println("Service: Orders found!");
        return orders;
    }

    public Order createOrder(Order order){
        Order savedOrder = orderRepository.save(order);
        priorityTree.insert(savedOrder);
        return savedOrder;
    }

    public Order addPriority(Order order) {
        priorityTree.insert(order);

        return order;
    }

    public Order findHighestPriority() {
       return priorityTree.findHighest();
    }

    public Order findLowestPriority() {
        return priorityTree.findLowest();
    }

    public List<Order> sortedOrders(){
        return priorityTree.getInorderOrders();
    }

    public List<Order> sortedOrdersHighToLow(){
        return priorityTree.getOrdersHighToLow();
    }

}
