package com.api.controller;

import com.api.Exception.HnDBankException;
import com.api.dto.CustomerDTO;
import com.api.dto.ProductDTO;
import com.api.entity.Product;
import com.api.service.CustomerService;
import com.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hndbank")
public class ProductController {

    @Autowired
    private Environment environment;
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() throws HnDBankException {
        List<ProductDTO> productList = productService.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping(value = "/products/{productId}")
    public ProductDTO getProduct(@PathVariable Integer productId) throws HnDBankException {
        ProductDTO product = productService.getProduct(productId);
        return product;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(value = "/product")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO product) throws HnDBankException {
        Integer productId = productService.addProduct(product);
        String successMessage = environment.getProperty("API.INSERT_SUCCESS") + productId;
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
