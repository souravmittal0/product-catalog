package com.souravmittal.productcategory.services;

import com.souravmittal.productcategory.dtos.ProductDto;
import com.souravmittal.productcategory.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public Product getProductById(long id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(long id, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(long id) {
        return null;
    }
}
