package com.souravmittal.productcategory.dtos;

import com.souravmittal.productcategory.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private long id;
    private String title;
    private double price;
    private String description;
    private CategoryDto category;
    private String image;

    public static ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setCategory(CategoryDto.from(product.getCategory()));
        productDto.setPrice(product.getPrice());
        productDto.setImage(product.getImageUrl());
        return productDto;
    }
}
