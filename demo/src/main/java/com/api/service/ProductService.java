package com.api.service;

import com.api.Exception.HnDBankException;
import com.api.dto.CustomerDTO;
import com.api.dto.ProductDTO;
import com.api.entity.Product;

import java.util.List;

public interface ProductService {
//product CRUD operations
    public int addProduct(ProductDTO product) throws HnDBankException;
    public ProductDTO getProduct(Integer productId) throws HnDBankException;
    public List<ProductDTO> findAll() throws HnDBankException;

    public void deleteProduct(Integer productId)throws HnDBankException;
    Product getProductById(Integer id);
    Product updateProduct(Integer id,Product product);

}
