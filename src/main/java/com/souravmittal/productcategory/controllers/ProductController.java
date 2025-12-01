package com.souravmittal.productcategory.controllers;

import com.souravmittal.productcategory.dtos.ProductDto;
import com.souravmittal.productcategory.models.Product;
import com.souravmittal.productcategory.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<Product> list = productService.getProducts();
//        List<ProductDto> response = list.stream().map(product -> ProductDto.from(product)).toList();
        List<ProductDto> response = list.stream().map(ProductDto::from).toList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than zero.");
        }
        Product product = productService.getProductById(id);
        ProductDto productDto = new ProductDto();
        if (product != null)
            BeanUtils.copyProperties(product, productDto);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        Product product = productService.createProduct(Product.from(productDto));
        return new ResponseEntity<>(ProductDto.from(product), HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDto> replaceProduct(@PathVariable long id, @RequestBody ProductDto productDto) {
        ProductDto productDtoResponse = ProductDto.from(productService.replaceProduct(id, Product.from(productDto)));
        return new ResponseEntity<>(productDtoResponse, HttpStatus.CREATED);
    }

    @PatchMapping("/products/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable long id, @RequestBody ProductDto productDto) {
        ProductDto productDtoResponse = ProductDto.from(productService.updateProduct(id, Product.from(productDto)));
        return new ResponseEntity<>(productDtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable long id) {
        ProductDto productDtoResponse = ProductDto.from(productService.deleteProduct(id));
        return new ResponseEntity<>(productDtoResponse, HttpStatus.OK);
    }
}
