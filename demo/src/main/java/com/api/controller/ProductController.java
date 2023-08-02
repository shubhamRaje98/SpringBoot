package com.api.controller;

import com.api.Exception.HnDBankException;
import com.api.dto.CustomerDTO;
import com.api.dto.ProductDTO;
import com.api.service.CustomerService;
import com.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hndbank")
public class ProductController {

    @Autowired
    private Environment environment;
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO product) throws HnDBankException {
        Integer productId = productService.addProduct(product);
        String successMessage = environment.getProperty("API.INSERT_SUCCESS") + productId;
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }
}
