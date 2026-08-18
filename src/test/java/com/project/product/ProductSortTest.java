package com.project.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductSortTest {

    private List<Product> testProductList;
    private ProductService productService;

    @BeforeEach
    public void setUpTestData(){
      productService = new ProductService();
      testProductList = new ArrayList<>();
      Product testProduct1 = new Product();
      Product testProduct2 = new Product();
      Product testProduct3 = new Product();

      testProduct1.setId(1L);
      testProduct1.setName("Hammer");
      testProduct1.setPrice(25.00);
      testProduct1.setStock(10);
      testProductList.add(testProduct1);

      testProduct2.setId(2L);
      testProduct2.setName("1/2 Combination Wrench");
      testProduct2.setPrice(9.99);
      testProduct2.setStock(30);
      testProductList.add(testProduct2);

      testProduct3.setId(3L);
      testProduct3.setName("29 pc Screw Driver set");
      testProduct3.setPrice(29.99);
      testProduct3.setStock(15);
      testProductList.add(testProduct3);

    }

    @Test
    public void testSortedByPrice(){
        List<Product> sortedList = productService.sortByPrice(testProductList);
        Double itemPrice = sortedList.get(0).getPrice();

        Assertions.assertEquals(3, sortedList.size());
        Assertions.assertEquals(9.99, itemPrice);
    }

    @Test
    public void testSortedByStock(){
        List<Product> sortedList = productService.sortByStock(testProductList);
        int itemStockQty = sortedList.get(0).getStock();

        Assertions.assertEquals(3, sortedList.size());
        Assertions.assertEquals(10, itemStockQty);
    }



}
