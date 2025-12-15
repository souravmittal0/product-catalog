package com.souravmittal.productcategory.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.souravmittal.productcategory.controllers.ProductController;
import com.souravmittal.productcategory.dtos.CategoryDto;
import com.souravmittal.productcategory.dtos.ProductDto;
import com.souravmittal.productcategory.models.Category;
import com.souravmittal.productcategory.models.Product;
import com.souravmittal.productcategory.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllProducts() throws Exception {
        List<Product> products = new ArrayList<>();

        Product product1 = new Product();
        product1.setId(1l);
        product1.setTitle("Product 1");
        product1.setPrice(100.00);
        product1.setCategory(new Category());
        products.add(product1);

        Product product2 = new Product();
        product2.setId(1l);
        product2.setTitle("Product 1");
        product2.setPrice(100.00);
        product2.setCategory(new Category());
        products.add(product2);

        when(productService.getProducts()).thenReturn(products);

        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(ProductDto.from(product1));
        productDtos.add(ProductDto.from(product2));

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(productDtos)));
    }

    @Test
    void testCreateProduct() throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setId(1l);
        productDto.setTitle("Product 1");
        productDto.setPrice(100.00);
        productDto.setCategory(new CategoryDto());

        when(productService.createProduct(any(Product.class))).thenReturn(Product.from(productDto));

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productDto)))
                .andExpect(status().isCreated())
                .andExpect(content().string(objectMapper.writeValueAsString(productDto)));
    }
}
