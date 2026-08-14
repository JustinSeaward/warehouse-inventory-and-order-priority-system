package com.project.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    // TODO: Fix sorting logic

    public List<Product> sortByPrice(List<Product> products) {

        for (int i = 0; i < products.size(); i++) {

            Product current = products.get(i);
            int j = i;

            while (j > 0 && products.get(j).getPrice() < current.getPrice()) {
                products.set(j, products.get(j - 1));
                j--;
            }

            products.set(j, current);
        }

        return products;
    }


}
