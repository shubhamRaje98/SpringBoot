package com.api.service;

import com.api.Exception.HnDBankException;
import com.api.dto.ProductDTO;
import com.api.entity.Customer;
import com.api.entity.Product;
import com.api.repository.CustomerRepository;
import com.api.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<ProductDTO> findAll() throws HnDBankException {
        return null;
    }

    @Override
    public void updateProduct(Integer productId, ProductDTO productDTO) throws HnDBankException {

    }

    @Override
    public void deleteProduct(Integer productId) throws HnDBankException {

    }
}
