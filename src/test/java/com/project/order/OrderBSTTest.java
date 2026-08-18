package com.project.order;

import com.project.customer.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class OrderBSTTest {

    private OrderBST tree;
    private Order testOrder1;
    private Order testOrder2;
    private Order testOrder3;
    private Customer testCustomer;

    @BeforeEach
    public void setUpTestData(){
        tree = new OrderBST();
        testOrder1 = new Order();
        testOrder2 = new Order();
        testOrder3 = new Order();
        testCustomer = new Customer();

        testCustomer.setId(1L);
        testCustomer.setName("Rusty");
        testCustomer.setEmail("rusty@email.com");

        testOrder1.setId(1L);
        testOrder1.setCustomer(testCustomer);
        testOrder1.setOrderDate(LocalDate.parse("2026-09-10"));
        testOrder1.setPriorityLevel(2);

        testOrder2.setId(2L);
        testOrder2.setCustomer(testCustomer);
        testOrder2.setOrderDate(LocalDate.parse("2026-09-16"));
        testOrder2.setPriorityLevel(6);

        testOrder3.setId(3L);
        testOrder3.setCustomer(testCustomer);
        testOrder3.setOrderDate(LocalDate.parse("2026-09-18"));
        testOrder3.setPriorityLevel(9);

        tree.insert(testOrder1);
        tree.insert(testOrder2);
        tree.insert(testOrder3);
    }

    @Test
    public void testFindHighestPriority(){
        Order highestPriority = tree.findHighest();
        int orderPriority = highestPriority.getPriorityLevel();

        Assertions.assertEquals(9, orderPriority);
    }

    @Test
    public void testFindLowestPriority(){
        Order lowestPriority = tree.findLowest();
        int orderPriority = lowestPriority.getPriorityLevel();

        Assertions.assertEquals(2, orderPriority);
    }
}
