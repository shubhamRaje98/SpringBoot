package com.api.service;

import com.api.Exception.HnDBankException;
import com.api.dto.CustomerDTO;
import com.api.dto.ProductDTO;
import com.api.entity.Customer;
import com.api.entity.Product;
import com.api.repository.CustomerRepository;
import com.api.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImp implements ProductService{
    @Autowired
    private ProductRepository productRespository;

    @Override
    public int addProduct(ProductDTO productDto) throws HnDBankException {
        Optional<Product> optional = productRespository.findById(productDto.getProductId());
        if (optional.isPresent())
            throw new HnDBankException("Product already exists!");
        Product p = new Product();
        p.setProductId(productDto.getProductId());
        p.setProductName(productDto.getProductName());
        p.setProductDescription(productDto.getProductDescription());
        p.setExpDate(productDto.getExpDate());

        Product np = productRespository.save(p);
        return np.getProductId();
    }

    @Override
    public ProductDTO getProduct(Integer productId) throws HnDBankException {
        return null;
    }
    @Override
    public Product getProductById(Integer id) {
        Optional<Product> optionalProduct = productRespository.findById(id);
        return optionalProduct.orElse(null);
    }
    @Override
    public List<ProductDTO> findAll() throws HnDBankException {
        Iterable<Product> products = productRespository.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();
        products.forEach(product -> {
            ProductDTO productDto = new ProductDTO();
            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());
            productDto.setProductDescription(product.getProductDescription());
            productDto.setExpDate(product.getExpDate());

            productDTOs.add(productDto);
        });
        if (productDTOs.isEmpty())
            throw new HnDBankException("Service.CUSTOMERS_NOT_FOUND");
        return productDTOs;
    }


    @Override
    public Product updateProduct(Integer id, Product product) {
        Optional<Product> optionalProduct = productRespository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setProductName(product.getProductName());
            existingProduct.setProductId(product.getProductId());
            existingProduct.setProductDescription(product.getProductDescription());
            existingProduct.setExpDate(product.getExpDate());

            return productRespository.save(existingProduct);
        } else {
            return null;
        }
    }

    @Override
    public void deleteProduct(Integer productId) throws HnDBankException {

    }
}
