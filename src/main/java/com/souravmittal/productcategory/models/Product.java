package com.souravmittal.productcategory.models;

import com.souravmittal.productcategory.dtos.CategoryDto;
import com.souravmittal.productcategory.dtos.FakeStoreProductDto;
import com.souravmittal.productcategory.dtos.ProductDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
    private String title;
    private String description;
    private String imageUrl;
    private double price;
    private Category category;

    public static Product from(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        return product;
    }

    public static Product from(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setCategory(Category.from(productDto.getCategory()));
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImage());
        return product;
    }
}
