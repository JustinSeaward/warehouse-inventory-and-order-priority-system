package com.project.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService  orderService;

    @GetMapping("/findall")
    public ResponseEntity<Order> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        if (orders.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok((Order) orders);
    }

    @PostMapping("/createnew")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order newOrderCreated = orderService.createOrder(order);
        if(newOrderCreated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrderCreated);
    }

    @PostMapping("/add-to-priority-tree ")
    public ResponseEntity<Order> addPriority(@RequestBody Order order) {
        Order priorityToAdd = orderService.addPriority(order);
        if (priorityToAdd == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(priorityToAdd);
    }

    @GetMapping("/priority/highest")
    public ResponseEntity<Order> highestPriority() {
        Order highestPriority = orderService.findHighestPriority();
        if(highestPriority == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(highestPriority);
    }

    @GetMapping("/priority/lowest")
    public ResponseEntity<Order> lowestPriority() {
        Order lowestPriority = orderService.findLowestPriority();
        if(lowestPriority == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lowestPriority);
    }

    @GetMapping("/priority/inorder")
    public ResponseEntity<List<Order>> inorderOrders(){
        List<Order> inorderOrders = orderService.sortedOrders();
        if(inorderOrders.isEmpty()){
            return ResponseEntity.notFound().build();
        }
       return ResponseEntity.ok(inorderOrders);
    }
}
