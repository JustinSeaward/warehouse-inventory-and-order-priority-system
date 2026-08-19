package com.project.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> product = productService.getAllProducts();

        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product newProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    // TODO: handle multiple sort types - DONE
    @GetMapping("/sorted")
    public ResponseEntity<List<Product>> getSorted(@RequestParam String by) {
        if(by.equals("price")){
            return ResponseEntity.ok(productService.sortByPrice(productService.getAllProducts()));
        }
        if(by.equals("stock")){
            return ResponseEntity.ok(productService.sortByStock(productService.getAllProducts()));
        }
        return ResponseEntity.notFound().build();
    }
}
