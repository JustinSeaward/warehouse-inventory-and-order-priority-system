package com.project.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if(products.isEmpty()){
            System.out.println("ProductService Error:  No products found");
            return null;
        }
        System.out.println("ProductService: Products found!");
        return products;
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product){
        Optional<Product> existingProduct = productRepository.findById(id);

        if(existingProduct.isPresent()){
            Product updateProduct = existingProduct.get();
            updateProduct.setName(product.getName());
            updateProduct.setPrice(product.getPrice());
            updateProduct.setStock(product.getStock());
            return productRepository.save(updateProduct);
        } else {
            return null;
        }
    }

    public void deleteProductById(Long id) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if(existingProduct.isPresent()){
            productRepository.deleteById(id);
        }
    }

    // TODO: Fix sorting logic - DONE
    public List<Product> sortByPrice(List<Product> products) {

        for (int i = 0; i < products.size(); i++) {
            Product current = products.get(i);
            int j = i;

            while (j > 0 && products.get(j-1).getPrice() > current.getPrice()) {
                products.set(j, products.get(j - 1));
                j--;
            }
            products.set(j, current);
        }

        return products;
    }

    public List<Product> sortByStock(List<Product> products) {

        for (int i = 0; i < products.size(); i++) {
            Product current = products.get(i);
            int j = i;

            while (j > 0 && products.get(j-1).getStock() > current.getStock()) {
                products.set(j, products.get(j - 1));
                j--;
            }
            products.set(j, current);
        }

        return products;
    }


}
