package com.souravmittal.productcategory.services;

import com.souravmittal.productcategory.dtos.ProductDto;
import com.souravmittal.productcategory.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    Product getProductById(long id);
    Product createProduct(Product product);
    Product replaceProduct(long id, Product product);
    Product updateProduct(long id, Product product);
    Product deleteProduct(long id);
}
